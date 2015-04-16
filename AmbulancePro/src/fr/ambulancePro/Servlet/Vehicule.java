package fr.ambulancePro.Servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.DAO.DAOFactory;

@Controller
public class Vehicule {
	
	@RequestMapping("vehicule")
	public ModelAndView printForm(){		
		return new ModelAndView("vehicule");
	}
}
