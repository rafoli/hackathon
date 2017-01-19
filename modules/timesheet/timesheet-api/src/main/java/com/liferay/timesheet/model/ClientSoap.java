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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.timesheet.service.http.ClientServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.timesheet.service.http.ClientServiceSoap
 * @generated
 */
@ProviderType
public class ClientSoap implements Serializable {
	public static ClientSoap toSoapModel(Client model) {
		ClientSoap soapModel = new ClientSoap();

		soapModel.setClientId(model.getClientId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ClientSoap[] toSoapModels(Client[] models) {
		ClientSoap[] soapModels = new ClientSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClientSoap[][] toSoapModels(Client[][] models) {
		ClientSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClientSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClientSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClientSoap[] toSoapModels(List<Client> models) {
		List<ClientSoap> soapModels = new ArrayList<ClientSoap>(models.size());

		for (Client model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClientSoap[soapModels.size()]);
	}

	public ClientSoap() {
	}

	public long getPrimaryKey() {
		return _clientId;
	}

	public void setPrimaryKey(long pk) {
		setClientId(pk);
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _clientId;
	private String _name;
}