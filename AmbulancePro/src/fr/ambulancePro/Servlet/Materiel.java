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

import fr.ambulancePro.Model.Ensemble.EnsembleAppareil;
import fr.ambulancePro.Model.Ensemble.EnsemblePersonnel;
import fr.ambulancePro.Model.Ensemble.EnsembleVehicule;

@Controller
public class Materiel {
	
	@Autowired
	private ServletContext _context;
	
	private EnsembleVehicule _vehicules;
	private EnsembleAppareil _appareils;
	
	@RequestMapping(method = RequestMethod.GET, value = "materiel")
	public ModelAndView materiel(@RequestParam("mat")String mat){
		
		if (this._appareils == null && this._vehicules==null) {
			this._vehicules = new EnsembleVehicule(this._context);
			this._vehicules.remplir();
			
			this._appareils = new EnsembleAppareil(this._context);
			this._appareils.remplir();
		}
		
		Map<String,Object> data =  new HashMap<String, Object>();
		data.put("MAT", mat);
		
		switch (mat) {
		case "VEHICULE":
			data.put("vehicules", this._vehicules.getVehicules());
			break;
		case "APPAREIL":
			data.put("appareils", this._appareils.getAppareils());
			break;
		default:
			break;
		}
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
	
	/*
	 * 
	 */
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
			this._vehicules.creerVehicule(newVehicule);
			return new ModelAndView("redirect:materiel.html?mat=VEHICULE","data",data);
		}
	}
	
	/*
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value =  "ajouter_appareil")
	public ModelAndView ajouterAppareil(@RequestParam("nom")String nom,
										@RequestParam("qty_total")int qty_total,
										@RequestParam("cout_supp")float cout_supp){
		Map<String,Object> data =  new HashMap<String, Object>();
		Map<String,Object> errors =  new HashMap<String, Object>();
		
		data.put("MAT", "VEHICULE");
		data.put("nom", nom);
		data.put("qty_total", qty_total);
		data.put("cout_supp", cout_supp);
		
		if (nom.isEmpty()) {
			errors.put("nom", "Vueillez saisir le nom de l'appareil.");
		}
		
		if (qty_total == 0) {
			errors.put("qty_total", "Vueillez saisir la quantité total disponible.");
		}
		
		if (cout_supp == 0) {
			errors.put("cout_supp", "Vueillez saisir le côut supplementaire de l'appareil.");
		}
		
		if (!errors.isEmpty()) {
			data.put("errors",errors);
			return new ModelAndView("materiel/ajouter_appareil", "data", data);
		}else{
			fr.ambulancePro.Model.Appareil newAppareil = new fr.ambulancePro.Model.Appareil(nom,qty_total,qty_total,cout_supp);
			this._appareils.creerAppareil(newAppareil);
			return new ModelAndView("redirect:materiel.html?mat=APPAREIL","data",data);
		}
	}
}
