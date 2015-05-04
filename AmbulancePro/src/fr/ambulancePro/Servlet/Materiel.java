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

import fr.ambulancePro.Model.Ensemble.EnsemblePersonnel;
import fr.ambulancePro.Model.Ensemble.EnsembleVehicule;

@Controller
public class Materiel {
	
	@Autowired
	private ServletContext _context;
	private EnsembleVehicule _vehicules;
	
	@RequestMapping(method = RequestMethod.GET, value = "materiel")
	public ModelAndView materiel(@RequestParam("mat")String mat){
		this._vehicules = new EnsembleVehicule(this._context);
		this._vehicules.remplir();
		
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("MAT", mat);
		data.put("vehicules", this._vehicules.getVehicules());
		return new ModelAndView("materiel/materiel","data",data);
	}
	
	@RequestMapping("ajouter_appareil")
	public ModelAndView ajouterAppareil(){
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("MAT", "APPAREIL");
		return new ModelAndView("materiel/ajouter_appareil","data",data);
	}
	
	@RequestMapping("ajouter_vehicule")
	public ModelAndView ajouterVehicule(){
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("MAT", "VEHICULE");
		return new ModelAndView("materiel/ajouter_vehicule","data",data);
	}
	
	@RequestMapping(method = RequestMethod.POST, value =  "ajouter_vehicule")
	public ModelAndView ajouterVehicule(@RequestParam("immatricule")String immatricule){
		Map<String,Object> data =  new HashMap<String, Object>();
		Map<String,Object> errors =  new HashMap<String, Object>();
		
		data.put("MAT", "VEHICULE");
		data.put("immatricule", immatricule);
		if (immatricule.isEmpty()) {
			errors.put("immatricule", "Vueillez saisir le numéro d'immatriculation");
		}
		
		if (!errors.isEmpty()) {
			data.put("errors",errors);
			return new ModelAndView("materiel/ajouter_vehicule", "data", data);
		}else{
			fr.ambulancePro.Model.Vehicule newVehicule = new fr.ambulancePro.Model.Vehicule(immatricule);
			this._vehicules.creerPersonnel(newVehicule);
			return new ModelAndView("redirect:materiel.html?mat=VEHICULE","data",data);
		}
		
		
		
	}
}
