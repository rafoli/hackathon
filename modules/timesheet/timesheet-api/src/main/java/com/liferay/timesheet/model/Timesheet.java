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

package com.liferay.timesheet.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Timesheet service. Represents a row in the &quot;TIME_Timesheet&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetModel
 * @see com.liferay.timesheet.model.impl.TimesheetImpl
 * @see com.liferay.timesheet.model.impl.TimesheetModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.timesheet.model.impl.TimesheetImpl")
@ProviderType
public interface Timesheet extends TimesheetModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.timesheet.model.impl.TimesheetImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Timesheet, Long> TIMESHEET_ID_ACCESSOR = new Accessor<Timesheet, Long>() {
			@Override
			public Long get(Timesheet timesheet) {
				return timesheet.getTimesheetId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Timesheet> getTypeClass() {
				return Timesheet.class;
			}
		};
}