package spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import persistence.PersistenceBeans;

@Configuration
@Import({
	RestBeans.class, 
	RestEndpoints.class, 
	PersistenceBeans.class,
	WebserviceFilter.class})
public class WebserviceContext {

}
