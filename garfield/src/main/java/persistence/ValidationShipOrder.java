package persistence;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.util.ValidationEventCollector;

public class ValidationShipOrder extends ValidationEventCollector {

	@Override
	public boolean handleEvent(ValidationEvent event) {
		System.out.println("ValidationEventHandler: " + event.getMessage());
		
		return true;
	}

}
