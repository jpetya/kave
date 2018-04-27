package web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.xml.sax.SAXException;

import context.ContextReader;
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
	public OutputAddFood addFood(InputAddFood food) {
		logger.info("addFood:" + food);
		
		return foodProvider.addFood(food.getFoodname());
	}

	@Override
	public Response uploadAdvertisement(List<Attachment> attachments, HttpServletRequest request) {
		if (attachments.size() != 1) {
			logger.error("Exactly only one file can be uploaded");
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		else {
			try {
				String home = contextReader.getFileTransferHome().toString();
				String filename = attachments.get(0).getContentDisposition().getFilename();
				
				attachments.get(0).transferTo(new File(home, filename));
					
				return Response.status(Response.Status.OK).build();
			} catch (IOException e) {
				logger.error(e);
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
		}
	}

	@Override
	public void readOrder() throws JAXBException, FileNotFoundException, SAXException {
		foodProvider.readOrder();		
	}
	
	@Autowired
	private ContextReader contextReader;

}
