package spring;

import javax.naming.NamingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import context.ContextReader;
import context.TomcatContextReader;
import persistence.PersistenceBeans;

@Configuration
@Import({
	RestBeans.class, 
	RestEndpoints.class, 
	PersistenceBeans.class,
	FilterBeans.class,
	NoSQLBeans.class})
@ImportResource(value = "classpath:application.xml")
public class WebserviceContext {
	
	@Bean
	public ContextReader getContextReader() throws NamingException {
		return new TomcatContextReader();
	}

}
