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

package com.liferay.timesheet.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.timesheet.model.Timesheet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Timesheet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Timesheet
 * @generated
 */
@ProviderType
public class TimesheetCacheModel implements CacheModel<Timesheet>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetCacheModel)) {
			return false;
		}

		TimesheetCacheModel timesheetCacheModel = (TimesheetCacheModel)obj;

		if (timesheetId == timesheetCacheModel.timesheetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timesheetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{timesheetId=");
		sb.append(timesheetId);
		sb.append(", dateFrom=");
		sb.append(dateFrom);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", dateTo=");
		sb.append(dateTo);
		sb.append(", approved=");
		sb.append(approved);
		sb.append(", open=");
		sb.append(open);
		sb.append(", submittedOn=");
		sb.append(submittedOn);
		sb.append(", approvedOn=");
		sb.append(approvedOn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Timesheet toEntityModel() {
		TimesheetImpl timesheetImpl = new TimesheetImpl();

		timesheetImpl.setTimesheetId(timesheetId);

		if (dateFrom == Long.MIN_VALUE) {
			timesheetImpl.setDateFrom(null);
		}
		else {
			timesheetImpl.setDateFrom(new Date(dateFrom));
		}

		timesheetImpl.setUserId(userId);

		if (dateTo == Long.MIN_VALUE) {
			timesheetImpl.setDateTo(null);
		}
		else {
			timesheetImpl.setDateTo(new Date(dateTo));
		}

		timesheetImpl.setApproved(approved);
		timesheetImpl.setOpen(open);

		if (submittedOn == Long.MIN_VALUE) {
			timesheetImpl.setSubmittedOn(null);
		}
		else {
			timesheetImpl.setSubmittedOn(new Date(submittedOn));
		}

		if (approvedOn == Long.MIN_VALUE) {
			timesheetImpl.setApprovedOn(null);
		}
		else {
			timesheetImpl.setApprovedOn(new Date(approvedOn));
		}

		timesheetImpl.resetOriginalValues();

		return timesheetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		timesheetId = objectInput.readLong();
		dateFrom = objectInput.readLong();

		userId = objectInput.readLong();
		dateTo = objectInput.readLong();

		approved = objectInput.readBoolean();

		open = objectInput.readBoolean();
		submittedOn = objectInput.readLong();
		approvedOn = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(timesheetId);
		objectOutput.writeLong(dateFrom);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(dateTo);

		objectOutput.writeBoolean(approved);

		objectOutput.writeBoolean(open);
		objectOutput.writeLong(submittedOn);
		objectOutput.writeLong(approvedOn);
	}

	public long timesheetId;
	public long dateFrom;
	public long userId;
	public long dateTo;
	public boolean approved;
	public boolean open;
	public long submittedOn;
	public long approvedOn;
}