package fr.ambulancePro.Model;

public class EtablissementSante {
	
	private int idEtablissement;
	
	private String NomEtablissement;
	private String AdresseEtablissment;
	private String MailEtablissment;
	private String TelEtablissment;	
	
	public EtablissementSante() {
		// TODO Auto-generated constructor stub
	}
	
	public EtablissementSante(String nomEtablissment,
			String adresseEtablissment, String mailEtablissment,
			String telEtablissment) {
		super();
		NomEtablissement = nomEtablissment;
		AdresseEtablissment = adresseEtablissment;
		MailEtablissment = mailEtablissment;
		TelEtablissment = telEtablissment;
	}
	
	public int getIdEtablissement() {
		return idEtablissement;
	}

	public void setIdEtablissement(int idEtablissement) {
		this.idEtablissement = idEtablissement;
	}
	
	public String getNomEtablissement() {
		return NomEtablissement;
	}
	public void setNomEtablissment(String nomEtablissment) {
		NomEtablissement = nomEtablissment;
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
