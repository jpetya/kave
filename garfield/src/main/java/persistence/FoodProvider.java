package persistence;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import json.OutputAddFood;

public interface FoodProvider {

	public OutputAddFood addFood(String foodname);
	
	public void readOrder() throws JAXBException, FileNotFoundException;
	
}
