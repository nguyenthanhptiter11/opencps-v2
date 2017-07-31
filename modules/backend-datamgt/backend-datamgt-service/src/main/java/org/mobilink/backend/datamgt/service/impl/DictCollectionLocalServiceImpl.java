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

package org.mobilink.backend.datamgt.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;

import org.mobilink.backend.datamgt.constants.DictCollectionTerm;
import org.mobilink.backend.datamgt.model.DictCollection;
import org.mobilink.backend.datamgt.service.base.DictCollectionLocalServiceBaseImpl;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.generic.MatchQuery.Operator;
import com.liferay.portal.kernel.search.generic.MultiMatchQuery;
import com.liferay.portal.kernel.search.generic.TermQueryImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the dict collection local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.mobilink.backend.datamgt.service.DictCollectionLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Binhth
 * @see DictCollectionLocalServiceBaseImpl
 * @see org.mobilink.backend.datamgt.service.DictCollectionLocalServiceUtil
 */
@ProviderType
public class DictCollectionLocalServiceImpl extends DictCollectionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * org.mobilink.backend.datamgt.service.DictCollectionLocalServiceUtil} to
	 * access the dict collection local service.
	 */
	/**
	 * @param userId
	 * @param groupId
	 * @param collectionCode
	 * @param collectionName
	 * @param description
	 * @param serviceContext
	 * @return
	 * @throws Exception
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DictCollection addDictCollection(long userId, long groupId, String collectionCode, String collectionName,
			String description, ServiceContext serviceContext) throws Exception {

		// TODO

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		if (Validator.isNotNull(collectionCode)) {

			collectionCode = collectionCode.toUpperCase();

		}

		long dictCollectionId = counterLocalService.increment(DictCollection.class.getName());

		DictCollection dictCollection = dictCollectionPersistence.create(dictCollectionId);

		// Group instance
		dictCollection.setGroupId(groupId);

		// Audit fields
		dictCollection.setUuid(serviceContext.getUuid());
		dictCollection.setCompanyId(user.getCompanyId());
		dictCollection.setUserId(user.getUserId());
		dictCollection.setUserName(user.getFullName());
		dictCollection.setCreateDate(serviceContext.getCreateDate(now));
		dictCollection.setModifiedDate(serviceContext.getCreateDate(now));

		// Other fields
		dictCollection.setCollectionCode(collectionCode);
		dictCollection.setCollectionName(collectionName);
		dictCollection.setDescription(description);

		dictCollection.setExpandoBridgeAttributes(serviceContext);

		dictCollectionPersistence.update(dictCollection);

		return dictCollection;
	}

	/**
	 * @param dictCollectionId
	 * @param serviceContext
	 * @return
	 * @throws Exception
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DictCollection deleteDictCollection(long dictCollectionId, ServiceContext serviceContext) throws Exception {

		// TODO

		DictCollection dictCollection = dictCollectionPersistence.remove(dictCollectionId);

		return dictCollection;

	}

	/**
	 * @param userId
	 * @param dictCollectionId
	 * @param collectionCode
	 * @param collectionName
	 * @param description
	 * @param serviceContext
	 * @return
	 * @throws Exception
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DictCollection updateDictCollection(long userId, long dictCollectionId, String collectionCode,
			String collectionName, String description, ServiceContext serviceContext) throws Exception {

		// TODO

		Date now = new Date();

		User user = userPersistence.findByPrimaryKey(userId);

		DictCollection dictCollection = dictCollectionPersistence.fetchByPrimaryKey(dictCollectionId);

		if (Validator.isNotNull(collectionCode)) {

			collectionCode = collectionCode.toUpperCase();

		}

		// Audit fields
		dictCollection.setUserId(user.getUserId());
		dictCollection.setUserName(user.getFullName());
		dictCollection.setModifiedDate(serviceContext.getCreateDate(now));

		// Other fields
		dictCollection.setCollectionCode(collectionCode);
		dictCollection.setCollectionName(collectionName);
		dictCollection.setDescription(description);

		dictCollection.setExpandoBridgeAttributes(serviceContext);

		dictCollectionPersistence.update(dictCollection);

		return dictCollection;
	}

	/**
	 * @param params
	 * 
	 *            <pre>
	 * <ol>
	 * <li> keywords </li>
	 * <li> groupId </li>
	 * <li> userId </li>
	 * <li> collectionCode </li>
	 * </ol>
	 *            </pre>
	 * 
	 * @param sorts
	 * @param start
	 * @param end
	 * @param searchContext
	 * @throws ParseException,
	 *             SearchException
	 */
	@SuppressWarnings("deprecation")
	public Hits luceneSearchEngine(LinkedHashMap<String, Object> params, Sort[] sorts, int start, int end,
			SearchContext searchContext) throws ParseException, SearchException {

		// TODO Auto-generated method stub
		String keywords = (String) params.get("keywords");
		String groupId = (String) params.get(DictCollectionTerm.GROUP_ID);
		String userId = (String) params.get(DictCollectionTerm.USER_ID);
		String collectionCode = (String) params.get(DictCollectionTerm.COLLECTION_CODE);

		Indexer<DictCollection> indexer = IndexerRegistryUtil.nullSafeGetIndexer(DictCollection.class);

		searchContext.addFullQueryEntryClassName(DictCollection.class.getName());
		searchContext.setEntryClassNames(new String[] { DictCollection.class.getName() });
		searchContext.setAttribute("paginationType", "regular");
		searchContext.setLike(true);
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setAndSearch(true);
		searchContext.setSorts(sorts);

		BooleanQuery booleanQuery = null;

		if (Validator.isNotNull(keywords)) {

			booleanQuery = BooleanQueryFactoryUtil.create(searchContext);

		} else {

			booleanQuery = indexer.getFullQuery(searchContext);

		}

		if (Validator.isNotNull(keywords)) {

			String[] keyword = keywords.split(StringPool.SPACE);

			for (String string : keyword) {

				MultiMatchQuery query = new MultiMatchQuery(string);

				query.addFields(DictCollectionTerm.COLLECTION_NAME, DictCollectionTerm.COLLECTION_CODE);

				Operator operator = Operator.AND;

				query.setOperator(operator);

				booleanQuery.add(query, BooleanClauseOccur.MUST);

			}

		}
		if (Validator.isNotNull(collectionCode)) {

			MultiMatchQuery query = new MultiMatchQuery(collectionCode);

			query.addFields(DictCollectionTerm.COLLECTION_CODE);

			booleanQuery.add(query, BooleanClauseOccur.MUST);

		}

		if (Validator.isNotNull(groupId)) {

			BooleanQuery categoryQuery = Validator.isNotNull((String) keywords)
					? BooleanQueryFactoryUtil.create((SearchContext) searchContext)
					: indexer.getFullQuery(searchContext);

			TermQuery catQuery1 = new TermQueryImpl(DictCollectionTerm.GROUP_ID, groupId);
			TermQuery catQuery2 = new TermQueryImpl(DictCollectionTerm.GROUP_ID, String.valueOf(0));

			categoryQuery.add(catQuery1, BooleanClauseOccur.SHOULD);
			categoryQuery.add(catQuery2, BooleanClauseOccur.SHOULD);

			booleanQuery.add(categoryQuery, BooleanClauseOccur.MUST);

		}

		if (Validator.isNotNull(userId)) {

			MultiMatchQuery query = new MultiMatchQuery(userId);

			query.addFields(DictCollectionTerm.USER_ID);

			booleanQuery.add(query, BooleanClauseOccur.MUST);

		}

		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, DictCollection.class.getName());

		return IndexSearcherHelperUtil.search(searchContext, booleanQuery);

	}

	public DictCollection fetchByF_dictCollectionCode(String collectionCode, long groupId) {

		return dictCollectionPersistence.fetchByF_dictCollectionCode(collectionCode, groupId);

	}
}