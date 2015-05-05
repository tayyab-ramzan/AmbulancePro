package fr.ambulancePro.Servlet;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.Model.Personnel;
import fr.ambulancePro.Model.StrategieAdmin;
import fr.ambulancePro.Model.StrategieChauffeur;
import fr.ambulancePro.Model.StrategieFacuration;
import fr.ambulancePro.Model.StrategieOperateur;
import fr.ambulancePro.Model.StrategiePlanning;

@Controller
public class Accueil {
	
	@RequestMapping("accueil")
	public ModelAndView redirect(HttpSession session){
		if (session.getAttribute("USER") != null) {
			Personnel personnel = (Personnel)session.getAttribute("USER");
			switch ( personnel.getStrategie().get_intituleRole() ) {
			case "OPERATEUR":
				return new ModelAndView("accueil/accueil_operateur");
			case "PLANNING":
				return new ModelAndView("accueil/accueil_admin");
			case "FACTURATION":
				return new ModelAndView("accueil/accueil_admin");
			case "CHAUFFEUR":
				return new ModelAndView("accueil/accueil_admin");
			case "ADMINISTRATEUR":
				return new ModelAndView("accueil/accueil_admin");
			default:
				break;
			}
		}
		return new ModelAndView("redirect:index.html");
	}

}
