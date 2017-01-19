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
 * This class is used by SOAP remote services, specifically {@link com.liferay.timesheet.service.http.TimesheetServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.timesheet.service.http.TimesheetServiceSoap
 * @generated
 */
@ProviderType
public class TimesheetSoap implements Serializable {
	public static TimesheetSoap toSoapModel(Timesheet model) {
		TimesheetSoap soapModel = new TimesheetSoap();

		soapModel.setTimesheetId(model.getTimesheetId());
		soapModel.setDateFrom(model.getDateFrom());
		soapModel.setUserId(model.getUserId());
		soapModel.setDateTo(model.getDateTo());
		soapModel.setApproved(model.getApproved());
		soapModel.setOpen(model.getOpen());
		soapModel.setSubmittedOn(model.getSubmittedOn());
		soapModel.setApprovedOn(model.getApprovedOn());

		return soapModel;
	}

	public static TimesheetSoap[] toSoapModels(Timesheet[] models) {
		TimesheetSoap[] soapModels = new TimesheetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimesheetSoap[][] toSoapModels(Timesheet[][] models) {
		TimesheetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimesheetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimesheetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimesheetSoap[] toSoapModels(List<Timesheet> models) {
		List<TimesheetSoap> soapModels = new ArrayList<TimesheetSoap>(models.size());

		for (Timesheet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimesheetSoap[soapModels.size()]);
	}

	public TimesheetSoap() {
	}

	public long getPrimaryKey() {
		return _timesheetId;
	}

	public void setPrimaryKey(long pk) {
		setTimesheetId(pk);
	}

	public long getTimesheetId() {
		return _timesheetId;
	}

	public void setTimesheetId(long timesheetId) {
		_timesheetId = timesheetId;
	}

	public Date getDateFrom() {
		return _dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		_dateFrom = dateFrom;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getDateTo() {
		return _dateTo;
	}

	public void setDateTo(Date dateTo) {
		_dateTo = dateTo;
	}

	public boolean getApproved() {
		return _approved;
	}

	public boolean isApproved() {
		return _approved;
	}

	public void setApproved(boolean approved) {
		_approved = approved;
	}

	public boolean getOpen() {
		return _open;
	}

	public boolean isOpen() {
		return _open;
	}

	public void setOpen(boolean open) {
		_open = open;
	}

	public Date getSubmittedOn() {
		return _submittedOn;
	}

	public void setSubmittedOn(Date submittedOn) {
		_submittedOn = submittedOn;
	}

	public Date getApprovedOn() {
		return _approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		_approvedOn = approvedOn;
	}

	private long _timesheetId;
	private Date _dateFrom;
	private long _userId;
	private Date _dateTo;
	private boolean _approved;
	private boolean _open;
	private Date _submittedOn;
	private Date _approvedOn;
}