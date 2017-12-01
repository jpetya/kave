package spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import persistence.PersistenceBeans;

@Configuration
@Import({RestBeans.class, RestEndpoints.class, PersistenceBeans.class})
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class WebserviceContext {

}
