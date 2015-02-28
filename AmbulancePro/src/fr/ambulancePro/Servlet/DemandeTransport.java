package fr.ambulancePro.Servlet;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemandeTransport {

	@RequestMapping("demandeTransport")
	public ModelAndView saisirDemandeTransport(){

		String message = "<br><div align='center'>"
				+ "<h3>Formulaire de demande de Transport<br><br>";
		return new ModelAndView("demandeTransport", "message", message);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "demandeTransport")
	public ModelAndView validerData(){
		
		//Map<String , String> data = new Map<String, String>() {
		//};
		
		String message = "<br><div align='center'>"
				+ "<h3>Formulaire de demande de Transport<br><br>";
		return new ModelAndView("demandeTransport", "message", message);
	}
}
