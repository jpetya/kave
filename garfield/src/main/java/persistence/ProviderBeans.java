package persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderBeans {

	private static final String PROVIDER_FOOD_SERVICE = "providerFoodService";
	
	@Bean(name=PROVIDER_FOOD_SERVICE)
	public FoodProvider getFoodProvider() {
		return new FoodProviderImpl();
	}
	
}
