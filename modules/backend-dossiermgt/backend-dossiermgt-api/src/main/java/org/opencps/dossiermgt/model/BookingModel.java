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

package org.opencps.dossiermgt.model;

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
 * The base model interface for the Booking service. Represents a row in the &quot;opencps_booking&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.BookingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.BookingImpl}.
 * </p>
 *
 * @author huymq
 * @see Booking
 * @see org.opencps.dossiermgt.model.impl.BookingImpl
 * @see org.opencps.dossiermgt.model.impl.BookingModelImpl
 * @generated
 */
@ProviderType
public interface BookingModel extends BaseModel<Booking>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a booking model instance should use the {@link Booking} interface instead.
	 */

	/**
	 * Returns the primary key of this booking.
	 *
	 * @return the primary key of this booking
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this booking.
	 *
	 * @param primaryKey the primary key of this booking
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this booking.
	 *
	 * @return the uuid of this booking
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this booking.
	 *
	 * @param uuid the uuid of this booking
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the booking ID of this booking.
	 *
	 * @return the booking ID of this booking
	 */
	public long getBookingId();

	/**
	 * Sets the booking ID of this booking.
	 *
	 * @param bookingId the booking ID of this booking
	 */
	public void setBookingId(long bookingId);

	/**
	 * Returns the group ID of this booking.
	 *
	 * @return the group ID of this booking
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this booking.
	 *
	 * @param groupId the group ID of this booking
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this booking.
	 *
	 * @return the company ID of this booking
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this booking.
	 *
	 * @param companyId the company ID of this booking
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this booking.
	 *
	 * @return the user ID of this booking
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this booking.
	 *
	 * @param userId the user ID of this booking
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this booking.
	 *
	 * @return the user uuid of this booking
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this booking.
	 *
	 * @param userUuid the user uuid of this booking
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this booking.
	 *
	 * @return the user name of this booking
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this booking.
	 *
	 * @param userName the user name of this booking
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this booking.
	 *
	 * @return the create date of this booking
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this booking.
	 *
	 * @param createDate the create date of this booking
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this booking.
	 *
	 * @return the modified date of this booking
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this booking.
	 *
	 * @param modifiedDate the modified date of this booking
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the class name of this booking.
	 *
	 * @return the class name of this booking
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this booking.
	 *
	 * @param className the class name of this booking
	 */
	public void setClassName(String className);

	/**
	 * Returns the class pk of this booking.
	 *
	 * @return the class pk of this booking
	 */
	public long getClassPK();

	/**
	 * Sets the class pk of this booking.
	 *
	 * @param classPK the class pk of this booking
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the service code of this booking.
	 *
	 * @return the service code of this booking
	 */
	@AutoEscape
	public String getServiceCode();

	/**
	 * Sets the service code of this booking.
	 *
	 * @param serviceCode the service code of this booking
	 */
	public void setServiceCode(String serviceCode);

	/**
	 * Returns the code number of this booking.
	 *
	 * @return the code number of this booking
	 */
	@AutoEscape
	public String getCodeNumber();

	/**
	 * Sets the code number of this booking.
	 *
	 * @param codeNumber the code number of this booking
	 */
	public void setCodeNumber(String codeNumber);

	/**
	 * Returns the booking name of this booking.
	 *
	 * @return the booking name of this booking
	 */
	@AutoEscape
	public String getBookingName();

	/**
	 * Sets the booking name of this booking.
	 *
	 * @param bookingName the booking name of this booking
	 */
	public void setBookingName(String bookingName);

	/**
	 * Returns the checkin date of this booking.
	 *
	 * @return the checkin date of this booking
	 */
	public Date getCheckinDate();

	/**
	 * Sets the checkin date of this booking.
	 *
	 * @param checkinDate the checkin date of this booking
	 */
	public void setCheckinDate(Date checkinDate);

	/**
	 * Returns the gate number of this booking.
	 *
	 * @return the gate number of this booking
	 */
	@AutoEscape
	public String getGateNumber();

	/**
	 * Sets the gate number of this booking.
	 *
	 * @param gateNumber the gate number of this booking
	 */
	public void setGateNumber(String gateNumber);

	/**
	 * Returns the state of this booking.
	 *
	 * @return the state of this booking
	 */
	public int getState();

	/**
	 * Sets the state of this booking.
	 *
	 * @param state the state of this booking
	 */
	public void setState(int state);

	/**
	 * Returns the booking date of this booking.
	 *
	 * @return the booking date of this booking
	 */
	public Date getBookingDate();

	/**
	 * Sets the booking date of this booking.
	 *
	 * @param bookingDate the booking date of this booking
	 */
	public void setBookingDate(Date bookingDate);

	/**
	 * Returns the speaking of this booking.
	 *
	 * @return the speaking of this booking
	 */
	public boolean getSpeaking();

	/**
	 * Returns <code>true</code> if this booking is speaking.
	 *
	 * @return <code>true</code> if this booking is speaking; <code>false</code> otherwise
	 */
	public boolean isSpeaking();

	/**
	 * Sets whether this booking is speaking.
	 *
	 * @param speaking the speaking of this booking
	 */
	public void setSpeaking(boolean speaking);

	/**
	 * Returns the service group code of this booking.
	 *
	 * @return the service group code of this booking
	 */
	@AutoEscape
	public String getServiceGroupCode();

	/**
	 * Sets the service group code of this booking.
	 *
	 * @param serviceGroupCode the service group code of this booking
	 */
	public void setServiceGroupCode(String serviceGroupCode);

	/**
	 * Returns the count of this booking.
	 *
	 * @return the count of this booking
	 */
	public int getCount();

	/**
	 * Sets the count of this booking.
	 *
	 * @param count the count of this booking
	 */
	public void setCount(int count);

	/**
	 * Returns the online of this booking.
	 *
	 * @return the online of this booking
	 */
	public boolean getOnline();

	/**
	 * Returns <code>true</code> if this booking is online.
	 *
	 * @return <code>true</code> if this booking is online; <code>false</code> otherwise
	 */
	public boolean isOnline();

	/**
	 * Sets whether this booking is online.
	 *
	 * @param online the online of this booking
	 */
	public void setOnline(boolean online);

	/**
	 * Returns the booking in time of this booking.
	 *
	 * @return the booking in time of this booking
	 */
	@AutoEscape
	public String getBookingInTime();

	/**
	 * Sets the booking in time of this booking.
	 *
	 * @param bookingInTime the booking in time of this booking
	 */
	public void setBookingInTime(String bookingInTime);

	/**
	 * Returns the tel no of this booking.
	 *
	 * @return the tel no of this booking
	 */
	@AutoEscape
	public String getTelNo();

	/**
	 * Sets the tel no of this booking.
	 *
	 * @param telNo the tel no of this booking
	 */
	public void setTelNo(String telNo);

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
	public int compareTo(Booking booking);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Booking> toCacheModel();

	@Override
	public Booking toEscapedModel();

	@Override
	public Booking toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}