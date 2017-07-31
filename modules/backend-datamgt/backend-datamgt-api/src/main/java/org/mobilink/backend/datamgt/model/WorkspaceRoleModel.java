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
 * The base model interface for the WorkspaceRole service. Represents a row in the &quot;m_workspacerole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.mobilink.backend.datamgt.model.impl.WorkspaceRoleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.mobilink.backend.datamgt.model.impl.WorkspaceRoleImpl}.
 * </p>
 *
 * @author Binhth
 * @see WorkspaceRole
 * @see org.mobilink.backend.datamgt.model.impl.WorkspaceRoleImpl
 * @see org.mobilink.backend.datamgt.model.impl.WorkspaceRoleModelImpl
 * @generated
 */
@ProviderType
public interface WorkspaceRoleModel extends BaseModel<WorkspaceRole>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a workspace role model instance should use the {@link WorkspaceRole} interface instead.
	 */

	/**
	 * Returns the primary key of this workspace role.
	 *
	 * @return the primary key of this workspace role
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this workspace role.
	 *
	 * @param primaryKey the primary key of this workspace role
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this workspace role.
	 *
	 * @return the uuid of this workspace role
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this workspace role.
	 *
	 * @param uuid the uuid of this workspace role
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the workspace role ID of this workspace role.
	 *
	 * @return the workspace role ID of this workspace role
	 */
	public long getWorkspaceRoleId();

	/**
	 * Sets the workspace role ID of this workspace role.
	 *
	 * @param workspaceRoleId the workspace role ID of this workspace role
	 */
	public void setWorkspaceRoleId(long workspaceRoleId);

	/**
	 * Returns the company ID of this workspace role.
	 *
	 * @return the company ID of this workspace role
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this workspace role.
	 *
	 * @param companyId the company ID of this workspace role
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this workspace role.
	 *
	 * @return the group ID of this workspace role
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this workspace role.
	 *
	 * @param groupId the group ID of this workspace role
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this workspace role.
	 *
	 * @return the user ID of this workspace role
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this workspace role.
	 *
	 * @param userId the user ID of this workspace role
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this workspace role.
	 *
	 * @return the user uuid of this workspace role
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this workspace role.
	 *
	 * @param userUuid the user uuid of this workspace role
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this workspace role.
	 *
	 * @return the user name of this workspace role
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this workspace role.
	 *
	 * @param userName the user name of this workspace role
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this workspace role.
	 *
	 * @return the create date of this workspace role
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this workspace role.
	 *
	 * @param createDate the create date of this workspace role
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this workspace role.
	 *
	 * @return the modified date of this workspace role
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this workspace role.
	 *
	 * @param modifiedDate the modified date of this workspace role
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the workspace ID of this workspace role.
	 *
	 * @return the workspace ID of this workspace role
	 */
	public long getWorkspaceId();

	/**
	 * Sets the workspace ID of this workspace role.
	 *
	 * @param workspaceId the workspace ID of this workspace role
	 */
	public void setWorkspaceId(long workspaceId);

	/**
	 * Returns the role ID of this workspace role.
	 *
	 * @return the role ID of this workspace role
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this workspace role.
	 *
	 * @param roleId the role ID of this workspace role
	 */
	public void setRoleId(long roleId);

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
	public int compareTo(WorkspaceRole workspaceRole);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WorkspaceRole> toCacheModel();

	@Override
	public WorkspaceRole toEscapedModel();

	@Override
	public WorkspaceRole toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}