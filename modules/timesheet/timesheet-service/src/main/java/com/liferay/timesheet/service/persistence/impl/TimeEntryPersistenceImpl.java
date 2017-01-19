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

package com.liferay.timesheet.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.timesheet.exception.NoSuchTimeEntryException;
import com.liferay.timesheet.model.TimeEntry;
import com.liferay.timesheet.model.impl.TimeEntryImpl;
import com.liferay.timesheet.model.impl.TimeEntryModelImpl;
import com.liferay.timesheet.service.persistence.TimeEntryPersistence;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the time entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TimeEntryPersistence
 * @see com.liferay.timesheet.service.persistence.TimeEntryUtil
 * @generated
 */
@ProviderType
public class TimeEntryPersistenceImpl extends BasePersistenceImpl<TimeEntry>
	implements TimeEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TimeEntryUtil} to access the time entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TimeEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, TimeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, TimeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, TimeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, TimeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			TimeEntryModelImpl.USERID_COLUMN_BITMASK |
			TimeEntryModelImpl.ONDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the time entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching time entries
	 */
	@Override
	public List<TimeEntry> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @return the range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByUserId(long userId, int start, int end,
		OrderByComparator<TimeEntry> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByUserId(long userId, int start, int end,
		OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<TimeEntry> list = null;

		if (retrieveFromCache) {
			list = (List<TimeEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeEntry timeEntry : list) {
					if ((userId != timeEntry.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TIMEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimeEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TimeEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimeEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first time entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time entry
	 * @throws NoSuchTimeEntryException if a matching time entry could not be found
	 */
	@Override
	public TimeEntry findByUserId_First(long userId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = fetchByUserId_First(userId, orderByComparator);

		if (timeEntry != null) {
			return timeEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimeEntryException(msg.toString());
	}

	/**
	 * Returns the first time entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	 */
	@Override
	public TimeEntry fetchByUserId_First(long userId,
		OrderByComparator<TimeEntry> orderByComparator) {
		List<TimeEntry> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time entry
	 * @throws NoSuchTimeEntryException if a matching time entry could not be found
	 */
	@Override
	public TimeEntry findByUserId_Last(long userId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = fetchByUserId_Last(userId, orderByComparator);

		if (timeEntry != null) {
			return timeEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimeEntryException(msg.toString());
	}

	/**
	 * Returns the last time entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	 */
	@Override
	public TimeEntry fetchByUserId_Last(long userId,
		OrderByComparator<TimeEntry> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<TimeEntry> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time entries before and after the current time entry in the ordered set where userId = &#63;.
	 *
	 * @param timeEntryId the primary key of the current time entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time entry
	 * @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry[] findByUserId_PrevAndNext(long timeEntryId, long userId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = findByPrimaryKey(timeEntryId);

		Session session = null;

		try {
			session = openSession();

			TimeEntry[] array = new TimeEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session, timeEntry, userId,
					orderByComparator, true);

			array[1] = timeEntry;

			array[2] = getByUserId_PrevAndNext(session, timeEntry, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TimeEntry getByUserId_PrevAndNext(Session session,
		TimeEntry timeEntry, long userId,
		OrderByComparator<TimeEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMEENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TimeEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timeEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimeEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (TimeEntry timeEntry : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(timeEntry);
		}
	}

	/**
	 * Returns the number of time entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching time entries
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "timeEntry.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDDATE =
		new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, TimeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdDate",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDATE =
		new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, TimeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdDate",
			new String[] { Long.class.getName(), Date.class.getName() },
			TimeEntryModelImpl.USERID_COLUMN_BITMASK |
			TimeEntryModelImpl.ONDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDDATE = new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdDate",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns all the time entries where userId = &#63; and onDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @return the matching time entries
	 */
	@Override
	public List<TimeEntry> findByUserIdDate(long userId, Date onDate) {
		return findByUserIdDate(userId, onDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time entries where userId = &#63; and onDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @return the range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end) {
		return findByUserIdDate(userId, onDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time entries where userId = &#63; and onDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end, OrderByComparator<TimeEntry> orderByComparator) {
		return findByUserIdDate(userId, onDate, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the time entries where userId = &#63; and onDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByUserIdDate(long userId, Date onDate,
		int start, int end, OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDATE;
			finderArgs = new Object[] { userId, onDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDDATE;
			finderArgs = new Object[] {
					userId, onDate,
					
					start, end, orderByComparator
				};
		}

		List<TimeEntry> list = null;

		if (retrieveFromCache) {
			list = (List<TimeEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeEntry timeEntry : list) {
					if ((userId != timeEntry.getUserId()) ||
							!Objects.equals(onDate, timeEntry.getOnDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_TIMEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERIDDATE_USERID_2);

			boolean bindOnDate = false;

			if (onDate == null) {
				query.append(_FINDER_COLUMN_USERIDDATE_ONDATE_1);
			}
			else {
				bindOnDate = true;

				query.append(_FINDER_COLUMN_USERIDDATE_ONDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimeEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindOnDate) {
					qPos.add(new Timestamp(onDate.getTime()));
				}

				if (!pagination) {
					list = (List<TimeEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimeEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first time entry in the ordered set where userId = &#63; and onDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time entry
	 * @throws NoSuchTimeEntryException if a matching time entry could not be found
	 */
	@Override
	public TimeEntry findByUserIdDate_First(long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = fetchByUserIdDate_First(userId, onDate,
				orderByComparator);

		if (timeEntry != null) {
			return timeEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", onDate=");
		msg.append(onDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimeEntryException(msg.toString());
	}

	/**
	 * Returns the first time entry in the ordered set where userId = &#63; and onDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	 */
	@Override
	public TimeEntry fetchByUserIdDate_First(long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator) {
		List<TimeEntry> list = findByUserIdDate(userId, onDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time entry in the ordered set where userId = &#63; and onDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time entry
	 * @throws NoSuchTimeEntryException if a matching time entry could not be found
	 */
	@Override
	public TimeEntry findByUserIdDate_Last(long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = fetchByUserIdDate_Last(userId, onDate,
				orderByComparator);

		if (timeEntry != null) {
			return timeEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", onDate=");
		msg.append(onDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimeEntryException(msg.toString());
	}

	/**
	 * Returns the last time entry in the ordered set where userId = &#63; and onDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	 */
	@Override
	public TimeEntry fetchByUserIdDate_Last(long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator) {
		int count = countByUserIdDate(userId, onDate);

		if (count == 0) {
			return null;
		}

		List<TimeEntry> list = findByUserIdDate(userId, onDate, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time entries before and after the current time entry in the ordered set where userId = &#63; and onDate = &#63;.
	 *
	 * @param timeEntryId the primary key of the current time entry
	 * @param userId the user ID
	 * @param onDate the on date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time entry
	 * @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry[] findByUserIdDate_PrevAndNext(long timeEntryId,
		long userId, Date onDate, OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = findByPrimaryKey(timeEntryId);

		Session session = null;

		try {
			session = openSession();

			TimeEntry[] array = new TimeEntryImpl[3];

			array[0] = getByUserIdDate_PrevAndNext(session, timeEntry, userId,
					onDate, orderByComparator, true);

			array[1] = timeEntry;

			array[2] = getByUserIdDate_PrevAndNext(session, timeEntry, userId,
					onDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TimeEntry getByUserIdDate_PrevAndNext(Session session,
		TimeEntry timeEntry, long userId, Date onDate,
		OrderByComparator<TimeEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TIMEENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERIDDATE_USERID_2);

		boolean bindOnDate = false;

		if (onDate == null) {
			query.append(_FINDER_COLUMN_USERIDDATE_ONDATE_1);
		}
		else {
			bindOnDate = true;

			query.append(_FINDER_COLUMN_USERIDDATE_ONDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TimeEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindOnDate) {
			qPos.add(new Timestamp(onDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timeEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimeEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time entries where userId = &#63; and onDate = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 */
	@Override
	public void removeByUserIdDate(long userId, Date onDate) {
		for (TimeEntry timeEntry : findByUserIdDate(userId, onDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timeEntry);
		}
	}

	/**
	 * Returns the number of time entries where userId = &#63; and onDate = &#63;.
	 *
	 * @param userId the user ID
	 * @param onDate the on date
	 * @return the number of matching time entries
	 */
	@Override
	public int countByUserIdDate(long userId, Date onDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDDATE;

		Object[] finderArgs = new Object[] { userId, onDate };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TIMEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERIDDATE_USERID_2);

			boolean bindOnDate = false;

			if (onDate == null) {
				query.append(_FINDER_COLUMN_USERIDDATE_ONDATE_1);
			}
			else {
				bindOnDate = true;

				query.append(_FINDER_COLUMN_USERIDDATE_ONDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindOnDate) {
					qPos.add(new Timestamp(onDate.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDDATE_USERID_2 = "timeEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDDATE_ONDATE_1 = "timeEntry.onDate IS NULL";
	private static final String _FINDER_COLUMN_USERIDDATE_ONDATE_2 = "timeEntry.onDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMESHEET =
		new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, TimeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTimesheet",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESHEET =
		new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, TimeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTimesheet",
			new String[] { Long.class.getName() },
			TimeEntryModelImpl.TIMESHEETID_COLUMN_BITMASK |
			TimeEntryModelImpl.USERID_COLUMN_BITMASK |
			TimeEntryModelImpl.ONDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TIMESHEET = new FinderPath(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTimesheet",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the time entries where timesheetId = &#63;.
	 *
	 * @param timesheetId the timesheet ID
	 * @return the matching time entries
	 */
	@Override
	public List<TimeEntry> findByTimesheet(long timesheetId) {
		return findByTimesheet(timesheetId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time entries where timesheetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timesheetId the timesheet ID
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @return the range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByTimesheet(long timesheetId, int start, int end) {
		return findByTimesheet(timesheetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time entries where timesheetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timesheetId the timesheet ID
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByTimesheet(long timesheetId, int start,
		int end, OrderByComparator<TimeEntry> orderByComparator) {
		return findByTimesheet(timesheetId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time entries where timesheetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param timesheetId the timesheet ID
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching time entries
	 */
	@Override
	public List<TimeEntry> findByTimesheet(long timesheetId, int start,
		int end, OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESHEET;
			finderArgs = new Object[] { timesheetId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TIMESHEET;
			finderArgs = new Object[] { timesheetId, start, end, orderByComparator };
		}

		List<TimeEntry> list = null;

		if (retrieveFromCache) {
			list = (List<TimeEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TimeEntry timeEntry : list) {
					if ((timesheetId != timeEntry.getTimesheetId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TIMEENTRY_WHERE);

			query.append(_FINDER_COLUMN_TIMESHEET_TIMESHEETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimeEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(timesheetId);

				if (!pagination) {
					list = (List<TimeEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimeEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first time entry in the ordered set where timesheetId = &#63;.
	 *
	 * @param timesheetId the timesheet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time entry
	 * @throws NoSuchTimeEntryException if a matching time entry could not be found
	 */
	@Override
	public TimeEntry findByTimesheet_First(long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = fetchByTimesheet_First(timesheetId,
				orderByComparator);

		if (timeEntry != null) {
			return timeEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timesheetId=");
		msg.append(timesheetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimeEntryException(msg.toString());
	}

	/**
	 * Returns the first time entry in the ordered set where timesheetId = &#63;.
	 *
	 * @param timesheetId the timesheet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time entry, or <code>null</code> if a matching time entry could not be found
	 */
	@Override
	public TimeEntry fetchByTimesheet_First(long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator) {
		List<TimeEntry> list = findByTimesheet(timesheetId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time entry in the ordered set where timesheetId = &#63;.
	 *
	 * @param timesheetId the timesheet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time entry
	 * @throws NoSuchTimeEntryException if a matching time entry could not be found
	 */
	@Override
	public TimeEntry findByTimesheet_Last(long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = fetchByTimesheet_Last(timesheetId,
				orderByComparator);

		if (timeEntry != null) {
			return timeEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("timesheetId=");
		msg.append(timesheetId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimeEntryException(msg.toString());
	}

	/**
	 * Returns the last time entry in the ordered set where timesheetId = &#63;.
	 *
	 * @param timesheetId the timesheet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time entry, or <code>null</code> if a matching time entry could not be found
	 */
	@Override
	public TimeEntry fetchByTimesheet_Last(long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator) {
		int count = countByTimesheet(timesheetId);

		if (count == 0) {
			return null;
		}

		List<TimeEntry> list = findByTimesheet(timesheetId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time entries before and after the current time entry in the ordered set where timesheetId = &#63;.
	 *
	 * @param timeEntryId the primary key of the current time entry
	 * @param timesheetId the timesheet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time entry
	 * @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry[] findByTimesheet_PrevAndNext(long timeEntryId,
		long timesheetId, OrderByComparator<TimeEntry> orderByComparator)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = findByPrimaryKey(timeEntryId);

		Session session = null;

		try {
			session = openSession();

			TimeEntry[] array = new TimeEntryImpl[3];

			array[0] = getByTimesheet_PrevAndNext(session, timeEntry,
					timesheetId, orderByComparator, true);

			array[1] = timeEntry;

			array[2] = getByTimesheet_PrevAndNext(session, timeEntry,
					timesheetId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TimeEntry getByTimesheet_PrevAndNext(Session session,
		TimeEntry timeEntry, long timesheetId,
		OrderByComparator<TimeEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMEENTRY_WHERE);

		query.append(_FINDER_COLUMN_TIMESHEET_TIMESHEETID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TimeEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(timesheetId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timeEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimeEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time entries where timesheetId = &#63; from the database.
	 *
	 * @param timesheetId the timesheet ID
	 */
	@Override
	public void removeByTimesheet(long timesheetId) {
		for (TimeEntry timeEntry : findByTimesheet(timesheetId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(timeEntry);
		}
	}

	/**
	 * Returns the number of time entries where timesheetId = &#63;.
	 *
	 * @param timesheetId the timesheet ID
	 * @return the number of matching time entries
	 */
	@Override
	public int countByTimesheet(long timesheetId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TIMESHEET;

		Object[] finderArgs = new Object[] { timesheetId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMEENTRY_WHERE);

			query.append(_FINDER_COLUMN_TIMESHEET_TIMESHEETID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(timesheetId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TIMESHEET_TIMESHEETID_2 = "timeEntry.timesheetId = ?";

	public TimeEntryPersistenceImpl() {
		setModelClass(TimeEntry.class);
	}

	/**
	 * Caches the time entry in the entity cache if it is enabled.
	 *
	 * @param timeEntry the time entry
	 */
	@Override
	public void cacheResult(TimeEntry timeEntry) {
		entityCache.putResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryImpl.class, timeEntry.getPrimaryKey(), timeEntry);

		timeEntry.resetOriginalValues();
	}

	/**
	 * Caches the time entries in the entity cache if it is enabled.
	 *
	 * @param timeEntries the time entries
	 */
	@Override
	public void cacheResult(List<TimeEntry> timeEntries) {
		for (TimeEntry timeEntry : timeEntries) {
			if (entityCache.getResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
						TimeEntryImpl.class, timeEntry.getPrimaryKey()) == null) {
				cacheResult(timeEntry);
			}
			else {
				timeEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all time entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TimeEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the time entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimeEntry timeEntry) {
		entityCache.removeResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryImpl.class, timeEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TimeEntry> timeEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimeEntry timeEntry : timeEntries) {
			entityCache.removeResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
				TimeEntryImpl.class, timeEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new time entry with the primary key. Does not add the time entry to the database.
	 *
	 * @param timeEntryId the primary key for the new time entry
	 * @return the new time entry
	 */
	@Override
	public TimeEntry create(long timeEntryId) {
		TimeEntry timeEntry = new TimeEntryImpl();

		timeEntry.setNew(true);
		timeEntry.setPrimaryKey(timeEntryId);

		return timeEntry;
	}

	/**
	 * Removes the time entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timeEntryId the primary key of the time entry
	 * @return the time entry that was removed
	 * @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry remove(long timeEntryId) throws NoSuchTimeEntryException {
		return remove((Serializable)timeEntryId);
	}

	/**
	 * Removes the time entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the time entry
	 * @return the time entry that was removed
	 * @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry remove(Serializable primaryKey)
		throws NoSuchTimeEntryException {
		Session session = null;

		try {
			session = openSession();

			TimeEntry timeEntry = (TimeEntry)session.get(TimeEntryImpl.class,
					primaryKey);

			if (timeEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimeEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(timeEntry);
		}
		catch (NoSuchTimeEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TimeEntry removeImpl(TimeEntry timeEntry) {
		timeEntry = toUnwrappedModel(timeEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(timeEntry)) {
				timeEntry = (TimeEntry)session.get(TimeEntryImpl.class,
						timeEntry.getPrimaryKeyObj());
			}

			if (timeEntry != null) {
				session.delete(timeEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (timeEntry != null) {
			clearCache(timeEntry);
		}

		return timeEntry;
	}

	@Override
	public TimeEntry updateImpl(TimeEntry timeEntry) {
		timeEntry = toUnwrappedModel(timeEntry);

		boolean isNew = timeEntry.isNew();

		TimeEntryModelImpl timeEntryModelImpl = (TimeEntryModelImpl)timeEntry;

		Session session = null;

		try {
			session = openSession();

			if (timeEntry.isNew()) {
				session.save(timeEntry);

				timeEntry.setNew(false);
			}
			else {
				timeEntry = (TimeEntry)session.merge(timeEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TimeEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((timeEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timeEntryModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { timeEntryModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((timeEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timeEntryModelImpl.getOriginalUserId(),
						timeEntryModelImpl.getOriginalOnDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDATE,
					args);

				args = new Object[] {
						timeEntryModelImpl.getUserId(),
						timeEntryModelImpl.getOnDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDATE,
					args);
			}

			if ((timeEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESHEET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timeEntryModelImpl.getOriginalTimesheetId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TIMESHEET, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESHEET,
					args);

				args = new Object[] { timeEntryModelImpl.getTimesheetId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TIMESHEET, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TIMESHEET,
					args);
			}
		}

		entityCache.putResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
			TimeEntryImpl.class, timeEntry.getPrimaryKey(), timeEntry, false);

		timeEntry.resetOriginalValues();

		return timeEntry;
	}

	protected TimeEntry toUnwrappedModel(TimeEntry timeEntry) {
		if (timeEntry instanceof TimeEntryImpl) {
			return timeEntry;
		}

		TimeEntryImpl timeEntryImpl = new TimeEntryImpl();

		timeEntryImpl.setNew(timeEntry.isNew());
		timeEntryImpl.setPrimaryKey(timeEntry.getPrimaryKey());

		timeEntryImpl.setTimeEntryId(timeEntry.getTimeEntryId());
		timeEntryImpl.setUserId(timeEntry.getUserId());
		timeEntryImpl.setHours(timeEntry.getHours());
		timeEntryImpl.setProjectId(timeEntry.getProjectId());
		timeEntryImpl.setTaskId(timeEntry.getTaskId());
		timeEntryImpl.setBillable(timeEntry.isBillable());
		timeEntryImpl.setTimesheetId(timeEntry.getTimesheetId());
		timeEntryImpl.setOnDate(timeEntry.getOnDate());
		timeEntryImpl.setMessage(timeEntry.getMessage());

		return timeEntryImpl;
	}

	/**
	 * Returns the time entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the time entry
	 * @return the time entry
	 * @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimeEntryException {
		TimeEntry timeEntry = fetchByPrimaryKey(primaryKey);

		if (timeEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimeEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return timeEntry;
	}

	/**
	 * Returns the time entry with the primary key or throws a {@link NoSuchTimeEntryException} if it could not be found.
	 *
	 * @param timeEntryId the primary key of the time entry
	 * @return the time entry
	 * @throws NoSuchTimeEntryException if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry findByPrimaryKey(long timeEntryId)
		throws NoSuchTimeEntryException {
		return findByPrimaryKey((Serializable)timeEntryId);
	}

	/**
	 * Returns the time entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the time entry
	 * @return the time entry, or <code>null</code> if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
				TimeEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		TimeEntry timeEntry = (TimeEntry)serializable;

		if (timeEntry == null) {
			Session session = null;

			try {
				session = openSession();

				timeEntry = (TimeEntry)session.get(TimeEntryImpl.class,
						primaryKey);

				if (timeEntry != null) {
					cacheResult(timeEntry);
				}
				else {
					entityCache.putResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
						TimeEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
					TimeEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return timeEntry;
	}

	/**
	 * Returns the time entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timeEntryId the primary key of the time entry
	 * @return the time entry, or <code>null</code> if a time entry with the primary key could not be found
	 */
	@Override
	public TimeEntry fetchByPrimaryKey(long timeEntryId) {
		return fetchByPrimaryKey((Serializable)timeEntryId);
	}

	@Override
	public Map<Serializable, TimeEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, TimeEntry> map = new HashMap<Serializable, TimeEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			TimeEntry timeEntry = fetchByPrimaryKey(primaryKey);

			if (timeEntry != null) {
				map.put(primaryKey, timeEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
					TimeEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (TimeEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_TIMEENTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (TimeEntry timeEntry : (List<TimeEntry>)q.list()) {
				map.put(timeEntry.getPrimaryKeyObj(), timeEntry);

				cacheResult(timeEntry);

				uncachedPrimaryKeys.remove(timeEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(TimeEntryModelImpl.ENTITY_CACHE_ENABLED,
					TimeEntryImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the time entries.
	 *
	 * @return the time entries
	 */
	@Override
	public List<TimeEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @return the range of time entries
	 */
	@Override
	public List<TimeEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the time entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of time entries
	 */
	@Override
	public List<TimeEntry> findAll(int start, int end,
		OrderByComparator<TimeEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the time entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TimeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time entries
	 * @param end the upper bound of the range of time entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of time entries
	 */
	@Override
	public List<TimeEntry> findAll(int start, int end,
		OrderByComparator<TimeEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TimeEntry> list = null;

		if (retrieveFromCache) {
			list = (List<TimeEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TIMEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIMEENTRY;

				if (pagination) {
					sql = sql.concat(TimeEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TimeEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TimeEntry>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the time entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TimeEntry timeEntry : findAll()) {
			remove(timeEntry);
		}
	}

	/**
	 * Returns the number of time entries.
	 *
	 * @return the number of time entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIMEENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TimeEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the time entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(TimeEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_TIMEENTRY = "SELECT timeEntry FROM TimeEntry timeEntry";
	private static final String _SQL_SELECT_TIMEENTRY_WHERE_PKS_IN = "SELECT timeEntry FROM TimeEntry timeEntry WHERE timeEntryId IN (";
	private static final String _SQL_SELECT_TIMEENTRY_WHERE = "SELECT timeEntry FROM TimeEntry timeEntry WHERE ";
	private static final String _SQL_COUNT_TIMEENTRY = "SELECT COUNT(timeEntry) FROM TimeEntry timeEntry";
	private static final String _SQL_COUNT_TIMEENTRY_WHERE = "SELECT COUNT(timeEntry) FROM TimeEntry timeEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timeEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimeEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TimeEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(TimeEntryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"message"
			});
}