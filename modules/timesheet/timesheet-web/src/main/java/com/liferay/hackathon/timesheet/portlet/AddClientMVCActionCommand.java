package com.liferay.hackathon.timesheet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.timesheet.model.Client;
import com.liferay.timesheet.model.Timesheet;
import com.liferay.timesheet.service.ClientLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Created by dnebinger on 1/19/17.
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + TimesheetPortletKeys.TIMESHEET,
				"mvc.command.name=/add_client"
		},
		service = MVCActionCommand.class

)
public class AddClientMVCActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String name = ParamUtil.getString(actionRequest, "name");

		Client client = _clientLocalService.addClient(name);

		actionRequest.setAttribute("clientId", client.getClientId());
	}

	@Reference
	protected void setClientLocalService(final ClientLocalService clientLocalService) {
		_clientLocalService = clientLocalService;
	}
	private ClientLocalService _clientLocalService;
}
