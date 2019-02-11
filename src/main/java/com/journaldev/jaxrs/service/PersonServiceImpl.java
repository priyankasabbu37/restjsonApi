package com.journaldev.jaxrs.service;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
/*
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/
import javax.ws.rs.core.MediaType;
import com.journaldev.jaxrs.model.Person;
import com.journaldev.jaxrs.model.Response;

@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@Consumes("application/json")
public class PersonServiceImpl implements PersonService {

	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
	// private static Map<Integer, Person> persons = new TreeMap<Integer, Person>();

	@Override
	@Path("/add")
	@POST
	public Response addPerson(Person  p) {
		
		/*try {
			File file = new File("D:\\PdfBox_Examples\\test1.pdf");
			PDDocument doc = PDDocument.load(file);
			// PDDocument doc = new PDDocument();
			PDPage page = new PDPage();
			doc.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(doc, page);
			// Create a new font object selecting one of the PDF base fonts
			PDFont font = PDType1Font.HELVETICA_BOLD;
			// Define a text content stream using the selected font, moving the cursor and
			// drawing the text "Hello World"
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.drawString("Customer Report\n");
			contentStream.endText();
			contentStream.newLine();
			contentStream.newLine();
			drawTable(page, contentStream, p);

			contentStream.close();
			doc.save("test.pdf");
			// Save the results and ensure that the document is properly closed:
			doc.save("D:\\PdfBox_Examples\\test1.pdf");
			doc.close();
			System.out.println("PDF Created Done.");

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Response response = new Response();
		// JSONObject recoData = new JSONObject(data);
//		if(persons.get(p.getId()) != null){
//			response.setStatus(false);
//			response.setMessage("Person Already Exists");
//			return response;
//		}
	//	System.out.println(recoData);
		System.out.println(p);
		//System.out.println(persons.get(p.getId()));
		persons.put(p.getId(),p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response; 

	}

/*	public static void drawTable(PDPage page, PDPageContentStream contentStream, Person content) throws IOException {
		// now add the text
		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 6);
		String text = "hello";
		contentStream.beginText();
		contentStream.newLineAtOffset(25, 700);
		contentStream.drawString(text);
		contentStream.endText();
	}*/

	@Override
	@DELETE
	@Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		Response response = new Response();
		if (persons.get(id) == null) {
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	public Person getPerson(@PathParam("id") int id) {
		Person p=new Person();
		p.setId(1);
		p.setName("priya");
		p.setAge(25);
		return p;//persons.get(id);
	}

	@GET
	@Path("/{id}/getDummy")
	public Person getDummyPerson(@PathParam("id") int id) {
		Person p = new Person();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	public Person[] getAllPersons() {
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

}
