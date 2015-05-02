package fr.ambulancePro.Model;

import java.util.ArrayList;

public class EnsemblePersonnel {
	
	private ArrayList<Personnel> _personnels = new ArrayList<Personnel>();

	public EnsemblePersonnel(ArrayList<Personnel> personnels) {
		this._personnels = personnels;
	}
	
	public EnsemblePersonnel() {
		
	}
	
	public void addPersonnel(Personnel p){
		this._personnels.add(p);
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
	
	public boolean isEmpty(){
		return this._personnels.isEmpty();
	}
	
}
