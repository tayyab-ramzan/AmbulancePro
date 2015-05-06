package fr.ambulancePro.Model;

public class Malade {
	
	private String _idMalade;
	private String _nomMalade;
	private String _prenomMalade;
	private Adresse _adresseMalade;
	
	public Malade() {
		// TODO Auto-generated constructor stub
	}
	
	public Malade(String nomMalade, String prenomMalade, Adresse adresseMalade) {
		_nomMalade = nomMalade;
		_prenomMalade = prenomMalade;
		_adresseMalade = adresseMalade;
	}

	public String getNomMalade() {
		return _nomMalade;
	}

	public void setNomMalade(String nomMalade) {
		_nomMalade = nomMalade;
	}

	public String getIdMalade() {
		return _idMalade;
	}

	public void setIdMalade(String idMalade) {
		this._idMalade = idMalade;
	}

	public String getPrenomMalade() {
		return _prenomMalade;
	}

	public void setPrenomMalade(String prenomMalade) {
		_prenomMalade = prenomMalade;
	}

	public Adresse getAdresseMalade() {
		return _adresseMalade;
	}

	public void setAdresseMalade(Adresse adresseMalade) {
		_adresseMalade = adresseMalade;
	}
}
