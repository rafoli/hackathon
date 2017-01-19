package com.liferay.hackathon.pdfgen.web.controller;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.hackathon.pdfgen.PdfGenerator;

@Component(immediate = true, service = Application.class)
@ApplicationPath("/pdf")
public class PDFController extends Application {
	
	// ==============
    // JAX-RS setup
    // ==============

	public Set<Object> getSingletons() {
		return Collections.<Object> singleton(this);
	}
	
	@GET
	@Path("/generate")
	@Produces(MediaType.APPLICATION_JSON)
	public String generate() {
		pdfGenerator.generatePdfs("<html><body>This is certificate number $$IDX$$.</body></html>", "/tmp/hackathon", 10);
		return "{\"message\":\"ok\"}";
	}
	
	// ==============
    // References
    // ==============
	
    @Reference
	public void setPdfGenerator(PdfGenerator pdfGenerator) {
		this.pdfGenerator = pdfGenerator;
	}

	private PdfGenerator pdfGenerator;
	

}
