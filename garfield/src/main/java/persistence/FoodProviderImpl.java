package persistence;

import json.OutputAddFood;

public class FoodProviderImpl implements FoodProvider {

	@Override
	public OutputAddFood addFood(String foodname) {
		OutputAddFood food = new OutputAddFood();
		food.setFoodid("1116");
		
		return food;
	}

}
