package fr.ambulancePro.Servlet;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.ambulancePro.Model.Connexion;

@Controller
public class DemandeTransport {

	@RequestMapping("demandeTransport")
	public ModelAndView saisirDemandeTransport(){
		
		Connexion con = Connexion.getConnexion();
		
		String message = "<br><div align='center'>"
				+ "<h3>Formulaire de demande de Transport<br><br>";
		return new ModelAndView("demandeTransport", "message", message);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "demandeTransport")
	public ModelAndView validerData(@RequestParam("etablissement") String etablissement,
									@RequestParam("date") String date,
									@RequestParam("hour") String heure,
									@RequestParam("min") String min,
									@RequestParam("adresse_deb") String adresse_deb,
									@RequestParam("adresse_fin") String adresse_fin,
									@RequestParam("nom_malade") String nom_malade,
									@RequestParam("prenom_malade") String prenom_malade,
									@RequestParam("adresse_malade") String adresse_malade){
		
		System.out.println(date);
		Connexion con = Connexion.getConnexion();
		
		Map<String, String> data = new HashMap<String, String>();
		
	
		data.put("Nom", "Le nom n'est pas correct");
		
		System.out.println(data.get("Nom"));
		
		String message = "<br><div align='center'>"
				+ "<h3>Traitement de Données<br><br>";
		return new ModelAndView("demandeTransport", "message", message);
	}
}
