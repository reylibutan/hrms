package com.ryad.hrms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import com.github.dandelion.datatables.thymeleaf.dialect.DataTablesDialect;
import com.github.dandelion.thymeleaf.dialect.DandelionDialect;


@Configuration
public class DandelionConfig {
	
	@Bean
	@Autowired
	public ThymeleafViewResolver thymeleafViewResolver(ThymeleafViewResolver thymeleafViewResolver) {
		SpringTemplateEngine engine = thymeleafViewResolver.getTemplateEngine();
		engine.addDialect(new DandelionDialect());
		engine.addDialect(new DataTablesDialect());
		
		return thymeleafViewResolver;
	}
}