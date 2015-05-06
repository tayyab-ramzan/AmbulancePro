package fr.ambulancePro.Model.Ensemble;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Etablissement.EtablissementDao;
import fr.ambulancePro.Model.EtablissementSante;
import fr.ambulancePro.Model.Personnel;

public class EnsembleEtablissement {
	
	private ArrayList<EtablissementSante> _etablissements = new ArrayList<EtablissementSante>();
	
	/*
	 * DAO
	 */
	private EtablissementDao _dao;
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";
	
	public EnsembleEtablissement(ServletContext context) {
		this._dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getEtablissementDao();
	}
	
	public EnsembleEtablissement() {
		// TODO Auto-generated constructor stub
		_etablissements = new ArrayList<EtablissementSante>();
	}
	
	public void addEtablissement(EtablissementSante e) {
		this._etablissements.add(e);
	}
	
	public void creerEtablissement(EtablissementSante e){
		this._etablissements.add(e);
		this._dao.creer(e);
	}
	
	public ArrayList<EtablissementSante> getEtablissements(){
		return this._etablissements;
	}
	
	public EtablissementSante getEtablissementByID(String id){
		EtablissementSante etablissement = null;
		boolean found = false;
		int index = 0;
		while(!found && index < _etablissements.size() ){
			found = (this._etablissements.get(index).getIdEtablissement().equals(id));
			index++;
		}
		//System.out.println(found);
		if (found) {
			etablissement = _etablissements.get(index-1);
		}			
		return etablissement;
	}
	
	public boolean isEmpty(){
		return this._etablissements.isEmpty();
	}
	
	public void remplir(){
		this._etablissements = this._dao.recupererEnsemble().getEtablissements();
	}
	
}
