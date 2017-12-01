package web;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import json.InputAddFood;

@WebService
@Path("/foodservice")
public interface FoodService {
	
	@Path("addfood")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public String addFood(InputAddFood addFoodInput);

	@Path("healthcheck")
	@POST
	public String healthCheck();
	
}
