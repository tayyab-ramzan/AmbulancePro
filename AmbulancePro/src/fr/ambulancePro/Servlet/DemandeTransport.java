package fr.ambulancePro.Servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemandeTransport {
	@RequestMapping(method = RequestMethod.POST , value = "/validerDemandeTransport")
	public ModelAndView helloWorld() {
 
		String message = "<br><div align='center'>"
				+ "<h3> "
				+ "Demande de Transport Créée <br><br>";
		return new ModelAndView("demandeTransport", "message", message);
	}
}
