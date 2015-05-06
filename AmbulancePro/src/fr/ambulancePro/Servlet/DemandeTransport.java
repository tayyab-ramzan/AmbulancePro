package fr.ambulancePro.Servlet;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.DemandeTransport.DemandeTransportDao;
import fr.ambulancePro.DAO.Etablissement.EtablissementDao;
import fr.ambulancePro.Model.Adresse;
import fr.ambulancePro.Model.Malade;
import fr.ambulancePro.Model.Ensemble.EnsembleDemandeTransport;
import fr.ambulancePro.Model.Ensemble.EnsembleEtablissement;
import fr.ambulancePro.Model.Ensemble.EnsemblePersonnel;

@Controller
public class DemandeTransport{
	
	//Le Model
	private EnsembleDemandeTransport _demandes;
	private EnsembleEtablissement _etablissements;
	
	@Autowired
	private ServletContext context;
	
	//HashMap pour les donn�es re�u pour un renvoi eventuel
	Map<String,Object> data =  new HashMap<String, Object>();
	//HashMap pour les erreurs
	Map<String, Object> errors = new HashMap<String, Object>();

	@RequestMapping("creer_demande")
	public ModelAndView saisirDemandeTransport(){
		errors.clear();
		data.clear();
		
		this._etablissements = new EnsembleEtablissement(context);
		this._etablissements.remplir();
		data.put("etablissements", this._etablissements.getEtablissements());
		return new ModelAndView("demande_transport/creer_demande", "data", data);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "creer_demande")
	public ModelAndView validerData(@RequestParam("etablissement") String etablissement,
									@RequestParam("date") String date,
									@RequestParam("hour") String heure,
									@RequestParam("min") String min,
									@RequestParam("num_dep")String numDep,
									@RequestParam("nom_rue_dep") String nomRueDep,
									@RequestParam("code_postal_dep")String codePostalDep,
									@RequestParam("ville_dep")String villeDep,
									@RequestParam("num_fin")String numFin,
									@RequestParam("nom_rue_fin") String nomRueFin,
									@RequestParam("code_postal_fin")String codePostalFin,
									@RequestParam("ville_fin")String villeFin,
									@RequestParam("nom_malade") String nom_malade,
									@RequestParam("prenom_malade") String prenom_malade,
									@RequestParam("num_malade")String numMalade,
									@RequestParam("nom_rue_malade") String nomRueMalade,
									@RequestParam("code_postal_malade")String codePostalMalade,
									@RequestParam("ville_malade")String villeMalade){

		data.put("etablissement", etablissement);
		data.put("date", date);
		data.put("hour", heure);
		data.put("min", min);
		data.put("num_dep", numDep);
		data.put("nom_rue_dep",nomRueDep);
		data.put("code_postal_dep", codePostalDep);
		data.put("ville_dep", villeDep);
		data.put("num_fin", numFin);
		data.put("nom_rue_fin",nomRueFin);
		data.put("code_postal_fin", codePostalFin);
		data.put("ville_fin", villeFin);
		data.put("nom_malade",nom_malade);
		data.put("prenom_malade",prenom_malade);
		data.put("num_malade", numMalade);
		data.put("nom_rue_malade",nomRueMalade);
		data.put("code_postal_malade", codePostalMalade);
		data.put("ville_malade", villeMalade);
		
		errors.clear();
		
		if (etablissement.isEmpty()) {
			errors.put("etablissement", "Veuillez choisir un Etablissement parmis la liste");
		}
		
		if (date.isEmpty()) {
			errors.put("date", "Veuillez donner une date pour la demande de transport");
		}
		
		if (heure.isEmpty() || min.isEmpty()) {
			errors.put("time", "Veuillez renseigner une heure pour la demande de transport");
		}
		
		if (!validationAdresse(nomRueDep) || numDep.isEmpty() || codePostalDep.isEmpty() || villeDep.isEmpty()){
			errors.put("adresse_dep", "L'adresse de départ n'est pas valide");
		}
		
		if (!validationAdresse(nomRueFin) || numFin.isEmpty() || codePostalFin.isEmpty() || villeFin.isEmpty()){
			errors.put("adresse_fin", "L'adresse de fin n'est pas valide");
		}
		
		if (nom_malade.isEmpty()) {
			errors.put("nom_malade", "Veuillez saisir le nom du malade");
		}
		
		if (prenom_malade.isEmpty()) {
			errors.put("prenom_malade", "Veuillez saisir le prénom du malade");
		}
		
		if (!validationAdresse(nomRueMalade) || numMalade.isEmpty() || codePostalMalade.isEmpty() || villeMalade.isEmpty()){
			errors.put("adresse_malade", "L'adresse du malade n'est pas valide");
		}
		
		if (!errors.isEmpty()) {
			data.put("errors", errors);
			return new ModelAndView("demande_transport/creer_demande", "data", data);
		}else{
			//Conversion de la date
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			try {
				Date date2 = formatter.parse(date);
				Time time = Time.valueOf(heure + ":" + min + ":" + "00");
				
				Adresse adresseDep = new Adresse(Integer.parseInt(numDep), nomRueDep, codePostalDep, villeDep);
				Adresse adresseFin = new Adresse(Integer.parseInt(numFin), nomRueFin, codePostalFin, villeFin);
				Adresse adresseMalade = new Adresse(Integer.parseInt(numMalade), nomRueMalade, codePostalMalade, villeMalade);
				
				Malade malade = new Malade(nom_malade, prenom_malade, adresseMalade);
				fr.ambulancePro.Model.DemandeTransport demande = new fr.ambulancePro.Model.DemandeTransport(date2, time, adresseDep, adresseFin, malade, this._etablissements.getEtablissementByID(etablissement));
				this._demandes.creerDemandeTransport(demande);
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ModelAndView("redirect:demande_transport.html");
		}		
	}
	
	@RequestMapping("demande_transport")
	public ModelAndView listeDemandeTransport(){
		errors.clear();
		data.clear();
		
		this._demandes = new EnsembleDemandeTransport(context);
		this._demandes.remplir();
		data.put("demandes", this._demandes.getDemandeTransports());
		return new ModelAndView("demande_transport/demande_transport", "data", data);
	}
	
	@RequestMapping("traiter_demande")
	public ModelAndView traiterDemande (@RequestParam("id") String id){
		
		fr.ambulancePro.Model.DemandeTransport demande = this._demandes.getDemandeByID(id);
		data.put("demande", demande);
		/*this.demandeDao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getDemandeTransportDao();
		fr.ambulancePro.Model.DemandeTransport demande = demandeDao.trouver(id);
		errors.clear();
		data.clear();
		data.put("demande", demande);*/
		return new ModelAndView("demande_transport/traiter_demande","data",data);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "traiterDemande")
	public ModelAndView validerDemande (){
		return new ModelAndView("traiterDemande");
	}
	
	private boolean validationAdresse(String adresse){
		if ( adresse != null && adresse.length() < 3 ) {
	        return false;
	    }
	    return true;
	}
	
}
