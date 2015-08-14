package com.ryad.hrms;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DandelionConfig {

	// ========================================================================
	// ========================================================================
	// @TODO: delete later
	// ========================================================================
	// ========================================================================
	
	/*@Bean
	public DandelionDialect dandelionDialect() {
		return new DandelionDialect();
	}

	@Bean
	public DataTablesDialect dataTablesDialect() {
		return new DataTablesDialect();
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new DandelionFilter());
		return filterRegistrationBean;
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new DandelionServlet());
		servletRegistrationBean.addUrlMappings("/dandelion-assets/*");
		servletRegistrationBean.setName("dandelionServlet");
		return servletRegistrationBean;
	}*/
}