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

package org.mobilink.backend.datamgt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WorkspaceUser service. Represents a row in the &quot;m_workspaceuser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.mobilink.backend.datamgt.model.impl.WorkspaceUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.mobilink.backend.datamgt.model.impl.WorkspaceUserImpl}.
 * </p>
 *
 * @author Binhth
 * @see WorkspaceUser
 * @see org.mobilink.backend.datamgt.model.impl.WorkspaceUserImpl
 * @see org.mobilink.backend.datamgt.model.impl.WorkspaceUserModelImpl
 * @generated
 */
@ProviderType
public interface WorkspaceUserModel extends BaseModel<WorkspaceUser>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a workspace user model instance should use the {@link WorkspaceUser} interface instead.
	 */

	/**
	 * Returns the primary key of this workspace user.
	 *
	 * @return the primary key of this workspace user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this workspace user.
	 *
	 * @param primaryKey the primary key of this workspace user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this workspace user.
	 *
	 * @return the uuid of this workspace user
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this workspace user.
	 *
	 * @param uuid the uuid of this workspace user
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the workspace user ID of this workspace user.
	 *
	 * @return the workspace user ID of this workspace user
	 */
	public long getWorkspaceUserId();

	/**
	 * Sets the workspace user ID of this workspace user.
	 *
	 * @param workspaceUserId the workspace user ID of this workspace user
	 */
	public void setWorkspaceUserId(long workspaceUserId);

	/**
	 * Returns the workspace user uuid of this workspace user.
	 *
	 * @return the workspace user uuid of this workspace user
	 */
	public String getWorkspaceUserUuid();

	/**
	 * Sets the workspace user uuid of this workspace user.
	 *
	 * @param workspaceUserUuid the workspace user uuid of this workspace user
	 */
	public void setWorkspaceUserUuid(String workspaceUserUuid);

	/**
	 * Returns the company ID of this workspace user.
	 *
	 * @return the company ID of this workspace user
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this workspace user.
	 *
	 * @param companyId the company ID of this workspace user
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this workspace user.
	 *
	 * @return the group ID of this workspace user
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this workspace user.
	 *
	 * @param groupId the group ID of this workspace user
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this workspace user.
	 *
	 * @return the user ID of this workspace user
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this workspace user.
	 *
	 * @param userId the user ID of this workspace user
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this workspace user.
	 *
	 * @return the user uuid of this workspace user
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this workspace user.
	 *
	 * @param userUuid the user uuid of this workspace user
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this workspace user.
	 *
	 * @return the user name of this workspace user
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this workspace user.
	 *
	 * @param userName the user name of this workspace user
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this workspace user.
	 *
	 * @return the create date of this workspace user
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this workspace user.
	 *
	 * @param createDate the create date of this workspace user
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this workspace user.
	 *
	 * @return the modified date of this workspace user
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this workspace user.
	 *
	 * @param modifiedDate the modified date of this workspace user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the workspace ID of this workspace user.
	 *
	 * @return the workspace ID of this workspace user
	 */
	public long getWorkspaceId();

	/**
	 * Sets the workspace ID of this workspace user.
	 *
	 * @param workspaceId the workspace ID of this workspace user
	 */
	public void setWorkspaceId(long workspaceId);

	/**
	 * Returns the assign user ID of this workspace user.
	 *
	 * @return the assign user ID of this workspace user
	 */
	public long getAssignUserId();

	/**
	 * Sets the assign user ID of this workspace user.
	 *
	 * @param assignUserId the assign user ID of this workspace user
	 */
	public void setAssignUserId(long assignUserId);

	/**
	 * Returns the assign user uuid of this workspace user.
	 *
	 * @return the assign user uuid of this workspace user
	 */
	public String getAssignUserUuid();

	/**
	 * Sets the assign user uuid of this workspace user.
	 *
	 * @param assignUserUuid the assign user uuid of this workspace user
	 */
	public void setAssignUserUuid(String assignUserUuid);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(WorkspaceUser workspaceUser);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WorkspaceUser> toCacheModel();

	@Override
	public WorkspaceUser toEscapedModel();

	@Override
	public WorkspaceUser toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}