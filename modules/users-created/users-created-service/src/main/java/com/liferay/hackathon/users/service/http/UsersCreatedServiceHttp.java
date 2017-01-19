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

package com.liferay.hackathon.users.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.hackathon.users.service.UsersCreatedServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link UsersCreatedServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UsersCreatedServiceSoap
 * @see HttpPrincipal
 * @see UsersCreatedServiceUtil
 * @generated
 */
@ProviderType
public class UsersCreatedServiceHttp {
	public static java.lang.String getHealthCheck(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(UsersCreatedServiceUtil.class,
					"getHealthCheck", _getHealthCheckParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getUsersAddedInLastWeek(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(UsersCreatedServiceUtil.class,
					"getUsersAddedInLastWeek",
					_getUsersAddedInLastWeekParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getUsersAddedInLastHour(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(UsersCreatedServiceUtil.class,
					"getUsersAddedInLastHour",
					_getUsersAddedInLastHourParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getUsersAddedInLastMinute(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(UsersCreatedServiceUtil.class,
					"getUsersAddedInLastMinute",
					_getUsersAddedInLastMinuteParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getUsersCount(HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(UsersCreatedServiceUtil.class,
					"getUsersCount", _getUsersCountParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getUsersAddedInLastXMinutes(
		HttpPrincipal httpPrincipal, int minutes) {
		try {
			MethodKey methodKey = new MethodKey(UsersCreatedServiceUtil.class,
					"getUsersAddedInLastXMinutes",
					_getUsersAddedInLastXMinutesParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, minutes);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getUsersAddedSince(
		HttpPrincipal httpPrincipal, java.lang.String since) {
		try {
			MethodKey methodKey = new MethodKey(UsersCreatedServiceUtil.class,
					"getUsersAddedSince", _getUsersAddedSinceParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, since);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.String getUsersAddedSince(
		HttpPrincipal httpPrincipal, java.util.Date since) {
		try {
			MethodKey methodKey = new MethodKey(UsersCreatedServiceUtil.class,
					"getUsersAddedSince", _getUsersAddedSinceParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, since);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UsersCreatedServiceHttp.class);
	private static final Class<?>[] _getHealthCheckParameterTypes0 = new Class[] {
			
		};
	private static final Class<?>[] _getUsersAddedInLastWeekParameterTypes1 = new Class[] {
			
		};
	private static final Class<?>[] _getUsersAddedInLastHourParameterTypes2 = new Class[] {
			
		};
	private static final Class<?>[] _getUsersAddedInLastMinuteParameterTypes3 = new Class[] {
			
		};
	private static final Class<?>[] _getUsersCountParameterTypes4 = new Class[] {  };
	private static final Class<?>[] _getUsersAddedInLastXMinutesParameterTypes5 = new Class[] {
			int.class
		};
	private static final Class<?>[] _getUsersAddedSinceParameterTypes6 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getUsersAddedSinceParameterTypes7 = new Class[] {
			java.util.Date.class
		};
}