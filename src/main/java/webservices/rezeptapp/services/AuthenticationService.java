package webservices.rezeptapp.services;

import io.micrometer.core.instrument.Counter;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.stereotype.Service;
import webservices.rezeptapp.authentification.Account;

import java.security.Principal;

@Service
public class AuthenticationService {
	
	/**
	 * Generiert einen Account aus einem KeyCloak Token
	 *
	 * @param principal Ein java-security Interface welches einen Nutzer representiert
	 * @return Account
	 */
	public Account createAccountFromPrincipal(Principal principal) {
		KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) principal;
		KeycloakPrincipal<?> keycloakToken = (KeycloakPrincipal<?>) token.getPrincipal();
		return new Account(
			keycloakToken.getName(),
			keycloakToken.getKeycloakSecurityContext().getIdToken().getEmail(),
			null,
			token.getAccount().getRoles());
	}
	
	public Account checkLoggedIn(Principal principal, Counter authenticatedAccess) {
		if (principal != null) {
			Account account = createAccountFromPrincipal(principal);
			authenticatedAccess.increment();
			return account;
		}
		return null;
	}
}
