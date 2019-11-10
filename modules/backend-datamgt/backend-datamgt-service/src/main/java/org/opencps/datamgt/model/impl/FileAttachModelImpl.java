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

package org.opencps.datamgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import org.opencps.datamgt.model.FileAttach;
import org.opencps.datamgt.model.FileAttachModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the FileAttach service. Represents a row in the &quot;m_fileattach&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link FileAttachModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FileAttachImpl}.
 * </p>
 *
 * @author khoavu
 * @see FileAttachImpl
 * @see FileAttach
 * @see FileAttachModel
 * @generated
 */
@ProviderType
public class FileAttachModelImpl extends BaseModelImpl<FileAttach>
	implements FileAttachModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a file attach model instance should use the {@link FileAttach} interface instead.
	 */
	public static final String TABLE_NAME = "m_fileattach";
	public static final Object[][] TABLE_COLUMNS = {
			{ "fileAttachId", Types.BIGINT },
			{ Field.GROUP_ID, Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "className", Types.VARCHAR },
			{ "classPK", Types.VARCHAR },
			{ "fullName", Types.VARCHAR },
			{ ConstantUtils.VALUE_EMAIL, Types.VARCHAR },
			{ "fileEntryId", Types.BIGINT },
			{ "source", Types.VARCHAR },
			{ "sourceUrl", Types.VARCHAR },
			{ "docFileId", Types.BIGINT },
			{ "fileName", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("fileAttachId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put(Field.GROUP_ID, Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("className", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("classPK", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fullName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put(ConstantUtils.VALUE_EMAIL, Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("source", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sourceUrl", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("docFileId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileName", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table m_fileattach (fileAttachId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(255) null,createDate DATE null,modifiedDate DATE null,className VARCHAR(500) null,classPK VARCHAR(75) null,fullName VARCHAR(500) null,email VARCHAR(500) null,fileEntryId LONG,source VARCHAR(500) null,sourceUrl VARCHAR(500) null,docFileId LONG,fileName VARCHAR(500) null)";
	public static final String TABLE_SQL_DROP = "drop table m_fileattach";
	public static final String ORDER_BY_JPQL = " ORDER BY fileAttach.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY m_fileattach.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.org.opencps.datamgt.model.FileAttach"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.org.opencps.datamgt.model.FileAttach"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.opencps.datamgt.model.FileAttach"),
			true);
	public static final long CLASSNAME_COLUMN_BITMASK = 1L;
	public static final long CLASSPK_COLUMN_BITMASK = 2L;
	public static final long DOCFILEID_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long CREATEDATE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(org.opencps.backend.datamgt.service.util.ServiceProps.get(
				"lock.expiration.time.org.opencps.datamgt.model.FileAttach"));

	public FileAttachModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileAttachId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileAttachId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileAttachId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FileAttach.class;
	}

	@Override
	public String getModelClassName() {
		return FileAttach.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fileAttachId", getFileAttachId());
		attributes.put(Field.GROUP_ID, getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("fullName", getFullName());
		attributes.put(ConstantUtils.VALUE_EMAIL, getEmail());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("source", getSource());
		attributes.put("sourceUrl", getSourceUrl());
		attributes.put("docFileId", getDocFileId());
		attributes.put("fileName", getFileName());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fileAttachId = (Long)attributes.get("fileAttachId");

		if (fileAttachId != null) {
			setFileAttachId(fileAttachId);
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

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String classPK = (String)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String email = (String)attributes.get(ConstantUtils.VALUE_EMAIL);

		if (email != null) {
			setEmail(email);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String sourceUrl = (String)attributes.get("sourceUrl");

		if (sourceUrl != null) {
			setSourceUrl(sourceUrl);
		}

		Long docFileId = (Long)attributes.get("docFileId");

		if (docFileId != null) {
			setDocFileId(docFileId);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}
	}

	@Override
	public long getFileAttachId() {
		return _fileAttachId;
	}

	@Override
	public void setFileAttachId(long fileAttachId) {
		_fileAttachId = fileAttachId;
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
		_companyId = companyId;
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
	public String getClassName() {
		if (_className == null) {
			return "";
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		_columnBitmask |= CLASSNAME_COLUMN_BITMASK;

		if (_originalClassName == null) {
			_originalClassName = _className;
		}

		_className = className;
	}

	public String getOriginalClassName() {
		return GetterUtil.getString(_originalClassName);
	}

	@Override
	public String getClassPK() {
		if (_classPK == null) {
			return "";
		}
		else {
			return _classPK;
		}
	}

	@Override
	public void setClassPK(String classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (_originalClassPK == null) {
			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public String getOriginalClassPK() {
		return GetterUtil.getString(_originalClassPK);
	}

	@Override
	public String getFullName() {
		if (_fullName == null) {
			return "";
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
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
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	@Override
	public String getSource() {
		if (_source == null) {
			return "";
		}
		else {
			return _source;
		}
	}

	@Override
	public void setSource(String source) {
		_source = source;
	}

	@Override
	public String getSourceUrl() {
		if (_sourceUrl == null) {
			return "";
		}
		else {
			return _sourceUrl;
		}
	}

	@Override
	public void setSourceUrl(String sourceUrl) {
		_sourceUrl = sourceUrl;
	}

	@Override
	public long getDocFileId() {
		return _docFileId;
	}

	@Override
	public void setDocFileId(long docFileId) {
		_columnBitmask |= DOCFILEID_COLUMN_BITMASK;

		if (!_setOriginalDocFileId) {
			_setOriginalDocFileId = true;

			_originalDocFileId = _docFileId;
		}

		_docFileId = docFileId;
	}

	public long getOriginalDocFileId() {
		return _originalDocFileId;
	}

	@Override
	public String getFileName() {
		if (_fileName == null) {
			return "";
		}
		else {
			return _fileName;
		}
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			FileAttach.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FileAttach toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FileAttach)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FileAttachImpl fileAttachImpl = new FileAttachImpl();

		fileAttachImpl.setFileAttachId(getFileAttachId());
		fileAttachImpl.setGroupId(getGroupId());
		fileAttachImpl.setCompanyId(getCompanyId());
		fileAttachImpl.setUserId(getUserId());
		fileAttachImpl.setUserName(getUserName());
		fileAttachImpl.setCreateDate(getCreateDate());
		fileAttachImpl.setModifiedDate(getModifiedDate());
		fileAttachImpl.setClassName(getClassName());
		fileAttachImpl.setClassPK(getClassPK());
		fileAttachImpl.setFullName(getFullName());
		fileAttachImpl.setEmail(getEmail());
		fileAttachImpl.setFileEntryId(getFileEntryId());
		fileAttachImpl.setSource(getSource());
		fileAttachImpl.setSourceUrl(getSourceUrl());
		fileAttachImpl.setDocFileId(getDocFileId());
		fileAttachImpl.setFileName(getFileName());

		fileAttachImpl.resetOriginalValues();

		return fileAttachImpl;
	}

	@Override
	public int compareTo(FileAttach fileAttach) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), fileAttach.getCreateDate());

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

		if (!(obj instanceof FileAttach)) {
			return false;
		}

		FileAttach fileAttach = (FileAttach)obj;

		long primaryKey = fileAttach.getPrimaryKey();

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
		FileAttachModelImpl fileAttachModelImpl = this;

		fileAttachModelImpl._originalGroupId = fileAttachModelImpl._groupId;

		fileAttachModelImpl._setOriginalGroupId = false;

		fileAttachModelImpl._setModifiedDate = false;

		fileAttachModelImpl._originalClassName = fileAttachModelImpl._className;

		fileAttachModelImpl._originalClassPK = fileAttachModelImpl._classPK;

		fileAttachModelImpl._originalDocFileId = fileAttachModelImpl._docFileId;

		fileAttachModelImpl._setOriginalDocFileId = false;

		fileAttachModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FileAttach> toCacheModel() {
		FileAttachCacheModel fileAttachCacheModel = new FileAttachCacheModel();

		fileAttachCacheModel.fileAttachId = getFileAttachId();

		fileAttachCacheModel.groupId = getGroupId();

		fileAttachCacheModel.companyId = getCompanyId();

		fileAttachCacheModel.userId = getUserId();

		fileAttachCacheModel.userName = getUserName();

		String userName = fileAttachCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			fileAttachCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			fileAttachCacheModel.createDate = createDate.getTime();
		}
		else {
			fileAttachCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			fileAttachCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			fileAttachCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		fileAttachCacheModel.className = getClassName();

		String className = fileAttachCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			fileAttachCacheModel.className = null;
		}

		fileAttachCacheModel.classPK = getClassPK();

		String classPK = fileAttachCacheModel.classPK;

		if ((classPK != null) && (classPK.length() == 0)) {
			fileAttachCacheModel.classPK = null;
		}

		fileAttachCacheModel.fullName = getFullName();

		String fullName = fileAttachCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			fileAttachCacheModel.fullName = null;
		}

		fileAttachCacheModel.email = getEmail();

		String email = fileAttachCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			fileAttachCacheModel.email = null;
		}

		fileAttachCacheModel.fileEntryId = getFileEntryId();

		fileAttachCacheModel.source = getSource();

		String source = fileAttachCacheModel.source;

		if ((source != null) && (source.length() == 0)) {
			fileAttachCacheModel.source = null;
		}

		fileAttachCacheModel.sourceUrl = getSourceUrl();

		String sourceUrl = fileAttachCacheModel.sourceUrl;

		if ((sourceUrl != null) && (sourceUrl.length() == 0)) {
			fileAttachCacheModel.sourceUrl = null;
		}

		fileAttachCacheModel.docFileId = getDocFileId();

		fileAttachCacheModel.fileName = getFileName();

		String fileName = fileAttachCacheModel.fileName;

		if ((fileName != null) && (fileName.length() == 0)) {
			fileAttachCacheModel.fileName = null;
		}

		return fileAttachCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{fileAttachId=");
		sb.append(getFileAttachId());
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
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", sourceUrl=");
		sb.append(getSourceUrl());
		sb.append(", docFileId=");
		sb.append(getDocFileId());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("org.opencps.datamgt.model.FileAttach");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fileAttachId</column-name><column-value><![CDATA[");
		sb.append(getFileAttachId());
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
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sourceUrl</column-name><column-value><![CDATA[");
		sb.append(getSourceUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>docFileId</column-name><column-value><![CDATA[");
		sb.append(getDocFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = FileAttach.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			FileAttach.class, ModelWrapper.class
		};
	private long _fileAttachId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _className;
	private String _originalClassName;
	private String _classPK;
	private String _originalClassPK;
	private String _fullName;
	private String _email;
	private long _fileEntryId;
	private String _source;
	private String _sourceUrl;
	private long _docFileId;
	private long _originalDocFileId;
	private boolean _setOriginalDocFileId;
	private String _fileName;
	private long _columnBitmask;
	private FileAttach _escapedModel;
}