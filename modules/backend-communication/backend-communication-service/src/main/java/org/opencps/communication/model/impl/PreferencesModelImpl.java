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

package org.opencps.communication.model.impl;

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

import org.opencps.communication.model.Preferences;
import org.opencps.communication.model.PreferencesModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Preferences service. Represents a row in the &quot;opencps_preferences&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link PreferencesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PreferencesImpl}.
 * </p>
 *
 * @author khoavd
 * @see PreferencesImpl
 * @see Preferences
 * @see PreferencesModel
 * @generated
 */
@ProviderType
public class PreferencesModelImpl extends BaseModelImpl<Preferences>
	implements PreferencesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a preferences model instance should use the {@link Preferences} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_preferences";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "preferencesId", Types.BIGINT },
			{ Field.GROUP_ID, Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "preferences", Types.CLOB }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("preferencesId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put(Field.GROUP_ID, Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("preferences", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_preferences (uuid_ VARCHAR(75) null,preferencesId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,preferences TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_preferences";
	public static final String ORDER_BY_JPQL = " ORDER BY preferences.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_preferences.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.communication.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.communication.model.Preferences"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.communication.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.communication.model.Preferences"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(backend.communication.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.communication.model.Preferences"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.communication.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.communication.model.Preferences"));

	public PreferencesModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _preferencesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPreferencesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _preferencesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Preferences.class;
	}

	@Override
	public String getModelClassName() {
		return Preferences.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("preferencesId", getPreferencesId());
		attributes.put(Field.GROUP_ID, getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("preferences", getPreferences());

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

		Long preferencesId = (Long)attributes.get("preferencesId");

		if (preferencesId != null) {
			setPreferencesId(preferencesId);
		}

		Long groupId = (Long)attributes.get(Field.GROUP_ID);

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String preferences = (String)attributes.get("preferences");

		if (preferences != null) {
			setPreferences(preferences);
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
	public long getPreferencesId() {
		return _preferencesId;
	}

	@Override
	public void setPreferencesId(long preferencesId) {
		_preferencesId = preferencesId;
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
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
	public String getPreferences() {
		if (_preferences == null) {
			return "";
		}
		else {
			return _preferences;
		}
	}

	@Override
	public void setPreferences(String preferences) {
		_preferences = preferences;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Preferences.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Preferences.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Preferences toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Preferences)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PreferencesImpl preferencesImpl = new PreferencesImpl();

		preferencesImpl.setUuid(getUuid());
		preferencesImpl.setPreferencesId(getPreferencesId());
		preferencesImpl.setGroupId(getGroupId());
		preferencesImpl.setCompanyId(getCompanyId());
		preferencesImpl.setUserId(getUserId());
		preferencesImpl.setUserName(getUserName());
		preferencesImpl.setCreateDate(getCreateDate());
		preferencesImpl.setModifiedDate(getModifiedDate());
		preferencesImpl.setPreferences(getPreferences());

		preferencesImpl.resetOriginalValues();

		return preferencesImpl;
	}

	@Override
	public int compareTo(Preferences preferences) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), preferences.getCreateDate());

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

		if (!(obj instanceof Preferences)) {
			return false;
		}

		Preferences preferences = (Preferences)obj;

		long primaryKey = preferences.getPrimaryKey();

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
		PreferencesModelImpl preferencesModelImpl = this;

		preferencesModelImpl._originalUuid = preferencesModelImpl._uuid;

		preferencesModelImpl._originalGroupId = preferencesModelImpl._groupId;

		preferencesModelImpl._setOriginalGroupId = false;

		preferencesModelImpl._originalCompanyId = preferencesModelImpl._companyId;

		preferencesModelImpl._setOriginalCompanyId = false;

		preferencesModelImpl._originalUserId = preferencesModelImpl._userId;

		preferencesModelImpl._setOriginalUserId = false;

		preferencesModelImpl._setModifiedDate = false;

		preferencesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Preferences> toCacheModel() {
		PreferencesCacheModel preferencesCacheModel = new PreferencesCacheModel();

		preferencesCacheModel.uuid = getUuid();

		String uuid = preferencesCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			preferencesCacheModel.uuid = null;
		}

		preferencesCacheModel.preferencesId = getPreferencesId();

		preferencesCacheModel.groupId = getGroupId();

		preferencesCacheModel.companyId = getCompanyId();

		preferencesCacheModel.userId = getUserId();

		preferencesCacheModel.userName = getUserName();

		String userName = preferencesCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			preferencesCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			preferencesCacheModel.createDate = createDate.getTime();
		}
		else {
			preferencesCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			preferencesCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			preferencesCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		preferencesCacheModel.preferences = getPreferences();

		String preferences = preferencesCacheModel.preferences;

		if ((preferences != null) && (preferences.length() == 0)) {
			preferencesCacheModel.preferences = null;
		}

		return preferencesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", preferencesId=");
		sb.append(getPreferencesId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", preferences=");
		sb.append(getPreferences());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.opencps.communication.model.Preferences");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preferencesId</column-name><column-value><![CDATA[");
		sb.append(getPreferencesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>preferences</column-name><column-value><![CDATA[");
		sb.append(getPreferences());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Preferences.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Preferences.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _preferencesId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _preferences;
	private long _columnBitmask;
	private Preferences _escapedModel;
}