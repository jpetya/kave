package web;

import java.util.List;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import json.InputAddFood;
import json.OutputAddFood;

@WebService
@Path("foodservice")
public interface FoodService {
	
	@Path("addfood")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Descriptions({
		@Description(value = "Add food to stock",   target = DocTarget.METHOD)})
	public OutputAddFood addFood(InputAddFood addFoodInput);

	@Path("uploadadv")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@POST
	public Response uploadAdvertisement(List<Attachment> attachments, @Context HttpServletRequest request);
	
}
