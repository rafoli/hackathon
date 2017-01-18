package com.liferay.hackathon.pdfgen;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;

/**
 * Created by dnebinger on 1/18/17.
 */
public class PdfGenerator {

	public void generatePdfs(final String html, final String path, final int count) {

		File dir = new File(path);
		try {
			FileUtil.mkdirs(dir);
		} catch (IOException e) {
			// ignored
		}

		for (int idx = 1; idx <= count; idx++) {
			generateFile(html, dir, idx);
		}
	}

	protected void generateFile(final String html, final File path, final int idx) {
		try {
			String k = StringUtil.replace(html, "$$IDX$$", String.valueOf(idx));

			String indexName = ("0000" + idx);
			indexName = indexName.substring(indexName.length() - 5);

			OutputStream file = new FileOutputStream(new File(path, "cert-" + indexName + ".pdf"));
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, file);
			document.open();
			InputStream is = new ByteArrayInputStream(k.getBytes());
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
			document.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
