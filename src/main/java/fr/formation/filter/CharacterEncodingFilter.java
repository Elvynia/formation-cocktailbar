package fr.formation.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Filtre web permettant de modifier toutes les requêtes HTTP avant qu'elles
 * n'atteignent une Servlet afin de préciser le jeu de caractères à utiliser.
 *
 * @author hb-asus
 *
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	/**
	 * Méthode permettant de libérer des ressources natives lorsque
	 * l'application web est arrêtée ou que le filtre est retiré.
	 */
	@Override
	public void destroy() {
	}

	/**
	 * Méthode appelée pour chaque requête HTTP suivant le pattern d'URL précisé
	 * dans l'annotation. L'appel à la méthode doFilter de l'objet FilterChain
	 * permet de laisser la requête passer au prochain filtre. Si cette méthode
	 * n'est pas appelée alors la requête ne sera pas traitée par les filtres
	 * suivants ou les servlets.
	 */
	@Override
	public void doFilter(final ServletRequest request,
			final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	/**
	 * Méthode d'initialisation appelée lorsque le filtre est activé à l'écoute
	 * des requêtes (principalement au démarrage de l'application web).
	 */
	@Override
	public void init(final FilterConfig arg0) throws ServletException {
	}

}
