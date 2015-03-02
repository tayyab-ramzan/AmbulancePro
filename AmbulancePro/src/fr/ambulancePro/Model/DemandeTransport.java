package fr.ambulancePro.Model;

import java.sql.Date;
import java.sql.Time;

public class DemandeTransport {
	
	
    private Date  DateTransport;
    private Time HeureTransport;
	private String AdresseDebut;
	private String  AdresseFin;
	private enum EtatDemandeTranposrt{EnCour, Traitée, Transférée};
	private Malade Malade;
	private Vehicule Vehicule;
	private EtablissmentSante Etablissment;
	

	
	
	public DemandeTransport(Date dateTransport, Time heureTransport,
			String adresseDebut, String adresseFin,
			Malade malade,
			Vehicule vehicule, EtablissmentSante etablissment) {
		super();
		DateTransport = dateTransport;
		HeureTransport = heureTransport;
		AdresseDebut = adresseDebut;
		AdresseFin = adresseFin;
		Malade = malade;
		Vehicule = vehicule;
		Etablissment = etablissment;
	}
	
	public Vehicule getVehicule() {
		return Vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		Vehicule = vehicule;
	}
	public EtablissmentSante getEtablissment() {
		return Etablissment;
	}
	public void setEtablissment(EtablissmentSante etablissment) {
		Etablissment = etablissment;
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
