package spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import persistence.PersistenceBeans;

@Configuration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
@Import({
	RestBeans.class, 
	RestEndpoints.class, 
	PersistenceBeans.class})
public class WebserviceContext {

}
