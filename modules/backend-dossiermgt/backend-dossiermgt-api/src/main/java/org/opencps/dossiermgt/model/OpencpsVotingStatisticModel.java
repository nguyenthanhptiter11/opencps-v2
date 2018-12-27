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
 * The base model interface for the OpencpsVotingStatistic service. Represents a row in the &quot;opencps_voting_statistic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.opencps.dossiermgt.model.impl.OpencpsVotingStatisticModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.opencps.dossiermgt.model.impl.OpencpsVotingStatisticImpl}.
 * </p>
 *
 * @author huymq
 * @see OpencpsVotingStatistic
 * @see org.opencps.dossiermgt.model.impl.OpencpsVotingStatisticImpl
 * @see org.opencps.dossiermgt.model.impl.OpencpsVotingStatisticModelImpl
 * @generated
 */
@ProviderType
public interface OpencpsVotingStatisticModel extends BaseModel<OpencpsVotingStatistic>,
	GroupedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a opencps voting statistic model instance should use the {@link OpencpsVotingStatistic} interface instead.
	 */

	/**
	 * Returns the primary key of this opencps voting statistic.
	 *
	 * @return the primary key of this opencps voting statistic
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this opencps voting statistic.
	 *
	 * @param primaryKey the primary key of this opencps voting statistic
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this opencps voting statistic.
	 *
	 * @return the uuid of this opencps voting statistic
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this opencps voting statistic.
	 *
	 * @param uuid the uuid of this opencps voting statistic
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the voting statistic ID of this opencps voting statistic.
	 *
	 * @return the voting statistic ID of this opencps voting statistic
	 */
	public long getVotingStatisticId();

	/**
	 * Sets the voting statistic ID of this opencps voting statistic.
	 *
	 * @param votingStatisticId the voting statistic ID of this opencps voting statistic
	 */
	public void setVotingStatisticId(long votingStatisticId);

	/**
	 * Returns the company ID of this opencps voting statistic.
	 *
	 * @return the company ID of this opencps voting statistic
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this opencps voting statistic.
	 *
	 * @param companyId the company ID of this opencps voting statistic
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this opencps voting statistic.
	 *
	 * @return the group ID of this opencps voting statistic
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this opencps voting statistic.
	 *
	 * @param groupId the group ID of this opencps voting statistic
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this opencps voting statistic.
	 *
	 * @return the user ID of this opencps voting statistic
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this opencps voting statistic.
	 *
	 * @param userId the user ID of this opencps voting statistic
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this opencps voting statistic.
	 *
	 * @return the user uuid of this opencps voting statistic
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this opencps voting statistic.
	 *
	 * @param userUuid the user uuid of this opencps voting statistic
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this opencps voting statistic.
	 *
	 * @return the user name of this opencps voting statistic
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this opencps voting statistic.
	 *
	 * @param userName the user name of this opencps voting statistic
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this opencps voting statistic.
	 *
	 * @return the create date of this opencps voting statistic
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this opencps voting statistic.
	 *
	 * @param createDate the create date of this opencps voting statistic
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this opencps voting statistic.
	 *
	 * @return the modified date of this opencps voting statistic
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this opencps voting statistic.
	 *
	 * @param modifiedDate the modified date of this opencps voting statistic
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the month of this opencps voting statistic.
	 *
	 * @return the month of this opencps voting statistic
	 */
	public int getMonth();

	/**
	 * Sets the month of this opencps voting statistic.
	 *
	 * @param month the month of this opencps voting statistic
	 */
	public void setMonth(int month);

	/**
	 * Returns the year of this opencps voting statistic.
	 *
	 * @return the year of this opencps voting statistic
	 */
	public int getYear();

	/**
	 * Sets the year of this opencps voting statistic.
	 *
	 * @param year the year of this opencps voting statistic
	 */
	public void setYear(int year);

	/**
	 * Returns the gov agency code of this opencps voting statistic.
	 *
	 * @return the gov agency code of this opencps voting statistic
	 */
	@AutoEscape
	public String getGovAgencyCode();

	/**
	 * Sets the gov agency code of this opencps voting statistic.
	 *
	 * @param govAgencyCode the gov agency code of this opencps voting statistic
	 */
	public void setGovAgencyCode(String govAgencyCode);

	/**
	 * Returns the gov agency name of this opencps voting statistic.
	 *
	 * @return the gov agency name of this opencps voting statistic
	 */
	@AutoEscape
	public String getGovAgencyName();

	/**
	 * Sets the gov agency name of this opencps voting statistic.
	 *
	 * @param govAgencyName the gov agency name of this opencps voting statistic
	 */
	public void setGovAgencyName(String govAgencyName);

	/**
	 * Returns the domain code of this opencps voting statistic.
	 *
	 * @return the domain code of this opencps voting statistic
	 */
	@AutoEscape
	public String getDomainCode();

	/**
	 * Sets the domain code of this opencps voting statistic.
	 *
	 * @param domainCode the domain code of this opencps voting statistic
	 */
	public void setDomainCode(String domainCode);

	/**
	 * Returns the domain name of this opencps voting statistic.
	 *
	 * @return the domain name of this opencps voting statistic
	 */
	@AutoEscape
	public String getDomainName();

	/**
	 * Sets the domain name of this opencps voting statistic.
	 *
	 * @param domainName the domain name of this opencps voting statistic
	 */
	public void setDomainName(String domainName);

	/**
	 * Returns the voting code of this opencps voting statistic.
	 *
	 * @return the voting code of this opencps voting statistic
	 */
	@AutoEscape
	public String getVotingCode();

	/**
	 * Sets the voting code of this opencps voting statistic.
	 *
	 * @param votingCode the voting code of this opencps voting statistic
	 */
	public void setVotingCode(String votingCode);

	/**
	 * Returns the voting subject of this opencps voting statistic.
	 *
	 * @return the voting subject of this opencps voting statistic
	 */
	@AutoEscape
	public String getVotingSubject();

	/**
	 * Sets the voting subject of this opencps voting statistic.
	 *
	 * @param votingSubject the voting subject of this opencps voting statistic
	 */
	public void setVotingSubject(String votingSubject);

	/**
	 * Returns the total voted of this opencps voting statistic.
	 *
	 * @return the total voted of this opencps voting statistic
	 */
	public int getTotalVoted();

	/**
	 * Sets the total voted of this opencps voting statistic.
	 *
	 * @param totalVoted the total voted of this opencps voting statistic
	 */
	public void setTotalVoted(int totalVoted);

	/**
	 * Returns the very good count of this opencps voting statistic.
	 *
	 * @return the very good count of this opencps voting statistic
	 */
	public int getVeryGoodCount();

	/**
	 * Sets the very good count of this opencps voting statistic.
	 *
	 * @param veryGoodCount the very good count of this opencps voting statistic
	 */
	public void setVeryGoodCount(int veryGoodCount);

	/**
	 * Returns the good count of this opencps voting statistic.
	 *
	 * @return the good count of this opencps voting statistic
	 */
	public int getGoodCount();

	/**
	 * Sets the good count of this opencps voting statistic.
	 *
	 * @param goodCount the good count of this opencps voting statistic
	 */
	public void setGoodCount(int goodCount);

	/**
	 * Returns the bad count of this opencps voting statistic.
	 *
	 * @return the bad count of this opencps voting statistic
	 */
	public int getBadCount();

	/**
	 * Sets the bad count of this opencps voting statistic.
	 *
	 * @param badCount the bad count of this opencps voting statistic
	 */
	public void setBadCount(int badCount);

	/**
	 * Returns the percent very good of this opencps voting statistic.
	 *
	 * @return the percent very good of this opencps voting statistic
	 */
	public int getPercentVeryGood();

	/**
	 * Sets the percent very good of this opencps voting statistic.
	 *
	 * @param percentVeryGood the percent very good of this opencps voting statistic
	 */
	public void setPercentVeryGood(int percentVeryGood);

	/**
	 * Returns the percent good of this opencps voting statistic.
	 *
	 * @return the percent good of this opencps voting statistic
	 */
	public int getPercentGood();

	/**
	 * Sets the percent good of this opencps voting statistic.
	 *
	 * @param percentGood the percent good of this opencps voting statistic
	 */
	public void setPercentGood(int percentGood);

	/**
	 * Returns the percent bad of this opencps voting statistic.
	 *
	 * @return the percent bad of this opencps voting statistic
	 */
	public int getPercentBad();

	/**
	 * Sets the percent bad of this opencps voting statistic.
	 *
	 * @param percentBad the percent bad of this opencps voting statistic
	 */
	public void setPercentBad(int percentBad);

	/**
	 * Returns the total count of this opencps voting statistic.
	 *
	 * @return the total count of this opencps voting statistic
	 */
	public int getTotalCount();

	/**
	 * Sets the total count of this opencps voting statistic.
	 *
	 * @param totalCount the total count of this opencps voting statistic
	 */
	public void setTotalCount(int totalCount);

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
	public int compareTo(OpencpsVotingStatistic opencpsVotingStatistic);

	@Override
	public int hashCode();

	@Override
	public CacheModel<OpencpsVotingStatistic> toCacheModel();

	@Override
	public OpencpsVotingStatistic toEscapedModel();

	@Override
	public OpencpsVotingStatistic toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}