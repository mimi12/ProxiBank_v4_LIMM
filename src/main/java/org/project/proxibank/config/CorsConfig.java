package org.project.proxibank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe de configuration CORS (Cross Origin Resource Sharing) permettant de
 * donner l'autorisation à la presentation Angular (consumer) de se connecter au
 * webservice Spring (producer) a partir de la methode addCorsMapping qui
 * configure la connexion entre les deux.
 * 
 * @author LIMM
 *
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins("http://localhost:4200")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD").allowCredentials(true);
	}

}
