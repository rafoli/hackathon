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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for UsersCreated. This utility wraps
 * {@link com.liferay.hackathon.users.service.impl.UsersCreatedServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UsersCreatedService
 * @see com.liferay.hackathon.users.service.base.UsersCreatedServiceBaseImpl
 * @see com.liferay.hackathon.users.service.impl.UsersCreatedServiceImpl
 * @generated
 */
@ProviderType
public class UsersCreatedServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.hackathon.users.service.impl.UsersCreatedServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.lang.String getHealthCheck() {
		return getService().getHealthCheck();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String getUsersAddedInLastHour() {
		return getService().getUsersAddedInLastHour();
	}

	public static java.lang.String getUsersAddedInLastMinute() {
		return getService().getUsersAddedInLastMinute();
	}

	public static java.lang.String getUsersAddedInLastWeek() {
		return getService().getUsersAddedInLastWeek();
	}

	public static java.lang.String getUsersAddedInLastXMinutes(int minutes) {
		return getService().getUsersAddedInLastXMinutes(minutes);
	}

	public static java.lang.String getUsersAddedSince(java.lang.String since) {
		return getService().getUsersAddedSince(since);
	}

	public static java.lang.String getUsersAddedSince(java.util.Date since) {
		return getService().getUsersAddedSince(since);
	}

	public static java.lang.String getUsersCount() {
		return getService().getUsersCount();
	}

	public static UsersCreatedService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UsersCreatedService, UsersCreatedService> _serviceTracker =
		ServiceTrackerFactory.open(UsersCreatedService.class);
}