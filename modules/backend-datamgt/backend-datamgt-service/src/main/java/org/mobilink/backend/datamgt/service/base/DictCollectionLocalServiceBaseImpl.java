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

package org.mobilink.backend.datamgt.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.mobilink.backend.datamgt.model.DictCollection;
import org.mobilink.backend.datamgt.service.DictCollectionLocalService;
import org.mobilink.backend.datamgt.service.persistence.CommentPersistence;
import org.mobilink.backend.datamgt.service.persistence.DictCollectionPersistence;
import org.mobilink.backend.datamgt.service.persistence.DictGroupPersistence;
import org.mobilink.backend.datamgt.service.persistence.DictItemGroupPersistence;
import org.mobilink.backend.datamgt.service.persistence.DictItemPersistence;
import org.mobilink.backend.datamgt.service.persistence.LabelPersistence;
import org.mobilink.backend.datamgt.service.persistence.LocationPersistence;
import org.mobilink.backend.datamgt.service.persistence.VotingPersistence;
import org.mobilink.backend.datamgt.service.persistence.VotingResultPersistence;
import org.mobilink.backend.datamgt.service.persistence.WorkspacePersistence;
import org.mobilink.backend.datamgt.service.persistence.WorkspaceRolePersistence;
import org.mobilink.backend.datamgt.service.persistence.WorkspaceUserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the dict collection local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.mobilink.backend.datamgt.service.impl.DictCollectionLocalServiceImpl}.
 * </p>
 *
 * @author Binhth
 * @see org.mobilink.backend.datamgt.service.impl.DictCollectionLocalServiceImpl
 * @see org.mobilink.backend.datamgt.service.DictCollectionLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class DictCollectionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements DictCollectionLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.mobilink.backend.datamgt.service.DictCollectionLocalServiceUtil} to access the dict collection local service.
	 */

	/**
	 * Adds the dict collection to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictCollection the dict collection
	 * @return the dict collection that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DictCollection addDictCollection(DictCollection dictCollection) {
		dictCollection.setNew(true);

		return dictCollectionPersistence.update(dictCollection);
	}

	/**
	 * Creates a new dict collection with the primary key. Does not add the dict collection to the database.
	 *
	 * @param dictCollectionId the primary key for the new dict collection
	 * @return the new dict collection
	 */
	@Override
	public DictCollection createDictCollection(long dictCollectionId) {
		return dictCollectionPersistence.create(dictCollectionId);
	}

	/**
	 * Deletes the dict collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictCollectionId the primary key of the dict collection
	 * @return the dict collection that was removed
	 * @throws PortalException if a dict collection with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DictCollection deleteDictCollection(long dictCollectionId)
		throws PortalException {
		return dictCollectionPersistence.remove(dictCollectionId);
	}

	/**
	 * Deletes the dict collection from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictCollection the dict collection
	 * @return the dict collection that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DictCollection deleteDictCollection(DictCollection dictCollection) {
		return dictCollectionPersistence.remove(dictCollection);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(DictCollection.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return dictCollectionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mobilink.backend.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return dictCollectionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mobilink.backend.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return dictCollectionPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return dictCollectionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return dictCollectionPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public DictCollection fetchDictCollection(long dictCollectionId) {
		return dictCollectionPersistence.fetchByPrimaryKey(dictCollectionId);
	}

	/**
	 * Returns the dict collection matching the UUID and group.
	 *
	 * @param uuid the dict collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dict collection, or <code>null</code> if a matching dict collection could not be found
	 */
	@Override
	public DictCollection fetchDictCollectionByUuidAndGroupId(String uuid,
		long groupId) {
		return dictCollectionPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the dict collection with the primary key.
	 *
	 * @param dictCollectionId the primary key of the dict collection
	 * @return the dict collection
	 * @throws PortalException if a dict collection with the primary key could not be found
	 */
	@Override
	public DictCollection getDictCollection(long dictCollectionId)
		throws PortalException {
		return dictCollectionPersistence.findByPrimaryKey(dictCollectionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(dictCollectionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DictCollection.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dictCollectionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(dictCollectionLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(DictCollection.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"dictCollectionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(dictCollectionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DictCollection.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("dictCollectionId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<DictCollection>() {
				@Override
				public void performAction(DictCollection dictCollection)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						dictCollection);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(DictCollection.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return dictCollectionLocalService.deleteDictCollection((DictCollection)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return dictCollectionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the dict collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the dict collections
	 * @param companyId the primary key of the company
	 * @return the matching dict collections, or an empty list if no matches were found
	 */
	@Override
	public List<DictCollection> getDictCollectionsByUuidAndCompanyId(
		String uuid, long companyId) {
		return dictCollectionPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of dict collections matching the UUID and company.
	 *
	 * @param uuid the UUID of the dict collections
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching dict collections, or an empty list if no matches were found
	 */
	@Override
	public List<DictCollection> getDictCollectionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<DictCollection> orderByComparator) {
		return dictCollectionPersistence.findByUuid_C(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	 * Returns the dict collection matching the UUID and group.
	 *
	 * @param uuid the dict collection's UUID
	 * @param groupId the primary key of the group
	 * @return the matching dict collection
	 * @throws PortalException if a matching dict collection could not be found
	 */
	@Override
	public DictCollection getDictCollectionByUuidAndGroupId(String uuid,
		long groupId) throws PortalException {
		return dictCollectionPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the dict collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.mobilink.backend.datamgt.model.impl.DictCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dict collections
	 * @param end the upper bound of the range of dict collections (not inclusive)
	 * @return the range of dict collections
	 */
	@Override
	public List<DictCollection> getDictCollections(int start, int end) {
		return dictCollectionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of dict collections.
	 *
	 * @return the number of dict collections
	 */
	@Override
	public int getDictCollectionsCount() {
		return dictCollectionPersistence.countAll();
	}

	/**
	 * Updates the dict collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dictCollection the dict collection
	 * @return the dict collection that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DictCollection updateDictCollection(DictCollection dictCollection) {
		return dictCollectionPersistence.update(dictCollection);
	}

	/**
	 * Returns the comment local service.
	 *
	 * @return the comment local service
	 */
	public org.mobilink.backend.datamgt.service.CommentLocalService getCommentLocalService() {
		return commentLocalService;
	}

	/**
	 * Sets the comment local service.
	 *
	 * @param commentLocalService the comment local service
	 */
	public void setCommentLocalService(
		org.mobilink.backend.datamgt.service.CommentLocalService commentLocalService) {
		this.commentLocalService = commentLocalService;
	}

	/**
	 * Returns the comment persistence.
	 *
	 * @return the comment persistence
	 */
	public CommentPersistence getCommentPersistence() {
		return commentPersistence;
	}

	/**
	 * Sets the comment persistence.
	 *
	 * @param commentPersistence the comment persistence
	 */
	public void setCommentPersistence(CommentPersistence commentPersistence) {
		this.commentPersistence = commentPersistence;
	}

	/**
	 * Returns the dict collection local service.
	 *
	 * @return the dict collection local service
	 */
	public DictCollectionLocalService getDictCollectionLocalService() {
		return dictCollectionLocalService;
	}

	/**
	 * Sets the dict collection local service.
	 *
	 * @param dictCollectionLocalService the dict collection local service
	 */
	public void setDictCollectionLocalService(
		DictCollectionLocalService dictCollectionLocalService) {
		this.dictCollectionLocalService = dictCollectionLocalService;
	}

	/**
	 * Returns the dict collection persistence.
	 *
	 * @return the dict collection persistence
	 */
	public DictCollectionPersistence getDictCollectionPersistence() {
		return dictCollectionPersistence;
	}

	/**
	 * Sets the dict collection persistence.
	 *
	 * @param dictCollectionPersistence the dict collection persistence
	 */
	public void setDictCollectionPersistence(
		DictCollectionPersistence dictCollectionPersistence) {
		this.dictCollectionPersistence = dictCollectionPersistence;
	}

	/**
	 * Returns the dict group local service.
	 *
	 * @return the dict group local service
	 */
	public org.mobilink.backend.datamgt.service.DictGroupLocalService getDictGroupLocalService() {
		return dictGroupLocalService;
	}

	/**
	 * Sets the dict group local service.
	 *
	 * @param dictGroupLocalService the dict group local service
	 */
	public void setDictGroupLocalService(
		org.mobilink.backend.datamgt.service.DictGroupLocalService dictGroupLocalService) {
		this.dictGroupLocalService = dictGroupLocalService;
	}

	/**
	 * Returns the dict group persistence.
	 *
	 * @return the dict group persistence
	 */
	public DictGroupPersistence getDictGroupPersistence() {
		return dictGroupPersistence;
	}

	/**
	 * Sets the dict group persistence.
	 *
	 * @param dictGroupPersistence the dict group persistence
	 */
	public void setDictGroupPersistence(
		DictGroupPersistence dictGroupPersistence) {
		this.dictGroupPersistence = dictGroupPersistence;
	}

	/**
	 * Returns the dict item local service.
	 *
	 * @return the dict item local service
	 */
	public org.mobilink.backend.datamgt.service.DictItemLocalService getDictItemLocalService() {
		return dictItemLocalService;
	}

	/**
	 * Sets the dict item local service.
	 *
	 * @param dictItemLocalService the dict item local service
	 */
	public void setDictItemLocalService(
		org.mobilink.backend.datamgt.service.DictItemLocalService dictItemLocalService) {
		this.dictItemLocalService = dictItemLocalService;
	}

	/**
	 * Returns the dict item persistence.
	 *
	 * @return the dict item persistence
	 */
	public DictItemPersistence getDictItemPersistence() {
		return dictItemPersistence;
	}

	/**
	 * Sets the dict item persistence.
	 *
	 * @param dictItemPersistence the dict item persistence
	 */
	public void setDictItemPersistence(DictItemPersistence dictItemPersistence) {
		this.dictItemPersistence = dictItemPersistence;
	}

	/**
	 * Returns the dict item group local service.
	 *
	 * @return the dict item group local service
	 */
	public org.mobilink.backend.datamgt.service.DictItemGroupLocalService getDictItemGroupLocalService() {
		return dictItemGroupLocalService;
	}

	/**
	 * Sets the dict item group local service.
	 *
	 * @param dictItemGroupLocalService the dict item group local service
	 */
	public void setDictItemGroupLocalService(
		org.mobilink.backend.datamgt.service.DictItemGroupLocalService dictItemGroupLocalService) {
		this.dictItemGroupLocalService = dictItemGroupLocalService;
	}

	/**
	 * Returns the dict item group persistence.
	 *
	 * @return the dict item group persistence
	 */
	public DictItemGroupPersistence getDictItemGroupPersistence() {
		return dictItemGroupPersistence;
	}

	/**
	 * Sets the dict item group persistence.
	 *
	 * @param dictItemGroupPersistence the dict item group persistence
	 */
	public void setDictItemGroupPersistence(
		DictItemGroupPersistence dictItemGroupPersistence) {
		this.dictItemGroupPersistence = dictItemGroupPersistence;
	}

	/**
	 * Returns the label local service.
	 *
	 * @return the label local service
	 */
	public org.mobilink.backend.datamgt.service.LabelLocalService getLabelLocalService() {
		return labelLocalService;
	}

	/**
	 * Sets the label local service.
	 *
	 * @param labelLocalService the label local service
	 */
	public void setLabelLocalService(
		org.mobilink.backend.datamgt.service.LabelLocalService labelLocalService) {
		this.labelLocalService = labelLocalService;
	}

	/**
	 * Returns the label persistence.
	 *
	 * @return the label persistence
	 */
	public LabelPersistence getLabelPersistence() {
		return labelPersistence;
	}

	/**
	 * Sets the label persistence.
	 *
	 * @param labelPersistence the label persistence
	 */
	public void setLabelPersistence(LabelPersistence labelPersistence) {
		this.labelPersistence = labelPersistence;
	}

	/**
	 * Returns the location local service.
	 *
	 * @return the location local service
	 */
	public org.mobilink.backend.datamgt.service.LocationLocalService getLocationLocalService() {
		return locationLocalService;
	}

	/**
	 * Sets the location local service.
	 *
	 * @param locationLocalService the location local service
	 */
	public void setLocationLocalService(
		org.mobilink.backend.datamgt.service.LocationLocalService locationLocalService) {
		this.locationLocalService = locationLocalService;
	}

	/**
	 * Returns the location persistence.
	 *
	 * @return the location persistence
	 */
	public LocationPersistence getLocationPersistence() {
		return locationPersistence;
	}

	/**
	 * Sets the location persistence.
	 *
	 * @param locationPersistence the location persistence
	 */
	public void setLocationPersistence(LocationPersistence locationPersistence) {
		this.locationPersistence = locationPersistence;
	}

	/**
	 * Returns the voting local service.
	 *
	 * @return the voting local service
	 */
	public org.mobilink.backend.datamgt.service.VotingLocalService getVotingLocalService() {
		return votingLocalService;
	}

	/**
	 * Sets the voting local service.
	 *
	 * @param votingLocalService the voting local service
	 */
	public void setVotingLocalService(
		org.mobilink.backend.datamgt.service.VotingLocalService votingLocalService) {
		this.votingLocalService = votingLocalService;
	}

	/**
	 * Returns the voting persistence.
	 *
	 * @return the voting persistence
	 */
	public VotingPersistence getVotingPersistence() {
		return votingPersistence;
	}

	/**
	 * Sets the voting persistence.
	 *
	 * @param votingPersistence the voting persistence
	 */
	public void setVotingPersistence(VotingPersistence votingPersistence) {
		this.votingPersistence = votingPersistence;
	}

	/**
	 * Returns the voting result local service.
	 *
	 * @return the voting result local service
	 */
	public org.mobilink.backend.datamgt.service.VotingResultLocalService getVotingResultLocalService() {
		return votingResultLocalService;
	}

	/**
	 * Sets the voting result local service.
	 *
	 * @param votingResultLocalService the voting result local service
	 */
	public void setVotingResultLocalService(
		org.mobilink.backend.datamgt.service.VotingResultLocalService votingResultLocalService) {
		this.votingResultLocalService = votingResultLocalService;
	}

	/**
	 * Returns the voting result persistence.
	 *
	 * @return the voting result persistence
	 */
	public VotingResultPersistence getVotingResultPersistence() {
		return votingResultPersistence;
	}

	/**
	 * Sets the voting result persistence.
	 *
	 * @param votingResultPersistence the voting result persistence
	 */
	public void setVotingResultPersistence(
		VotingResultPersistence votingResultPersistence) {
		this.votingResultPersistence = votingResultPersistence;
	}

	/**
	 * Returns the workspace local service.
	 *
	 * @return the workspace local service
	 */
	public org.mobilink.backend.datamgt.service.WorkspaceLocalService getWorkspaceLocalService() {
		return workspaceLocalService;
	}

	/**
	 * Sets the workspace local service.
	 *
	 * @param workspaceLocalService the workspace local service
	 */
	public void setWorkspaceLocalService(
		org.mobilink.backend.datamgt.service.WorkspaceLocalService workspaceLocalService) {
		this.workspaceLocalService = workspaceLocalService;
	}

	/**
	 * Returns the workspace persistence.
	 *
	 * @return the workspace persistence
	 */
	public WorkspacePersistence getWorkspacePersistence() {
		return workspacePersistence;
	}

	/**
	 * Sets the workspace persistence.
	 *
	 * @param workspacePersistence the workspace persistence
	 */
	public void setWorkspacePersistence(
		WorkspacePersistence workspacePersistence) {
		this.workspacePersistence = workspacePersistence;
	}

	/**
	 * Returns the workspace role local service.
	 *
	 * @return the workspace role local service
	 */
	public org.mobilink.backend.datamgt.service.WorkspaceRoleLocalService getWorkspaceRoleLocalService() {
		return workspaceRoleLocalService;
	}

	/**
	 * Sets the workspace role local service.
	 *
	 * @param workspaceRoleLocalService the workspace role local service
	 */
	public void setWorkspaceRoleLocalService(
		org.mobilink.backend.datamgt.service.WorkspaceRoleLocalService workspaceRoleLocalService) {
		this.workspaceRoleLocalService = workspaceRoleLocalService;
	}

	/**
	 * Returns the workspace role persistence.
	 *
	 * @return the workspace role persistence
	 */
	public WorkspaceRolePersistence getWorkspaceRolePersistence() {
		return workspaceRolePersistence;
	}

	/**
	 * Sets the workspace role persistence.
	 *
	 * @param workspaceRolePersistence the workspace role persistence
	 */
	public void setWorkspaceRolePersistence(
		WorkspaceRolePersistence workspaceRolePersistence) {
		this.workspaceRolePersistence = workspaceRolePersistence;
	}

	/**
	 * Returns the workspace user local service.
	 *
	 * @return the workspace user local service
	 */
	public org.mobilink.backend.datamgt.service.WorkspaceUserLocalService getWorkspaceUserLocalService() {
		return workspaceUserLocalService;
	}

	/**
	 * Sets the workspace user local service.
	 *
	 * @param workspaceUserLocalService the workspace user local service
	 */
	public void setWorkspaceUserLocalService(
		org.mobilink.backend.datamgt.service.WorkspaceUserLocalService workspaceUserLocalService) {
		this.workspaceUserLocalService = workspaceUserLocalService;
	}

	/**
	 * Returns the workspace user persistence.
	 *
	 * @return the workspace user persistence
	 */
	public WorkspaceUserPersistence getWorkspaceUserPersistence() {
		return workspaceUserPersistence;
	}

	/**
	 * Sets the workspace user persistence.
	 *
	 * @param workspaceUserPersistence the workspace user persistence
	 */
	public void setWorkspaceUserPersistence(
		WorkspaceUserPersistence workspaceUserPersistence) {
		this.workspaceUserPersistence = workspaceUserPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("org.mobilink.backend.datamgt.model.DictCollection",
			dictCollectionLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"org.mobilink.backend.datamgt.model.DictCollection");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DictCollectionLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DictCollection.class;
	}

	protected String getModelClassName() {
		return DictCollection.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = dictCollectionPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.mobilink.backend.datamgt.service.CommentLocalService.class)
	protected org.mobilink.backend.datamgt.service.CommentLocalService commentLocalService;
	@BeanReference(type = CommentPersistence.class)
	protected CommentPersistence commentPersistence;
	@BeanReference(type = DictCollectionLocalService.class)
	protected DictCollectionLocalService dictCollectionLocalService;
	@BeanReference(type = DictCollectionPersistence.class)
	protected DictCollectionPersistence dictCollectionPersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.DictGroupLocalService.class)
	protected org.mobilink.backend.datamgt.service.DictGroupLocalService dictGroupLocalService;
	@BeanReference(type = DictGroupPersistence.class)
	protected DictGroupPersistence dictGroupPersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.DictItemLocalService.class)
	protected org.mobilink.backend.datamgt.service.DictItemLocalService dictItemLocalService;
	@BeanReference(type = DictItemPersistence.class)
	protected DictItemPersistence dictItemPersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.DictItemGroupLocalService.class)
	protected org.mobilink.backend.datamgt.service.DictItemGroupLocalService dictItemGroupLocalService;
	@BeanReference(type = DictItemGroupPersistence.class)
	protected DictItemGroupPersistence dictItemGroupPersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.LabelLocalService.class)
	protected org.mobilink.backend.datamgt.service.LabelLocalService labelLocalService;
	@BeanReference(type = LabelPersistence.class)
	protected LabelPersistence labelPersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.LocationLocalService.class)
	protected org.mobilink.backend.datamgt.service.LocationLocalService locationLocalService;
	@BeanReference(type = LocationPersistence.class)
	protected LocationPersistence locationPersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.VotingLocalService.class)
	protected org.mobilink.backend.datamgt.service.VotingLocalService votingLocalService;
	@BeanReference(type = VotingPersistence.class)
	protected VotingPersistence votingPersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.VotingResultLocalService.class)
	protected org.mobilink.backend.datamgt.service.VotingResultLocalService votingResultLocalService;
	@BeanReference(type = VotingResultPersistence.class)
	protected VotingResultPersistence votingResultPersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.WorkspaceLocalService.class)
	protected org.mobilink.backend.datamgt.service.WorkspaceLocalService workspaceLocalService;
	@BeanReference(type = WorkspacePersistence.class)
	protected WorkspacePersistence workspacePersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.WorkspaceRoleLocalService.class)
	protected org.mobilink.backend.datamgt.service.WorkspaceRoleLocalService workspaceRoleLocalService;
	@BeanReference(type = WorkspaceRolePersistence.class)
	protected WorkspaceRolePersistence workspaceRolePersistence;
	@BeanReference(type = org.mobilink.backend.datamgt.service.WorkspaceUserLocalService.class)
	protected org.mobilink.backend.datamgt.service.WorkspaceUserLocalService workspaceUserLocalService;
	@BeanReference(type = WorkspaceUserPersistence.class)
	protected WorkspaceUserPersistence workspaceUserPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}