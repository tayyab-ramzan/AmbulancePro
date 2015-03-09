package fr.ambulancePro.Model;

import java.util.ArrayList;

public class EnsembleEtablissement {
	
	private ArrayList<EtablissementSante> etablissements;
	
	public EnsembleEtablissement() {
		// TODO Auto-generated constructor stub
		etablissements = new ArrayList<EtablissementSante>();
	}
	
	public void addEtablissement(EtablissementSante e) {
		this.etablissements.add(e);
	}
	
	public ArrayList<EtablissementSante> getEtablissements(){
		return etablissements;
	}
}
