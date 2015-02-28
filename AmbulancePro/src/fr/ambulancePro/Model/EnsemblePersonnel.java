package fr.ambulancePro.Model;

import java.util.ArrayList;

public class EnsemblePersonnel {
	
	private ArrayList<Personnel> personnels = new ArrayList<Personnel>();

	public EnsemblePersonnel(ArrayList<Personnel> personnels) {
		super();
		this.personnels = personnels;
	}

	public ArrayList<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(ArrayList<Personnel> personnels) {
		this.personnels = personnels;
	}
	
	public boolean isIn(Personnel p){
		return personnels.contains(p);
	}
	
}
