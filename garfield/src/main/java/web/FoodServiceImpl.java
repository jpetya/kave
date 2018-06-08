package web;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

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
		return foodProvider.uploadAdvertisement(attachments);
	}

	@Override
	public void readOrder() throws JAXBException, FileNotFoundException, SAXException {
		foodProvider.readOrder();		
	}

}
