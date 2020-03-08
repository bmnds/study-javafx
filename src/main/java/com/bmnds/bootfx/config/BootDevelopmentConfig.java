package com.bmnds.bootfx.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@Profile("development")
class BootDevelopmentConfig {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();

		source.setBasename("classpath:messages");
		source.setUseCodeAsDefaultMessage(true);
		source.setCacheSeconds(0);
		source.setDefaultLocale(new Locale("pt", "BR"));
		source.setDefaultEncoding("UTF-8");

		return source;
	}

}
