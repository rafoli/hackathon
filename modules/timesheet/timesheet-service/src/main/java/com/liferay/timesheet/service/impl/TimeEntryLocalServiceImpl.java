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

package com.liferay.timesheet.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.timesheet.model.TimeEntry;
import com.liferay.timesheet.service.base.TimeEntryLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the time entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timesheet.service.TimeEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeEntryLocalServiceBaseImpl
 * @see com.liferay.timesheet.service.TimeEntryLocalServiceUtil
 */
@ProviderType
public class TimeEntryLocalServiceImpl extends TimeEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.timesheet.service.TimeEntryLocalServiceUtil} to access the time entry local service.
	 */

	public TimeEntry addTimeEntry(final long userId, final Double hours, final long projectId, final long taskId, final boolean billable, final long timesheetId, final Date forDate, final String message) {
		TimeEntry entry = createTimeEntry(counterLocalService.increment(TimeEntry.class.getName()));

		entry.setBillable(billable);
		entry.setHours(hours);
		entry.setMessage(message);
		entry.setOnDate(forDate);
		entry.setProjectId(projectId);
		entry.setTaskId(taskId);
		entry.setUserId(userId);
		entry.setTimesheetId(timesheetId);

		return addTimeEntry(entry);
	}

	public List<TimeEntry> findByUser(final long userId) {
		return timeEntryPersistence.findByUserId(userId);
	}
	public long countByUser(final long userId) {
		return timeEntryPersistence.countByUserId(userId);
	}
	public List<TimeEntry> findByTimesheet(final long timesheetId) {
		return timeEntryPersistence.findByTimesheet(userId);
	}
	public long countByTimesheet(final long timesheetId) {
		return timeEntryPersistence.countByTimesheet(userId);
	}
	public List<TimeEntry> findByUserDate(final long userId, final Date onDate) {
		return timeEntryPersistence.findByUserIdDate(userId, onDate);
	}
	public long countByUserDate(final long userId, final Date onDate) {
		return timeEntryPersistence.countByUserIdDate(userId, onDate);
	}
}