package fr.ambulancePro.Servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Personnel.PersonnelDAO;
import fr.ambulancePro.DAO.Personnel.PersonnelDAOImpl;
import fr.ambulancePro.Model.EnsemblePersonnel;
import fr.ambulancePro.Model.Personnel;

@Controller
public class Connexion {
	
	private EnsemblePersonnel _personnel = new EnsemblePersonnel();
	
	@RequestMapping("index")
	public ModelAndView verificationSession(HttpSession session){
		if (session.getAttribute("CONNECTED") == null) {
			return new ModelAndView("connexion");
		}
		return new ModelAndView("demandeTransport");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="connexion")
	public ModelAndView seConnecter(@RequestParam("login")String login,@RequestParam("password")String password ,HttpSession session){
		boolean connected = true;
		//session.setAttribute("CONNECTED", connected);
		
		if (password.isEmpty() || login.isEmpty()) {
			return new ModelAndView("connexion");
		}
		else {
			Personnel user = new Personnel(login, password);
			user.seConnecter();
		}
		return new ModelAndView("etablissement");
	}
}
