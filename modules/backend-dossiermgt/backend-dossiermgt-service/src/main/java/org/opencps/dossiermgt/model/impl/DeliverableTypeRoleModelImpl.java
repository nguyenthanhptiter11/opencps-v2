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

package org.opencps.dossiermgt.model.impl;

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

import org.opencps.dossiermgt.model.DeliverableTypeRole;
import org.opencps.dossiermgt.model.DeliverableTypeRoleModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the DeliverableTypeRole service. Represents a row in the &quot;opencps_deliverabletyperole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DeliverableTypeRoleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DeliverableTypeRoleImpl}.
 * </p>
 *
 * @author huymq
 * @see DeliverableTypeRoleImpl
 * @see DeliverableTypeRole
 * @see DeliverableTypeRoleModel
 * @generated
 */
@ProviderType
public class DeliverableTypeRoleModelImpl extends BaseModelImpl<DeliverableTypeRole>
	implements DeliverableTypeRoleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a deliverable type role model instance should use the {@link DeliverableTypeRole} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_deliverabletyperole";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "deliverableTypeRoleId", Types.BIGINT },
			{ Field.GROUP_ID, Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "deliverableTypeId", Types.BIGINT },
			{ "roleId", Types.BIGINT },
			{ "moderator", Types.BOOLEAN }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("deliverableTypeRoleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put(Field.GROUP_ID, Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("deliverableTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("moderator", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_deliverabletyperole (uuid_ VARCHAR(75) null,deliverableTypeRoleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,deliverableTypeId LONG,roleId LONG,moderator BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table opencps_deliverabletyperole";
	public static final String ORDER_BY_JPQL = " ORDER BY deliverableTypeRole.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_deliverabletyperole.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.DeliverableTypeRole"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.DeliverableTypeRole"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.DeliverableTypeRole"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long DELIVERABLETYPEID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long ROLEID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long CREATEDATE_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.DeliverableTypeRole"));

	public DeliverableTypeRoleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _deliverableTypeRoleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDeliverableTypeRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _deliverableTypeRoleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DeliverableTypeRole.class;
	}

	@Override
	public String getModelClassName() {
		return DeliverableTypeRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("deliverableTypeRoleId", getDeliverableTypeRoleId());
		attributes.put(Field.GROUP_ID, getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deliverableTypeId", getDeliverableTypeId());
		attributes.put("roleId", getRoleId());
		attributes.put("moderator", isModerator());

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

		Long deliverableTypeRoleId = (Long)attributes.get(
				"deliverableTypeRoleId");

		if (deliverableTypeRoleId != null) {
			setDeliverableTypeRoleId(deliverableTypeRoleId);
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

		Long deliverableTypeId = (Long)attributes.get("deliverableTypeId");

		if (deliverableTypeId != null) {
			setDeliverableTypeId(deliverableTypeId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Boolean moderator = (Boolean)attributes.get("moderator");

		if (moderator != null) {
			setModerator(moderator);
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
	public long getDeliverableTypeRoleId() {
		return _deliverableTypeRoleId;
	}

	@Override
	public void setDeliverableTypeRoleId(long deliverableTypeRoleId) {
		_deliverableTypeRoleId = deliverableTypeRoleId;
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
	public long getDeliverableTypeId() {
		return _deliverableTypeId;
	}

	@Override
	public void setDeliverableTypeId(long deliverableTypeId) {
		_columnBitmask |= DELIVERABLETYPEID_COLUMN_BITMASK;

		if (!_setOriginalDeliverableTypeId) {
			_setOriginalDeliverableTypeId = true;

			_originalDeliverableTypeId = _deliverableTypeId;
		}

		_deliverableTypeId = deliverableTypeId;
	}

	public long getOriginalDeliverableTypeId() {
		return _originalDeliverableTypeId;
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_columnBitmask |= ROLEID_COLUMN_BITMASK;

		if (!_setOriginalRoleId) {
			_setOriginalRoleId = true;

			_originalRoleId = _roleId;
		}

		_roleId = roleId;
	}

	public long getOriginalRoleId() {
		return _originalRoleId;
	}

	@Override
	public boolean getModerator() {
		return _moderator;
	}

	@Override
	public boolean isModerator() {
		return _moderator;
	}

	@Override
	public void setModerator(boolean moderator) {
		_moderator = moderator;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				DeliverableTypeRole.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DeliverableTypeRole.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DeliverableTypeRole toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DeliverableTypeRole)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DeliverableTypeRoleImpl deliverableTypeRoleImpl = new DeliverableTypeRoleImpl();

		deliverableTypeRoleImpl.setUuid(getUuid());
		deliverableTypeRoleImpl.setDeliverableTypeRoleId(getDeliverableTypeRoleId());
		deliverableTypeRoleImpl.setGroupId(getGroupId());
		deliverableTypeRoleImpl.setCompanyId(getCompanyId());
		deliverableTypeRoleImpl.setUserId(getUserId());
		deliverableTypeRoleImpl.setUserName(getUserName());
		deliverableTypeRoleImpl.setCreateDate(getCreateDate());
		deliverableTypeRoleImpl.setModifiedDate(getModifiedDate());
		deliverableTypeRoleImpl.setDeliverableTypeId(getDeliverableTypeId());
		deliverableTypeRoleImpl.setRoleId(getRoleId());
		deliverableTypeRoleImpl.setModerator(isModerator());

		deliverableTypeRoleImpl.resetOriginalValues();

		return deliverableTypeRoleImpl;
	}

	@Override
	public int compareTo(DeliverableTypeRole deliverableTypeRole) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				deliverableTypeRole.getCreateDate());

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

		if (!(obj instanceof DeliverableTypeRole)) {
			return false;
		}

		DeliverableTypeRole deliverableTypeRole = (DeliverableTypeRole)obj;

		long primaryKey = deliverableTypeRole.getPrimaryKey();

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
		DeliverableTypeRoleModelImpl deliverableTypeRoleModelImpl = this;

		deliverableTypeRoleModelImpl._originalUuid = deliverableTypeRoleModelImpl._uuid;

		deliverableTypeRoleModelImpl._originalGroupId = deliverableTypeRoleModelImpl._groupId;

		deliverableTypeRoleModelImpl._setOriginalGroupId = false;

		deliverableTypeRoleModelImpl._originalCompanyId = deliverableTypeRoleModelImpl._companyId;

		deliverableTypeRoleModelImpl._setOriginalCompanyId = false;

		deliverableTypeRoleModelImpl._setModifiedDate = false;

		deliverableTypeRoleModelImpl._originalDeliverableTypeId = deliverableTypeRoleModelImpl._deliverableTypeId;

		deliverableTypeRoleModelImpl._setOriginalDeliverableTypeId = false;

		deliverableTypeRoleModelImpl._originalRoleId = deliverableTypeRoleModelImpl._roleId;

		deliverableTypeRoleModelImpl._setOriginalRoleId = false;

		deliverableTypeRoleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DeliverableTypeRole> toCacheModel() {
		DeliverableTypeRoleCacheModel deliverableTypeRoleCacheModel = new DeliverableTypeRoleCacheModel();

		deliverableTypeRoleCacheModel.uuid = getUuid();

		String uuid = deliverableTypeRoleCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			deliverableTypeRoleCacheModel.uuid = null;
		}

		deliverableTypeRoleCacheModel.deliverableTypeRoleId = getDeliverableTypeRoleId();

		deliverableTypeRoleCacheModel.groupId = getGroupId();

		deliverableTypeRoleCacheModel.companyId = getCompanyId();

		deliverableTypeRoleCacheModel.userId = getUserId();

		deliverableTypeRoleCacheModel.userName = getUserName();

		String userName = deliverableTypeRoleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			deliverableTypeRoleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			deliverableTypeRoleCacheModel.createDate = createDate.getTime();
		}
		else {
			deliverableTypeRoleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			deliverableTypeRoleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			deliverableTypeRoleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		deliverableTypeRoleCacheModel.deliverableTypeId = getDeliverableTypeId();

		deliverableTypeRoleCacheModel.roleId = getRoleId();

		deliverableTypeRoleCacheModel.moderator = isModerator();

		return deliverableTypeRoleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", deliverableTypeRoleId=");
		sb.append(getDeliverableTypeRoleId());
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
		sb.append(", deliverableTypeId=");
		sb.append(getDeliverableTypeId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", moderator=");
		sb.append(isModerator());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.DeliverableTypeRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliverableTypeRoleId</column-name><column-value><![CDATA[");
		sb.append(getDeliverableTypeRoleId());
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
			"<column><column-name>deliverableTypeId</column-name><column-value><![CDATA[");
		sb.append(getDeliverableTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moderator</column-name><column-value><![CDATA[");
		sb.append(isModerator());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = DeliverableTypeRole.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			DeliverableTypeRole.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _deliverableTypeRoleId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _deliverableTypeId;
	private long _originalDeliverableTypeId;
	private boolean _setOriginalDeliverableTypeId;
	private long _roleId;
	private long _originalRoleId;
	private boolean _setOriginalRoleId;
	private boolean _moderator;
	private long _columnBitmask;
	private DeliverableTypeRole _escapedModel;
}