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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import org.mobilink.backend.usermgt.model.ContactGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ContactGroup in entity cache.
 *
 * @author Binhth
 * @see ContactGroup
 * @generated
 */
@ProviderType
public class ContactGroupCacheModel implements CacheModel<ContactGroup>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContactGroupCacheModel)) {
			return false;
		}

		ContactGroupCacheModel contactGroupCacheModel = (ContactGroupCacheModel)obj;

		if (contactGroupId == contactGroupCacheModel.contactGroupId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contactGroupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", contactGroupId=");
		sb.append(contactGroupId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", contactList=");
		sb.append(contactList);
		sb.append(", shared=");
		sb.append(shared);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ContactGroup toEntityModel() {
		ContactGroupImpl contactGroupImpl = new ContactGroupImpl();

		if (uuid == null) {
			contactGroupImpl.setUuid(StringPool.BLANK);
		}
		else {
			contactGroupImpl.setUuid(uuid);
		}

		contactGroupImpl.setContactGroupId(contactGroupId);
		contactGroupImpl.setGroupId(groupId);
		contactGroupImpl.setCompanyId(companyId);
		contactGroupImpl.setUserId(userId);

		if (userName == null) {
			contactGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			contactGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			contactGroupImpl.setCreateDate(null);
		}
		else {
			contactGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			contactGroupImpl.setModifiedDate(null);
		}
		else {
			contactGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (groupName == null) {
			contactGroupImpl.setGroupName(StringPool.BLANK);
		}
		else {
			contactGroupImpl.setGroupName(groupName);
		}

		if (contactList == null) {
			contactGroupImpl.setContactList(StringPool.BLANK);
		}
		else {
			contactGroupImpl.setContactList(contactList);
		}

		contactGroupImpl.setShared(shared);

		contactGroupImpl.resetOriginalValues();

		return contactGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		contactGroupId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		groupName = objectInput.readUTF();
		contactList = objectInput.readUTF();

		shared = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(contactGroupId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (groupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		if (contactList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactList);
		}

		objectOutput.writeInt(shared);
	}

	public String uuid;
	public long contactGroupId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String groupName;
	public String contactList;
	public int shared;
}