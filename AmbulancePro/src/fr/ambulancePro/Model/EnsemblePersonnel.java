package fr.ambulancePro.Model;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Personnel.PersonnelDAO;

public class EnsemblePersonnel {
	
	private ArrayList<Personnel> _personnels = new ArrayList<Personnel>();
	
	/*
	   *DAO pour le personnel 
	   */
	private PersonnelDAO _dao;
	public static final String CONF_DAO_FACTORY = "DAOFACTORY";

	public EnsemblePersonnel(ArrayList<Personnel> personnels) {
		this._personnels = personnels;
	}
	
	public EnsemblePersonnel(ServletContext context) {
		this._dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getPersonnelDAO();
	}
	
	public EnsemblePersonnel() {
		// TODO Auto-generated constructor stub
	}
	
	public void addPersonnel(Personnel p){
		this._personnels.add(p);
	}
	
	public void creerPersonnel(Personnel p){
		this._personnels.add(p);
		this._dao.creer(p);
	}

	public ArrayList<Personnel> getPersonnels() {
		return _personnels;
	}

	public void setPersonnels(ArrayList<Personnel> personnels) {
		this._personnels = personnels;
	}
	
	public boolean isIn(Personnel p){
		return _personnels.contains(p);
	}
	
	public Personnel getPersonnel(String login, String password){
		Personnel personnel = null;
		boolean found = false;
		int index = 0;
		while(!found && index < this._personnels.size() ){
			found = (this._personnels.get(index).getLoginPersonnel().equals(login) && this._personnels.get(index).getMdpPersonnel().equals(password));
			index++;
		}
		//System.out.println(found);
		if (found) {
			personnel = this._personnels.get(index-1);
		}			
		return personnel;
	}
	
	public void remplir(){
		this._personnels = this._dao.recupererEnsemblePersonnel().getPersonnels();
	}
	
	public ArrayList<Personnel> getByRole(String role){
		ArrayList<Personnel> membres = new ArrayList<Personnel>();
		
		for (int i = 0; i < this._personnels.size(); i++) {
			if (this._personnels.get(i).getStrategie().get_intituleRole().equals(role)) {
				membres.add(this._personnels.get(i));
			}
		}
		return membres;
	}
	
	public boolean isEmpty(){
		return this._personnels.isEmpty();
	}
	
}
