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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Client}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Client
 * @generated
 */
@ProviderType
public class ClientWrapper implements Client, ModelWrapper<Client> {
	public ClientWrapper(Client client) {
		_client = client;
	}

	@Override
	public Class<?> getModelClass() {
		return Client.class;
	}

	@Override
	public String getModelClassName() {
		return Client.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("clientId", getClientId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public Client toEscapedModel() {
		return new ClientWrapper(_client.toEscapedModel());
	}

	@Override
	public Client toUnescapedModel() {
		return new ClientWrapper(_client.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _client.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _client.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _client.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _client.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Client> toCacheModel() {
		return _client.toCacheModel();
	}

	@Override
	public int compareTo(Client client) {
		return _client.compareTo(client);
	}

	@Override
	public int hashCode() {
		return _client.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _client.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ClientWrapper((Client)_client.clone());
	}

	/**
	* Returns the name of this client.
	*
	* @return the name of this client
	*/
	@Override
	public java.lang.String getName() {
		return _client.getName();
	}

	@Override
	public java.lang.String toString() {
		return _client.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _client.toXmlString();
	}

	/**
	* Returns the client ID of this client.
	*
	* @return the client ID of this client
	*/
	@Override
	public long getClientId() {
		return _client.getClientId();
	}

	/**
	* Returns the primary key of this client.
	*
	* @return the primary key of this client
	*/
	@Override
	public long getPrimaryKey() {
		return _client.getPrimaryKey();
	}

	@Override
	public void persist() {
		_client.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_client.setCachedModel(cachedModel);
	}

	/**
	* Sets the client ID of this client.
	*
	* @param clientId the client ID of this client
	*/
	@Override
	public void setClientId(long clientId) {
		_client.setClientId(clientId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_client.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_client.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_client.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the name of this client.
	*
	* @param name the name of this client
	*/
	@Override
	public void setName(java.lang.String name) {
		_client.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_client.setNew(n);
	}

	/**
	* Sets the primary key of this client.
	*
	* @param primaryKey the primary key of this client
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_client.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_client.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientWrapper)) {
			return false;
		}

		ClientWrapper clientWrapper = (ClientWrapper)obj;

		if (Objects.equals(_client, clientWrapper._client)) {
			return true;
		}

		return false;
	}

	@Override
	public Client getWrappedModel() {
		return _client;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _client.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _client.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_client.resetOriginalValues();
	}

	private final Client _client;
}