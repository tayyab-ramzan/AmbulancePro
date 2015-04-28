package fr.ambulancePro.Model;

import java.util.ArrayList;

public class EnsembleEtablissement {
	
	private ArrayList<EtablissementSante> _etablissements;
	
	public EnsembleEtablissement() {
		// TODO Auto-generated constructor stub
		_etablissements = new ArrayList<EtablissementSante>();
	}
	
	public void addEtablissement(EtablissementSante e) {
		this._etablissements.add(e);
	}
	
	public ArrayList<EtablissementSante> getEtablissements(){
		return _etablissements;
	}
}
