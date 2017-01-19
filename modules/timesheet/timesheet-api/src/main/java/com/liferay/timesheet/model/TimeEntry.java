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
 * The extended model interface for the TimeEntry service. Represents a row in the &quot;TIME_TimeEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TimeEntryModel
 * @see com.liferay.timesheet.model.impl.TimeEntryImpl
 * @see com.liferay.timesheet.model.impl.TimeEntryModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.timesheet.model.impl.TimeEntryImpl")
@ProviderType
public interface TimeEntry extends TimeEntryModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.timesheet.model.impl.TimeEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TimeEntry, Long> TIME_ENTRY_ID_ACCESSOR = new Accessor<TimeEntry, Long>() {
			@Override
			public Long get(TimeEntry timeEntry) {
				return timeEntry.getTimeEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TimeEntry> getTypeClass() {
				return TimeEntry.class;
			}
		};
}