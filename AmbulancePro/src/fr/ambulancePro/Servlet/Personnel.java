package fr.ambulancePro.Servlet;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.Model.EnsemblePersonnel;
import fr.ambulancePro.Model.EtablissementSante;

@Controller
public class Personnel {
	
	@Autowired
	private ServletContext _context;
	
	EnsemblePersonnel _personnel;
	
	@RequestMapping("personnel")
	public ModelAndView personnel(){
		this._personnel = new EnsemblePersonnel(this._context);
		
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("ROLE", "ADMINISTRATEUR");
		this._personnel.remplir();
		data.put("personnel", this._personnel);
		return new ModelAndView("personnel/personnel","data",data);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "personnel")
	public ModelAndView personnel(@RequestParam("role")String role){
		this._personnel = new EnsemblePersonnel(this._context);
		this._personnel.remplir();
		
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("ROLE", role);
		data.put("personnel", this._personnel.getByRole(role));
		return new ModelAndView("personnel/personnel","data",data);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "ajouter_personnel")
	public ModelAndView ajouterPersonnel(@RequestParam("role")String role){
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("ROLE", role);
		
		return new ModelAndView("personnel/ajouter_personnel","data",data);
	}
	
	/*
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value="ajouter_personnel")
	public ModelAndView ajouterPersonnel(@RequestParam("nom")String nom,
										 @RequestParam("role")String role,
										 @RequestParam("prenom")String prenom,
										 @RequestParam("email")String email){
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("ROLE", role);
		data.put("nom", nom);
		data.put("prenom", prenom);
		data.put("email", email);
		
		Map<String,Object> errors =  new HashMap<String, Object>();
		
		if (email == "") {
			errors.put("email","Veuillez saisir une adresse mail");
		}else if(!validationEmail(email)){
			errors.put("email","Veuillez saisir une adresse mail valide");
		}
		
		if (!validationNom(nom)) {
			errors.put("nom", "Le nom d'Etablissement doit contenit au minimum 3 caratères");
		}
		
		if (!validationNom(prenom)) {
			errors.put("prenom", "Le prenom doit contenit au minimum 3 caratères");
		}
		
		if (!errors.isEmpty()) {
			data.put("errors",errors);
			return new ModelAndView("personnel/ajouter_personnel", "data", data);
		}else{
			fr.ambulancePro.Model.Personnel newPersonnel = new fr.ambulancePro.Model.Personnel(nom, prenom, email);
			newPersonnel.setStrategieByName(role);
			this._personnel.creerPersonnel(newPersonnel);
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
}
