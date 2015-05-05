package fr.ambulancePro.Model.Ensemble;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Appareil.AppareilDao;
import fr.ambulancePro.DAO.Vehicule.VehiculeDao;
import fr.ambulancePro.Model.Appareil;
import fr.ambulancePro.Model.Vehicule;

public class EnsembleAppareil {
	
private ArrayList<Appareil> _appareils = new ArrayList<Appareil>();
	
	private AppareilDao _dao;
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";
	
	public EnsembleAppareil(ArrayList<Appareil> _appareil) {
		this._appareils = _appareil;
	}
	
	public EnsembleAppareil(ServletContext context) {
		this._dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getAppareilDAO();
	}
	
	public EnsembleAppareil() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Appareil> getAppareils() {
		return _appareils;
	}

	public void setAppareils(ArrayList<Appareil> _appareils) {
		this._appareils = _appareils;
	}
	
	public void addAppareil(Appareil a){
		this._appareils.add(a);
	}
	
	public void remplir(){
		this._appareils = this._dao.recupererEnsemble().getAppareils();
	}
	
	public void creerAppareil(Appareil a){
		this._appareils.add(a);
		this._dao.creer(a);
	}
	
}
