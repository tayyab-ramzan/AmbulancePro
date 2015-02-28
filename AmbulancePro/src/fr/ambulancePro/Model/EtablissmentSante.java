package fr.ambulancePro.Model;

public class EtablissmentSante {
	
	private String NomEtablissment;
	private String AdresseEtablissment;
	private String MailEtablissment;
	private String TelEtablissment;	
	
	public EtablissmentSante(String nomEtablissment,
			String adresseEtablissment, String mailEtablissment,
			String telEtablissment) {
		super();
		NomEtablissment = nomEtablissment;
		AdresseEtablissment = adresseEtablissment;
		MailEtablissment = mailEtablissment;
		TelEtablissment = telEtablissment;
	}
	public String getNomEtablissment() {
		return NomEtablissment;
	}
	public void setNomEtablissment(String nomEtablissment) {
		NomEtablissment = nomEtablissment;
	}
	public String getAdresseEtablissment() {
		return AdresseEtablissment;
	}
	public void setAdresseEtablissment(String adresseEtablissment) {
		AdresseEtablissment = adresseEtablissment;
	}
	public String getMailEtablissment() {
		return MailEtablissment;
	}
	public void setMailEtablissment(String mailEtablissment) {
		MailEtablissment = mailEtablissment;
	}
	public String getTelEtablissment() {
		return TelEtablissment;
	}
	public void setTelEtablissment(String telEtablissment) {
		TelEtablissment = telEtablissment;
	}
	
	

}
