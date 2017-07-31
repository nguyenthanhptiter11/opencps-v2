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

package org.mobilink.backend.datamgt.model.impl;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.mobilink.backend.datamgt.model.DictItemGroup;
import org.mobilink.backend.datamgt.model.DictItemGroupModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DictItemGroup service. Represents a row in the &quot;m_dictitemgroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DictItemGroupModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DictItemGroupImpl}.
 * </p>
 *
 * @author Binhth
 * @see DictItemGroupImpl
 * @see DictItemGroup
 * @see DictItemGroupModel
 * @generated
 */
@ProviderType
public class DictItemGroupModelImpl extends BaseModelImpl<DictItemGroup>
	implements DictItemGroupModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dict item group model instance should use the {@link DictItemGroup} interface instead.
	 */
	public static final String TABLE_NAME = "m_dictitemgroup";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "dictItemGroupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "dictGroupId", Types.BIGINT },
			{ "dictItemId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dictItemGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dictGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dictItemId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table m_dictitemgroup (uuid_ VARCHAR(75) null,dictItemGroupId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,dictGroupId LONG,dictItemId LONG)";
	public static final String TABLE_SQL_DROP = "drop table m_dictitemgroup";
	public static final String ORDER_BY_JPQL = " ORDER BY dictItemGroup.dictGroupId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY m_dictitemgroup.dictGroupId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.datamgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.mobilink.backend.datamgt.model.DictItemGroup"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.datamgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.mobilink.backend.datamgt.model.DictItemGroup"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(backend.datamgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.mobilink.backend.datamgt.model.DictItemGroup"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long DICTGROUPID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.datamgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.mobilink.backend.datamgt.model.DictItemGroup"));

	public DictItemGroupModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dictItemGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictItemGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictItemGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DictItemGroup.class;
	}

	@Override
	public String getModelClassName() {
		return DictItemGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("dictItemGroupId", getDictItemGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dictGroupId", getDictGroupId());
		attributes.put("dictItemId", getDictItemId());

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

		Long dictItemGroupId = (Long)attributes.get("dictItemGroupId");

		if (dictItemGroupId != null) {
			setDictItemGroupId(dictItemGroupId);
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

		Long dictGroupId = (Long)attributes.get("dictGroupId");

		if (dictGroupId != null) {
			setDictGroupId(dictGroupId);
		}

		Long dictItemId = (Long)attributes.get("dictItemId");

		if (dictItemId != null) {
			setDictItemId(dictItemId);
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
	public long getDictItemGroupId() {
		return _dictItemGroupId;
	}

	@Override
	public void setDictItemGroupId(long dictItemGroupId) {
		_dictItemGroupId = dictItemGroupId;
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
	public long getDictGroupId() {
		return _dictGroupId;
	}

	@Override
	public void setDictGroupId(long dictGroupId) {
		_columnBitmask = -1L;

		_dictGroupId = dictGroupId;
	}

	@Override
	public long getDictItemId() {
		return _dictItemId;
	}

	@Override
	public void setDictItemId(long dictItemId) {
		_dictItemId = dictItemId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				DictItemGroup.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DictItemGroup.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DictItemGroup toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DictItemGroup)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DictItemGroupImpl dictItemGroupImpl = new DictItemGroupImpl();

		dictItemGroupImpl.setUuid(getUuid());
		dictItemGroupImpl.setDictItemGroupId(getDictItemGroupId());
		dictItemGroupImpl.setCompanyId(getCompanyId());
		dictItemGroupImpl.setGroupId(getGroupId());
		dictItemGroupImpl.setUserId(getUserId());
		dictItemGroupImpl.setUserName(getUserName());
		dictItemGroupImpl.setCreateDate(getCreateDate());
		dictItemGroupImpl.setModifiedDate(getModifiedDate());
		dictItemGroupImpl.setDictGroupId(getDictGroupId());
		dictItemGroupImpl.setDictItemId(getDictItemId());

		dictItemGroupImpl.resetOriginalValues();

		return dictItemGroupImpl;
	}

	@Override
	public int compareTo(DictItemGroup dictItemGroup) {
		int value = 0;

		if (getDictGroupId() < dictItemGroup.getDictGroupId()) {
			value = -1;
		}
		else if (getDictGroupId() > dictItemGroup.getDictGroupId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof DictItemGroup)) {
			return false;
		}

		DictItemGroup dictItemGroup = (DictItemGroup)obj;

		long primaryKey = dictItemGroup.getPrimaryKey();

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
		DictItemGroupModelImpl dictItemGroupModelImpl = this;

		dictItemGroupModelImpl._originalUuid = dictItemGroupModelImpl._uuid;

		dictItemGroupModelImpl._originalCompanyId = dictItemGroupModelImpl._companyId;

		dictItemGroupModelImpl._setOriginalCompanyId = false;

		dictItemGroupModelImpl._originalGroupId = dictItemGroupModelImpl._groupId;

		dictItemGroupModelImpl._setOriginalGroupId = false;

		dictItemGroupModelImpl._setModifiedDate = false;

		dictItemGroupModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DictItemGroup> toCacheModel() {
		DictItemGroupCacheModel dictItemGroupCacheModel = new DictItemGroupCacheModel();

		dictItemGroupCacheModel.uuid = getUuid();

		String uuid = dictItemGroupCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dictItemGroupCacheModel.uuid = null;
		}

		dictItemGroupCacheModel.dictItemGroupId = getDictItemGroupId();

		dictItemGroupCacheModel.companyId = getCompanyId();

		dictItemGroupCacheModel.groupId = getGroupId();

		dictItemGroupCacheModel.userId = getUserId();

		dictItemGroupCacheModel.userName = getUserName();

		String userName = dictItemGroupCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dictItemGroupCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dictItemGroupCacheModel.createDate = createDate.getTime();
		}
		else {
			dictItemGroupCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dictItemGroupCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dictItemGroupCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dictItemGroupCacheModel.dictGroupId = getDictGroupId();

		dictItemGroupCacheModel.dictItemId = getDictItemId();

		return dictItemGroupCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", dictItemGroupId=");
		sb.append(getDictItemGroupId());
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
		sb.append(", dictGroupId=");
		sb.append(getDictGroupId());
		sb.append(", dictItemId=");
		sb.append(getDictItemId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.mobilink.backend.datamgt.model.DictItemGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictItemGroupId</column-name><column-value><![CDATA[");
		sb.append(getDictItemGroupId());
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
			"<column><column-name>dictGroupId</column-name><column-value><![CDATA[");
		sb.append(getDictGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictItemId</column-name><column-value><![CDATA[");
		sb.append(getDictItemId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DictItemGroup.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DictItemGroup.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _dictItemGroupId;
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
	private long _dictGroupId;
	private long _dictItemId;
	private long _columnBitmask;
	private DictItemGroup _escapedModel;
}