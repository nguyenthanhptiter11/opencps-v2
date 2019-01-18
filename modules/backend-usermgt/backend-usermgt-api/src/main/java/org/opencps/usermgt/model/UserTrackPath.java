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

package org.opencps.usermgt.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the UserTrackPath service. Represents a row in the &quot;opencps_usertrackpath&quot; database table, with each column mapped to a property of this class.
 *
 * @author khoavu
 * @see UserTrackPathModel
 * @see org.opencps.usermgt.model.impl.UserTrackPathImpl
 * @see org.opencps.usermgt.model.impl.UserTrackPathModelImpl
 * @generated
 */
@ImplementationClassName("org.opencps.usermgt.model.impl.UserTrackPathImpl")
@ProviderType
public interface UserTrackPath extends UserTrackPathModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.opencps.usermgt.model.impl.UserTrackPathImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserTrackPath, Long> USER_TRACK_PATH_ID_ACCESSOR =
		new Accessor<UserTrackPath, Long>() {
			@Override
			public Long get(UserTrackPath userTrackPath) {
				return userTrackPath.getUserTrackPathId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserTrackPath> getTypeClass() {
				return UserTrackPath.class;
			}
		};
}