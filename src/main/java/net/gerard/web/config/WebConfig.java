package net.gerard.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Value("${mygmc.ruta.imagenes}")
	private String rutaImagenes;
	
	@Value("${mygmc.ruta.cv}")
	private String rutaCv;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/folder/**").addResourceLocations("file:"+rutaImagenes);
		registry.addResourceHandler("/cv/**").addResourceLocations("file:"+rutaCv); 
	}
}