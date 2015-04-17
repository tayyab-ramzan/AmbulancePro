package fr.ambulancePro.Servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.DAO.DAOFactory;

@Controller
public class Vehicule {
	
	@RequestMapping("vehicule")
	public ModelAndView printForm(){		
		return new ModelAndView("vehicule");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="vehicule")
	public ModelAndView validateForm(@RequestParam("numero_immatricule") String numero_immatricule){
		System.out.println(numero_immatricule);
		return new ModelAndView("vehicule");
	}
}
