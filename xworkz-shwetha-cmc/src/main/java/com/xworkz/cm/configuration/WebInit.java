package com.xworkz.cm.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@Slf4j
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer{

	public WebInit() {
		log.info("created" + getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("getServletConfigClass");
		return new Class[] {SignUpConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		log.info("getServletMappings");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		log.info("configureDefaultServletHandling");
		configurer.enable();
	}
}
