package web;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
@Path("/foodservice")
public interface FoodService {
	
	@Path("addfood")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addFood(String foodname);

	@Path("verion")
	public String getVersion();
	
}
