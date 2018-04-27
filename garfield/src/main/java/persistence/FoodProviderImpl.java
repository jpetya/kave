package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import json.OutputAddFood;
import schemagen.shiporder.Shiporder;

public class FoodProviderImpl implements FoodProvider {

	@Override
	public OutputAddFood addFood(String foodname) {
		OutputAddFood food = new OutputAddFood();
		food.setFoodid("1116");
		
		return food;
	}

	@Override
	public void readOrder() throws JAXBException, FileNotFoundException {

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
	}

}
