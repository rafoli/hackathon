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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.timesheet.exception.NoSuchTimeEntryException;
import com.liferay.timesheet.model.TimeEntry;

import java.util.Date;

/**
 * The persistence interface for the time entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.timesheet.service.persistence.impl.TimeEntryPersistenceImpl
 * @see TimeEntryUtil
 * @generated
 */
@ProviderType
public interface TimeEntryPersistence extends BasePersistence<TimeEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimeEntryUtil} to access the time entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the time entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching time entries
	*/
	public java.util.List<TimeEntry> findByUserId(long userId);

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
	public java.util.List<TimeEntry> findByUserId(long userId, int start,
		int end);

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
	public java.util.List<TimeEntry> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

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
	public java.util.List<TimeEntry> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first time entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public TimeEntry findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Returns the first time entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public TimeEntry fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

	/**
	* Returns the last time entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public TimeEntry findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Returns the last time entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public TimeEntry fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

	/**
	* Returns the time entries before and after the current time entry in the ordered set where userId = &#63;.
	*
	* @param timeEntryId the primary key of the current time entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time entry
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public TimeEntry[] findByUserId_PrevAndNext(long timeEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Removes all the time entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of time entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching time entries
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the time entries where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @return the matching time entries
	*/
	public java.util.List<TimeEntry> findByUserIdDate(long userId, Date onDate);

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
	public java.util.List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end);

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
	public java.util.List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

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
	public java.util.List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public TimeEntry findByUserIdDate_First(long userId, Date onDate,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Returns the first time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public TimeEntry fetchByUserIdDate_First(long userId, Date onDate,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

	/**
	* Returns the last time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public TimeEntry findByUserIdDate_Last(long userId, Date onDate,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Returns the last time entry in the ordered set where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public TimeEntry fetchByUserIdDate_Last(long userId, Date onDate,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

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
	public TimeEntry[] findByUserIdDate_PrevAndNext(long timeEntryId,
		long userId, Date onDate,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Removes all the time entries where userId = &#63; and onDate = &#63; from the database.
	*
	* @param userId the user ID
	* @param onDate the on date
	*/
	public void removeByUserIdDate(long userId, Date onDate);

	/**
	* Returns the number of time entries where userId = &#63; and onDate = &#63;.
	*
	* @param userId the user ID
	* @param onDate the on date
	* @return the number of matching time entries
	*/
	public int countByUserIdDate(long userId, Date onDate);

	/**
	* Returns all the time entries where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the matching time entries
	*/
	public java.util.List<TimeEntry> findByTimesheet(long timesheetId);

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
	public java.util.List<TimeEntry> findByTimesheet(long timesheetId,
		int start, int end);

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
	public java.util.List<TimeEntry> findByTimesheet(long timesheetId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

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
	public java.util.List<TimeEntry> findByTimesheet(long timesheetId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public TimeEntry findByTimesheet_First(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Returns the first time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public TimeEntry fetchByTimesheet_First(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

	/**
	* Returns the last time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry
	* @throws NoSuchTimeEntryException if a matching time entry could not be found
	*/
	public TimeEntry findByTimesheet_Last(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Returns the last time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	*/
	public TimeEntry fetchByTimesheet_Last(long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

	/**
	* Returns the time entries before and after the current time entry in the ordered set where timesheetId = &#63;.
	*
	* @param timeEntryId the primary key of the current time entry
	* @param timesheetId the timesheet ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time entry
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public TimeEntry[] findByTimesheet_PrevAndNext(long timeEntryId,
		long timesheetId,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException;

	/**
	* Removes all the time entries where timesheetId = &#63; from the database.
	*
	* @param timesheetId the timesheet ID
	*/
	public void removeByTimesheet(long timesheetId);

	/**
	* Returns the number of time entries where timesheetId = &#63;.
	*
	* @param timesheetId the timesheet ID
	* @return the number of matching time entries
	*/
	public int countByTimesheet(long timesheetId);

	/**
	* Caches the time entry in the entity cache if it is enabled.
	*
	* @param timeEntry the time entry
	*/
	public void cacheResult(TimeEntry timeEntry);

	/**
	* Caches the time entries in the entity cache if it is enabled.
	*
	* @param timeEntries the time entries
	*/
	public void cacheResult(java.util.List<TimeEntry> timeEntries);

	/**
	* Creates a new time entry with the primary key. Does not add the time entry to the database.
	*
	* @param timeEntryId the primary key for the new time entry
	* @return the new time entry
	*/
	public TimeEntry create(long timeEntryId);

	/**
	* Removes the time entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timeEntryId the primary key of the time entry
	* @return the time entry that was removed
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public TimeEntry remove(long timeEntryId) throws NoSuchTimeEntryException;

	public TimeEntry updateImpl(TimeEntry timeEntry);

	/**
	* Returns the time entry with the primary key or throws a {@link NoSuchTimeEntryException} if it could not be found.
	*
	* @param timeEntryId the primary key of the time entry
	* @return the time entry
	* @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	*/
	public TimeEntry findByPrimaryKey(long timeEntryId)
		throws NoSuchTimeEntryException;

	/**
	* Returns the time entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timeEntryId the primary key of the time entry
	* @return the time entry, or <code>null</code> if a time entry with the primary key could not be found
	*/
	public TimeEntry fetchByPrimaryKey(long timeEntryId);

	@Override
	public java.util.Map<java.io.Serializable, TimeEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the time entries.
	*
	* @return the time entries
	*/
	public java.util.List<TimeEntry> findAll();

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
	public java.util.List<TimeEntry> findAll(int start, int end);

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
	public java.util.List<TimeEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator);

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
	public java.util.List<TimeEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the time entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of time entries.
	*
	* @return the number of time entries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}