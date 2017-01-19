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

package com.liferay.timesheet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TimesheetService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetService
 * @generated
 */
@ProviderType
public class TimesheetServiceWrapper implements TimesheetService,
	ServiceWrapper<TimesheetService> {
	public TimesheetServiceWrapper(TimesheetService timesheetService) {
		_timesheetService = timesheetService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _timesheetService.getOSGiServiceIdentifier();
	}

	@Override
	public TimesheetService getWrappedService() {
		return _timesheetService;
	}

	@Override
	public void setWrappedService(TimesheetService timesheetService) {
		_timesheetService = timesheetService;
	}

	private TimesheetService _timesheetService;
}