<%@ page import="java.util.List" %>
<%@ page import="com.liferay.timesheet.model.Client" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.timesheet.model.TimeEntry" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="timesheet_web_TimesheetWeb.caption"/></b>
</p>

<portlet:renderURL var="viewURL" >
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<%
	long clientId = GetterUtil.getLong(renderRequest.getAttribute("clientId"), -1);
	long projectId = GetterUtil.getLong(renderRequest.getAttribute("projectId"), -1);

	if (_clientLocalService.getClientsCount() < 1) {
%>
<portlet:actionURL name="/add_client" var="addClientUrl">
	<portlet:param name="mvcActionCommand" value="/add_client" />
</portlet:actionURL>
<aui:form action="<%= addClientUrl %>" method="post" name="fm" >
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input type="text" name="name" label="Client Name:" />
		</aui:fieldset>
		<aui:fieldset>
			<aui:button-row>
				<aui:button type="submit" value="addClient" />
				<aui:button href="<%= viewURL %>" type="cancel" value="cancel" />
			</aui:button-row>
		</aui:fieldset>
	</aui:fieldset-group>
</aui:form>
<%
	} else if (_projectLocalService.getProjectsCount() < 1) {
%>
<portlet:actionURL name="/add_project" var="addProjectUrl">
	<portlet:param name="mvcActionCommand" value="/add_project" />
</portlet:actionURL>
<aui:form action="<%= addProjectUrl %>" method="post" name="fm" >

	<aui:input type="hidden" name="clientId" value="<%= clientId %>" />
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input type="text" name="name" label="Project Name:" />
		</aui:fieldset>
		<aui:fieldset>
			<aui:button-row>
				<aui:button type="submit" value="addProject" />
				<aui:button href="<%= viewURL %>" type="cancel" value="cancel" />
			</aui:button-row>
		</aui:fieldset>
	</aui:fieldset-group>
</aui:form>
<%
	} else {
%>
<portlet:actionURL name="/add_time" var="addTimeUrl">
	<portlet:param name="mvcActionCommand" value="/add_time" />
</portlet:actionURL>
<aui:form action="<%= addTimeUrl %>" method="post" name="fm" >
	<aui:input type="hidden" name="clientId" value="<%= clientId %>" />
	<aui:input type="hidden" name="projectId" value="<%= projectId %>" />
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input type="text" name="hours" label="Hours:" />
			<aui:input type="text" name="date" label="Date: mm/dd/yyyy " />
			<aui:input type="text" name="message" label="Message: " />
		</aui:fieldset>
		<aui:fieldset>
			<aui:button-row>
				<aui:button type="submit" value="addTime" />
				<aui:button href="<%= viewURL %>" type="cancel" value="cancel" />
			</aui:button-row>
		</aui:fieldset>
	</aui:fieldset-group>
</aui:form>

<%
	List<TimeEntry> time = _timeEntryLocalService.getTimeEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

	if ((time != null) && (! time.isEmpty())) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		%>
<table class="table table-striped">
	<thead>
		<tr><th>Hours</th><th>Date</th><th>Message</th></tr>
	</thead>
	<tbody>

	<%
		for (TimeEntry entry : time) {
	%>
		<tr><td><%= entry.getHours() %></td><td><%= sdf.format(entry.getOnDate()) %></td><td><%= entry.getMessage() %></td></tr>
	<%
		}
	%>
	</tbody>
</table>
<%
		}
	}
%>