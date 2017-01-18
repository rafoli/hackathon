package com.liferay.hackathon.pdfgen.web.portlet;

import com.liferay.hackathon.pdfgen.PdfGenerator;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 *
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + GeneratePdfsPortletKeys.GENERATE_PDFS,
				"mvc.command.name=/generate_pdfs"
		},
		service = MVCActionCommand.class
)
public class GeneratePDFMVCActionCommand extends BaseMVCActionCommand {
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String html = "<html><body>This is certificate number $$IDX$$.</body></html>";

		_pdfGenerator.generatePdfs(html, "/tmp/hackathon", 1000);
	}

	@Reference(unbind = "-")
	protected void setPdfGenerator(final PdfGenerator pdfGenerator) {
		_pdfGenerator = pdfGenerator;
	}

	private PdfGenerator _pdfGenerator;
}
