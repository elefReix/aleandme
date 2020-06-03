package mx.com.asteci.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.asteci.app.model.Propiedades;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	


@Autowired
Propiedades propiedades;

	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(regex("/profe.*"))                          
          .build()
          .apiInfo(apiInfo());                                           
    }


	private Contact contact() {
		return new Contact(propiedades.getNombre(),propiedades.getUrl(),propiedades.getLicencia());
	}
	
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(propiedades.getTitulo()).description(propiedades.getDescripcion()).version(propiedades.getVersion()).contact(contact()).build();
	}

	


	
	
	
	

}
