package spring;

import javax.annotation.Resource;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.RuntimeDelegate;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import web.FoodService;

@Configuration
public class RestEndpoints {

	public static final String JAXRS_APP = "application"; // jaxrs
	public static final String JAXRS_SERVER = "server";   // jaxrs
	public static final String JSON_PROVIDER = "jsonprovider";
	
	public class JaxRsApiApplication extends Application { }
	
	@Bean(name=JAXRS_APP) 
	public JaxRsApiApplication jaxRsApiApplication() {
		return new JaxRsApiApplication();
	}	
	
	@Bean(name=JAXRS_SERVER)
	public Server getJaxRsServer(){
		JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(jaxRsApiApplication(), JAXRSServerFactoryBean.class);
		factory.setProvider(jsonProvider());
		factory.setServiceBean(this.foodService);
		factory.setBus(springBus);
		
		return factory.create();
	}
	
	@Resource(name=Bus.DEFAULT_BUS_ID)
	private SpringBus springBus;
	
	@Resource(name=RestBeans.REST_FOOD_SERVICE)
	private FoodService foodService;

	@Bean(name = JSON_PROVIDER)
	public JacksonJsonProvider jsonProvider() {
		JacksonJsonProvider provider = new JacksonJsonProvider();
		return provider;
	}
	
}
