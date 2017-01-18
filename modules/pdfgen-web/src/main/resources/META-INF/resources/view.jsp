<%@ page import="java.io.File" %>
<%@ page import="java.util.Date" %>
<%@ include file="/init.jsp" %>

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
		<thead><tr>
		<th><liferay-ui:message key="header.filename" /></th>
		<th><liferay-ui:message key="header.created" /></th>
		</tr></thead>
		<tbody>
	<%
		File path = new File("/tmp/hackathon");
		File[] pdfFiles = path.listFiles();

		if ((pdfFiles != null) && (pdfFiles.length > 0)) {
		for (File pdfFile : pdfFiles) {
	%>
	<portlet:resourceURL id="/fetch_pdf" var="fetchPdf" >
		<portlet:param name="name" value="<%= pdfFile.getName() %>" />
	</portlet:resourceURL>

	<tr><td ><a href="<%= fetchPdf %>"><%= pdfFile.getName()%></a></td><td><%= new Date(pdfFile.lastModified())%></td></tr>
	<%

		}
		}
	%>
	</tbody>
	</table>
</div>
