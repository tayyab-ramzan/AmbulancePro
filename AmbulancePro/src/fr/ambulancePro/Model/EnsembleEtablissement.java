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
	
}
