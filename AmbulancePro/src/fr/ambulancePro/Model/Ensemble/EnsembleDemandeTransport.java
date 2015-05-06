package fr.ambulancePro.Model.Ensemble;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.DemandeTransport.DemandeTransportDao;
import fr.ambulancePro.DAO.Etablissement.EtablissementDao;
import fr.ambulancePro.Model.DemandeTransport;
import fr.ambulancePro.Model.EtablissementSante;
import fr.ambulancePro.Model.Personnel;

public class EnsembleDemandeTransport {
	
	private ArrayList<DemandeTransport> _demandeTransports = new ArrayList<DemandeTransport>();
	
	/*
	 * DAO
	 */
	private DemandeTransportDao _dao;
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";
	
	public EnsembleDemandeTransport(ServletContext context) {
		this._dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getDemandeTransportDao();
	}
	
	public EnsembleDemandeTransport() {
		// TODO Auto-generated constructor stub
		_demandeTransports = new ArrayList<DemandeTransport>();
	}
	
	public void addDemandeTransport(DemandeTransport d) {
		this._demandeTransports.add(d);
	}
	
	public void creerDemandeTransport(DemandeTransport d){
		this._demandeTransports.add(d);
		this._dao.creer(d);
	}
	
	public ArrayList<DemandeTransport> getDemandeTransports(){
		return this._demandeTransports;
	}
	
	public DemandeTransport getDemandeByID(String id){
		DemandeTransport demande = null;
		boolean found = false;
		int index = 0;
		while(!found && index < _demandeTransports.size() ){
			found = (this._demandeTransports.get(index).getIdDemandeTransport().equals(id));
			index++;
		}
		//System.out.println(found);
		if (found) {
			demande = _demandeTransports.get(index-1);
		}			
		return demande;
	}
	
	public boolean isEmpty(){
		return this._demandeTransports.isEmpty();
	}
	
	public void remplir(){
		this._demandeTransports = this._dao.listeDemandeTransport().getDemandeTransports();
	}
	
}
