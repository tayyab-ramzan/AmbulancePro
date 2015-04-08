package fr.ambulancePro.Servlet;

import java.sql.ResultSet;
import java.sql.SQLException;
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

import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.DemandeTransportDao;
import fr.ambulancePro.DAO.EtablissementDao;
import fr.ambulancePro.Model.Connexion;
import fr.ambulancePro.Model.EtablissementSante;
import fr.ambulancePro.Model.Malade;

@Controller
public class DemandeTransport {
	
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";
	
	private EtablissementDao dao;
	private DemandeTransportDao demandeDao;
	
	@Autowired
	private ServletContext context;
	
	//HashMap pour contenir l'ensembles de données et erreurs
	Map<String, Map<String, Object>> dataErrorMap = new HashMap<String, Map<String,Object>>();
	//HashMap pour les données reçu pour un renvoi eventuel
	Map<String,Object> data =  new HashMap<String, Object>();
	//HashMap pour les erreurs
	Map<String, Object> errors = new HashMap<String, Object>();

	@RequestMapping("demandeTransport")
	public ModelAndView saisirDemandeTransport(){
		errors.clear();
		data.clear();
		this.dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getEtablissementDao();
		this.demandeDao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getDemandeTransportDao();
		ArrayList<EtablissementSante> etablissements = new ArrayList<EtablissementSante>();
		etablissements = this.dao.recupererEnsemble();
		data.put("etablissements", etablissements);
		dataErrorMap.put("data",data);
		return new ModelAndView("demandeTransport", "dataErrors", dataErrorMap);
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
		System.out.println(etablissement);
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
		
		if (etablissement == "") {
			errors.put("etablissement", "Veuillez choisir un établissement parmis la liste");
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
				fr.ambulancePro.Model.DemandeTransport demande = new fr.ambulancePro.Model.DemandeTransport(date2, time, adresse_deb, adresse_fin, malade, Integer.parseInt(etablissement));
				demandeDao.creer(demande, malade);
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return listeDemandeTransport();
		}		
	}
	
	@RequestMapping("listeDemandeTransport")
	public ModelAndView listeDemandeTransport(){
		errors.clear();
		data.clear();
		this.dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getEtablissementDao();
		this.demandeDao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getDemandeTransportDao();
		ArrayList<fr.ambulancePro.Model.DemandeTransport> demandes = new ArrayList<fr.ambulancePro.Model.DemandeTransport>();
		demandes = this.demandeDao.listeDemandeTransport();
		data.put("demandes", demandes);
		dataErrorMap.put("data",data);
		return new ModelAndView("listeDemandeTransport", "dataErrors", dataErrorMap);
	}
	
}
