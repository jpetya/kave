package web;

import persistence.FoodProvider;

public class FoodServiceImpl implements FoodService {

	private final FoodProvider foodProvider;
	
	public FoodServiceImpl(FoodProvider foodProvider) {
		this.foodProvider = foodProvider; 		
	}
	
	@Override
	public String addFood(String foodname) {
		return "OK: " + foodname;
	}

}
