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
 * Provides a wrapper for {@link TimesheetLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimesheetLocalService
 * @generated
 */
@ProviderType
public class TimesheetLocalServiceWrapper implements TimesheetLocalService,
	ServiceWrapper<TimesheetLocalService> {
	public TimesheetLocalServiceWrapper(
		TimesheetLocalService timesheetLocalService) {
		_timesheetLocalService = timesheetLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _timesheetLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timesheetLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _timesheetLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the timesheet to the database. Also notifies the appropriate model listeners.
	*
	* @param timesheet the timesheet
	* @return the timesheet that was added
	*/
	@Override
	public com.liferay.timesheet.model.Timesheet addTimesheet(
		com.liferay.timesheet.model.Timesheet timesheet) {
		return _timesheetLocalService.addTimesheet(timesheet);
	}

	@Override
	public com.liferay.timesheet.model.Timesheet addTimesheet(long userId,
		java.util.Date dateFrom, java.util.Date dateTo) {
		return _timesheetLocalService.addTimesheet(userId, dateFrom, dateTo);
	}

	/**
	* Creates a new timesheet with the primary key. Does not add the timesheet to the database.
	*
	* @param timesheetId the primary key for the new timesheet
	* @return the new timesheet
	*/
	@Override
	public com.liferay.timesheet.model.Timesheet createTimesheet(
		long timesheetId) {
		return _timesheetLocalService.createTimesheet(timesheetId);
	}

	/**
	* Deletes the timesheet from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheet the timesheet
	* @return the timesheet that was removed
	*/
	@Override
	public com.liferay.timesheet.model.Timesheet deleteTimesheet(
		com.liferay.timesheet.model.Timesheet timesheet) {
		return _timesheetLocalService.deleteTimesheet(timesheet);
	}

	/**
	* Deletes the timesheet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet that was removed
	* @throws PortalException if a timesheet with the primary key could not be found
	*/
	@Override
	public com.liferay.timesheet.model.Timesheet deleteTimesheet(
		long timesheetId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetLocalService.deleteTimesheet(timesheetId);
	}

	@Override
	public com.liferay.timesheet.model.Timesheet fetchTimesheet(
		long timesheetId) {
		return _timesheetLocalService.fetchTimesheet(timesheetId);
	}

	/**
	* Returns the timesheet with the primary key.
	*
	* @param timesheetId the primary key of the timesheet
	* @return the timesheet
	* @throws PortalException if a timesheet with the primary key could not be found
	*/
	@Override
	public com.liferay.timesheet.model.Timesheet getTimesheet(long timesheetId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _timesheetLocalService.getTimesheet(timesheetId);
	}

	/**
	* Updates the timesheet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timesheet the timesheet
	* @return the timesheet that was updated
	*/
	@Override
	public com.liferay.timesheet.model.Timesheet updateTimesheet(
		com.liferay.timesheet.model.Timesheet timesheet) {
		return _timesheetLocalService.updateTimesheet(timesheet);
	}

	/**
	* Returns the number of timesheets.
	*
	* @return the number of timesheets
	*/
	@Override
	public int getTimesheetsCount() {
		return _timesheetLocalService.getTimesheetsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _timesheetLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _timesheetLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timesheet.model.impl.TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _timesheetLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timesheet.model.impl.TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _timesheetLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.timesheet.model.Timesheet> findByUser(
		long userId) {
		return _timesheetLocalService.findByUser(userId);
	}

	@Override
	public java.util.List<com.liferay.timesheet.model.Timesheet> findByUserOpen(
		long userId, boolean open) {
		return _timesheetLocalService.findByUserOpen(userId, open);
	}

	/**
	* Returns a range of all the timesheets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timesheet.model.impl.TimesheetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of timesheets
	* @param end the upper bound of the range of timesheets (not inclusive)
	* @return the range of timesheets
	*/
	@Override
	public java.util.List<com.liferay.timesheet.model.Timesheet> getTimesheets(
		int start, int end) {
		return _timesheetLocalService.getTimesheets(start, end);
	}

	@Override
	public long countByUser(long userId) {
		return _timesheetLocalService.countByUser(userId);
	}

	@Override
	public long countByUserOpen(long userId, boolean open) {
		return _timesheetLocalService.countByUserOpen(userId, open);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _timesheetLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _timesheetLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void approveTimesheet(long timesheetId) {
		_timesheetLocalService.approveTimesheet(timesheetId);
	}

	@Override
	public void submitTimesheet(long timesheetId) {
		_timesheetLocalService.submitTimesheet(timesheetId);
	}

	@Override
	public TimesheetLocalService getWrappedService() {
		return _timesheetLocalService;
	}

	@Override
	public void setWrappedService(TimesheetLocalService timesheetLocalService) {
		_timesheetLocalService = timesheetLocalService;
	}

	private TimesheetLocalService _timesheetLocalService;
}