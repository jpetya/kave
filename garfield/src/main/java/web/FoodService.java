package web;

import java.io.FileNotFoundException;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;
import org.xml.sax.SAXException;

import json.InputAddFood;
import json.OutputAddFood;

@WebService
@Path("foodservice")
public interface FoodService {
	
	@Path("addfood")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Description(value = "Add food to stock", target = DocTarget.METHOD)
	public OutputAddFood addFood(@WebParam(name = "food") InputAddFood food);

	@Path("uploadadv")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@POST
	public Response uploadAdvertisement(@WebParam(name = "attachment") List<Attachment> attachments,
										@WebParam(name = "request")    @Context HttpServletRequest request);
	
	@Path("readorder")
	@POST
	public void readOrder() throws JAXBException, FileNotFoundException, SAXException;
	
}
