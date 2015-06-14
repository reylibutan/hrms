package com.reylibutan.tabularasa;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
/* These are the added annotations for @SpringBootApplication
 * @Configuration
 * @EnableAutoConfiguration
 * @EnableWebMvc (added if it sees spring-webmvc on the classpath)
 * @ComponentScan
*/
//SpringBootServletInitializer - needed to be able to produce a deployable WAR file
public class TabularasaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
    	SpringApplication.run(TabularasaApplication.class, args);
    }
    
    public static void printGeneratedBeans(ApplicationContext ctx) {
    	System.out.println("Generated Beans:");
    	
    	String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
    
    //needed to be able to produce a deployable WAR file
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TabularasaApplication.class);
    }
}