package web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import json.InputAddFood;
import json.OutputAddFood;
import persistence.FoodProvider;

public class FoodServiceImpl implements FoodService {

	private final FoodProvider foodProvider;
	
	public FoodServiceImpl(FoodProvider foodProvider) {
		this.foodProvider = foodProvider; 		
	}
	
	@Override
	public OutputAddFood addFood(InputAddFood addFoodInput) {
		return foodProvider.addFood(addFoodInput.getFoodname());
	}

	@Override
	public Response uploadAdvertisement(Attachment attachment, HttpServletRequest request) {
		try {
			String userdir = System.getProperty("user.dir");
			
			attachment.transferTo(new File(userdir + "\\\\valami"));
				
			return Response.status(Response.Status.OK).build();
		} catch (IOException e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
	}

}
