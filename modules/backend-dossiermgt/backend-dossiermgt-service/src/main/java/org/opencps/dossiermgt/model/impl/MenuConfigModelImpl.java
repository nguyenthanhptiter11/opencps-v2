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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.dossiermgt.model.MenuConfig;
import org.opencps.dossiermgt.model.MenuConfigModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the MenuConfig service. Represents a row in the &quot;opencps_menuconfig&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link MenuConfigModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MenuConfigImpl}.
 * </p>
 *
 * @author huymq
 * @see MenuConfigImpl
 * @see MenuConfig
 * @see MenuConfigModel
 * @generated
 */
@ProviderType
public class MenuConfigModelImpl extends BaseModelImpl<MenuConfig>
	implements MenuConfigModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a menu config model instance should use the {@link MenuConfig} interface instead.
	 */
	public static final String TABLE_NAME = "opencps_menuconfig";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "menuConfigId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "menuGroup", Types.VARCHAR },
			{ "menuName", Types.VARCHAR },
			{ "order_", Types.INTEGER },
			{ "menuType", Types.INTEGER },
			{ "queryParams", Types.VARCHAR },
			{ "tableConfig", Types.VARCHAR },
			{ "buttonConfig", Types.VARCHAR },
			{ "icon", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("menuConfigId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("menuGroup", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("menuName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("menuType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("queryParams", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("tableConfig", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("buttonConfig", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("icon", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table opencps_menuconfig (uuid_ VARCHAR(75) null,menuConfigId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,menuGroup VARCHAR(75) null,menuName VARCHAR(75) null,order_ INTEGER,menuType INTEGER,queryParams VARCHAR(75) null,tableConfig VARCHAR(75) null,buttonConfig VARCHAR(75) null,icon VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table opencps_menuconfig";
	public static final String ORDER_BY_JPQL = " ORDER BY menuConfig.order ASC";
	public static final String ORDER_BY_SQL = " ORDER BY opencps_menuconfig.order_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.dossiermgt.model.MenuConfig"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.dossiermgt.model.MenuConfig"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.dossiermgt.model.MenuConfig"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long MENUCONFIGID_COLUMN_BITMASK = 4L;
	public static final long MENUGROUP_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long ORDER_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.dossiermgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.dossiermgt.model.MenuConfig"));

	public MenuConfigModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _menuConfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMenuConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _menuConfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MenuConfig.class;
	}

	@Override
	public String getModelClassName() {
		return MenuConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("menuConfigId", getMenuConfigId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("menuGroup", getMenuGroup());
		attributes.put("menuName", getMenuName());
		attributes.put("order", getOrder());
		attributes.put("menuType", getMenuType());
		attributes.put("queryParams", getQueryParams());
		attributes.put("tableConfig", getTableConfig());
		attributes.put("buttonConfig", getButtonConfig());
		attributes.put("icon", getIcon());

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

		Long menuConfigId = (Long)attributes.get("menuConfigId");

		if (menuConfigId != null) {
			setMenuConfigId(menuConfigId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String menuGroup = (String)attributes.get("menuGroup");

		if (menuGroup != null) {
			setMenuGroup(menuGroup);
		}

		String menuName = (String)attributes.get("menuName");

		if (menuName != null) {
			setMenuName(menuName);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Integer menuType = (Integer)attributes.get("menuType");

		if (menuType != null) {
			setMenuType(menuType);
		}

		String queryParams = (String)attributes.get("queryParams");

		if (queryParams != null) {
			setQueryParams(queryParams);
		}

		String tableConfig = (String)attributes.get("tableConfig");

		if (tableConfig != null) {
			setTableConfig(tableConfig);
		}

		String buttonConfig = (String)attributes.get("buttonConfig");

		if (buttonConfig != null) {
			setButtonConfig(buttonConfig);
		}

		String icon = (String)attributes.get("icon");

		if (icon != null) {
			setIcon(icon);
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
	public long getMenuConfigId() {
		return _menuConfigId;
	}

	@Override
	public void setMenuConfigId(long menuConfigId) {
		_columnBitmask |= MENUCONFIGID_COLUMN_BITMASK;

		if (!_setOriginalMenuConfigId) {
			_setOriginalMenuConfigId = true;

			_originalMenuConfigId = _menuConfigId;
		}

		_menuConfigId = menuConfigId;
	}

	public long getOriginalMenuConfigId() {
		return _originalMenuConfigId;
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
	public String getMenuGroup() {
		if (_menuGroup == null) {
			return "";
		}
		else {
			return _menuGroup;
		}
	}

	@Override
	public void setMenuGroup(String menuGroup) {
		_columnBitmask |= MENUGROUP_COLUMN_BITMASK;

		if (_originalMenuGroup == null) {
			_originalMenuGroup = _menuGroup;
		}

		_menuGroup = menuGroup;
	}

	public String getOriginalMenuGroup() {
		return GetterUtil.getString(_originalMenuGroup);
	}

	@Override
	public String getMenuName() {
		if (_menuName == null) {
			return "";
		}
		else {
			return _menuName;
		}
	}

	@Override
	public void setMenuName(String menuName) {
		_menuName = menuName;
	}

	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_columnBitmask = -1L;

		_order = order;
	}

	@Override
	public int getMenuType() {
		return _menuType;
	}

	@Override
	public void setMenuType(int menuType) {
		_menuType = menuType;
	}

	@Override
	public String getQueryParams() {
		if (_queryParams == null) {
			return "";
		}
		else {
			return _queryParams;
		}
	}

	@Override
	public void setQueryParams(String queryParams) {
		_queryParams = queryParams;
	}

	@Override
	public String getTableConfig() {
		if (_tableConfig == null) {
			return "";
		}
		else {
			return _tableConfig;
		}
	}

	@Override
	public void setTableConfig(String tableConfig) {
		_tableConfig = tableConfig;
	}

	@Override
	public String getButtonConfig() {
		if (_buttonConfig == null) {
			return "";
		}
		else {
			return _buttonConfig;
		}
	}

	@Override
	public void setButtonConfig(String buttonConfig) {
		_buttonConfig = buttonConfig;
	}

	@Override
	public String getIcon() {
		if (_icon == null) {
			return "";
		}
		else {
			return _icon;
		}
	}

	@Override
	public void setIcon(String icon) {
		_icon = icon;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				MenuConfig.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			MenuConfig.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MenuConfig toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MenuConfig)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MenuConfigImpl menuConfigImpl = new MenuConfigImpl();

		menuConfigImpl.setUuid(getUuid());
		menuConfigImpl.setMenuConfigId(getMenuConfigId());
		menuConfigImpl.setCompanyId(getCompanyId());
		menuConfigImpl.setGroupId(getGroupId());
		menuConfigImpl.setUserId(getUserId());
		menuConfigImpl.setCreateDate(getCreateDate());
		menuConfigImpl.setModifiedDate(getModifiedDate());
		menuConfigImpl.setMenuGroup(getMenuGroup());
		menuConfigImpl.setMenuName(getMenuName());
		menuConfigImpl.setOrder(getOrder());
		menuConfigImpl.setMenuType(getMenuType());
		menuConfigImpl.setQueryParams(getQueryParams());
		menuConfigImpl.setTableConfig(getTableConfig());
		menuConfigImpl.setButtonConfig(getButtonConfig());
		menuConfigImpl.setIcon(getIcon());

		menuConfigImpl.resetOriginalValues();

		return menuConfigImpl;
	}

	@Override
	public int compareTo(MenuConfig menuConfig) {
		int value = 0;

		if (getOrder() < menuConfig.getOrder()) {
			value = -1;
		}
		else if (getOrder() > menuConfig.getOrder()) {
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

		if (!(obj instanceof MenuConfig)) {
			return false;
		}

		MenuConfig menuConfig = (MenuConfig)obj;

		long primaryKey = menuConfig.getPrimaryKey();

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
		MenuConfigModelImpl menuConfigModelImpl = this;

		menuConfigModelImpl._originalUuid = menuConfigModelImpl._uuid;

		menuConfigModelImpl._originalMenuConfigId = menuConfigModelImpl._menuConfigId;

		menuConfigModelImpl._setOriginalMenuConfigId = false;

		menuConfigModelImpl._originalCompanyId = menuConfigModelImpl._companyId;

		menuConfigModelImpl._setOriginalCompanyId = false;

		menuConfigModelImpl._originalGroupId = menuConfigModelImpl._groupId;

		menuConfigModelImpl._setOriginalGroupId = false;

		menuConfigModelImpl._setModifiedDate = false;

		menuConfigModelImpl._originalMenuGroup = menuConfigModelImpl._menuGroup;

		menuConfigModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<MenuConfig> toCacheModel() {
		MenuConfigCacheModel menuConfigCacheModel = new MenuConfigCacheModel();

		menuConfigCacheModel.uuid = getUuid();

		String uuid = menuConfigCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			menuConfigCacheModel.uuid = null;
		}

		menuConfigCacheModel.menuConfigId = getMenuConfigId();

		menuConfigCacheModel.companyId = getCompanyId();

		menuConfigCacheModel.groupId = getGroupId();

		menuConfigCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			menuConfigCacheModel.createDate = createDate.getTime();
		}
		else {
			menuConfigCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			menuConfigCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			menuConfigCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		menuConfigCacheModel.menuGroup = getMenuGroup();

		String menuGroup = menuConfigCacheModel.menuGroup;

		if ((menuGroup != null) && (menuGroup.length() == 0)) {
			menuConfigCacheModel.menuGroup = null;
		}

		menuConfigCacheModel.menuName = getMenuName();

		String menuName = menuConfigCacheModel.menuName;

		if ((menuName != null) && (menuName.length() == 0)) {
			menuConfigCacheModel.menuName = null;
		}

		menuConfigCacheModel.order = getOrder();

		menuConfigCacheModel.menuType = getMenuType();

		menuConfigCacheModel.queryParams = getQueryParams();

		String queryParams = menuConfigCacheModel.queryParams;

		if ((queryParams != null) && (queryParams.length() == 0)) {
			menuConfigCacheModel.queryParams = null;
		}

		menuConfigCacheModel.tableConfig = getTableConfig();

		String tableConfig = menuConfigCacheModel.tableConfig;

		if ((tableConfig != null) && (tableConfig.length() == 0)) {
			menuConfigCacheModel.tableConfig = null;
		}

		menuConfigCacheModel.buttonConfig = getButtonConfig();

		String buttonConfig = menuConfigCacheModel.buttonConfig;

		if ((buttonConfig != null) && (buttonConfig.length() == 0)) {
			menuConfigCacheModel.buttonConfig = null;
		}

		menuConfigCacheModel.icon = getIcon();

		String icon = menuConfigCacheModel.icon;

		if ((icon != null) && (icon.length() == 0)) {
			menuConfigCacheModel.icon = null;
		}

		return menuConfigCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", menuConfigId=");
		sb.append(getMenuConfigId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", menuGroup=");
		sb.append(getMenuGroup());
		sb.append(", menuName=");
		sb.append(getMenuName());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", menuType=");
		sb.append(getMenuType());
		sb.append(", queryParams=");
		sb.append(getQueryParams());
		sb.append(", tableConfig=");
		sb.append(getTableConfig());
		sb.append(", buttonConfig=");
		sb.append(getButtonConfig());
		sb.append(", icon=");
		sb.append(getIcon());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.MenuConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>menuConfigId</column-name><column-value><![CDATA[");
		sb.append(getMenuConfigId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>menuGroup</column-name><column-value><![CDATA[");
		sb.append(getMenuGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>menuName</column-name><column-value><![CDATA[");
		sb.append(getMenuName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>menuType</column-name><column-value><![CDATA[");
		sb.append(getMenuType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>queryParams</column-name><column-value><![CDATA[");
		sb.append(getQueryParams());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tableConfig</column-name><column-value><![CDATA[");
		sb.append(getTableConfig());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>buttonConfig</column-name><column-value><![CDATA[");
		sb.append(getButtonConfig());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>icon</column-name><column-value><![CDATA[");
		sb.append(getIcon());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = MenuConfig.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			MenuConfig.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _menuConfigId;
	private long _originalMenuConfigId;
	private boolean _setOriginalMenuConfigId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _menuGroup;
	private String _originalMenuGroup;
	private String _menuName;
	private int _order;
	private int _menuType;
	private String _queryParams;
	private String _tableConfig;
	private String _buttonConfig;
	private String _icon;
	private long _columnBitmask;
	private MenuConfig _escapedModel;
}