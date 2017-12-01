package web;

import json.InputAddFood;
import persistence.FoodProvider;

public class FoodServiceImpl implements FoodService {

	private final FoodProvider foodProvider;
	
	public FoodServiceImpl(FoodProvider foodProvider) {
		this.foodProvider = foodProvider; 		
	}
	
	@Override
	public String addFood(InputAddFood addFoodInput) {
		return foodProvider.addFood(addFoodInput.foodname);
	}

	@Override
	public String healthCheck() {
		return "OK";
	}

}
