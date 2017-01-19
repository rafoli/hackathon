package com.liferay.hackathon.timesheet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.timesheet.model.Project;
import com.liferay.timesheet.model.TimeEntry;
import com.liferay.timesheet.service.ProjectLocalService;
import com.liferay.timesheet.service.TimeEntryLocalService;
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
				"mvc.command.name=/add_time"
		},
		service = MVCActionCommand.class

)
public class AddTimeMVCActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String message = ParamUtil.getString(actionRequest, "message");
		long clientId = ParamUtil.getLong(actionRequest, "clientId", 0);
		long projectId = ParamUtil.getLong(actionRequest, "projectId", 0);
		double hours = ParamUtil.getDouble(actionRequest, "hours", 1.0);

		String dateStr = ParamUtil.getString(actionRequest, "date");

		Date date = new Date();

		if (Validator.isNotNull(dateStr)) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			try {
				date = sdf.parse(dateStr);
			}catch (Throwable t) {

			}
		}

		long userId = PortalUtil.getUserId(actionRequest);

		TimeEntry entry = _timeEntryLocalService.addTimeEntry(userId, hours, projectId, 0, true, 0, date, message);

		actionResponse.setRenderParameter("message", "");
		actionResponse.setRenderParameter("clientId", String.valueOf(clientId));
		actionResponse.setRenderParameter("hours", "");
		actionResponse.setRenderParameter("date", "");
	}

	@Reference
	protected void setTimeEntryLocalService(final TimeEntryLocalService timeEntryLocalService) {
		_timeEntryLocalService = timeEntryLocalService;
	}
	private TimeEntryLocalService _timeEntryLocalService;
}
