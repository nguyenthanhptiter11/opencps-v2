/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.opencps.usermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.usermgt.model.JobPos;
import org.opencps.usermgt.model.JobPosModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the JobPos service. Represents a row in the &quot;opencps_jobpos&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link JobPosModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobPosImpl}.
 * </p>
 *
 * @author khoavu
 * @see JobPosImpl
 * @see JobPos
 * @see JobPosModel
 * @generated
 */
@ProviderType
public class JobPosModelImpl extends BaseModelImpl<JobPos>
	implements JobPosModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a job pos model instance should use the {@link JobPos} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_jobpos";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "jobPosId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ Field.GROUP_ID, Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "jobPosCode", Types.VARCHAR },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "mappingRoleId", Types.BIGINT },
			{ "leader", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jobPosId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put(Field.GROUP_ID, Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("jobPosCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mappingRoleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("leader", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_jobpos (uuid_ VARCHAR(75) null,jobPosId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(255) null,createDate DATE null,modifiedDate DATE null,jobPosCode VARCHAR(255) null,title VARCHAR(500) null,description STRING null,mappingRoleId LONG,leader INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table opencps_jobpos";
	public static final String ORDER_BY_JPQL = " ORDER BY jobPos.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_jobpos.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.usermgt.model.JobPos"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.usermgt.model.JobPos"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.usermgt.model.JobPos"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long JOBPOSCODE_COLUMN_BITMASK = 4L;
	public static final long MAPPINGROLEID_COLUMN_BITMASK = 8L;
	public static final long TITLE_COLUMN_BITMASK = 16L;
	public static final long UUID_COLUMN_BITMASK = 32L;
	public static final long CREATEDATE_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.usermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.usermgt.model.JobPos"));

	public JobPosModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _jobPosId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJobPosId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobPosId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JobPos.class;
	}

	@Override
	public String getModelClassName() {
		return JobPos.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("jobPosId", getJobPosId());
		attributes.put("companyId", getCompanyId());
		attributes.put(Field.GROUP_ID, getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("jobPosCode", getJobPosCode());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("mappingRoleId", getMappingRoleId());
		attributes.put("leader", getLeader());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long jobPosId = (Long)attributes.get("jobPosId");

		if (jobPosId != null) {
			setJobPosId(jobPosId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get(Field.GROUP_ID);

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String jobPosCode = (String)attributes.get("jobPosCode");

		if (jobPosCode != null) {
			setJobPosCode(jobPosCode);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long mappingRoleId = (Long)attributes.get("mappingRoleId");

		if (mappingRoleId != null) {
			setMappingRoleId(mappingRoleId);
		}

		Integer leader = (Integer)attributes.get("leader");

		if (leader != null) {
			setLeader(leader);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getJobPosId() {
		return _jobPosId;
	}

	@Override
	public void setJobPosId(long jobPosId) {
		_jobPosId = jobPosId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getJobPosCode() {
		if (_jobPosCode == null) {
			return "";
		}
		else {
			return _jobPosCode;
		}
	}

	@Override
	public void setJobPosCode(String jobPosCode) {
		_columnBitmask |= JOBPOSCODE_COLUMN_BITMASK;

		if (_originalJobPosCode == null) {
			_originalJobPosCode = _jobPosCode;
		}

		_jobPosCode = jobPosCode;
	}

	public String getOriginalJobPosCode() {
		return GetterUtil.getString(_originalJobPosCode);
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public long getMappingRoleId() {
		return _mappingRoleId;
	}

	@Override
	public void setMappingRoleId(long mappingRoleId) {
		_columnBitmask |= MAPPINGROLEID_COLUMN_BITMASK;

		if (!_setOriginalMappingRoleId) {
			_setOriginalMappingRoleId = true;

			_originalMappingRoleId = _mappingRoleId;
		}

		_mappingRoleId = mappingRoleId;
	}

	public long getOriginalMappingRoleId() {
		return _originalMappingRoleId;
	}

	@Override
	public int getLeader() {
		return _leader;
	}

	@Override
	public void setLeader(int leader) {
		_leader = leader;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				JobPos.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			JobPos.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JobPos toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JobPos)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JobPosImpl jobPosImpl = new JobPosImpl();

		jobPosImpl.setUuid(getUuid());
		jobPosImpl.setJobPosId(getJobPosId());
		jobPosImpl.setCompanyId(getCompanyId());
		jobPosImpl.setGroupId(getGroupId());
		jobPosImpl.setUserId(getUserId());
		jobPosImpl.setUserName(getUserName());
		jobPosImpl.setCreateDate(getCreateDate());
		jobPosImpl.setModifiedDate(getModifiedDate());
		jobPosImpl.setJobPosCode(getJobPosCode());
		jobPosImpl.setTitle(getTitle());
		jobPosImpl.setDescription(getDescription());
		jobPosImpl.setMappingRoleId(getMappingRoleId());
		jobPosImpl.setLeader(getLeader());

		jobPosImpl.resetOriginalValues();

		return jobPosImpl;
	}

	@Override
	public int compareTo(JobPos jobPos) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), jobPos.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobPos)) {
			return false;
		}

		JobPos jobPos = (JobPos)obj;

		long primaryKey = jobPos.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		JobPosModelImpl jobPosModelImpl = this;

		jobPosModelImpl._originalUuid = jobPosModelImpl._uuid;

		jobPosModelImpl._originalCompanyId = jobPosModelImpl._companyId;

		jobPosModelImpl._setOriginalCompanyId = false;

		jobPosModelImpl._originalGroupId = jobPosModelImpl._groupId;

		jobPosModelImpl._setOriginalGroupId = false;

		jobPosModelImpl._setModifiedDate = false;

		jobPosModelImpl._originalJobPosCode = jobPosModelImpl._jobPosCode;

		jobPosModelImpl._originalTitle = jobPosModelImpl._title;

		jobPosModelImpl._originalMappingRoleId = jobPosModelImpl._mappingRoleId;

		jobPosModelImpl._setOriginalMappingRoleId = false;

		jobPosModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JobPos> toCacheModel() {
		JobPosCacheModel jobPosCacheModel = new JobPosCacheModel();

		jobPosCacheModel.uuid = getUuid();

		String uuid = jobPosCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			jobPosCacheModel.uuid = null;
		}

		jobPosCacheModel.jobPosId = getJobPosId();

		jobPosCacheModel.companyId = getCompanyId();

		jobPosCacheModel.groupId = getGroupId();

		jobPosCacheModel.userId = getUserId();

		jobPosCacheModel.userName = getUserName();

		String userName = jobPosCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			jobPosCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			jobPosCacheModel.createDate = createDate.getTime();
		}
		else {
			jobPosCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			jobPosCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			jobPosCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		jobPosCacheModel.jobPosCode = getJobPosCode();

		String jobPosCode = jobPosCacheModel.jobPosCode;

		if ((jobPosCode != null) && (jobPosCode.length() == 0)) {
			jobPosCacheModel.jobPosCode = null;
		}

		jobPosCacheModel.title = getTitle();

		String title = jobPosCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			jobPosCacheModel.title = null;
		}

		jobPosCacheModel.description = getDescription();

		String description = jobPosCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			jobPosCacheModel.description = null;
		}

		jobPosCacheModel.mappingRoleId = getMappingRoleId();

		jobPosCacheModel.leader = getLeader();

		return jobPosCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", jobPosId=");
		sb.append(getJobPosId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", jobPosCode=");
		sb.append(getJobPosCode());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", mappingRoleId=");
		sb.append(getMappingRoleId());
		sb.append(", leader=");
		sb.append(getLeader());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.opencps.usermgt.model.JobPos");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobPosId</column-name><column-value><![CDATA[");
		sb.append(getJobPosId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobPosCode</column-name><column-value><![CDATA[");
		sb.append(getJobPosCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingRoleId</column-name><column-value><![CDATA[");
		sb.append(getMappingRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leader</column-name><column-value><![CDATA[");
		sb.append(getLeader());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = JobPos.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			JobPos.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _jobPosId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _jobPosCode;
	private String _originalJobPosCode;
	private String _title;
	private String _originalTitle;
	private String _description;
	private long _mappingRoleId;
	private long _originalMappingRoleId;
	private boolean _setOriginalMappingRoleId;
	private int _leader;
	private long _columnBitmask;
	private JobPos _escapedModel;
}