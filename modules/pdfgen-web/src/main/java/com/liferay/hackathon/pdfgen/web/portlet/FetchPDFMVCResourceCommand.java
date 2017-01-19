package com.liferay.hackathon.pdfgen.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by dnebinger on 1/18/17.
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + GeneratePdfsPortletKeys.GENERATE_PDFS,
				"mvc.command.name=/fetch_pdf"
		},
		service = MVCResourceCommand.class
)
public class FetchPDFMVCResourceCommand extends BaseMVCResourceCommand {
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		String filename = ParamUtil.getString(resourceRequest, "name");

		if (Validator.isNull(filename)) {
			return;
		}

		File target = new File("/tmp/hackathon/" + filename);

		InputStream in = new FileInputStream(target);
		HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(resourceResponse);
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
		ServletResponseUtil.sendFile(httpReq,httpRes, target.getName(), in, "application/download");

		in.close();
	}
}
