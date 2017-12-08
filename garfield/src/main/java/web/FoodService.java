package web;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

import json.InputAddFood;

@WebService
@Path("foodservice")
public interface FoodService {
	
	@Path("addfood")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Descriptions({
		@Description(value = "New food id in json", target = DocTarget.RESPONSE),
		@Description(value = "Add a food to stock", target = DocTarget.METHOD)})
	public String addFood(@Description(value = "Input params in json", target = DocTarget.PARAM) InputAddFood addFoodInput);

	@Path("healthcheck")
	@POST
	public String healthCheck();
	
}
