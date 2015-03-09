package fr.ambulancePro.Model;

import java.util.Date;
import java.sql.Time;

public class DemandeTransport {
	
	private int idDemandeTransport;
	private Date  DateTransport;
    private Time HeureTransport;
	private String AdresseDebut;
	private String  AdresseFin;
	private enum EtatDemandeTranposrt{EnCour, Traiter, Transferer};
	private Malade Malade;
	private int idEtablissment;
	
	public DemandeTransport(Date dateTransport, Time heureTransport,
			String adresseDebut, String adresseFin,
			Malade malade,
			int idEtablissment) {
		DateTransport = dateTransport;
		HeureTransport = heureTransport;
		AdresseDebut = adresseDebut;
		AdresseFin = adresseFin;
		Malade = malade;
		this.idDemandeTransport = idEtablissment;
	}
	
	public int getIdDemandeTransport() {
		return idDemandeTransport;
	}

	public void setIdDemandeTransport(int idDemandeTransport) {
		this.idDemandeTransport = idDemandeTransport;
	}
	
	public int getEtablissment() {
		return idEtablissment;
	}
	public void setEtablissment(int etablissment) {
		this.idDemandeTransport = etablissment;
	}
	public Malade getMalade() {
		return Malade;
	}
	public void setMalade(Malade malade) {
		this.Malade = malade;
	}
    public Date getDateTransport() {
		return DateTransport;
	}
	public void setDateTransport(Date dateTransport) {
		DateTransport = dateTransport;
	}
	public Time getHeureTransport() {
		return HeureTransport;
	}
	public void setHeureTransport(Time heureTransport) {
		HeureTransport = heureTransport;
	}
	public String getAdresseDebut() {
		return AdresseDebut;
	}
	public void setAdresseDebut(String adresseDebut) {
		AdresseDebut = adresseDebut;
	}
	public String getAdresseFin() {
		return AdresseFin;
	}
	public void setAdresseFin(String adresseFin) {
		AdresseFin = adresseFin;
	};

	

}
