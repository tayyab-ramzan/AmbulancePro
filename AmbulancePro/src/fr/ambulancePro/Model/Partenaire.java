package fr.ambulancePro.Model;

public class Partenaire {
	
	private String NomPartenaire;
	private String AdressePartenaire;
	private String MailPartenaire;
	private String TelPartenaire;
	
	
	public Partenaire(String nomPartenaire, String adressePartenaire,
			String mailPartenaire, String telPartenaire) {
		super();
		NomPartenaire = nomPartenaire;
		AdressePartenaire = adressePartenaire;
		MailPartenaire = mailPartenaire;
		TelPartenaire = telPartenaire;
	}
	public String getNomPartenaire() {
		return NomPartenaire;
	}
	public void setNomPartenaire(String nomPartenaire) {
		NomPartenaire = nomPartenaire;
	}
	public String getAdressePartenaire() {
		return AdressePartenaire;
	}
	public void setAdressePartenaire(String adressePartenaire) {
		AdressePartenaire = adressePartenaire;
	}
	public String getMailPartenaire() {
		return MailPartenaire;
	}
	public void setMailPartenaire(String mailPartenaire) {
		MailPartenaire = mailPartenaire;
	}
	public String getTelPartenaire() {
		return TelPartenaire;
	}
	public void setTelPartenaire(String telPartenaire) {
		TelPartenaire = telPartenaire;
	}
	

}
