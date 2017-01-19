package com.liferay.hackathon.pdfgen;

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

@Component(immediate = true, service = Application.class)
@ApplicationPath("/pdf")
public class PDFGeneratorWS extends Application {
	
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
		pdfGenerator.generatePdfs("<hackathon>test</hackathon>", "/tmp/hackathon", 10);
		return "{\"message\":\"ok\"}";
	}
	
    @Reference
	public void setPdfGenerator(PdfGenerator pdfGenerator) {
		this.pdfGenerator = pdfGenerator;
	}

	private PdfGenerator pdfGenerator;

}
