package webservices.rezeptapp.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;
import webservices.rezeptapp.Konstanten;
import webservices.rezeptapp.authentification.Account;
import webservices.rezeptapp.services.AuthenticationService;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.logging.Logger;

@Controller
@SessionScope
public class HomeController {
	
	private final Logger logger = Logger.getLogger(HomeController.class.getName());
	
	private final transient Counter authenticatedAccess;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	public HomeController(MeterRegistry registry) {
		authenticatedAccess = registry.counter("access.authenticated");
	}
	
	@GetMapping("/")
	@RolesAllowed({Konstanten.ROLE_ORGA, Konstanten.ROLE_STUDENTIN})
	public String home(Principal principal, Model model) {
		
		// Account
		Account account = authenticationService.checkLoggedIn(principal, authenticatedAccess);
		if (account == null) {
			throw new AccessDeniedException(Konstanten.NOT_LOGGED_IN);
		}
		model.addAttribute(Konstanten.ACCOUNT, account);
		
		return "home";
	}
}
