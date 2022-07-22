package com.inswave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.inswave"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
  @Bean
  public ServletRegistrationBean getServletRegistrationBean()
  {
      ServletRegistrationBean websquareDispatcher = new ServletRegistrationBean(new websquare.http.DefaultRequestDispatcher());
      websquareDispatcher.addUrlMappings("*.wq");
      return websquareDispatcher;
  }

}
