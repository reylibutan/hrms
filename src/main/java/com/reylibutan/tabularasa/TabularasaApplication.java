package com.reylibutan.tabularasa;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
/* These are the added annotations for @SpringBootApplication
 * @Configuration
 * @EnableAutoConfiguration
 * @EnableWebMvc (added if it sees spring-webmvc on the classpath)
 * @ComponentScan
*/
public class TabularasaApplication {

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
}