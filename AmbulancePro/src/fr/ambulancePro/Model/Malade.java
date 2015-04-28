package fr.ambulancePro.Model;

public class Malade {
	
	private int _idMalade;
	private String _nomMalade;
	private String _prenomMalade;
	private String _adresseMalade;
	
	
	public Malade(String nomMalade, String prenomMalade, String adresseMalade) {
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


	public int getIdMalade() {
		return _idMalade;
	}


	public void setIdMalade(int idMalade) {
		this._idMalade = idMalade;
	}


	public String getPrenomMalade() {
		return _prenomMalade;
	}


	public void setPrenomMalade(String prenomMalade) {
		_prenomMalade = prenomMalade;
	}


	public String getAdresseMalade() {
		return _adresseMalade;
	}


	public void setAdresseMalade(String adresseMalade) {
		_adresseMalade = adresseMalade;
	}
}
