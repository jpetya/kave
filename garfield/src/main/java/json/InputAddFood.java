package json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // for wadl generation. JSON objects show, if browser send "Accept: application/json"
public class InputAddFood {
	
	private String foodname;

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	
}
