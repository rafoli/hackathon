<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="timesheet_web_TimesheetWeb.caption"/></b>
</p>

<%
	if (_clientLocalService.getClientCount() < 1) {
%>
<%
	} else if {_projectLocalService.getProjectCount() < 1) {
%>
<%
	} else if {_taskLocalService.getTaskCount() < 1) {
%>
<%
	} else {
%>

<%
	}
%>