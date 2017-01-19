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

package com.liferay.hackathon.users.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UsersCreatedService}.
 *
 * @author Brian Wing Shun Chan
 * @see UsersCreatedService
 * @generated
 */
@ProviderType
public class UsersCreatedServiceWrapper implements UsersCreatedService,
	ServiceWrapper<UsersCreatedService> {
	public UsersCreatedServiceWrapper(UsersCreatedService usersCreatedService) {
		_usersCreatedService = usersCreatedService;
	}

	@Override
	public java.lang.String getHealthCheck() {
		return _usersCreatedService.getHealthCheck();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _usersCreatedService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String getUsersAddedInLastHour() {
		return _usersCreatedService.getUsersAddedInLastHour();
	}

	@Override
	public java.lang.String getUsersAddedInLastMinute() {
		return _usersCreatedService.getUsersAddedInLastMinute();
	}

	@Override
	public java.lang.String getUsersAddedInLastWeek() {
		return _usersCreatedService.getUsersAddedInLastWeek();
	}

	@Override
	public java.lang.String getUsersAddedInLastXMinutes(int minutes) {
		return _usersCreatedService.getUsersAddedInLastXMinutes(minutes);
	}

	@Override
	public java.lang.String getUsersAddedSince(java.lang.String since) {
		return _usersCreatedService.getUsersAddedSince(since);
	}

	@Override
	public java.lang.String getUsersAddedSince(java.util.Date since) {
		return _usersCreatedService.getUsersAddedSince(since);
	}

	@Override
	public java.lang.String getUsersCount() {
		return _usersCreatedService.getUsersCount();
	}

	@Override
	public UsersCreatedService getWrappedService() {
		return _usersCreatedService;
	}

	@Override
	public void setWrappedService(UsersCreatedService usersCreatedService) {
		_usersCreatedService = usersCreatedService;
	}

	private UsersCreatedService _usersCreatedService;
}