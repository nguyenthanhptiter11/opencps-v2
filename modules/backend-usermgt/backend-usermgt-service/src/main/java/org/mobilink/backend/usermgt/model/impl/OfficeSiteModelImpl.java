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

import org.mobilink.backend.usermgt.model.OfficeSite;
import org.mobilink.backend.usermgt.model.OfficeSiteModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OfficeSite service. Represents a row in the &quot;m_officesite&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link OfficeSiteModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OfficeSiteImpl}.
 * </p>
 *
 * @author Binhth
 * @see OfficeSiteImpl
 * @see OfficeSite
 * @see OfficeSiteModel
 * @generated
 */
@ProviderType
public class OfficeSiteModelImpl extends BaseModelImpl<OfficeSite>
	implements OfficeSiteModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a office site model instance should use the {@link OfficeSite} interface instead.
	 */
	public static final String TABLE_NAME = "m_officesite";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "officeSiteId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "enName", Types.VARCHAR },
			{ "govAgencyCode", Types.VARCHAR },
			{ "address", Types.VARCHAR },
			{ "telNo", Types.VARCHAR },
			{ "faxNo", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "website", Types.VARCHAR },
			{ "logoFileEntryId", Types.BIGINT },
			{ "siteGroupId", Types.BIGINT },
			{ "adminUserId", Types.BIGINT },
			{ "preferences", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officeSiteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("enName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("govAgencyCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("telNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("faxNo", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("website", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("logoFileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("siteGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("adminUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("preferences", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table m_officesite (uuid_ VARCHAR(75) null,officeSiteId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,enName VARCHAR(75) null,govAgencyCode VARCHAR(75) null,address VARCHAR(75) null,telNo VARCHAR(75) null,faxNo VARCHAR(75) null,email VARCHAR(75) null,website VARCHAR(75) null,logoFileEntryId LONG,siteGroupId LONG,adminUserId LONG,preferences VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table m_officesite";
	public static final String ORDER_BY_JPQL = " ORDER BY officeSite.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY m_officesite.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(backend.usermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.mobilink.backend.usermgt.model.OfficeSite"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(backend.usermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.mobilink.backend.usermgt.model.OfficeSite"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(backend.usermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.mobilink.backend.usermgt.model.OfficeSite"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long UUID_COLUMN_BITMASK = 4L;
	public static final long CREATEDATE_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(backend.usermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.mobilink.backend.usermgt.model.OfficeSite"));

	public OfficeSiteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _officeSiteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeSiteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeSiteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSite.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("officeSiteId", getOfficeSiteId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("enName", getEnName());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("address", getAddress());
		attributes.put("telNo", getTelNo());
		attributes.put("faxNo", getFaxNo());
		attributes.put("email", getEmail());
		attributes.put("website", getWebsite());
		attributes.put("logoFileEntryId", getLogoFileEntryId());
		attributes.put("siteGroupId", getSiteGroupId());
		attributes.put("adminUserId", getAdminUserId());
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

		Long officeSiteId = (Long)attributes.get("officeSiteId");

		if (officeSiteId != null) {
			setOfficeSiteId(officeSiteId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String enName = (String)attributes.get("enName");

		if (enName != null) {
			setEnName(enName);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String telNo = (String)attributes.get("telNo");

		if (telNo != null) {
			setTelNo(telNo);
		}

		String faxNo = (String)attributes.get("faxNo");

		if (faxNo != null) {
			setFaxNo(faxNo);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		Long logoFileEntryId = (Long)attributes.get("logoFileEntryId");

		if (logoFileEntryId != null) {
			setLogoFileEntryId(logoFileEntryId);
		}

		Long siteGroupId = (Long)attributes.get("siteGroupId");

		if (siteGroupId != null) {
			setSiteGroupId(siteGroupId);
		}

		Long adminUserId = (Long)attributes.get("adminUserId");

		if (adminUserId != null) {
			setAdminUserId(adminUserId);
		}

		String preferences = (String)attributes.get("preferences");

		if (preferences != null) {
			setPreferences(preferences);
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
	public long getOfficeSiteId() {
		return _officeSiteId;
	}

	@Override
	public void setOfficeSiteId(long officeSiteId) {
		_officeSiteId = officeSiteId;
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
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getEnName() {
		if (_enName == null) {
			return StringPool.BLANK;
		}
		else {
			return _enName;
		}
	}

	@Override
	public void setEnName(String enName) {
		_enName = enName;
	}

	@Override
	public String getGovAgencyCode() {
		if (_govAgencyCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _govAgencyCode;
		}
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;
	}

	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@Override
	public String getTelNo() {
		if (_telNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _telNo;
		}
	}

	@Override
	public void setTelNo(String telNo) {
		_telNo = telNo;
	}

	@Override
	public String getFaxNo() {
		if (_faxNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _faxNo;
		}
	}

	@Override
	public void setFaxNo(String faxNo) {
		_faxNo = faxNo;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String getWebsite() {
		if (_website == null) {
			return StringPool.BLANK;
		}
		else {
			return _website;
		}
	}

	@Override
	public void setWebsite(String website) {
		_website = website;
	}

	@Override
	public long getLogoFileEntryId() {
		return _logoFileEntryId;
	}

	@Override
	public void setLogoFileEntryId(long logoFileEntryId) {
		_logoFileEntryId = logoFileEntryId;
	}

	@Override
	public long getSiteGroupId() {
		return _siteGroupId;
	}

	@Override
	public void setSiteGroupId(long siteGroupId) {
		_siteGroupId = siteGroupId;
	}

	@Override
	public long getAdminUserId() {
		return _adminUserId;
	}

	@Override
	public void setAdminUserId(long adminUserId) {
		_adminUserId = adminUserId;
	}

	@Override
	public String getAdminUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getAdminUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setAdminUserUuid(String adminUserUuid) {
	}

	@Override
	public String getPreferences() {
		if (_preferences == null) {
			return StringPool.BLANK;
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
				OfficeSite.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			OfficeSite.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OfficeSite toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OfficeSite)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OfficeSiteImpl officeSiteImpl = new OfficeSiteImpl();

		officeSiteImpl.setUuid(getUuid());
		officeSiteImpl.setOfficeSiteId(getOfficeSiteId());
		officeSiteImpl.setCompanyId(getCompanyId());
		officeSiteImpl.setGroupId(getGroupId());
		officeSiteImpl.setUserId(getUserId());
		officeSiteImpl.setUserName(getUserName());
		officeSiteImpl.setCreateDate(getCreateDate());
		officeSiteImpl.setModifiedDate(getModifiedDate());
		officeSiteImpl.setName(getName());
		officeSiteImpl.setEnName(getEnName());
		officeSiteImpl.setGovAgencyCode(getGovAgencyCode());
		officeSiteImpl.setAddress(getAddress());
		officeSiteImpl.setTelNo(getTelNo());
		officeSiteImpl.setFaxNo(getFaxNo());
		officeSiteImpl.setEmail(getEmail());
		officeSiteImpl.setWebsite(getWebsite());
		officeSiteImpl.setLogoFileEntryId(getLogoFileEntryId());
		officeSiteImpl.setSiteGroupId(getSiteGroupId());
		officeSiteImpl.setAdminUserId(getAdminUserId());
		officeSiteImpl.setPreferences(getPreferences());

		officeSiteImpl.resetOriginalValues();

		return officeSiteImpl;
	}

	@Override
	public int compareTo(OfficeSite officeSite) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), officeSite.getCreateDate());

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

		if (!(obj instanceof OfficeSite)) {
			return false;
		}

		OfficeSite officeSite = (OfficeSite)obj;

		long primaryKey = officeSite.getPrimaryKey();

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
		OfficeSiteModelImpl officeSiteModelImpl = this;

		officeSiteModelImpl._originalUuid = officeSiteModelImpl._uuid;

		officeSiteModelImpl._originalCompanyId = officeSiteModelImpl._companyId;

		officeSiteModelImpl._setOriginalCompanyId = false;

		officeSiteModelImpl._originalGroupId = officeSiteModelImpl._groupId;

		officeSiteModelImpl._setOriginalGroupId = false;

		officeSiteModelImpl._setModifiedDate = false;

		officeSiteModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OfficeSite> toCacheModel() {
		OfficeSiteCacheModel officeSiteCacheModel = new OfficeSiteCacheModel();

		officeSiteCacheModel.uuid = getUuid();

		String uuid = officeSiteCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			officeSiteCacheModel.uuid = null;
		}

		officeSiteCacheModel.officeSiteId = getOfficeSiteId();

		officeSiteCacheModel.companyId = getCompanyId();

		officeSiteCacheModel.groupId = getGroupId();

		officeSiteCacheModel.userId = getUserId();

		officeSiteCacheModel.userName = getUserName();

		String userName = officeSiteCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			officeSiteCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			officeSiteCacheModel.createDate = createDate.getTime();
		}
		else {
			officeSiteCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			officeSiteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			officeSiteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		officeSiteCacheModel.name = getName();

		String name = officeSiteCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			officeSiteCacheModel.name = null;
		}

		officeSiteCacheModel.enName = getEnName();

		String enName = officeSiteCacheModel.enName;

		if ((enName != null) && (enName.length() == 0)) {
			officeSiteCacheModel.enName = null;
		}

		officeSiteCacheModel.govAgencyCode = getGovAgencyCode();

		String govAgencyCode = officeSiteCacheModel.govAgencyCode;

		if ((govAgencyCode != null) && (govAgencyCode.length() == 0)) {
			officeSiteCacheModel.govAgencyCode = null;
		}

		officeSiteCacheModel.address = getAddress();

		String address = officeSiteCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			officeSiteCacheModel.address = null;
		}

		officeSiteCacheModel.telNo = getTelNo();

		String telNo = officeSiteCacheModel.telNo;

		if ((telNo != null) && (telNo.length() == 0)) {
			officeSiteCacheModel.telNo = null;
		}

		officeSiteCacheModel.faxNo = getFaxNo();

		String faxNo = officeSiteCacheModel.faxNo;

		if ((faxNo != null) && (faxNo.length() == 0)) {
			officeSiteCacheModel.faxNo = null;
		}

		officeSiteCacheModel.email = getEmail();

		String email = officeSiteCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			officeSiteCacheModel.email = null;
		}

		officeSiteCacheModel.website = getWebsite();

		String website = officeSiteCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			officeSiteCacheModel.website = null;
		}

		officeSiteCacheModel.logoFileEntryId = getLogoFileEntryId();

		officeSiteCacheModel.siteGroupId = getSiteGroupId();

		officeSiteCacheModel.adminUserId = getAdminUserId();

		officeSiteCacheModel.preferences = getPreferences();

		String preferences = officeSiteCacheModel.preferences;

		if ((preferences != null) && (preferences.length() == 0)) {
			officeSiteCacheModel.preferences = null;
		}

		return officeSiteCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", officeSiteId=");
		sb.append(getOfficeSiteId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", enName=");
		sb.append(getEnName());
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", telNo=");
		sb.append(getTelNo());
		sb.append(", faxNo=");
		sb.append(getFaxNo());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", logoFileEntryId=");
		sb.append(getLogoFileEntryId());
		sb.append(", siteGroupId=");
		sb.append(getSiteGroupId());
		sb.append(", adminUserId=");
		sb.append(getAdminUserId());
		sb.append(", preferences=");
		sb.append(getPreferences());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("org.mobilink.backend.usermgt.model.OfficeSite");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSiteId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSiteId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enName</column-name><column-value><![CDATA[");
		sb.append(getEnName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telNo</column-name><column-value><![CDATA[");
		sb.append(getTelNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>faxNo</column-name><column-value><![CDATA[");
		sb.append(getFaxNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logoFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getLogoFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteGroupId</column-name><column-value><![CDATA[");
		sb.append(getSiteGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adminUserId</column-name><column-value><![CDATA[");
		sb.append(getAdminUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preferences</column-name><column-value><![CDATA[");
		sb.append(getPreferences());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = OfficeSite.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			OfficeSite.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _officeSiteId;
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
	private String _name;
	private String _enName;
	private String _govAgencyCode;
	private String _address;
	private String _telNo;
	private String _faxNo;
	private String _email;
	private String _website;
	private long _logoFileEntryId;
	private long _siteGroupId;
	private long _adminUserId;
	private String _preferences;
	private long _columnBitmask;
	private OfficeSite _escapedModel;
}