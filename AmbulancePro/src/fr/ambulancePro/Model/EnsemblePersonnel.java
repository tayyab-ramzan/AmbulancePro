package fr.ambulancePro.Model;

import java.util.ArrayList;

public class EnsemblePersonnel {
	
	private ArrayList<Personnel> _personnels = new ArrayList<Personnel>();

	public EnsemblePersonnel(ArrayList<Personnel> personnels) {
		this._personnels = personnels;
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
	
}
