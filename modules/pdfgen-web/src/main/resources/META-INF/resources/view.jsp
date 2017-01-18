<%@ page import="java.io.File" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="liferay-ui" uri="http://java.sun.com/portlet" %>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="pdfgen_web_PdfgenWeb.caption"/></b>
</p>

<portlet:actionURL name="/generate_pdfs" var="genPdfURL">
	<portlet:param name="mvcActionCommand" value="/generate_pdf" />
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:actionURL>
<div>
	<div class="col-md-10">
		<liferay-ui:message key="hello.caption" />
	</div>
	<div class="col-md-2">
		<p><a href="<%= genPdfURL %>" class="btn btn-default" role="button"><liferay-ui:message key="button.generate.pdfs" /></a></p>
	</div>
</div>
<div class="col-md-12">
	<table class="table table-striped">
		<th><liferay-ui:message key="header.filename" /></th>
		<th><liferay-ui:message key="header.created" /></th>
	</table>
	<%
		File path = new File("/tmp/hackathon");
		File[] pdfFiles = path.listFiles();

		for (File pdfFile : pdfFiles) {
	%>
	<tr><td ><%= pdfFile.getName()%></td><td><%= new Date(pdfFile.lastModified())%></td></tr>
	<%

		}
	%>
</div>

<table class="table table-striped">
	<thead><tr>
		<th><liferay-ui:message key="header.status" /></th>
		<th><liferay-ui:message key="header.server" /></th>
		<th><liferay-ui:message key="header.last.check.run" /></th>
	</tr></thead>
	<tbody>
	<%
		for (TWStatus status : statuses) {
	%>
	<tr><td ><span class='<%= "status-color-" + status.getStatusColor() %>'><%= WordUtils.capitalize(status.getStatusColor()) %></span></td>
		<td ><%= status.getServer() %></td><td ><%= status.getLastCheckRunDate() %></td></tr>
	<%
		}
	%>
	</tbody>
</table>
