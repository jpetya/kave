package web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import json.InputAddFood;
import persistence.FoodProvider;

public class FoodServiceImpl implements FoodService {

	private final FoodProvider foodProvider;
	
	public FoodServiceImpl(FoodProvider foodProvider) {
		this.foodProvider = foodProvider; 		
	}
	
	@Override
	public String addFood(InputAddFood addFoodInput) {
		return foodProvider.addFood(addFoodInput.foodname);
	}

	@Override
	public Response uploadAdvertisement(Attachment attachment, HttpServletRequest request) {
		DataHandler handler = attachment.getDataHandler();
		try {
			String userdir = System.getProperty("user.dir");
			
			OutputStream out = new FileOutputStream(new File(userdir + "\\\\valami"));
			try {
				try(InputStream is = handler.getInputStream()){
					MultivaluedMap<String, String> map = attachment.getHeaders();
					System.out.println(map);
				
		            int read = 0;
		            byte[] bytes = new byte[1024];
		            while ((read = is.read(bytes)) != -1) {
		               out.write(bytes, 0, read);
		            }
				}
				
				out.flush();
			} finally {
				out.close();
			}
				
			return Response.status(Response.Status.OK).build();
		} catch (IOException e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
	}

}
