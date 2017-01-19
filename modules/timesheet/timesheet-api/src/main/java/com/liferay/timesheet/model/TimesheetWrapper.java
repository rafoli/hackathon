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
 * This class is a wrapper for {@link Timesheet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Timesheet
 * @generated
 */
@ProviderType
public class TimesheetWrapper implements Timesheet, ModelWrapper<Timesheet> {
	public TimesheetWrapper(Timesheet timesheet) {
		_timesheet = timesheet;
	}

	@Override
	public Class<?> getModelClass() {
		return Timesheet.class;
	}

	@Override
	public String getModelClassName() {
		return Timesheet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timesheetId", getTimesheetId());
		attributes.put("dateFrom", getDateFrom());
		attributes.put("userId", getUserId());
		attributes.put("dateTo", getDateTo());
		attributes.put("approved", getApproved());
		attributes.put("open", getOpen());
		attributes.put("submittedOn", getSubmittedOn());
		attributes.put("approvedOn", getApprovedOn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long timesheetId = (Long)attributes.get("timesheetId");

		if (timesheetId != null) {
			setTimesheetId(timesheetId);
		}

		Date dateFrom = (Date)attributes.get("dateFrom");

		if (dateFrom != null) {
			setDateFrom(dateFrom);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date dateTo = (Date)attributes.get("dateTo");

		if (dateTo != null) {
			setDateTo(dateTo);
		}

		Boolean approved = (Boolean)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		Boolean open = (Boolean)attributes.get("open");

		if (open != null) {
			setOpen(open);
		}

		Date submittedOn = (Date)attributes.get("submittedOn");

		if (submittedOn != null) {
			setSubmittedOn(submittedOn);
		}

		Date approvedOn = (Date)attributes.get("approvedOn");

		if (approvedOn != null) {
			setApprovedOn(approvedOn);
		}
	}

	@Override
	public Timesheet toEscapedModel() {
		return new TimesheetWrapper(_timesheet.toEscapedModel());
	}

	@Override
	public Timesheet toUnescapedModel() {
		return new TimesheetWrapper(_timesheet.toUnescapedModel());
	}

	/**
	* Returns the approved of this timesheet.
	*
	* @return the approved of this timesheet
	*/
	@Override
	public boolean getApproved() {
		return _timesheet.getApproved();
	}

	/**
	* Returns the open of this timesheet.
	*
	* @return the open of this timesheet
	*/
	@Override
	public boolean getOpen() {
		return _timesheet.getOpen();
	}

	/**
	* Returns <code>true</code> if this timesheet is approved.
	*
	* @return <code>true</code> if this timesheet is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _timesheet.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _timesheet.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _timesheet.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _timesheet.isNew();
	}

	/**
	* Returns <code>true</code> if this timesheet is open.
	*
	* @return <code>true</code> if this timesheet is open; <code>false</code> otherwise
	*/
	@Override
	public boolean isOpen() {
		return _timesheet.isOpen();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _timesheet.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Timesheet> toCacheModel() {
		return _timesheet.toCacheModel();
	}

	@Override
	public int compareTo(Timesheet timesheet) {
		return _timesheet.compareTo(timesheet);
	}

	@Override
	public int hashCode() {
		return _timesheet.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timesheet.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TimesheetWrapper((Timesheet)_timesheet.clone());
	}

	/**
	* Returns the user uuid of this timesheet.
	*
	* @return the user uuid of this timesheet
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _timesheet.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _timesheet.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timesheet.toXmlString();
	}

	/**
	* Returns the approved on of this timesheet.
	*
	* @return the approved on of this timesheet
	*/
	@Override
	public Date getApprovedOn() {
		return _timesheet.getApprovedOn();
	}

	/**
	* Returns the date from of this timesheet.
	*
	* @return the date from of this timesheet
	*/
	@Override
	public Date getDateFrom() {
		return _timesheet.getDateFrom();
	}

	/**
	* Returns the date to of this timesheet.
	*
	* @return the date to of this timesheet
	*/
	@Override
	public Date getDateTo() {
		return _timesheet.getDateTo();
	}

	/**
	* Returns the submitted on of this timesheet.
	*
	* @return the submitted on of this timesheet
	*/
	@Override
	public Date getSubmittedOn() {
		return _timesheet.getSubmittedOn();
	}

	/**
	* Returns the primary key of this timesheet.
	*
	* @return the primary key of this timesheet
	*/
	@Override
	public long getPrimaryKey() {
		return _timesheet.getPrimaryKey();
	}

	/**
	* Returns the timesheet ID of this timesheet.
	*
	* @return the timesheet ID of this timesheet
	*/
	@Override
	public long getTimesheetId() {
		return _timesheet.getTimesheetId();
	}

	/**
	* Returns the user ID of this timesheet.
	*
	* @return the user ID of this timesheet
	*/
	@Override
	public long getUserId() {
		return _timesheet.getUserId();
	}

	@Override
	public void persist() {
		_timesheet.persist();
	}

	/**
	* Sets whether this timesheet is approved.
	*
	* @param approved the approved of this timesheet
	*/
	@Override
	public void setApproved(boolean approved) {
		_timesheet.setApproved(approved);
	}

	/**
	* Sets the approved on of this timesheet.
	*
	* @param approvedOn the approved on of this timesheet
	*/
	@Override
	public void setApprovedOn(Date approvedOn) {
		_timesheet.setApprovedOn(approvedOn);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timesheet.setCachedModel(cachedModel);
	}

	/**
	* Sets the date from of this timesheet.
	*
	* @param dateFrom the date from of this timesheet
	*/
	@Override
	public void setDateFrom(Date dateFrom) {
		_timesheet.setDateFrom(dateFrom);
	}

	/**
	* Sets the date to of this timesheet.
	*
	* @param dateTo the date to of this timesheet
	*/
	@Override
	public void setDateTo(Date dateTo) {
		_timesheet.setDateTo(dateTo);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_timesheet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_timesheet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_timesheet.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_timesheet.setNew(n);
	}

	/**
	* Sets whether this timesheet is open.
	*
	* @param open the open of this timesheet
	*/
	@Override
	public void setOpen(boolean open) {
		_timesheet.setOpen(open);
	}

	/**
	* Sets the primary key of this timesheet.
	*
	* @param primaryKey the primary key of this timesheet
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timesheet.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_timesheet.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the submitted on of this timesheet.
	*
	* @param submittedOn the submitted on of this timesheet
	*/
	@Override
	public void setSubmittedOn(Date submittedOn) {
		_timesheet.setSubmittedOn(submittedOn);
	}

	/**
	* Sets the timesheet ID of this timesheet.
	*
	* @param timesheetId the timesheet ID of this timesheet
	*/
	@Override
	public void setTimesheetId(long timesheetId) {
		_timesheet.setTimesheetId(timesheetId);
	}

	/**
	* Sets the user ID of this timesheet.
	*
	* @param userId the user ID of this timesheet
	*/
	@Override
	public void setUserId(long userId) {
		_timesheet.setUserId(userId);
	}

	/**
	* Sets the user uuid of this timesheet.
	*
	* @param userUuid the user uuid of this timesheet
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_timesheet.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimesheetWrapper)) {
			return false;
		}

		TimesheetWrapper timesheetWrapper = (TimesheetWrapper)obj;

		if (Objects.equals(_timesheet, timesheetWrapper._timesheet)) {
			return true;
		}

		return false;
	}

	@Override
	public Timesheet getWrappedModel() {
		return _timesheet;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _timesheet.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _timesheet.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_timesheet.resetOriginalValues();
	}

	private final Timesheet _timesheet;
}