package com.liferay.hackathon.timesheet.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.timesheet.model.Client;
import com.liferay.timesheet.model.Project;
import com.liferay.timesheet.model.Timesheet;
import com.liferay.timesheet.service.ClientLocalService;
import com.liferay.timesheet.service.ProjectLocalService;
import com.liferay.timesheet.service.TaskLocalService;
import com.liferay.timesheet.service.TimeEntryLocalService;
import com.liferay.timesheet.service.TimesheetLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=timesheet-web Portlet",
		"javax.portlet.name=" + TimesheetPortletKeys.TIMESHEET,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TimesheetWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<Client> clients = _clientLocalService.getClients(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if ((clients != null) && (! clients.isEmpty())) {
			renderRequest.setAttribute("clientId", clients.get(0).getClientId());
		}

		List<Project> projects = _projectLocalService.getProjects(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if ((projects != null) && (! projects.isEmpty())) {
			renderRequest.setAttribute("projectId", projects.get(0).getProjectId());
		}

		renderRequest.setAttribute(Constants.ATTRIB_CLIENT_LOCAL_SERVICE, _clientLocalService);
		renderRequest.setAttribute(Constants.ATTRIB_PROJECT_LOCAL_SERVICE, _projectLocalService);
		renderRequest.setAttribute(Constants.ATTRIB_TASK_LOCAL_SERVICE, _taskLocalService);
		renderRequest.setAttribute(Constants.ATTRIB_TIMEENTRY_LOCAL_SERVICE, _timeEntryLocalService);
		renderRequest.setAttribute(Constants.ATTRIB_TIMESHEET_LOCAL_SERVICE, _timesheetLocalService);

		super.render(renderRequest, renderResponse);
	}

	@Reference(unbind = "-")
	protected void setTimesheetLocalService(final TimesheetLocalService timesheetLocalService) {
		_timesheetLocalService = timesheetLocalService;
	}
	@Reference(unbind = "-")
	protected void setTimeEntryLocalService(final TimeEntryLocalService timeEntryLocalService) {
		_timeEntryLocalService = timeEntryLocalService;
	}
	@Reference(unbind = "-")
	protected void setClientLocalService(final ClientLocalService clientLocalService) {
		_clientLocalService = clientLocalService;
	}
	@Reference(unbind = "-")
	protected void setProjectLocalService(final ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}
	@Reference(unbind = "-")
	protected void setTaskLocalService(final TaskLocalService taskLocalService) {
		_taskLocalService = taskLocalService;
	}

	private TimesheetLocalService _timesheetLocalService;
	private TimeEntryLocalService _timeEntryLocalService;
	private ClientLocalService _clientLocalService;
	private ProjectLocalService _projectLocalService;
	private TaskLocalService _taskLocalService;
}