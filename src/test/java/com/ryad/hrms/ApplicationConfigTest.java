package com.ryad.hrms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ryad.hrms.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
@WebAppConfiguration
public class ApplicationConfigTest {

	@Test
	public void contextLoads() {
		
	}
}
