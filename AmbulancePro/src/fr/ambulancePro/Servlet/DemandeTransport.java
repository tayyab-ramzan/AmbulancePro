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
import fr.ambulancePro.Model.Malade;
import fr.ambulancePro.Model.Ensemble.EnsembleEtablissement;

@Controller
public class DemandeTransport {
	
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";
	
	private EtablissementDao daoEtablissement;
	private DemandeTransportDao demandeDao;
	
	//Le Model
	private EnsembleEtablissement _etablissements = new EnsembleEtablissement();
	
	@Autowired
	private ServletContext context;
	
	//HashMap pour contenir l'ensembles de donn�es et erreurs
	Map<String, Map<String, Object>> dataErrorMap = new HashMap<String, Map<String,Object>>();
	//HashMap pour les donn�es re�u pour un renvoi eventuel
	Map<String,Object> data =  new HashMap<String, Object>();
	//HashMap pour les erreurs
	Map<String, Object> errors = new HashMap<String, Object>();

	@RequestMapping("creer_demande")
	public ModelAndView saisirDemandeTransport(){
		errors.clear();
		data.clear();
		
		this.daoEtablissement = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getEtablissementDao();
		this.demandeDao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getDemandeTransportDao();
		
		_etablissements = this.daoEtablissement.recupererEnsemble();
		data.put("etablissements", _etablissements.getEtablissements());
		dataErrorMap.put("data",data);
		return new ModelAndView("demande_transport/creer_demande", "dataErrors", dataErrorMap);
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
		//System.out.println(etablissement);
		data.put("etablissement", etablissement);
		data.put("date", date);
		data.put("hour", heure);
		data.put("min", min);
		data.put("adresse_deb",adresse_deb);
		data.put("adresse_fin",adresse_fin);
		data.put("nom_malade",nom_malade);
		data.put("prenom_malade",prenom_malade);
		data.put("adresse_malade", adresse_malade);
		
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
		
		if (adresse_deb.isEmpty()) {
			errors.put("adresse_deb", "Veuillez saisir une adresse de début");
		}
		
		if (adresse_fin.isEmpty()) {
			errors.put("adresse_fin", "Veuillez saisir une adresse de fin");
		}
		
		if (nom_malade.isEmpty()) {
			errors.put("nom_malade", "Veuillez saisir le nom du malade");
		}
		
		if (prenom_malade.isEmpty()) {
			errors.put("prenom_malade", "Veuillez saisir le prénom du malade");
		}
		
		if (adresse_malade.isEmpty()) {
			errors.put("adresse_malade", "Veuillez saisir l'adresse du malade");
		}
		
		if (!errors.isEmpty()) {
			dataErrorMap.put("errors", errors);
			return new ModelAndView("demandeTransport", "dataErrors", dataErrorMap);
		}else{
			//Conversion de la date
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			try {
				Date date2 = formatter.parse(date);
				Time time = Time.valueOf(heure + ":" + min + ":" + "00");
				
				Malade malade = new Malade(nom_malade, prenom_malade, adresse_malade);
				fr.ambulancePro.Model.DemandeTransport demande = new fr.ambulancePro.Model.DemandeTransport(date2, time, adresse_deb, adresse_fin, malade, this._etablissements.getEtablissementByID(etablissement));
				demandeDao.creer(demande, malade);
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listeDemandeTransport();
		}		
	}
	
	@RequestMapping("demande_transport")
	public ModelAndView listeDemandeTransport(){
		errors.clear();
		data.clear();
		this.daoEtablissement = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getEtablissementDao();
		this.demandeDao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getDemandeTransportDao();
		ArrayList<fr.ambulancePro.Model.DemandeTransport> demandes = new ArrayList<fr.ambulancePro.Model.DemandeTransport>();
		demandes = this.demandeDao.listeDemandeTransport();
		data.put("demandes", demandes);
		dataErrorMap.put("data",data);
		return new ModelAndView("demande_transport/demande_transport", "dataErrors", dataErrorMap);
	}
	
	@RequestMapping("traiter_demande")
	public ModelAndView traiterDemande (@RequestParam("id") String id){
		
		this.demandeDao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getDemandeTransportDao();
		fr.ambulancePro.Model.DemandeTransport demande = demandeDao.trouver(id);
		errors.clear();
		data.clear();
		data.put("demande", demande);
		return new ModelAndView("traiter_demande","data",data);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "traiterDemande")
	public ModelAndView validerDemande (){
		return new ModelAndView("traiterDemande");
	}
	
}
