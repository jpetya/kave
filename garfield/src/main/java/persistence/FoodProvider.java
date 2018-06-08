package persistence;

import java.io.FileNotFoundException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import json.OutputAddFood;
import persistence.dto.ShipOrderDTO;

public interface FoodProvider {

	public OutputAddFood addFood(String foodname);
	
	public ShipOrderDTO readOrder() throws JAXBException, FileNotFoundException;
	public Response uploadAdvertisement(List<Attachment> attachments);
	
}
