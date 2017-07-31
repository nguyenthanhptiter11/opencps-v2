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
 * The base model interface for the DictItem service. Represents a row in the &quot;m_dictitem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.mobilink.backend.datamgt.model.impl.DictItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.mobilink.backend.datamgt.model.impl.DictItemImpl}.
 * </p>
 *
 * @author Binhth
 * @see DictItem
 * @see org.mobilink.backend.datamgt.model.impl.DictItemImpl
 * @see org.mobilink.backend.datamgt.model.impl.DictItemModelImpl
 * @generated
 */
@ProviderType
public interface DictItemModel extends BaseModel<DictItem>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dict item model instance should use the {@link DictItem} interface instead.
	 */

	/**
	 * Returns the primary key of this dict item.
	 *
	 * @return the primary key of this dict item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dict item.
	 *
	 * @param primaryKey the primary key of this dict item
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this dict item.
	 *
	 * @return the uuid of this dict item
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this dict item.
	 *
	 * @param uuid the uuid of this dict item
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the dict item ID of this dict item.
	 *
	 * @return the dict item ID of this dict item
	 */
	public long getDictItemId();

	/**
	 * Sets the dict item ID of this dict item.
	 *
	 * @param dictItemId the dict item ID of this dict item
	 */
	public void setDictItemId(long dictItemId);

	/**
	 * Returns the company ID of this dict item.
	 *
	 * @return the company ID of this dict item
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this dict item.
	 *
	 * @param companyId the company ID of this dict item
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this dict item.
	 *
	 * @return the group ID of this dict item
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this dict item.
	 *
	 * @param groupId the group ID of this dict item
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this dict item.
	 *
	 * @return the user ID of this dict item
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this dict item.
	 *
	 * @param userId the user ID of this dict item
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this dict item.
	 *
	 * @return the user uuid of this dict item
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this dict item.
	 *
	 * @param userUuid the user uuid of this dict item
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this dict item.
	 *
	 * @return the user name of this dict item
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this dict item.
	 *
	 * @param userName the user name of this dict item
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this dict item.
	 *
	 * @return the create date of this dict item
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this dict item.
	 *
	 * @param createDate the create date of this dict item
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this dict item.
	 *
	 * @return the modified date of this dict item
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this dict item.
	 *
	 * @param modifiedDate the modified date of this dict item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the dict collection ID of this dict item.
	 *
	 * @return the dict collection ID of this dict item
	 */
	public long getDictCollectionId();

	/**
	 * Sets the dict collection ID of this dict item.
	 *
	 * @param dictCollectionId the dict collection ID of this dict item
	 */
	public void setDictCollectionId(long dictCollectionId);

	/**
	 * Returns the item code of this dict item.
	 *
	 * @return the item code of this dict item
	 */
	@AutoEscape
	public String getItemCode();

	/**
	 * Sets the item code of this dict item.
	 *
	 * @param itemCode the item code of this dict item
	 */
	public void setItemCode(String itemCode);

	/**
	 * Returns the item name of this dict item.
	 *
	 * @return the item name of this dict item
	 */
	@AutoEscape
	public String getItemName();

	/**
	 * Sets the item name of this dict item.
	 *
	 * @param itemName the item name of this dict item
	 */
	public void setItemName(String itemName);

	/**
	 * Returns the item name en of this dict item.
	 *
	 * @return the item name en of this dict item
	 */
	@AutoEscape
	public String getItemNameEN();

	/**
	 * Sets the item name en of this dict item.
	 *
	 * @param itemNameEN the item name en of this dict item
	 */
	public void setItemNameEN(String itemNameEN);

	/**
	 * Returns the item description of this dict item.
	 *
	 * @return the item description of this dict item
	 */
	@AutoEscape
	public String getItemDescription();

	/**
	 * Sets the item description of this dict item.
	 *
	 * @param itemDescription the item description of this dict item
	 */
	public void setItemDescription(String itemDescription);

	/**
	 * Returns the parent item ID of this dict item.
	 *
	 * @return the parent item ID of this dict item
	 */
	public long getParentItemId();

	/**
	 * Sets the parent item ID of this dict item.
	 *
	 * @param parentItemId the parent item ID of this dict item
	 */
	public void setParentItemId(long parentItemId);

	/**
	 * Returns the level of this dict item.
	 *
	 * @return the level of this dict item
	 */
	public int getLevel();

	/**
	 * Sets the level of this dict item.
	 *
	 * @param level the level of this dict item
	 */
	public void setLevel(int level);

	/**
	 * Returns the sibling of this dict item.
	 *
	 * @return the sibling of this dict item
	 */
	@AutoEscape
	public String getSibling();

	/**
	 * Sets the sibling of this dict item.
	 *
	 * @param sibling the sibling of this dict item
	 */
	public void setSibling(String sibling);

	/**
	 * Returns the tree index of this dict item.
	 *
	 * @return the tree index of this dict item
	 */
	@AutoEscape
	public String getTreeIndex();

	/**
	 * Sets the tree index of this dict item.
	 *
	 * @param treeIndex the tree index of this dict item
	 */
	public void setTreeIndex(String treeIndex);

	/**
	 * Returns the data form of this dict item.
	 *
	 * @return the data form of this dict item
	 */
	@AutoEscape
	public String getDataForm();

	/**
	 * Sets the data form of this dict item.
	 *
	 * @param dataForm the data form of this dict item
	 */
	public void setDataForm(String dataForm);

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
	public int compareTo(DictItem dictItem);

	@Override
	public int hashCode();

	@Override
	public CacheModel<DictItem> toCacheModel();

	@Override
	public DictItem toEscapedModel();

	@Override
	public DictItem toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}