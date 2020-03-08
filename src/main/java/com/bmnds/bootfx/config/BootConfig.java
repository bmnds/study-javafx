package com.bmnds.bootfx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@Profile("!development")
public class BootConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {

		var source = new ResourceBundleMessageSource();
		source.setUseCodeAsDefaultMessage(false);
		source.setBasename("messages");
		source.setDefaultEncoding("UTF-8");

		return source;
	}

}
