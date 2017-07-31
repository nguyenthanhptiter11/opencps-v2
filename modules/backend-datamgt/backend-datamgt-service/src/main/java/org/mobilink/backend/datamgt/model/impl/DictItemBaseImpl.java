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

package org.mobilink.backend.datamgt.model.impl;

import aQute.bnd.annotation.ProviderType;

import org.mobilink.backend.datamgt.model.DictItem;
import org.mobilink.backend.datamgt.service.DictItemLocalServiceUtil;

/**
 * The extended model base implementation for the DictItem service. Represents a row in the &quot;m_dictitem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DictItemImpl}.
 * </p>
 *
 * @author Binhth
 * @see DictItemImpl
 * @see DictItem
 * @generated
 */
@ProviderType
public abstract class DictItemBaseImpl extends DictItemModelImpl
	implements DictItem {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dict item model instance should use the {@link DictItem} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			DictItemLocalServiceUtil.addDictItem(this);
		}
		else {
			DictItemLocalServiceUtil.updateDictItem(this);
		}
	}
}