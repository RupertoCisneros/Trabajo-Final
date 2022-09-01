package gob.mdmq.remetfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import gob.mdmq.remetfu.config.RestServiceCorsApplication;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
//@EnableSwagger2 
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class RemetfuApplication {

	public static void main(String[] args) throws UnknownHostException{
		SpringApplication.run(RemetfuApplication.class, args);

               
                
	}
@Bean
  public Docket productApi() {      
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("gob.mdmq")).build();
  }
  
}
