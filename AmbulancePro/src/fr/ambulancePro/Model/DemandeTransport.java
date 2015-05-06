package fr.ambulancePro.Model;

import java.util.Date;
import java.sql.Time;

public class DemandeTransport {
	
	private String _idDemandeTransport;
	private Date  _dateTransport;
    private Time _heureTransport;
	private Adresse _adresseDebut;
	private Adresse  _adresseFin;
	private Malade _malade;
	private EtablissementSante _etablissement;
	private enum EtatDemandeTranposrt{ENCOUR, TRAITER, TRANSFERER};
	private EtatDemandeTranposrt _etatDemandeTransport;

	public DemandeTransport() {
		
	}
	
	public DemandeTransport(Date dateTransport, 
							Time heureTransport,
							Adresse adresseDebut, 
							Adresse adresseFin,
							Malade malade,
							EtablissementSante etablissment) {
		
		this._dateTransport = dateTransport;
		this._heureTransport = heureTransport;
		this._adresseDebut = adresseDebut;
		this._adresseFin = adresseFin;
		this._malade = malade;
		this._etablissement = etablissment;
	}
	
	public String getIdDemandeTransport() {
		return this._idDemandeTransport;
	}

	public void setIdDemandeTransport(String idDemandeTransport) {
		this._idDemandeTransport = idDemandeTransport;
	}
	
	public EtablissementSante getEtablissement() {
		return this._etablissement;
	}
	
	public void setEtablissement(EtablissementSante etablissment) {
		this._etablissement = etablissment;
	}
	
	public Malade getMalade() {
		return this._malade;
	}
	public void setMalade(Malade malade) {
		this._malade = malade;
	}
	
    public Date getDateTransport() {
		return this._dateTransport;
	}
    
	public void setDateTransport(Date dateTransport) {
		this._dateTransport = dateTransport;
	}
	
	public Time getHeureTransport() {
		return this._heureTransport;
	}
	
	public void setHeureTransport(Time heureTransport) {
		this._heureTransport = heureTransport;
	}
	
	public Adresse getAdresseDebut() {
		return this._adresseDebut;
	}
	
	public void setAdresseDebut(Adresse adresseDebut) {
		this._adresseDebut = adresseDebut;
	}
	
	public Adresse getAdresseFin() {
		return this._adresseFin;
	}
	
	public void setAdresseFin(Adresse adresseFin) {
		this._adresseFin = adresseFin;
	}
	
	public EtatDemandeTranposrt getEtatDemandeTransport() {
		return _etatDemandeTransport;
	}

	public void setEtatDemandeTransport(EtatDemandeTranposrt etatDemandeTransport) {
		this._etatDemandeTransport = etatDemandeTransport;
	}
}