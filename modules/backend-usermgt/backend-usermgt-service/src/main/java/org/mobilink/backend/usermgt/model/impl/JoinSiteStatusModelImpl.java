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

package org.mobilink.backend.usermgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.mobilink.backend.usermgt.model.JoinSiteStatus;
import org.mobilink.backend.usermgt.model.JoinSiteStatusModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the JoinSiteStatus service. Represents a row in the &quot;m_join_site_status&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link JoinSiteStatusModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JoinSiteStatusImpl}.
 * </p>
 *
 * @author Binhth
 * @see JoinSiteStatusImpl
 * @see JoinSiteStatus
 * @see JoinSiteStatusModel
 * @generated
 */
@ProviderType
public class JoinSiteStatusModelImpl extends BaseModelImpl<JoinSiteStatus>
	implements JoinSiteStatusModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a join site status model instance should use the {@link JoinSiteStatus} interface instead.
	 */
	public static final String TABLE_NAME = "m_join_site_status";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "JoinSiteStatusId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "employeeId", Types.BIGINT },
			{ "joinSiteGroupId", Types.BIGINT },
			{ "status", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("JoinSiteStatusId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("joinSiteGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table m_join_site_status (uuid_ VARCHAR(75) null,JoinSiteStatusId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,employeeId LONG,joinSiteGroupId LONG,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table m_join_site_status";
	public static final String ORDER_BY_JPQL = " ORDER BY joinSiteStatus.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY m_join_site_status.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.usermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.mobilink.backend.usermgt.model.JoinSiteStatus"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.usermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.mobilink.backend.usermgt.model.JoinSiteStatus"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(backend.usermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.mobilink.backend.usermgt.model.JoinSiteStatus"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long EMPLOYEEID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long JOINSITEGROUPID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long CREATEDATE_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.usermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.mobilink.backend.usermgt.model.JoinSiteStatus"));

	public JoinSiteStatusModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _JoinSiteStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJoinSiteStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _JoinSiteStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JoinSiteStatus.class;
	}

	@Override
	public String getModelClassName() {
		return JoinSiteStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("JoinSiteStatusId", getJoinSiteStatusId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("joinSiteGroupId", getJoinSiteGroupId());
		attributes.put("status", getStatus());

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

		Long JoinSiteStatusId = (Long)attributes.get("JoinSiteStatusId");

		if (JoinSiteStatusId != null) {
			setJoinSiteStatusId(JoinSiteStatusId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

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

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long joinSiteGroupId = (Long)attributes.get("joinSiteGroupId");

		if (joinSiteGroupId != null) {
			setJoinSiteGroupId(joinSiteGroupId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
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
	public long getJoinSiteStatusId() {
		return _JoinSiteStatusId;
	}

	@Override
	public void setJoinSiteStatusId(long JoinSiteStatusId) {
		_JoinSiteStatusId = JoinSiteStatusId;
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
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
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
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_columnBitmask |= EMPLOYEEID_COLUMN_BITMASK;

		if (!_setOriginalEmployeeId) {
			_setOriginalEmployeeId = true;

			_originalEmployeeId = _employeeId;
		}

		_employeeId = employeeId;
	}

	public long getOriginalEmployeeId() {
		return _originalEmployeeId;
	}

	@Override
	public long getJoinSiteGroupId() {
		return _joinSiteGroupId;
	}

	@Override
	public void setJoinSiteGroupId(long joinSiteGroupId) {
		_columnBitmask |= JOINSITEGROUPID_COLUMN_BITMASK;

		if (!_setOriginalJoinSiteGroupId) {
			_setOriginalJoinSiteGroupId = true;

			_originalJoinSiteGroupId = _joinSiteGroupId;
		}

		_joinSiteGroupId = joinSiteGroupId;
	}

	public long getOriginalJoinSiteGroupId() {
		return _originalJoinSiteGroupId;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				JoinSiteStatus.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			JoinSiteStatus.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JoinSiteStatus toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JoinSiteStatus)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JoinSiteStatusImpl joinSiteStatusImpl = new JoinSiteStatusImpl();

		joinSiteStatusImpl.setUuid(getUuid());
		joinSiteStatusImpl.setJoinSiteStatusId(getJoinSiteStatusId());
		joinSiteStatusImpl.setCompanyId(getCompanyId());
		joinSiteStatusImpl.setGroupId(getGroupId());
		joinSiteStatusImpl.setUserId(getUserId());
		joinSiteStatusImpl.setUserName(getUserName());
		joinSiteStatusImpl.setCreateDate(getCreateDate());
		joinSiteStatusImpl.setModifiedDate(getModifiedDate());
		joinSiteStatusImpl.setEmployeeId(getEmployeeId());
		joinSiteStatusImpl.setJoinSiteGroupId(getJoinSiteGroupId());
		joinSiteStatusImpl.setStatus(getStatus());

		joinSiteStatusImpl.resetOriginalValues();

		return joinSiteStatusImpl;
	}

	@Override
	public int compareTo(JoinSiteStatus joinSiteStatus) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				joinSiteStatus.getCreateDate());

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

		if (!(obj instanceof JoinSiteStatus)) {
			return false;
		}

		JoinSiteStatus joinSiteStatus = (JoinSiteStatus)obj;

		long primaryKey = joinSiteStatus.getPrimaryKey();

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
		JoinSiteStatusModelImpl joinSiteStatusModelImpl = this;

		joinSiteStatusModelImpl._originalUuid = joinSiteStatusModelImpl._uuid;

		joinSiteStatusModelImpl._originalCompanyId = joinSiteStatusModelImpl._companyId;

		joinSiteStatusModelImpl._setOriginalCompanyId = false;

		joinSiteStatusModelImpl._originalGroupId = joinSiteStatusModelImpl._groupId;

		joinSiteStatusModelImpl._setOriginalGroupId = false;

		joinSiteStatusModelImpl._setModifiedDate = false;

		joinSiteStatusModelImpl._originalEmployeeId = joinSiteStatusModelImpl._employeeId;

		joinSiteStatusModelImpl._setOriginalEmployeeId = false;

		joinSiteStatusModelImpl._originalJoinSiteGroupId = joinSiteStatusModelImpl._joinSiteGroupId;

		joinSiteStatusModelImpl._setOriginalJoinSiteGroupId = false;

		joinSiteStatusModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JoinSiteStatus> toCacheModel() {
		JoinSiteStatusCacheModel joinSiteStatusCacheModel = new JoinSiteStatusCacheModel();

		joinSiteStatusCacheModel.uuid = getUuid();

		String uuid = joinSiteStatusCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			joinSiteStatusCacheModel.uuid = null;
		}

		joinSiteStatusCacheModel.JoinSiteStatusId = getJoinSiteStatusId();

		joinSiteStatusCacheModel.companyId = getCompanyId();

		joinSiteStatusCacheModel.groupId = getGroupId();

		joinSiteStatusCacheModel.userId = getUserId();

		joinSiteStatusCacheModel.userName = getUserName();

		String userName = joinSiteStatusCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			joinSiteStatusCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			joinSiteStatusCacheModel.createDate = createDate.getTime();
		}
		else {
			joinSiteStatusCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			joinSiteStatusCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			joinSiteStatusCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		joinSiteStatusCacheModel.employeeId = getEmployeeId();

		joinSiteStatusCacheModel.joinSiteGroupId = getJoinSiteGroupId();

		joinSiteStatusCacheModel.status = getStatus();

		return joinSiteStatusCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", JoinSiteStatusId=");
		sb.append(getJoinSiteStatusId());
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
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", joinSiteGroupId=");
		sb.append(getJoinSiteGroupId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.mobilink.backend.usermgt.model.JoinSiteStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>JoinSiteStatusId</column-name><column-value><![CDATA[");
		sb.append(getJoinSiteStatusId());
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
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joinSiteGroupId</column-name><column-value><![CDATA[");
		sb.append(getJoinSiteGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = JoinSiteStatus.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			JoinSiteStatus.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _JoinSiteStatusId;
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
	private long _employeeId;
	private long _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private long _joinSiteGroupId;
	private long _originalJoinSiteGroupId;
	private boolean _setOriginalJoinSiteGroupId;
	private int _status;
	private long _columnBitmask;
	private JoinSiteStatus _escapedModel;
}