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

import com.liferay.timesheet.exception.NoSuchTimesheetException;
import com.liferay.timesheet.model.Timesheet;

/**
 * The persistence interface for the timesheet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.timesheet.service.persistence.impl.TimesheetPersistenceImpl
 * @see TimesheetUtil
 * @generated
 */
@ProviderType
public interface TimesheetPersistence extends BasePersistence<Timesheet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TimesheetUtil} to access the timesheet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the timesheets where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching timesheets
	*/
	public java.util.List<Timesheet> findByUserId(long userId);

	/**
	* Returns a range of all the timesheets where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of matching timesheets
	*/
	public java.util.List<Timesheet> findByUserId(long userId, int start,
		int end);

	/**
	* Returns an ordered range of all the timesheets where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheets
	*/
	public java.util.List<Timesheet> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator);

	/**
	* Returns an ordered range of all the timesheets where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheets
	*/
	public java.util.List<Timesheet> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public Timesheet findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException;

	/**
	* Returns the first timesheet in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public Timesheet fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator);

	/**
	* Returns the last timesheet in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public Timesheet findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException;

	/**
	* Returns the last timesheet in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public Timesheet fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator);

	/**
	* Returns the timesheets before and after the current timesheet in the ordered set where userId = &#63;.
	*
	* @param timesheetId the primary key of the current timesheet
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public Timesheet[] findByUserId_PrevAndNext(long timesheetId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException;

	/**
	* Removes all the timesheets where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of timesheets where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching timesheets
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the timesheets where userId = &#63; and open = &#63;.
	*
	* @param userId the user ID
	* @param open the open
	* @return the matching timesheets
	*/
	public java.util.List<Timesheet> findByUserIdOpen(long userId, boolean open);

	/**
	* Returns a range of all the timesheets where userId = &#63; and open = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param open the open
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of matching timesheets
	*/
	public java.util.List<Timesheet> findByUserIdOpen(long userId,
		boolean open, int start, int end);

	/**
	* Returns an ordered range of all the timesheets where userId = &#63; and open = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param open the open
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching timesheets
	*/
	public java.util.List<Timesheet> findByUserIdOpen(long userId,
		boolean open, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator);

	/**
	* Returns an ordered range of all the timesheets where userId = &#63; and open = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param open the open
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching timesheets
	*/
	public java.util.List<Timesheet> findByUserIdOpen(long userId,
		boolean open, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first timesheet in the ordered set where userId = &#63; and open = &#63;.
	*
	* @param userId the user ID
	* @param open the open
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public Timesheet findByUserIdOpen_First(long userId, boolean open,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException;

	/**
	* Returns the first timesheet in the ordered set where userId = &#63; and open = &#63;.
	*
	* @param userId the user ID
	* @param open the open
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public Timesheet fetchByUserIdOpen_First(long userId, boolean open,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator);

	/**
	* Returns the last timesheet in the ordered set where userId = &#63; and open = &#63;.
	*
	* @param userId the user ID
	* @param open the open
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet
	* @throws NoSuchTimesheetException if a matching timesheet could not be found
	*/
	public Timesheet findByUserIdOpen_Last(long userId, boolean open,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException;

	/**
	* Returns the last timesheet in the ordered set where userId = &#63; and open = &#63;.
	*
	* @param userId the user ID
	* @param open the open
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching timesheet, or <code>null</code> if a matching timesheet could not be found
	*/
	public Timesheet fetchByUserIdOpen_Last(long userId, boolean open,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator);

	/**
	* Returns the timesheets before and after the current timesheet in the ordered set where userId = &#63; and open = &#63;.
	*
	* @param timesheetId the primary key of the current timesheet
	* @param userId the user ID
	* @param open the open
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public Timesheet[] findByUserIdOpen_PrevAndNext(long timesheetId,
		long userId, boolean open,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator)
		throws NoSuchTimesheetException;

	/**
	* Removes all the timesheets where userId = &#63; and open = &#63; from the database.
	*
	* @param userId the user ID
	* @param open the open
	*/
	public void removeByUserIdOpen(long userId, boolean open);

	/**
	* Returns the number of timesheets where userId = &#63; and open = &#63;.
	*
	* @param userId the user ID
	* @param open the open
	* @return the number of matching timesheets
	*/
	public int countByUserIdOpen(long userId, boolean open);

	/**
	* Caches the timesheet in the entity cache if it is enabled.
	*
	* @param timesheet the timesheet
	*/
	public void cacheResult(Timesheet timesheet);

	/**
	* Caches the timesheets in the entity cache if it is enabled.
	*
	* @param timesheets the timesheets
	*/
	public void cacheResult(java.util.List<Timesheet> timesheets);

	/**
	* Creates a new timesheet with the primary key. Does not add the timesheet to the database.
	*
	* @param timesheetId the primary key for the new timesheet
	* @return the new timesheet
	*/
	public Timesheet create(long timesheetId);

	/**
	* Removes the timesheet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet that was removed
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public Timesheet remove(long timesheetId) throws NoSuchTimesheetException;

	public Timesheet updateImpl(Timesheet timesheet);

	/**
	* Returns the timesheet with the primary key or throws a {@link NoSuchTimesheetException} if it could not be found.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet
	* @throws NoSuchTimesheetException if a timesheet with the primary key could not be found
	*/
	public Timesheet findByPrimaryKey(long timesheetId)
		throws NoSuchTimesheetException;

	/**
	* Returns the timesheet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet, or <code>null</code> if a timesheet with the primary key could not be found
	*/
	public Timesheet fetchByPrimaryKey(long timesheetId);

	@Override
	public java.util.Map<java.io.Serializable, Timesheet> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the timesheets.
	*
	* @return the timesheets
	*/
	public java.util.List<Timesheet> findAll();

	/**
	* Returns a range of all the timesheets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of timesheets
	*/
	public java.util.List<Timesheet> findAll(int start, int end);

	/**
	* Returns an ordered range of all the timesheets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of timesheets
	*/
	public java.util.List<Timesheet> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator);

	/**
	* Returns an ordered range of all the timesheets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of timesheets
	*/
	public java.util.List<Timesheet> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Timesheet> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the timesheets from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of timesheets.
	*
	* @return the number of timesheets
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}