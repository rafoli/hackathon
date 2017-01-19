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

package com.liferay.timesheet.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.timesheet.model.TimeEntry;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the time entry service. This utility wraps {@link com.liferay.timesheet.service.persistence.impl.TimeEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeEntryPersistence
 * @see com.liferay.timesheet.service.persistence.impl.TimeEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class TimeEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TimeEntry timeEntry) {
		getPersistence().clearCache(timeEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TimeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TimeEntry update(TimeEntry timeEntry) {
		return getPersistence().update(timeEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TimeEntry update(TimeEntry timeEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(timeEntry, serviceContext);
	}

	/**
	* Returns all the time entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching time entries
	*/
	public static List<TimeEntry> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the time entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @return the range of matching time entries
	*/
	public static List<TimeEntry> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the time entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching time entries
	*/
	public static List<TimeEntry> findByUserId(long userId, int start, int end,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the time entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching time entries
	*/
	public static List<TimeEntry> findByUserId(long userId, int start, int end,
		OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first time entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public static TimeEntry findByUserId_First(long userId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first time entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public static TimeEntry fetchByUserId_First(long userId,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last time entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public static TimeEntry findByUserId_Last(long userId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last time entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public static TimeEntry fetchByUserId_Last(long userId,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the time entries before and after the current time entry in the ordered set where userId = &#63;.
	*
	* @param timeEntryId the primary key of the current time entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time entry
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public static TimeEntry[] findByUserId_PrevAndNext(long timeEntryId,
		long userId, OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(timeEntryId, userId,
			orderByComparator);
	}

	/**
	* Removes all the time entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of time entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching time entries
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the time entries where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @return the matching time entries
	*/
	public static List<TimeEntry> findByUserIdDate(long userId, Date onDate) {
		return getPersistence().findByUserIdDate(userId, onDate);
	}

	/**
	* Returns a range of all the time entries where userId = &#63; and onDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @return the range of matching time entries
	*/
	public static List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end) {
		return getPersistence().findByUserIdDate(userId, onDate, start, end);
	}

	/**
	* Returns an ordered range of all the time entries where userId = &#63; and onDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching time entries
	*/
	public static List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end, OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence()
				   .findByUserIdDate(userId, onDate, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the time entries where userId = &#63; and onDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching time entries
	*/
	public static List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end, OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserIdDate(userId, onDate, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public static TimeEntry findByUserIdDate_First(long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence()
				   .findByUserIdDate_First(userId, onDate, orderByComparator);
	}

	/**
	* Returns the first time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public static TimeEntry fetchByUserIdDate_First(long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUserIdDate_First(userId, onDate, orderByComparator);
	}

	/**
	* Returns the last time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public static TimeEntry findByUserIdDate_Last(long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence()
				   .findByUserIdDate_Last(userId, onDate, orderByComparator);
	}

	/**
	* Returns the last time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public static TimeEntry fetchByUserIdDate_Last(long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence()
				   .fetchByUserIdDate_Last(userId, onDate, orderByComparator);
	}

	/**
	* Returns the time entries before and after the current time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param timeEntryId the primary key of the current time entry
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time entry
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public static TimeEntry[] findByUserIdDate_PrevAndNext(long timeEntryId,
		long userId, Date onDate, OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence()
				   .findByUserIdDate_PrevAndNext(timeEntryId, userId, onDate,
			orderByComparator);
	}

	/**
	* Removes all the time entries where userId = &#63; and onDate = &#63; from the database.
	*
	* @param userId the user ID
	* @param onDate the on date
	*/
	public static void removeByUserIdDate(long userId, Date onDate) {
		getPersistence().removeByUserIdDate(userId, onDate);
	}

	/**
	* Returns the number of time entries where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @return the number of matching time entries
	*/
	public static int countByUserIdDate(long userId, Date onDate) {
		return getPersistence().countByUserIdDate(userId, onDate);
	}

	/**
	* Returns all the time entries where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the matching time entries
	*/
	public static List<TimeEntry> findByTimesheet(long timesheetId) {
		return getPersistence().findByTimesheet(timesheetId);
	}

	/**
	* Returns a range of all the time entries where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @return the range of matching time entries
	*/
	public static List<TimeEntry> findByTimesheet(long timesheetId, int start,
		int end) {
		return getPersistence().findByTimesheet(timesheetId, start, end);
	}

	/**
	* Returns an ordered range of all the time entries where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching time entries
	*/
	public static List<TimeEntry> findByTimesheet(long timesheetId, int start,
		int end, OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence()
				   .findByTimesheet(timesheetId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the time entries where timesheetId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param timesheetId the timesheet ID
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching time entries
	*/
	public static List<TimeEntry> findByTimesheet(long timesheetId, int start,
		int end, OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTimesheet(timesheetId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public static TimeEntry findByTimesheet_First(long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence()
				   .findByTimesheet_First(timesheetId, orderByComparator);
	}

	/**
	* Returns the first time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public static TimeEntry fetchByTimesheet_First(long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence()
				   .fetchByTimesheet_First(timesheetId, orderByComparator);
	}

	/**
	* Returns the last time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public static TimeEntry findByTimesheet_Last(long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence()
				   .findByTimesheet_Last(timesheetId, orderByComparator);
	}

	/**
	* Returns the last time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public static TimeEntry fetchByTimesheet_Last(long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence()
				   .fetchByTimesheet_Last(timesheetId, orderByComparator);
	}

	/**
	* Returns the time entries before and after the current time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timeEntryId the primary key of the current time entry
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time entry
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public static TimeEntry[] findByTimesheet_PrevAndNext(long timeEntryId,
		long timesheetId, OrderByComparator<TimeEntry> orderByComparator)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence()
				   .findByTimesheet_PrevAndNext(timeEntryId, timesheetId,
			orderByComparator);
	}

	/**
	* Removes all the time entries where timesheetId = &#63; from the database.
	*
	* @param timesheetId the timesheet ID
	*/
	public static void removeByTimesheet(long timesheetId) {
		getPersistence().removeByTimesheet(timesheetId);
	}

	/**
	* Returns the number of time entries where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the number of matching time entries
	*/
	public static int countByTimesheet(long timesheetId) {
		return getPersistence().countByTimesheet(timesheetId);
	}

	/**
	* Caches the time entry in the entity cache if it is enabled.
	*
	* @param timeEntry the time entry
	*/
	public static void cacheResult(TimeEntry timeEntry) {
		getPersistence().cacheResult(timeEntry);
	}

	/**
	* Caches the time entries in the entity cache if it is enabled.
	*
	* @param timeEntries the time entries
	*/
	public static void cacheResult(List<TimeEntry> timeEntries) {
		getPersistence().cacheResult(timeEntries);
	}

	/**
	* Creates a new time entry with the primary key. Does not add the time entry to the database.
	*
	* @param timeEntryId the primary key for the new time entry
	* @return the new time entry
	*/
	public static TimeEntry create(long timeEntryId) {
		return getPersistence().create(timeEntryId);
	}

	/**
	* Removes the time entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timeEntryId the primary key of the time entry
	* @return the time entry that was removed
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public static TimeEntry remove(long timeEntryId)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence().remove(timeEntryId);
	}

	public static TimeEntry updateImpl(TimeEntry timeEntry) {
		return getPersistence().updateImpl(timeEntry);
	}

	/**
	* Returns the time entry with the primary key or throws a {@link NoSuchTimeEntryException} if it could not be found.
	*
	* @param timeEntryId the primary key of the time entry
	* @return the time entry
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public static TimeEntry findByPrimaryKey(long timeEntryId)
		throws com.liferay.timesheet.exception.NoSuchTimeEntryException {
		return getPersistence().findByPrimaryKey(timeEntryId);
	}

	/**
	* Returns the time entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timeEntryId the primary key of the time entry
	* @return the time entry, or <code>null</code> if a time entry with the primary key could not be found
	*/
	public static TimeEntry fetchByPrimaryKey(long timeEntryId) {
		return getPersistence().fetchByPrimaryKey(timeEntryId);
	}

	public static java.util.Map<java.io.Serializable, TimeEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the time entries.
	*
	* @return the time entries
	*/
	public static List<TimeEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the time entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @return the range of time entries
	*/
	public static List<TimeEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the time entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of time entries
	*/
	public static List<TimeEntry> findAll(int start, int end,
		OrderByComparator<TimeEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the time entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of time entries
	*/
	public static List<TimeEntry> findAll(int start, int end,
		OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the time entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of time entries.
	*
	* @return the number of time entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TimeEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimeEntryPersistence, TimeEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(TimeEntryPersistence.class);
}