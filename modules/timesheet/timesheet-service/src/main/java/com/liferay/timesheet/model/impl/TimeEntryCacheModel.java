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
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.timesheet.model.TimeEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TimeEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TimeEntry
 * @generated
 */
@ProviderType
public class TimeEntryCacheModel implements CacheModel<TimeEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimeEntryCacheModel)) {
			return false;
		}

		TimeEntryCacheModel timeEntryCacheModel = (TimeEntryCacheModel)obj;

		if (timeEntryId == timeEntryCacheModel.timeEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, timeEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{timeEntryId=");
		sb.append(timeEntryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", hours=");
		sb.append(hours);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", billable=");
		sb.append(billable);
		sb.append(", timesheetId=");
		sb.append(timesheetId);
		sb.append(", onDate=");
		sb.append(onDate);
		sb.append(", message=");
		sb.append(message);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TimeEntry toEntityModel() {
		TimeEntryImpl timeEntryImpl = new TimeEntryImpl();

		timeEntryImpl.setTimeEntryId(timeEntryId);
		timeEntryImpl.setUserId(userId);
		timeEntryImpl.setHours(hours);
		timeEntryImpl.setProjectId(projectId);
		timeEntryImpl.setTaskId(taskId);
		timeEntryImpl.setBillable(billable);
		timeEntryImpl.setTimesheetId(timesheetId);

		if (onDate == Long.MIN_VALUE) {
			timeEntryImpl.setOnDate(null);
		}
		else {
			timeEntryImpl.setOnDate(new Date(onDate));
		}

		if (message == null) {
			timeEntryImpl.setMessage(StringPool.BLANK);
		}
		else {
			timeEntryImpl.setMessage(message);
		}

		timeEntryImpl.resetOriginalValues();

		return timeEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		timeEntryId = objectInput.readLong();

		userId = objectInput.readLong();

		hours = objectInput.readDouble();

		projectId = objectInput.readLong();

		taskId = objectInput.readLong();

		billable = objectInput.readBoolean();

		timesheetId = objectInput.readLong();
		onDate = objectInput.readLong();
		message = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(timeEntryId);

		objectOutput.writeLong(userId);

		objectOutput.writeDouble(hours);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(taskId);

		objectOutput.writeBoolean(billable);

		objectOutput.writeLong(timesheetId);
		objectOutput.writeLong(onDate);

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}
	}

	public long timeEntryId;
	public long userId;
	public double hours;
	public long projectId;
	public long taskId;
	public boolean billable;
	public long timesheetId;
	public long onDate;
	public String message;
}