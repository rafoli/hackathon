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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.timesheet.service.http.TimeEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.timesheet.service.http.TimeEntryServiceSoap
 * @generated
 */
@ProviderType
public class TimeEntrySoap implements Serializable {
	public static TimeEntrySoap toSoapModel(TimeEntry model) {
		TimeEntrySoap soapModel = new TimeEntrySoap();

		soapModel.setTimeEntryId(model.getTimeEntryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setHours(model.getHours());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setTaskId(model.getTaskId());
		soapModel.setBillable(model.getBillable());
		soapModel.setTimesheetId(model.getTimesheetId());
		soapModel.setOnDate(model.getOnDate());
		soapModel.setMessage(model.getMessage());

		return soapModel;
	}

	public static TimeEntrySoap[] toSoapModels(TimeEntry[] models) {
		TimeEntrySoap[] soapModels = new TimeEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimeEntrySoap[][] toSoapModels(TimeEntry[][] models) {
		TimeEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimeEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimeEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimeEntrySoap[] toSoapModels(List<TimeEntry> models) {
		List<TimeEntrySoap> soapModels = new ArrayList<TimeEntrySoap>(models.size());

		for (TimeEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimeEntrySoap[soapModels.size()]);
	}

	public TimeEntrySoap() {
	}

	public long getPrimaryKey() {
		return _timeEntryId;
	}

	public void setPrimaryKey(long pk) {
		setTimeEntryId(pk);
	}

	public long getTimeEntryId() {
		return _timeEntryId;
	}

	public void setTimeEntryId(long timeEntryId) {
		_timeEntryId = timeEntryId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Double getHours() {
		return _hours;
	}

	public void setHours(Double hours) {
		_hours = hours;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getTaskId() {
		return _taskId;
	}

	public void setTaskId(long taskId) {
		_taskId = taskId;
	}

	public boolean getBillable() {
		return _billable;
	}

	public boolean isBillable() {
		return _billable;
	}

	public void setBillable(boolean billable) {
		_billable = billable;
	}

	public long getTimesheetId() {
		return _timesheetId;
	}

	public void setTimesheetId(long timesheetId) {
		_timesheetId = timesheetId;
	}

	public Date getOnDate() {
		return _onDate;
	}

	public void setOnDate(Date onDate) {
		_onDate = onDate;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	private long _timeEntryId;
	private long _userId;
	private Double _hours;
	private long _projectId;
	private long _taskId;
	private boolean _billable;
	private long _timesheetId;
	private Date _onDate;
	private String _message;
}