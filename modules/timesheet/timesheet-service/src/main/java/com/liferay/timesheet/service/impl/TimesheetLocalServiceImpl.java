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

import com.liferay.timesheet.model.Timesheet;
import com.liferay.timesheet.service.base.TimesheetLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the timesheet local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timesheet.service.TimesheetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetLocalServiceBaseImpl
 * @see com.liferay.timesheet.service.TimesheetLocalServiceUtil
 */
@ProviderType
public class TimesheetLocalServiceImpl extends TimesheetLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.timesheet.service.TimesheetLocalServiceUtil} to access the timesheet local service.
	 */

	public Timesheet addTimesheet(final long userId, final Date dateFrom, final Date dateTo) {
		Timesheet sheet = createTimesheet(counterLocalService.increment(Timesheet.class.getName()));

		sheet.setUserId(userId);
		sheet.setDateFrom(dateFrom);
		sheet.setDateTo(dateTo);

		return addTimesheet(sheet);
	}

	public void approveTimesheet(final long timesheetId) {
		Timesheet sheet = fetchTimesheet(timesheetId);

		sheet.setOpen(false);
		sheet.setApproved(true);
		sheet.setApprovedOn(new Date());

		updateTimesheet(sheet);
	}

	public void submitTimesheet(final long timesheetId) {
		Timesheet sheet = fetchTimesheet(timesheetId);

		sheet.setSubmittedOn(new Date());
		sheet.setOpen(false);

		updateTimesheet(sheet);
	}

	public List<Timesheet> findByUser(final long userId) {
		return timesheetPersistence.findByUserId(userId);
	}
	public long countByUser(final long userId) {
		return timesheetPersistence.countByUserId(userId);
	}

	public List<Timesheet> findByUserOpen(final long userId, final boolean open) {
		return timesheetPersistence.findByUserIdOpen(userId, open);
	}
	public long countByUserOpen(final long userId, final boolean open) {
		return timesheetPersistence.countByUserIdOpen(userId, open);
	}
}