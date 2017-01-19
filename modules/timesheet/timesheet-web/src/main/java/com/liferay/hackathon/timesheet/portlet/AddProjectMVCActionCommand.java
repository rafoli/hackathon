package com.liferay.hackathon.timesheet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.timesheet.model.Client;
import com.liferay.timesheet.model.Project;
import com.liferay.timesheet.service.ClientLocalService;
import com.liferay.timesheet.service.ProjectLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dnebinger on 1/19/17.
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + TimesheetPortletKeys.TIMESHEET,
				"mvc.command.name=/add_project"
		},
		service = MVCActionCommand.class

)
public class AddProjectMVCActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String name = ParamUtil.getString(actionRequest, "name");
		long clientId = ParamUtil.getLong(actionRequest, "clientId", 0);

		Date starts = new Date();
		Date ends = new Date();

		Project project = _projectLocalService.addProject(clientId, name, starts, ends);

		actionRequest.setAttribute("clientId", clientId);
		actionRequest.setAttribute("projectId", project.getProjectId());
	}

	@Reference
	protected void setProjectLocalService(final ProjectLocalService projectLocalService) {
		_projectLocalService = projectLocalService;
	}
	private ProjectLocalService _projectLocalService;
}
