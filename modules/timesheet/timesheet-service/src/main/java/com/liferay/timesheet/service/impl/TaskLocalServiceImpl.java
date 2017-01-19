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

package com.liferay.timesheet.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.timesheet.model.Task;
import com.liferay.timesheet.service.base.TaskLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timesheet.service.TaskLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskLocalServiceBaseImpl
 * @see com.liferay.timesheet.service.TaskLocalServiceUtil
 */
@ProviderType
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.timesheet.service.TaskLocalServiceUtil} to access the task local service.
	 */

	public Task addTask(final long projectId, final String name) {
		Task task = createTask(counterLocalService.increment(Task.class.getName()));

		task.setProjectId(projectId);
		task.setName(name);

		return addTask(task);
	}

	public List<Task> findByProject(final long projectId) {
		return taskPersistence.findByProject(projectId);
	}
	public long countByProject(final long projectId) {
		return taskPersistence.countByProject(projectId);
	}
}