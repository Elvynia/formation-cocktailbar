package fr.elvynia.formation.cocktailbar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
@ComponentScan({ "fr.elvynia.formation.cocktailbar.presentation",
		"fr.elvynia.formation.cocktailbar.service",
		"fr.elvynia.formation.cocktailbar.persistence" })
public class CocktailbarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CocktailbarApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("classpath:menu");
	    messageSource.setCacheSeconds(10);
	    return messageSource;
	}
}
