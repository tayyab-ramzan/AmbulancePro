package fr.ambulancePro.Servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.EtablissementDao;
import fr.ambulancePro.Model.EtablissementSante;

@Controller
public class Etablissement {
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";
	
	private EtablissementDao dao;
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("etablissement")
	public ModelAndView printForm(){
		
		this.dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getEtablissementDao();
		
		
		return new ModelAndView("etablissement");
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value="etablissement")
	public ModelAndView validateForm(@RequestParam("nom_etablissement") String nom,
									 @RequestParam("adresse") String adresse,
									 @RequestParam("email") String email,
									 @RequestParam("tel") String tel){
		
		//HashMap pour contenir l'ensembles de données et erreurs
		Map<String, Map<String, String>> dataErrorMap = new HashMap<String, Map<String,String>>();
		//HashMap pour les données reçu pour un renvoi eventuel
		Map<String,String> data =  new HashMap<String, String>();
		//HashMap pour les erreurs
		Map<String, String> errors = new HashMap<String, String>();
		
		data.put("email", email);
		data.put("nom",nom);
		data.put("tel",tel);
		data.put("adresse",adresse);
		
		if (email == "") {
			errors.put("email","Veuillez saisir une adresse mail");
		}else if(!validationEmail(email)){
			errors.put("email","Veuillez saisir une adresse mail valide");
		}
		
		if (!validationNom(nom)) {
			errors.put("nom", "Le nom d'établissement doit contenit au minimum 3 caratères");
		}
		
		if (!validationTel(tel)) {
			errors.put("tel", "Le numéro de téléphone n'est pas valide");
		}
		
		if (!validationAdresse(adresse)) {
			errors.put("adresse", "L'adresse n'est pas valide");
		}
		
		if (!errors.isEmpty()) {
			dataErrorMap.put("data", data);
			dataErrorMap.put("errors",errors);
			return new ModelAndView("etablissement", "dataErrors", dataErrorMap);
		}else{
			EtablissementSante newEtablissement = new EtablissementSante(nom, adresse, email, tel);
			dao.creer(newEtablissement);
			return new ModelAndView("liste_etablissement");
		}
		
	}
	
	private boolean validationEmail( String email ){
	    
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            return false;
	        }
	        return true;
	}
	
	private boolean validationNom( String nom ){
	    if ( nom != null && nom.length() < 3 ) {
	        return false;
	    }
	    return true;
	}
	
	private boolean validationTel(String tel){
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher matcher = pattern.matcher(tel);
		
		if(matcher.matches())
			return true;
		
		return false;
	}
	
	private boolean validationAdresse(String adresse){
		if ( adresse != null && adresse.length() < 3 ) {
	        return false;
	    }
	    return true;
	}
	
	
}
