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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TimeEntry. This utility wraps
 * {@link com.liferay.timesheet.service.impl.TimeEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TimeEntryLocalService
 * @see com.liferay.timesheet.service.base.TimeEntryLocalServiceBaseImpl
 * @see com.liferay.timesheet.service.impl.TimeEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public class TimeEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.timesheet.service.impl.TimeEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the time entry to the database. Also notifies the appropriate model listeners.
	*
	* @param timeEntry the time entry
	* @return the time entry that was added
	*/
	public static com.liferay.timesheet.model.TimeEntry addTimeEntry(
		com.liferay.timesheet.model.TimeEntry timeEntry) {
		return getService().addTimeEntry(timeEntry);
	}

	public static com.liferay.timesheet.model.TimeEntry addTimeEntry(
		long userId, java.lang.Double hours, long projectId, long taskId,
		boolean billable, long timesheetId, java.util.Date forDate,
		java.lang.String message) {
		return getService()
				   .addTimeEntry(userId, hours, projectId, taskId, billable,
			timesheetId, forDate, message);
	}

	/**
	* Creates a new time entry with the primary key. Does not add the time entry to the database.
	*
	* @param timeEntryId the primary key for the new time entry
	* @return the new time entry
	*/
	public static com.liferay.timesheet.model.TimeEntry createTimeEntry(
		long timeEntryId) {
		return getService().createTimeEntry(timeEntryId);
	}

	/**
	* Deletes the time entry from the database. Also notifies the appropriate model listeners.
	*
	* @param timeEntry the time entry
	* @return the time entry that was removed
	*/
	public static com.liferay.timesheet.model.TimeEntry deleteTimeEntry(
		com.liferay.timesheet.model.TimeEntry timeEntry) {
		return getService().deleteTimeEntry(timeEntry);
	}

	/**
	* Deletes the time entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timeEntryId the primary key of the time entry
	* @return the time entry that was removed
	* @throws PortalException if a time entry with the primary key could not be found
	*/
	public static com.liferay.timesheet.model.TimeEntry deleteTimeEntry(
		long timeEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTimeEntry(timeEntryId);
	}

	public static com.liferay.timesheet.model.TimeEntry fetchTimeEntry(
		long timeEntryId) {
		return getService().fetchTimeEntry(timeEntryId);
	}

	/**
	* Returns the time entry with the primary key.
	*
	* @param timeEntryId the primary key of the time entry
	* @return the time entry
	* @throws PortalException if a time entry with the primary key could not be found
	*/
	public static com.liferay.timesheet.model.TimeEntry getTimeEntry(
		long timeEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTimeEntry(timeEntryId);
	}

	/**
	* Updates the time entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timeEntry the time entry
	* @return the time entry that was updated
	*/
	public static com.liferay.timesheet.model.TimeEntry updateTimeEntry(
		com.liferay.timesheet.model.TimeEntry timeEntry) {
		return getService().updateTimeEntry(timeEntry);
	}

	/**
	* Returns the number of time entries.
	*
	* @return the number of time entries
	*/
	public static int getTimeEntriesCount() {
		return getService().getTimeEntriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timesheet.model.impl.TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timesheet.model.impl.TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.timesheet.model.TimeEntry> findByTimesheet(
		long timesheetId) {
		return getService().findByTimesheet(timesheetId);
	}

	public static java.util.List<com.liferay.timesheet.model.TimeEntry> findByUser(
		long userId) {
		return getService().findByUser(userId);
	}

	public static java.util.List<com.liferay.timesheet.model.TimeEntry> findByUserDate(
		long userId, java.util.Date onDate) {
		return getService().findByUserDate(userId, onDate);
	}

	/**
	* Returns a range of all the time entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timesheet.model.impl.TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time entries
	* @param end the upper bound of the range of time entries (not inclusive)
	* @return the range of time entries
	*/
	public static java.util.List<com.liferay.timesheet.model.TimeEntry> getTimeEntries(
		int start, int end) {
		return getService().getTimeEntries(start, end);
	}

	public static long countByTimesheet(long timesheetId) {
		return getService().countByTimesheet(timesheetId);
	}

	public static long countByUser(long userId) {
		return getService().countByUser(userId);
	}

	public static long countByUserDate(long userId, java.util.Date onDate) {
		return getService().countByUserDate(userId, onDate);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static TimeEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TimeEntryLocalService, TimeEntryLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TimeEntryLocalService.class);
}