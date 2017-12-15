package json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OutputAddFood {

	private String foodid;

	public String getFoodid() {
		return foodid;
	}

	public void setFoodid(String foodid) {
		this.foodid = foodid;
	}
	
}
