package fr.ambulancePro.Model.Ensemble;

import java.util.ArrayList;

import fr.ambulancePro.Model.Appareil;

public class EnsembleAppareil {
	
	private ArrayList<Appareil> _appareils = new ArrayList<Appareil>();

	public ArrayList<Appareil> getAppareils() {
		return _appareils;
	}

	public void setAppareils(ArrayList<Appareil> _appareils) {
		this._appareils = _appareils;
	}
	
	public void addAppareil(Appareil a){
		this._appareils.add(a);
	}
	
}
