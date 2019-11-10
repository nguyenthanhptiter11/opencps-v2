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

package org.opencps.datamgt.constants;

import java.util.Date;

public class WorkspaceUserTerm {
	
	public static final String WORKSPACE_USER_ID = "workspaceUserId";

	public static final String COMPANY_ID = "companyId";

	public static final String GROUP_ID = Field.GROUP_ID;

	public static final String USER_ID = "userId";

	public static final String USER_NAME = "userName";

	public static final String CREATE_DATE = "createDate";

	public static final String MODIFIED_DATE = "modifiedDate";

	public static final String WORKSPACE_ID = "workspaceId";
	
	public static final String ASSIGN_USER_ID = "assignUserId";
	
	public static final String WORKSPACEUSER = "mworkspaceuser";
	
	
	public static final String WORKSPACE_USER_ID_SORTABLE = "workspaceUserId_sortable";

	public static final String COMPANY_ID_SORTABLE = "companyId_sortable";

	public static final String GROUP_ID_SORTABLE = "groupId_sortable";

	public static final String USER_ID_SORTABLE = "userId_sortable";

	public static final String USER_NAME_SORTABLE = "userName_sortable";

	public static final String CREATE_DATE_SORTABLE = "createDate_sortable";

	public static final String MODIFIED_DATE_SORTABLE = "modifiedDate_sortable";

	public static final String WORKSPACE_ID_SORTABLE = "workspaceId_sortable";
	
	public static final String ASSIGN_USER_ID_SORTABLE = "assignUserId_sortable";
	
	public WorkspaceUserTerm() {

	}

	public long getWorkspaceUserId() {
		return workspaceUserId;
	}

	public void setWorkspaceUserId(long workspaceUserId) {
		this.workspaceUserId = workspaceUserId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public long getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(long workspaceId) {
		this.workspaceId = workspaceId;
	}


	private long workspaceUserId;
	private long companyId;
	private long groupId;

	private long userId;
	private String userName;
	private Date createDate;
	private Date modifiedDate;
	
	private long workspaceId;
	private long assignUserId;

	public long getAssignUserId() {
		return assignUserId;
	}

	public void setAssignUserId(long assignUserId) {
		this.assignUserId = assignUserId;
	}

}
