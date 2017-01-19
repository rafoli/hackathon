<%@ page import="com.liferay.timesheet.service.TimesheetLocalService" %>
<%@ page import="com.liferay.hackathon.timesheet.portlet.Constants" %>
<%@ page import="com.liferay.timesheet.service.TimeEntryLocalService" %>
<%@ page import="com.liferay.timesheet.service.TaskLocalService" %>
<%@ page import="com.liferay.timesheet.service.ClientLocalService" %>
<%@ page import="com.liferay.timesheet.service.ProjectLocalService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    TimesheetLocalService _timesheetLocalService = (TimesheetLocalService) renderRequest.getAttribute(Constants.ATTRIB_TIMESHEET_LOCAL_SERVICE);
    TimeEntryLocalService _timeEntryLocalService = (TimeEntryLocalService) renderRequest.getAttribute(Constants.ATTRIB_TIMEENTRY_LOCAL_SERVICE);
    TaskLocalService _taskLocalService = (TaskLocalService) renderRequest.getAttribute(Constants.ATTRIB_TASK_LOCAL_SERVICE);
    ClientLocalService _clientLocalService = (ClientLocalService) renderRequest.getAttribute(Constants.ATTRIB_CLIENT_LOCAL_SERVICE);
    ProjectLocalService _projectLocalService = (ProjectLocalService) renderRequest.getAttribute(Constants.ATTRIB_PROJECT_LOCAL_SERVICE);

%>