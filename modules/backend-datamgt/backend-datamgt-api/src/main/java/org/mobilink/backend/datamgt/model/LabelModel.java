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
 * The base model interface for the Label service. Represents a row in the &quot;m_label&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.mobilink.backend.datamgt.model.impl.LabelModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.mobilink.backend.datamgt.model.impl.LabelImpl}.
 * </p>
 *
 * @author Binhth
 * @see Label
 * @see org.mobilink.backend.datamgt.model.impl.LabelImpl
 * @see org.mobilink.backend.datamgt.model.impl.LabelModelImpl
 * @generated
 */
@ProviderType
public interface LabelModel extends BaseModel<Label>, GroupedModel, ShardedModel,
	StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a label model instance should use the {@link Label} interface instead.
	 */

	/**
	 * Returns the primary key of this label.
	 *
	 * @return the primary key of this label
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this label.
	 *
	 * @param primaryKey the primary key of this label
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this label.
	 *
	 * @return the uuid of this label
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this label.
	 *
	 * @param uuid the uuid of this label
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the label ID of this label.
	 *
	 * @return the label ID of this label
	 */
	public long getLabelId();

	/**
	 * Sets the label ID of this label.
	 *
	 * @param labelId the label ID of this label
	 */
	public void setLabelId(long labelId);

	/**
	 * Returns the company ID of this label.
	 *
	 * @return the company ID of this label
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this label.
	 *
	 * @param companyId the company ID of this label
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this label.
	 *
	 * @return the group ID of this label
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this label.
	 *
	 * @param groupId the group ID of this label
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this label.
	 *
	 * @return the user ID of this label
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this label.
	 *
	 * @param userId the user ID of this label
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this label.
	 *
	 * @return the user uuid of this label
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this label.
	 *
	 * @param userUuid the user uuid of this label
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this label.
	 *
	 * @return the user name of this label
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this label.
	 *
	 * @param userName the user name of this label
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this label.
	 *
	 * @return the create date of this label
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this label.
	 *
	 * @param createDate the create date of this label
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this label.
	 *
	 * @return the modified date of this label
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this label.
	 *
	 * @param modifiedDate the modified date of this label
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this label.
	 *
	 * @return the name of this label
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this label.
	 *
	 * @param name the name of this label
	 */
	public void setName(String name);

	/**
	 * Returns the color of this label.
	 *
	 * @return the color of this label
	 */
	@AutoEscape
	public String getColor();

	/**
	 * Sets the color of this label.
	 *
	 * @param color the color of this label
	 */
	public void setColor(String color);

	/**
	 * Returns the scope of this label.
	 *
	 * @return the scope of this label
	 */
	public int getScope();

	/**
	 * Sets the scope of this label.
	 *
	 * @param scope the scope of this label
	 */
	public void setScope(int scope);

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
	public int compareTo(Label label);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Label> toCacheModel();

	@Override
	public Label toEscapedModel();

	@Override
	public Label toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}