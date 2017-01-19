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

package com.liferay.timesheet.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.timesheet.model.Task;
import com.liferay.timesheet.service.TaskService;
import com.liferay.timesheet.service.persistence.ClientPersistence;
import com.liferay.timesheet.service.persistence.ProjectPersistence;
import com.liferay.timesheet.service.persistence.TaskPersistence;
import com.liferay.timesheet.service.persistence.TimeEntryPersistence;
import com.liferay.timesheet.service.persistence.TimesheetPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the task remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.timesheet.service.impl.TaskServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.timesheet.service.impl.TaskServiceImpl
 * @see com.liferay.timesheet.service.TaskServiceUtil
 * @generated
 */
public abstract class TaskServiceBaseImpl extends BaseServiceImpl
	implements TaskService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.timesheet.service.TaskServiceUtil} to access the task remote service.
	 */

	/**
	 * Returns the client local service.
	 *
	 * @return the client local service
	 */
	public com.liferay.timesheet.service.ClientLocalService getClientLocalService() {
		return clientLocalService;
	}

	/**
	 * Sets the client local service.
	 *
	 * @param clientLocalService the client local service
	 */
	public void setClientLocalService(
		com.liferay.timesheet.service.ClientLocalService clientLocalService) {
		this.clientLocalService = clientLocalService;
	}

	/**
	 * Returns the client remote service.
	 *
	 * @return the client remote service
	 */
	public com.liferay.timesheet.service.ClientService getClientService() {
		return clientService;
	}

	/**
	 * Sets the client remote service.
	 *
	 * @param clientService the client remote service
	 */
	public void setClientService(
		com.liferay.timesheet.service.ClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * Returns the client persistence.
	 *
	 * @return the client persistence
	 */
	public ClientPersistence getClientPersistence() {
		return clientPersistence;
	}

	/**
	 * Sets the client persistence.
	 *
	 * @param clientPersistence the client persistence
	 */
	public void setClientPersistence(ClientPersistence clientPersistence) {
		this.clientPersistence = clientPersistence;
	}

	/**
	 * Returns the project local service.
	 *
	 * @return the project local service
	 */
	public com.liferay.timesheet.service.ProjectLocalService getProjectLocalService() {
		return projectLocalService;
	}

	/**
	 * Sets the project local service.
	 *
	 * @param projectLocalService the project local service
	 */
	public void setProjectLocalService(
		com.liferay.timesheet.service.ProjectLocalService projectLocalService) {
		this.projectLocalService = projectLocalService;
	}

	/**
	 * Returns the project remote service.
	 *
	 * @return the project remote service
	 */
	public com.liferay.timesheet.service.ProjectService getProjectService() {
		return projectService;
	}

	/**
	 * Sets the project remote service.
	 *
	 * @param projectService the project remote service
	 */
	public void setProjectService(
		com.liferay.timesheet.service.ProjectService projectService) {
		this.projectService = projectService;
	}

	/**
	 * Returns the project persistence.
	 *
	 * @return the project persistence
	 */
	public ProjectPersistence getProjectPersistence() {
		return projectPersistence;
	}

	/**
	 * Sets the project persistence.
	 *
	 * @param projectPersistence the project persistence
	 */
	public void setProjectPersistence(ProjectPersistence projectPersistence) {
		this.projectPersistence = projectPersistence;
	}

	/**
	 * Returns the task local service.
	 *
	 * @return the task local service
	 */
	public com.liferay.timesheet.service.TaskLocalService getTaskLocalService() {
		return taskLocalService;
	}

	/**
	 * Sets the task local service.
	 *
	 * @param taskLocalService the task local service
	 */
	public void setTaskLocalService(
		com.liferay.timesheet.service.TaskLocalService taskLocalService) {
		this.taskLocalService = taskLocalService;
	}

	/**
	 * Returns the task remote service.
	 *
	 * @return the task remote service
	 */
	public TaskService getTaskService() {
		return taskService;
	}

	/**
	 * Sets the task remote service.
	 *
	 * @param taskService the task remote service
	 */
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	/**
	 * Returns the task persistence.
	 *
	 * @return the task persistence
	 */
	public TaskPersistence getTaskPersistence() {
		return taskPersistence;
	}

	/**
	 * Sets the task persistence.
	 *
	 * @param taskPersistence the task persistence
	 */
	public void setTaskPersistence(TaskPersistence taskPersistence) {
		this.taskPersistence = taskPersistence;
	}

	/**
	 * Returns the time entry local service.
	 *
	 * @return the time entry local service
	 */
	public com.liferay.timesheet.service.TimeEntryLocalService getTimeEntryLocalService() {
		return timeEntryLocalService;
	}

	/**
	 * Sets the time entry local service.
	 *
	 * @param timeEntryLocalService the time entry local service
	 */
	public void setTimeEntryLocalService(
		com.liferay.timesheet.service.TimeEntryLocalService timeEntryLocalService) {
		this.timeEntryLocalService = timeEntryLocalService;
	}

	/**
	 * Returns the time entry remote service.
	 *
	 * @return the time entry remote service
	 */
	public com.liferay.timesheet.service.TimeEntryService getTimeEntryService() {
		return timeEntryService;
	}

	/**
	 * Sets the time entry remote service.
	 *
	 * @param timeEntryService the time entry remote service
	 */
	public void setTimeEntryService(
		com.liferay.timesheet.service.TimeEntryService timeEntryService) {
		this.timeEntryService = timeEntryService;
	}

	/**
	 * Returns the time entry persistence.
	 *
	 * @return the time entry persistence
	 */
	public TimeEntryPersistence getTimeEntryPersistence() {
		return timeEntryPersistence;
	}

	/**
	 * Sets the time entry persistence.
	 *
	 * @param timeEntryPersistence the time entry persistence
	 */
	public void setTimeEntryPersistence(
		TimeEntryPersistence timeEntryPersistence) {
		this.timeEntryPersistence = timeEntryPersistence;
	}

	/**
	 * Returns the timesheet local service.
	 *
	 * @return the timesheet local service
	 */
	public com.liferay.timesheet.service.TimesheetLocalService getTimesheetLocalService() {
		return timesheetLocalService;
	}

	/**
	 * Sets the timesheet local service.
	 *
	 * @param timesheetLocalService the timesheet local service
	 */
	public void setTimesheetLocalService(
		com.liferay.timesheet.service.TimesheetLocalService timesheetLocalService) {
		this.timesheetLocalService = timesheetLocalService;
	}

	/**
	 * Returns the timesheet remote service.
	 *
	 * @return the timesheet remote service
	 */
	public com.liferay.timesheet.service.TimesheetService getTimesheetService() {
		return timesheetService;
	}

	/**
	 * Sets the timesheet remote service.
	 *
	 * @param timesheetService the timesheet remote service
	 */
	public void setTimesheetService(
		com.liferay.timesheet.service.TimesheetService timesheetService) {
		this.timesheetService = timesheetService;
	}

	/**
	 * Returns the timesheet persistence.
	 *
	 * @return the timesheet persistence
	 */
	public TimesheetPersistence getTimesheetPersistence() {
		return timesheetPersistence;
	}

	/**
	 * Sets the timesheet persistence.
	 *
	 * @param timesheetPersistence the timesheet persistence
	 */
	public void setTimesheetPersistence(
		TimesheetPersistence timesheetPersistence) {
		this.timesheetPersistence = timesheetPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TaskService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Task.class;
	}

	protected String getModelClassName() {
		return Task.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = taskPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.timesheet.service.ClientLocalService.class)
	protected com.liferay.timesheet.service.ClientLocalService clientLocalService;
	@BeanReference(type = com.liferay.timesheet.service.ClientService.class)
	protected com.liferay.timesheet.service.ClientService clientService;
	@BeanReference(type = ClientPersistence.class)
	protected ClientPersistence clientPersistence;
	@BeanReference(type = com.liferay.timesheet.service.ProjectLocalService.class)
	protected com.liferay.timesheet.service.ProjectLocalService projectLocalService;
	@BeanReference(type = com.liferay.timesheet.service.ProjectService.class)
	protected com.liferay.timesheet.service.ProjectService projectService;
	@BeanReference(type = ProjectPersistence.class)
	protected ProjectPersistence projectPersistence;
	@BeanReference(type = com.liferay.timesheet.service.TaskLocalService.class)
	protected com.liferay.timesheet.service.TaskLocalService taskLocalService;
	@BeanReference(type = TaskService.class)
	protected TaskService taskService;
	@BeanReference(type = TaskPersistence.class)
	protected TaskPersistence taskPersistence;
	@BeanReference(type = com.liferay.timesheet.service.TimeEntryLocalService.class)
	protected com.liferay.timesheet.service.TimeEntryLocalService timeEntryLocalService;
	@BeanReference(type = com.liferay.timesheet.service.TimeEntryService.class)
	protected com.liferay.timesheet.service.TimeEntryService timeEntryService;
	@BeanReference(type = TimeEntryPersistence.class)
	protected TimeEntryPersistence timeEntryPersistence;
	@BeanReference(type = com.liferay.timesheet.service.TimesheetLocalService.class)
	protected com.liferay.timesheet.service.TimesheetLocalService timesheetLocalService;
	@BeanReference(type = com.liferay.timesheet.service.TimesheetService.class)
	protected com.liferay.timesheet.service.TimesheetService timesheetService;
	@BeanReference(type = TimesheetPersistence.class)
	protected TimesheetPersistence timesheetPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}