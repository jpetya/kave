package persistence;

public class FoodProviderImpl implements FoodProvider {

	@Override
	public String addFood(String foodname) {
		return "{ \"yousent\": \"" + foodname + "\" }";
	}

}
