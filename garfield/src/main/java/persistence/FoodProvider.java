package persistence;

import json.OutputAddFood;

public interface FoodProvider {

	public OutputAddFood addFood(String foodname);
	
}
