package org.opencps.api.controller.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatus;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskStatusRegistryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.opencps.api.controller.SystemManagement;
import org.opencps.auth.api.BackendAuth;
import org.opencps.auth.api.BackendAuthImpl;
import org.opencps.auth.api.exception.UnauthenticationException;
import org.opencps.background.executor.SiteCleanBackgroundTaskExecutor;
import org.opencps.background.model.BackgroundTaskProgress;
import org.opencps.background.model.BackgroundTaskResult;
import org.opencps.communication.model.Notificationtemplate;
import org.opencps.communication.model.ServerConfig;
import org.opencps.communication.service.NotificationtemplateLocalServiceUtil;
import org.opencps.communication.service.ServerConfigLocalServiceUtil;
import org.opencps.dossiermgt.action.ServiceProcessActions;
import org.opencps.dossiermgt.action.impl.ServiceProcessActionsImpl;
import org.opencps.dossiermgt.action.util.ConstantUtils;
import org.opencps.dossiermgt.action.util.ReadFilePropertiesUtils;
import org.opencps.dossiermgt.constants.ProcessActionTerm;
import org.opencps.dossiermgt.model.ActionConfig;
import org.opencps.dossiermgt.model.DocumentType;
import org.opencps.dossiermgt.model.MenuConfig;
import org.opencps.dossiermgt.model.ProcessAction;
import org.opencps.dossiermgt.model.ServiceConfig;
import org.opencps.dossiermgt.model.ServiceInfo;
import org.opencps.dossiermgt.model.StepConfig;
import org.opencps.dossiermgt.service.ActionConfigLocalServiceUtil;
import org.opencps.dossiermgt.service.DocumentTypeLocalServiceUtil;
import org.opencps.dossiermgt.service.MenuConfigLocalServiceUtil;
import org.opencps.dossiermgt.service.ProcessActionLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceConfigLocalServiceUtil;
import org.opencps.dossiermgt.service.ServiceInfoLocalServiceUtil;
import org.opencps.dossiermgt.service.StepConfigLocalServiceUtil;

import backend.auth.api.exception.BusinessExceptionImpl;

