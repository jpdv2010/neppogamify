package br.com.neppogamify.neppogamify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import javax.annotation.Resource;
import java.util.Locale;

@SpringBootApplication
public class NeppogamifyApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(NeppogamifyApplication.class, args);
	}
	@Bean
	public LocaleResolver localeResolver(){
		return new FixedLocaleResolver(new Locale("pt","BR"));
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(!registry.hasMappingForPattern("/static/**")){
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/*");
		}
	}
}
