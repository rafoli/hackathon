package com.liferay.hackathon.pdfgen.web.portlet;

import com.liferay.hackathon.pdfgen.PdfGenerator;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=pdfgen-web Portlet",
		"javax.portlet.name=" + GeneratePdfsPortletKeys.GENERATE_PDFS,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PdfgenWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		renderRequest.setAttribute("pdfGenerator", _pdfGenerator);
		super.render(renderRequest, renderResponse);
	}

	@Reference(unbind = "-")
	protected void setPdfGenerator(final PdfGenerator pdfGenerator) {
		_pdfGenerator = pdfGenerator;
	}

	private PdfGenerator _pdfGenerator;
}