package fr.ambulancePro.Servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConnexionServlet {
	@RequestMapping("/demandeTransport")
	public ModelAndView helloWorld() {
 
		String message = "<br><div align='center'>"
				+ "<h3> "
				+ "Bienvenu sur la page de Gestions des demande de transports <br><br>";
		return new ModelAndView("demandeTransport", "message", message);
	}
}
