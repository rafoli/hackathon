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

package com.liferay.hackathon.users.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.hackathon.users.service.base.UsersCreatedServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * The implementation of the users created remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.hackathon.users.service.UsersCreatedService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UsersCreatedServiceBaseImpl
 * @see com.liferay.hackathon.users.service.UsersCreatedServiceUtil
 */
@ProviderType
public class UsersCreatedServiceImpl extends UsersCreatedServiceBaseImpl {

	public String getHealthCheck() {
		int rnd = new Random().nextInt(2);

		if (rnd == 0) return "Poor";

		return "Good";
	}

	public String getUsersAddedInLastWeek() {
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, -7);

		return getUsersAddedSince(cal.getTime());
	}

	public String getUsersAddedInLastHour() {
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.HOUR_OF_DAY, -1);

		return getUsersAddedSince(cal.getTime());
	}

	public String getUsersAddedInLastMinute() {
		return getUsersAddedInLastXMinutes(1);
	}

	public String getUsersCount() {
		return String.valueOf(userLocalService.getUsersCount());
	}

	public String getUsersAddedInLastXMinutes(final int minutes) {
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.MINUTE, minutes);

		return getUsersAddedSince(cal.getTime());
	}

	public String getUsersAddedSince(final String since) {
		// date format is yyyy-mm-dd
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		Date dt = null;

		try {
			dt = df.parse(since);
		} catch (ParseException e) {
			_log.info("Failed to parse date [" + since + "].");
		}

		if (dt == null) {
			return "0";
		}

		return getUsersAddedSince(dt);
	}

	public String getUsersAddedSince(final Date since) {

		// get a DQ for the query
		DynamicQuery dq = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());

		// now we want to find users since the given date
		// dq.add(PropertyFactoryUtil.forName("createDate").gt(since));
		dq.add(RestrictionsFactoryUtil.between("createDate", since, new Date()));

		// should be it, now we can get the count?
		long count = 0;

		count = userLocalService.dynamicQueryCount(dq);

		return String.valueOf(count);
	}

	private static final Log _log = LogFactoryUtil.getLog(UsersCreatedServiceImpl.class);
}