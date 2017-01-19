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

package com.liferay.timesheet.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link TimeEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeEntry
 * @generated
 */
@ProviderType
public class TimeEntryWrapper implements TimeEntry, ModelWrapper<TimeEntry> {
	public TimeEntryWrapper(TimeEntry timeEntry) {
		_timeEntry = timeEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return TimeEntry.class;
	}

	@Override
	public String getModelClassName() {
		return TimeEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timeEntryId", getTimeEntryId());
		attributes.put("userId", getUserId());
		attributes.put("hours", getHours());
		attributes.put("projectId", getProjectId());
		attributes.put("taskId", getTaskId());
		attributes.put("billable", getBillable());
		attributes.put("timesheetId", getTimesheetId());
		attributes.put("onDate", getOnDate());
		attributes.put("message", getMessage());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long timeEntryId = (Long)attributes.get("timeEntryId");

		if (timeEntryId != null) {
			setTimeEntryId(timeEntryId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Double hours = (Double)attributes.get("hours");

		if (hours != null) {
			setHours(hours);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Boolean billable = (Boolean)attributes.get("billable");

		if (billable != null) {
			setBillable(billable);
		}

		Long timesheetId = (Long)attributes.get("timesheetId");

		if (timesheetId != null) {
			setTimesheetId(timesheetId);
		}

		Date onDate = (Date)attributes.get("onDate");

		if (onDate != null) {
			setOnDate(onDate);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}
	}

	@Override
	public TimeEntry toEscapedModel() {
		return new TimeEntryWrapper(_timeEntry.toEscapedModel());
	}

	@Override
	public TimeEntry toUnescapedModel() {
		return new TimeEntryWrapper(_timeEntry.toUnescapedModel());
	}

	/**
	* Returns the billable of this time entry.
	*
	* @return the billable of this time entry
	*/
	@Override
	public boolean getBillable() {
		return _timeEntry.getBillable();
	}

	/**
	* Returns <code>true</code> if this time entry is billable.
	*
	* @return <code>true</code> if this time entry is billable; <code>false</code> otherwise
	*/
	@Override
	public boolean isBillable() {
		return _timeEntry.isBillable();
	}

	@Override
	public boolean isCachedModel() {
		return _timeEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _timeEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _timeEntry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timeEntry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<TimeEntry> toCacheModel() {
		return _timeEntry.toCacheModel();
	}

	@Override
	public int compareTo(TimeEntry timeEntry) {
		return _timeEntry.compareTo(timeEntry);
	}

	@Override
	public int hashCode() {
		return _timeEntry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timeEntry.getPrimaryKeyObj();
	}

	/**
	* Returns the hours of this time entry.
	*
	* @return the hours of this time entry
	*/
	@Override
	public java.lang.Double getHours() {
		return _timeEntry.getHours();
	}

	@Override
	public java.lang.Object clone() {
		return new TimeEntryWrapper((TimeEntry)_timeEntry.clone());
	}

	/**
	* Returns the message of this time entry.
	*
	* @return the message of this time entry
	*/
	@Override
	public java.lang.String getMessage() {
		return _timeEntry.getMessage();
	}

	/**
	* Returns the user uuid of this time entry.
	*
	* @return the user uuid of this time entry
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _timeEntry.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _timeEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timeEntry.toXmlString();
	}

	/**
	* Returns the on date of this time entry.
	*
	* @return the on date of this time entry
	*/
	@Override
	public Date getOnDate() {
		return _timeEntry.getOnDate();
	}

	/**
	* Returns the primary key of this time entry.
	*
	* @return the primary key of this time entry
	*/
	@Override
	public long getPrimaryKey() {
		return _timeEntry.getPrimaryKey();
	}

	/**
	* Returns the project ID of this time entry.
	*
	* @return the project ID of this time entry
	*/
	@Override
	public long getProjectId() {
		return _timeEntry.getProjectId();
	}

	/**
	* Returns the task ID of this time entry.
	*
	* @return the task ID of this time entry
	*/
	@Override
	public long getTaskId() {
		return _timeEntry.getTaskId();
	}

	/**
	* Returns the time entry ID of this time entry.
	*
	* @return the time entry ID of this time entry
	*/
	@Override
	public long getTimeEntryId() {
		return _timeEntry.getTimeEntryId();
	}

	/**
	* Returns the timesheet ID of this time entry.
	*
	* @return the timesheet ID of this time entry
	*/
	@Override
	public long getTimesheetId() {
		return _timeEntry.getTimesheetId();
	}

	/**
	* Returns the user ID of this time entry.
	*
	* @return the user ID of this time entry
	*/
	@Override
	public long getUserId() {
		return _timeEntry.getUserId();
	}

	@Override
	public void persist() {
		_timeEntry.persist();
	}

	/**
	* Sets whether this time entry is billable.
	*
	* @param billable the billable of this time entry
	*/
	@Override
	public void setBillable(boolean billable) {
		_timeEntry.setBillable(billable);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timeEntry.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timeEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timeEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timeEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the hours of this time entry.
	*
	* @param hours the hours of this time entry
	*/
	@Override
	public void setHours(java.lang.Double hours) {
		_timeEntry.setHours(hours);
	}

	/**
	* Sets the message of this time entry.
	*
	* @param message the message of this time entry
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_timeEntry.setMessage(message);
	}

	@Override
	public void setNew(boolean n) {
		_timeEntry.setNew(n);
	}

	/**
	* Sets the on date of this time entry.
	*
	* @param onDate the on date of this time entry
	*/
	@Override
	public void setOnDate(Date onDate) {
		_timeEntry.setOnDate(onDate);
	}

	/**
	* Sets the primary key of this time entry.
	*
	* @param primaryKey the primary key of this time entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timeEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timeEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the project ID of this time entry.
	*
	* @param projectId the project ID of this time entry
	*/
	@Override
	public void setProjectId(long projectId) {
		_timeEntry.setProjectId(projectId);
	}

	/**
	* Sets the task ID of this time entry.
	*
	* @param taskId the task ID of this time entry
	*/
	@Override
	public void setTaskId(long taskId) {
		_timeEntry.setTaskId(taskId);
	}

	/**
	* Sets the time entry ID of this time entry.
	*
	* @param timeEntryId the time entry ID of this time entry
	*/
	@Override
	public void setTimeEntryId(long timeEntryId) {
		_timeEntry.setTimeEntryId(timeEntryId);
	}

	/**
	* Sets the timesheet ID of this time entry.
	*
	* @param timesheetId the timesheet ID of this time entry
	*/
	@Override
	public void setTimesheetId(long timesheetId) {
		_timeEntry.setTimesheetId(timesheetId);
	}

	/**
	* Sets the user ID of this time entry.
	*
	* @param userId the user ID of this time entry
	*/
	@Override
	public void setUserId(long userId) {
		_timeEntry.setUserId(userId);
	}

	/**
	* Sets the user uuid of this time entry.
	*
	* @param userUuid the user uuid of this time entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_timeEntry.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimeEntryWrapper)) {
			return false;
		}

		TimeEntryWrapper timeEntryWrapper = (TimeEntryWrapper)obj;

		if (Objects.equals(_timeEntry, timeEntryWrapper._timeEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public TimeEntry getWrappedModel() {
		return _timeEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timeEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timeEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timeEntry.resetOriginalValues();
	}

	private final TimeEntry _timeEntry;
}