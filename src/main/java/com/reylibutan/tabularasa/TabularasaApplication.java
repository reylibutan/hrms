package com.reylibutan.tabularasa;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.reylibutan.tabularasa.interceptor.SampleInterceptor;

@SpringBootApplication
public class TabularasaApplication extends SpringBootServletInitializer {

    private final String PARAM_LANGUAGE = "lang";
	
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
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TabularasaApplication.class);
    }
    
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName(this.PARAM_LANGUAGE);
        return lci;
    }
    
    @Bean
    public WebMvcConfigurerAdapter adapter() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
            	registry.addInterceptor(new SampleInterceptor()).addPathPatterns("/sample/*");
            	registry.addInterceptor(localeChangeInterceptor());
            }
        };
    }
}