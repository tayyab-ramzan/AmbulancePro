package fr.ambulancePro.Model.Ensemble;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Vehicule.VehiculeDao;
import fr.ambulancePro.Model.Personnel;
import fr.ambulancePro.Model.Vehicule;

public class EnsembleVehicule {
	
	private ArrayList<Vehicule> _vehicules = new ArrayList<Vehicule>();
	
	private VehiculeDao _dao;
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";
	
	public EnsembleVehicule(ArrayList<Vehicule> vehicules) {
		this._vehicules = vehicules;
	}
	
	public EnsembleVehicule(ServletContext context) {
		this._dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getVehiculeDAO();
	}
	
	public EnsembleVehicule() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Vehicule> getVehicules() {
		return _vehicules;
	}

	public void setVehicules(ArrayList<Vehicule> _vehicules) {
		this._vehicules = _vehicules;
	}
	
	public void addVehicule(Vehicule v){
		this._vehicules.add(v);
	}
	
	public void remplir(){
		this._vehicules = this._dao.recupererEnsemble().getVehicules();
	}
	
	public void creerPersonnel(Vehicule v){
		this._vehicules.add(v);
		this._dao.creer(v);
	}
}	
