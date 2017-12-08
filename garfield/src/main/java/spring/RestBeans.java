package spring;

import javax.annotation.Resource;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import persistence.FoodProvider;
import persistence.PersistenceBeans;
import web.FoodService;
import web.FoodServiceImpl;

@Configuration
public class RestBeans {

	public static final String REST_FOOD_SERVICE = "restFoodService";
	
    @Bean(name=Bus.DEFAULT_BUS_ID) 
    public SpringBus springBus() { 
        return new SpringBus(); 
    } 	
	
	@Bean(name=REST_FOOD_SERVICE)
	public FoodService getFoodService() {
		return new FoodServiceImpl(this.foodProvider);		
	}
	
	@Resource(name=PersistenceBeans.PROVIDER_FOOD_SERVICE)
	private FoodProvider foodProvider;
	
}
