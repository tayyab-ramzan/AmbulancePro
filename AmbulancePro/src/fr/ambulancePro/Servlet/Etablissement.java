package fr.ambulancePro.Servlet;

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
import fr.ambulancePro.DAO.Etablissement.EtablissementDao;
import fr.ambulancePro.Model.Adresse;
import fr.ambulancePro.Model.EtablissementSante;
import fr.ambulancePro.Model.Ensemble.EnsembleEtablissement;

@Controller
public class Etablissement {
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";
	
	private EnsembleEtablissement _etablissements;
	
	@Autowired
	private ServletContext context;
	
	@RequestMapping("etablissement")
	public ModelAndView etablissement(){
		this._etablissements = new EnsembleEtablissement(context);
		this._etablissements.remplir();
		
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("etablissements", this._etablissements.getEtablissements());
		
		return new ModelAndView("etablissement/etablissement","data",data);
	}
	
	@RequestMapping("creer_etablissement")
	public ModelAndView printForm(){
		return new ModelAndView("etablissement/creer_etablissement");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="creer_etablissement")
	public ModelAndView validateForm(@RequestParam("nom_etablissement") String nom,
									 @RequestParam("num")String num,
									 @RequestParam("nom_rue") String nomRue,
									 @RequestParam("code_postal")String codePostal,
									 @RequestParam("ville")String ville,
									 @RequestParam("email") String email,
									 @RequestParam("tel") String tel){
		
		//HashMap pour les données reçu pour un renvoi eventuel
		Map<String,Object> data =  new HashMap<String, Object>();
		//HashMap pour les erreurs
		Map<String, String> errors = new HashMap<String, String>();
		
		data.put("email", email);
		data.put("nom",nom);
		data.put("tel",tel);
		data.put("num", num);
		data.put("adresse",nomRue);
		data.put("code_postal", codePostal);
		data.put("ville", ville);
		
		if (email == "") {
			errors.put("email","Veuillez saisir une adresse mail");
		}else if(!validationEmail(email)){
			errors.put("email","Veuillez saisir une adresse mail valide");
		}
		
		if (!validationNom(nom)) {
			errors.put("nom", "Le nom d'Etablissement doit contenit au minimum 3 caratères");
		}
		
		if (!validationTel(tel)) {
			errors.put("tel", "Le numéro de telephone n'est pas valide");
		}
		
		if (!validationAdresse(nomRue) || num.isEmpty() || codePostal.isEmpty() || ville.isEmpty()){
			errors.put("adresse", "L'adresse n'est pas valide");
		}
		
		if (!errors.isEmpty()) {
			data.put("errors", errors);
			return new ModelAndView("etablissement/creer_etablissement", "data", data);
		}else{
			Adresse adresse = new Adresse(Integer.parseInt(num), nomRue, codePostal, ville);
			EtablissementSante newEtablissement = new EtablissementSante(nom, adresse, email, tel);
			this._etablissements.creerEtablissement(newEtablissement);
			return new ModelAndView("redirect:etablissement.html");
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
