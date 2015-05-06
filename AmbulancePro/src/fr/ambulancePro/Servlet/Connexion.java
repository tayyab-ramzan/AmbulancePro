package fr.ambulancePro.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Personnel.PersonnelDAO;
import fr.ambulancePro.DAO.Personnel.PersonnelDAOImpl;
import fr.ambulancePro.Model.Personnel;
import fr.ambulancePro.Model.Ensemble.EnsemblePersonnel;

@Controller
public class Connexion {
	
	@Autowired
	private ServletContext _context;
	
	@RequestMapping("index")
	public ModelAndView verificationSession(HttpSession session){
		if (session.getAttribute("USER") == null) {
			return new ModelAndView("connexion");
		}
		return redirection(session);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="connexion")
	public ModelAndView seConnecter(@RequestParam("login")String login,@RequestParam("password")String password ,HttpSession session){
		boolean connected = true;
		//session.setAttribute("CONNECTED", connected);
		
		if (!password.isEmpty() && !login.isEmpty()) {
			Personnel user = new Personnel(login, password,this._context);
			if (user.seConnecter()) {
				session.setAttribute("USER", user);
				return redirection(session);
			}else{
				return new ModelAndView("connexion");
			}
		}
		return new ModelAndView("connexion");
	}
	
	private ModelAndView redirection(HttpSession session){
		Personnel p = (Personnel) session.getAttribute("USER");
		session.setAttribute("USER", p);
		switch ( p.getStrategie().get_intituleRole() ) {
		case "OPERATEUR":
			return new ModelAndView("accueil/accueil_operateur");
		case "PLANNING":
			return new ModelAndView("accueil/accueil_planning");
		case "FACTURATION":
			return new ModelAndView("accueil/accueil_admin");
		case "CHAUFFEUR":
			return new ModelAndView("accueil/accueil_admin");
		case "ADMINISTRATEUR":
			return new ModelAndView("accueil/accueil_admin");
		default:
			return new ModelAndView("connexion");
		}
	}
	
	@RequestMapping("deconnexion")
	public ModelAndView seDeconnecter(HttpSession session){
		session.removeAttribute("USER");
		return new ModelAndView("redirect:index.html");
	}
}
