package fr.ambulancePro.Servlet;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.Model.Personnel;

@Controller
public class Accueil {
	
	public ModelAndView redirect(HttpSession session){
		Personnel personnel = (Personnel)session.getAttribute("USER");
		
		return null;
	}

}
