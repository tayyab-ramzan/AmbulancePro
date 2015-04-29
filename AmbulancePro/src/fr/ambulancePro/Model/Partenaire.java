package fr.ambulancePro.Model;

public class Partenaire {
	
	private String _idPartenaire;
	private String _nomPartenaire;
	private String _adressePartenaire;
	private String _mailPartenaire;
	private String _telPartenaire;
	
	public Partenaire(String nomPartenaire, String adressePartenaire,String mailPartenaire, String telPartenaire) {
		this._nomPartenaire = nomPartenaire;
		this._adressePartenaire = adressePartenaire;
		this._mailPartenaire = mailPartenaire;
		this._telPartenaire = telPartenaire;
	}
	
	public Partenaire(String idPartenaire, String nomPartenaire, String adressePartenaire,String mailPartenaire, String telPartenaire) {
		this._idPartenaire = idPartenaire;
		this._nomPartenaire = nomPartenaire;
		this._adressePartenaire = adressePartenaire;
		this._mailPartenaire = mailPartenaire;
		this._telPartenaire = telPartenaire;
	}
		
	public String get_idPartenaire() {
		return this._idPartenaire;
	}

	public void set_idPartenaire(String _idPartenaire) {
		this._idPartenaire = _idPartenaire;
	}

	public String getNomPartenaire() {
		return this._nomPartenaire;
	}
	
	public void setNomPartenaire(String nomPartenaire) {
		this._nomPartenaire = nomPartenaire;
	}
	
	public String getAdressePartenaire() {
		return this._adressePartenaire;
	}
	
	public void setAdressePartenaire(String adressePartenaire) {
		this._adressePartenaire = adressePartenaire;
	}
	
	public String getMailPartenaire() {
		return this._mailPartenaire;
	}
	
	public void setMailPartenaire(String mailPartenaire) {
		this._mailPartenaire = mailPartenaire;
	}
	
	public String getTelPartenaire() {
		return this._telPartenaire;
	}
	
	public void setTelPartenaire(String telPartenaire) {
		this._telPartenaire = telPartenaire;
	}
}
