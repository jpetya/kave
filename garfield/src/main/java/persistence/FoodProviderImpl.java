package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import context.ContextReader;
import json.OutputAddFood;
import persistence.dto.ShipOrderDTO;
import schemagen.shiporder.Shiporder;

public class FoodProviderImpl implements FoodProvider {

	final static Logger logger = Logger.getLogger(FoodProviderImpl.class);
	
	@Override
	public OutputAddFood addFood(String foodname) {
		OutputAddFood food = new OutputAddFood();
		food.setFoodid("1116");
		
		return food;
	}

	@Override
	public ShipOrderDTO readOrder() throws JAXBException, FileNotFoundException {

		//SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
		//URL schemaURL = FoodProviderImpl.class.getResource("/xsd/shiporder.xsd");
		//Schema schema = sf.newSchema(schemaURL);

		JAXBContext context = JAXBContext.newInstance(Shiporder.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //unmarshaller.setSchema(schema);
        unmarshaller.setEventHandler(new ValidationShipOrder());
        
        File xml = new File("D://Temp//sample.txt");
        FileInputStream is = new FileInputStream(xml);
        
        JAXBElement<Shiporder> order = unmarshaller.unmarshal(new StreamSource(is), Shiporder.class);
        
		System.out.println("After unmarshal: " + order.getValue().getShipto().getAddress());
		
		ShipOrderDTO shiporderDTO = mapper.map(order.getValue(), ShipOrderDTO.class);
		
		return shiporderDTO;
	}

	@Override
	public Response uploadAdvertisement(List<Attachment> attachments) {
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
	
	@Autowired
	private ContextReader contextReader;

	@Autowired
	private DozerBeanMapper mapper;
	
}
