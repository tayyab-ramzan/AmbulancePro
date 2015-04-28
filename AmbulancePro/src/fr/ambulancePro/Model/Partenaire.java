package fr.ambulancePro.Model;

public class Partenaire {
	
	private String _nomPartenaire;
	private String _adressePartenaire;
	private String _mailPartenaire;
	private String _telPartenaire;
	
	public Partenaire(String nomPartenaire, String adressePartenaire,String mailPartenaire, String telPartenaire) {
		_nomPartenaire = nomPartenaire;
		_adressePartenaire = adressePartenaire;
		_mailPartenaire = mailPartenaire;
		_telPartenaire = telPartenaire;
	}
	
	public String getNomPartenaire() {
		return _nomPartenaire;
	}
	
	public void setNomPartenaire(String nomPartenaire) {
		_nomPartenaire = nomPartenaire;
	}
	
	public String getAdressePartenaire() {
		return _adressePartenaire;
	}
	
	public void setAdressePartenaire(String adressePartenaire) {
		_adressePartenaire = adressePartenaire;
	}
	
	public String getMailPartenaire() {
		return _mailPartenaire;
	}
	
	public void setMailPartenaire(String mailPartenaire) {
		_mailPartenaire = mailPartenaire;
	}
	
	public String getTelPartenaire() {
		return _telPartenaire;
	}
	
	public void setTelPartenaire(String telPartenaire) {
		_telPartenaire = telPartenaire;
	}
}