public class SystemManagementImpl implements SystemManagement {
	Log _log = LogFactoryUtil.getLog(SystemManagementImpl.class.getName());
	@Override
	public Response cleanSite(HttpServletRequest request, HttpHeaders header, Company company, Locale locale, User user,
			ServiceContext serviceContext, Long siteId) {
		long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));
		
		BackgroundTaskResult result = new BackgroundTaskResult();
	    Map<String, Serializable> taskContextMap = new HashMap<>();
	    taskContextMap.put(Field.GROUP_ID, siteId);

	    try {
			BackgroundTask backgroundTask = BackgroundTaskManagerUtil.addBackgroundTask(user.getUserId(),
			        groupId, SiteCleanBackgroundTaskExecutor.class.getName(),
			        SiteCleanBackgroundTaskExecutor.class.getName(),
			        taskContextMap, serviceContext);
			
			result.setBackgroundTaskId(backgroundTask.getBackgroundTaskId());
		} catch (PortalException e) {
			_log.error(e);
		}
	    
		return Response.status(200).entity(result).build();
	}

	@Override
	public Response getProgress(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext, Long backgroundTaskId) {
		BackgroundTaskProgress result = new BackgroundTaskProgress();
		
		BackgroundTaskStatus backgroundTaskStatus = BackgroundTaskStatusRegistryUtil
				.getBackgroundTaskStatus(backgroundTaskId);
		
		if (backgroundTaskStatus != null && Validator.isNotNull(backgroundTaskStatus.getAttribute(ConstantUtils.VALUE_PERCENTAGE))) {
			result.setPercentage((int)backgroundTaskStatus.getAttribute(ConstantUtils.VALUE_PERCENTAGE));			
		}
		else {
			result.setPercentage(100);
		}
		result.setBackgroundTaskId(backgroundTaskId);
		if (backgroundTaskStatus != null) {
			result.setExecutionLog((String)backgroundTaskStatus.getAttribute(ConstantUtils.VALUE_EXE_LOG));
		}
		else {
			result.setExecutionLog(StringPool.BLANK);
		}
		
		return Response.status(200).entity(result).build();
	}

	@Override
	public Response initSystem(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext) {
		BackendAuth auth = new BackendAuthImpl();

		try {
			if (!auth.isAuth(serviceContext)) {
				throw new UnauthenticationException();
			}

			List<Role> userRoles = user.getRoles();
			boolean isAdmin = false;
			for (Role r : userRoles) {
				if (r.getName().startsWith(ReadFilePropertiesUtils.get(ConstantUtils.ROLE_ADMIN))) {
					isAdmin = true;
					break;
				}
			}
			
			if (!isAdmin) {
				throw new UnauthenticationException();
			}
			
			Role oldApplicantRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_APPLICANT));
			Map<Locale, String> titleMap = new HashMap<>();
			titleMap.put(Locale.getDefault(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_APPLICANT));
			
			Map<Locale, String> titleDesc = new HashMap<>();
			titleDesc.put(Locale.getDefault(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_APPLICANT));

			if (oldApplicantRole == null) {
				RoleLocalServiceUtil.addRole(user.getUserId(), Role.class.getName(), CounterLocalServiceUtil.increment(),
						ReadFilePropertiesUtils.get(ConstantUtils.VALUE_APPLICANT), titleMap, titleDesc, RoleConstants.TYPE_REGULAR, ReadFilePropertiesUtils.get(ConstantUtils.VALUE_APPLICANT), serviceContext);				
				oldApplicantRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_APPLICANT));
				oldApplicantRole.setTitle(ReadFilePropertiesUtils.get(ConstantUtils.VALUE_APPLICANT));
				oldApplicantRole.setDescription(ReadFilePropertiesUtils.get(ConstantUtils.VALUE_APPLICANT));
				RoleLocalServiceUtil.updateRole(oldApplicantRole);
			}
			Role oldEmployeeRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_EMPLOYEE));
			if (oldEmployeeRole == null) {
				titleMap.put(Locale.getDefault(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_EMPLOYEE));
				titleDesc.put(Locale.getDefault(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_EMPLOYEE));				
				RoleLocalServiceUtil.addRole(user.getUserId(), Role.class.getName(), CounterLocalServiceUtil.increment(),
						ReadFilePropertiesUtils.get(ConstantUtils.VALUE_EMPLOYEE), titleMap, titleDesc, RoleConstants.TYPE_REGULAR, ReadFilePropertiesUtils.get(ConstantUtils.VALUE_EMPLOYEE), serviceContext);				
				oldEmployeeRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN));
				oldEmployeeRole.setTitle(ReadFilePropertiesUtils.get(ConstantUtils.VALUE_EMPLOYEE));
				oldEmployeeRole.setDescription(ReadFilePropertiesUtils.get(ConstantUtils.VALUE_EMPLOYEE));
				RoleLocalServiceUtil.updateRole(oldEmployeeRole);
			}
			Role oldCitizenRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN));
			if (oldCitizenRole == null) {
				titleMap.put(Locale.getDefault(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN));
				titleDesc.put(Locale.getDefault(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN));
				RoleLocalServiceUtil.addRole(user.getUserId(), Role.class.getName(), CounterLocalServiceUtil.increment(),
						ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN), titleMap, titleDesc, RoleConstants.TYPE_REGULAR, ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN), serviceContext);
				oldCitizenRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN));
				oldCitizenRole.setTitle(ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN));
				oldCitizenRole.setDescription(ReadFilePropertiesUtils.get(ConstantUtils.VALUE_CITIZEN));
				RoleLocalServiceUtil.updateRole(oldCitizenRole);
			}
			
			return Response.status(200).entity(StringPool.BLANK).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	@Override
	public Response verifyMasterData(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext) {
		long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));
		BackendAuth auth = new BackendAuthImpl();

		try {
			if (!auth.isAuth(serviceContext)) {
				throw new UnauthenticationException();
			}

			List<Role> userRoles = user.getRoles();
			boolean isAdmin = false;
			for (Role r : userRoles) {
				if (r.getName().startsWith(ReadFilePropertiesUtils.get(ConstantUtils.ROLE_ADMIN))) {
					isAdmin = true;
					break;
				}
			}
			
			if (!isAdmin) {
				throw new UnauthenticationException();
			}
			
			JSONObject resultObj = JSONFactoryUtil.createJSONObject();
			
			JSONArray verifyWarninglArr = JSONFactoryUtil.createJSONArray();
			JSONArray verifyServiceConfigArr = verifyCriticalServiceConfig(groupId);
			JSONArray verifyErrorArr = JSONFactoryUtil.createJSONArray();
			
			if (groupId != 0) {
				JSONArray verifyCriticalArr = verifyCriticalConfig(groupId);
				verifyWarninglArr = verifyWarningConfig(groupId);
				for (int i = 0; i < verifyCriticalArr.length(); i++) {
					verifyErrorArr.put(verifyCriticalArr.get(i));
				}
				for (int i = 0; i < verifyServiceConfigArr.length(); i++) {
					verifyErrorArr.put(verifyServiceConfigArr.get(i));
				}
			}
			else {
			}
			
			if (verifyErrorArr.length() > 0) {
				resultObj.put("verify", false);
				resultObj.put("message", "Dữ liệu cấu hình có lỗi!");	
				resultObj.put("errors", verifyErrorArr);
			}
			else {
				resultObj.put("verify", true);
				if (verifyWarninglArr.length() > 0) {
					resultObj.put("message", "Dữ liệu cấu hình không có lỗi, nhưng có nhiều cảnh báo có thể hệ thống hoạt động không ổn định!!!");					
				}
				else {
					resultObj.put("message", "Dữ liệu cấu hình không có lỗi!");
				}
			}
			
			resultObj.put("warnings", verifyWarninglArr);

			return Response.status(200).entity(resultObj.toJSONString()).build();

		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}

	private JSONArray verifyCriticalConfig(long groupId) {
		JSONArray objArr = JSONFactoryUtil.createJSONArray();
				
		if (groupId != 0) {
			List<ActionConfig> lstAcs = ActionConfigLocalServiceUtil.getByGroupId(groupId);

			if (lstAcs.isEmpty()) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("message", "Thiếu cấu hình ActionConfig");
				
				objArr.put(obj);
			}
			List<MenuConfig> lstMenuConfigs = MenuConfigLocalServiceUtil.getByGroupId(groupId);
			if (lstMenuConfigs.isEmpty()) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("message", "Thiếu cấu hình MenuConfig");
				
				objArr.put(obj);
			}
			List<ServerConfig> lstServerConfigs = ServerConfigLocalServiceUtil.getGroupId(groupId);
			if (lstServerConfigs.isEmpty()) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("message", "Thiếu cấu hình ServerConfig");
				
				objArr.put(obj);
			}
			List<StepConfig> lstStepConfigs = StepConfigLocalServiceUtil.getStepByGroupId(groupId);
			if (lstStepConfigs.isEmpty()) {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("message", "Thiếu cấu hình StepConfig");
				
				objArr.put(obj);
			}
		}
		else {
			
		}
		
		return objArr;
	}
	
	private JSONArray verifyWarningConfig(long groupId) {
		JSONArray objArr = JSONFactoryUtil.createJSONArray();
				
		if (groupId != 0) {
			List<ActionConfig> lstAcs = ActionConfigLocalServiceUtil.getByGroupId(groupId);

			if (lstAcs.isEmpty()) {
			}
			else {
				for (ActionConfig ac : lstAcs) {
					if (Validator.isNotNull(ac)) {
						try {
							JSONFactoryUtil.createJSONObject(ac.getFormConfig());
						} catch (JSONException e) {
							JSONObject obj = JSONFactoryUtil.createJSONObject();
							obj.put("message", "Cấu hình FormConfig của thao tác " + ac.getActionCode() + "-" + ac.getActionName() + " phải có kiểu JSON chuẩn");
							objArr.put(obj);
							_log.debug(e);
						}
						
						//Verify notification template
						if (Validator.isNotNull(ac.getNotificationType())) {
							Notificationtemplate nt = NotificationtemplateLocalServiceUtil.fetchByF_NotificationtemplateByType(groupId, ac.getNotificationType());
							if (Validator.isNull(nt)) {
								JSONObject obj = JSONFactoryUtil.createJSONObject();
								obj.put("message", "Cấu hình Notificationtemplate " + ac.getNotificationType() + " của thao tác " + ac.getActionCode() + "-" + ac.getActionName() +  " chưa có mẫu gửi thông báo");
								objArr.put(obj);							
							}							
						}

						//Verify document type
						if (Validator.isNotNull(ac.getDocumentType())) {
							DocumentType docType = DocumentTypeLocalServiceUtil.getByTypeCode(groupId, ac.getDocumentType());
							if (docType == null) {
								JSONObject obj = JSONFactoryUtil.createJSONObject();
								obj.put("message", "Cấu hình DocumentType " + ac.getDocumentType() + " của thao tác " + ac.getActionCode() + "-" + ac.getActionName() +  " chưa có mẫu phiếu");
								objArr.put(obj);															
							}
							else if (Validator.isNull(docType.getDocumentScript())) {
								JSONObject obj = JSONFactoryUtil.createJSONObject();
								obj.put("message", "Cấu hình DocumentType " + ac.getDocumentType() + " của thao tác " + ac.getActionCode() + "-" + ac.getActionName() +  " chưa có mẫu JASPER phiếu");
								objArr.put(obj);																							
							}
						}						
					}
				}
			}
			List<MenuConfig> lstMenuConfigs = MenuConfigLocalServiceUtil.getByGroupId(groupId);
			if (lstMenuConfigs.isEmpty()) {
			}
			else {
				
			}
			List<ServerConfig> lstServerConfigs = ServerConfigLocalServiceUtil.getGroupId(groupId);
			if (lstServerConfigs.isEmpty()) {
			}
			List<StepConfig> lstStepConfigs = StepConfigLocalServiceUtil.getStepByGroupId(groupId);
			if (lstStepConfigs.isEmpty()) {
			}
			
		}
		else {
			
		}
		
		return objArr;
	}	
	
	private JSONArray verifyCriticalServiceConfig(long groupId) {
		JSONArray objArr = JSONFactoryUtil.createJSONArray();
				
		if (groupId != 0) {
			List<ServiceConfig> lstScs;
			try {
				lstScs = ServiceConfigLocalServiceUtil.getByGroupId(groupId);
				for (ServiceConfig sc : lstScs) {
					ServiceInfo si = ServiceInfoLocalServiceUtil.fetchServiceInfo(sc.getServiceInfoId());
					if (si == null) {
						JSONObject obj = JSONFactoryUtil.createJSONObject();
						obj.put("message", "Cấu hình dịch vụ công gắn với thủ tục hành chính sai " + sc.getServiceConfigId());
						objArr.put(obj);
					}
				}
			} catch (SystemException e) {
				_log.debug(e);
			} catch (PortalException e) {
				_log.debug(e);
			}
		}
		else {
			
		}
		
		return objArr;
	}

	@Override
	public Response resolveConflict(HttpServletRequest request, HttpHeaders header, Company company, Locale locale,
			User user, ServiceContext serviceContext) {
		ServiceProcessActions actions = new ServiceProcessActionsImpl();

		long groupId = GetterUtil.getLong(header.getHeaderString(Field.GROUP_ID));

		BackendAuth auth = new BackendAuthImpl();
		Indexer<ProcessAction> indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(ProcessAction.class);
		try {

			if (!auth.isAuth(serviceContext)) {
				throw new UnauthenticationException();
			}

			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>();

			params.put(Field.GROUP_ID, String.valueOf(groupId));
			params.put(Field.KEYWORD_SEARCH, StringPool.BLANK);
			
			Sort[] sorts = new Sort[] { };

			JSONObject jsonData = actions.getProcessActions(user.getUserId(), serviceContext.getCompanyId(), groupId,
					params, sorts, QueryUtil.ALL_POS, QueryUtil.ALL_POS, serviceContext);

			long total = jsonData.getInt(ConstantUtils.TOTAL);
			if (total > 0) {
				List<Document> lstDocuments = (List<Document>) jsonData.get(ConstantUtils.DATA);	
				for (Document document : lstDocuments) {
					long processActionId = GetterUtil.getLong(document.get(ProcessActionTerm.PROCESS_ACTION_ID));
					long companyId = GetterUtil.getLong(document.get(Field.COMPANY_ID));
					String uid = document.get(Field.UID);
					ProcessAction pa = ProcessActionLocalServiceUtil.fetchProcessAction(processActionId);
					if (pa == null) {
						try {
							indexer.delete(companyId, uid);
						} catch (SearchException e) {
							_log.error(e);
						}
					}
				}
			}
			
			return Response.status(200).entity("{}").build();
		} catch (Exception e) {
			return BusinessExceptionImpl.processException(e);
		}
	}	
}
