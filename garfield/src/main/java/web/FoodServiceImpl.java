package web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;

import json.InputAddFood;
import json.OutputAddFood;
import persistence.FoodProvider;

public class FoodServiceImpl implements FoodService {

	final static Logger logger = Logger.getLogger(FoodServiceImpl.class);
	
	private final FoodProvider foodProvider;
	
	public FoodServiceImpl(FoodProvider foodProvider) {
		this.foodProvider = foodProvider; 		
	}
	
	@Override
	public OutputAddFood addFood(InputAddFood addFoodInput) {
		logger.info("addFood:" + addFoodInput);
		
		return foodProvider.addFood(addFoodInput.getFoodname());
	}

	@Override
	public Response uploadAdvertisement(Attachment attachment, HttpServletRequest request) {
		try {
			String userdir = System.getProperty("user.dir");
			
			attachment.transferTo(new File(userdir + "\\\\valami"));
				
			logger.info("uploadAdvertisement");
			
			return Response.status(Response.Status.OK).build();
		} catch (IOException e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
	}

}
