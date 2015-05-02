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
	
	@Autowired
	private ServletContext _context;
	
	private EnsemblePersonnel _personnel = new EnsemblePersonnel();
	
	@RequestMapping("index")
	public ModelAndView verificationSession(HttpSession session){
		if (session.getAttribute("USER") == null) {
			return new ModelAndView("connexion");
		}
		return new ModelAndView("accueil");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="connexion")
	public ModelAndView seConnecter(@RequestParam("login")String login,@RequestParam("password")String password ,HttpSession session){
		boolean connected = true;
		//session.setAttribute("CONNECTED", connected);
		
		if (password.isEmpty() || login.isEmpty()) {
			return new ModelAndView("connexion");
		}
		else {
			Personnel user = new Personnel(login, password,this._context);
			if (user.seConnecter()) {
				session.setAttribute("USER", user);
				return new ModelAndView("accueil");
			}else{
				return new ModelAndView("connexion");
			}
		}
		
	}
}
