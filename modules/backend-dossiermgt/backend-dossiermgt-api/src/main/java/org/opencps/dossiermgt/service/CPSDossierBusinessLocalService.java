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

package org.opencps.dossiermgt.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import org.opencps.auth.api.exception.UnauthenticationException;

import org.opencps.dossiermgt.input.model.DossierInputModel;
import org.opencps.dossiermgt.model.Dossier;
import org.opencps.dossiermgt.model.DossierAction;
import org.opencps.dossiermgt.model.DossierFile;
import org.opencps.dossiermgt.model.ProcessAction;
import org.opencps.dossiermgt.model.ProcessOption;

/**
 * Provides the local service interface for CPSDossierBusiness. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author huymq
 * @see CPSDossierBusinessLocalServiceUtil
 * @see org.opencps.dossiermgt.service.base.CPSDossierBusinessLocalServiceBaseImpl
 * @see org.opencps.dossiermgt.service.impl.CPSDossierBusinessLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CPSDossierBusinessLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CPSDossierBusinessLocalServiceUtil} to access the cps dossier business local service. Add custom service methods to {@link org.opencps.dossiermgt.service.impl.CPSDossierBusinessLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor =  {
		SystemException.class, PortalException.class, Exception.class}
	)
	public Dossier addDossier(long groupId, Company company, User user,
		ServiceContext serviceContext, DossierInputModel input)
		throws UnauthenticationException, PortalException, Exception;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor =  {
		SystemException.class, PortalException.class, Exception.class}
	)
	public DossierFile addDossierFileByDossierId(long groupId, Company company,
		User user, ServiceContext serviceContext, Attachment file, String id,
		String referenceUid, String dossierTemplateNo, String dossierPartNo,
		String fileTemplateNo, String displayName, String fileType,
		String isSync, String formData, String removed, String eForm,
		Long modifiedDate)
		throws UnauthenticationException, PortalException, Exception;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor =  {
		SystemException.class, PortalException.class, Exception.class}
	)
	public DossierAction doAction(long groupId, long userId, Dossier dossier,
		ProcessOption option, ProcessAction proAction, String actionCode,
		String actionUser, String actionNote, String payload,
		String assignUsers, String payment, int syncType, ServiceContext context)
		throws PortalException, SystemException, Exception;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	public void initDossierActionUser(ProcessAction processAction,
		Dossier dossier, int allowAssignUser, DossierAction dossierAction,
		long userId, long groupId, long assignUserId) throws PortalException;
}