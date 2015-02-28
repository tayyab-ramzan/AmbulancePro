package fr.ambulancePro.Model;

public class Malade {
	
	
	private String NomMalade;
	private String PrenomMalade;
	private String AdresseMalade;
	
	
	public Malade(String nomMalade, String prenomMalade, String adresseMalade) {
		super();
		NomMalade = nomMalade;
		PrenomMalade = prenomMalade;
		AdresseMalade = adresseMalade;
	}


	public String getNomMalade() {
		return NomMalade;
	}


	public void setNomMalade(String nomMalade) {
		NomMalade = nomMalade;
	}


	public String getPrenomMalade() {
		return PrenomMalade;
	}


	public void setPrenomMalade(String prenomMalade) {
		PrenomMalade = prenomMalade;
	}


	public String getAdresseMalade() {
		return AdresseMalade;
	}


	public void setAdresseMalade(String adresseMalade) {
		AdresseMalade = adresseMalade;
	}

}
