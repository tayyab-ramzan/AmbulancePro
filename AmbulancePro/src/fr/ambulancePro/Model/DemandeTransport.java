package fr.ambulancePro.Model;

import java.util.Date;
import java.sql.Time;

public class DemandeTransport {
	
	private int _idDemandeTransport;
	private Date  _dateTransport;
    private Time _heureTransport;
	private String _adresseDebut;
	private String  _adresseFin;
	private Malade _malade;
	private int _idEtablissment;
	private enum EtatDemandeTranposrt{ENCOUR, TRAITER, TRANSFERER};
	private EtatDemandeTranposrt _etatDemandeTransport;

	public DemandeTransport() {
		
	}
	
	public DemandeTransport(Date dateTransport, 
							Time heureTransport,
							String adresseDebut, 
							String adresseFin,
							Malade malade,
							int idEtablissment) {
		
		this._dateTransport = dateTransport;
		this._heureTransport = heureTransport;
		this._adresseDebut = adresseDebut;
		this._adresseFin = adresseFin;
		this._malade = malade;
		this._idEtablissment = idEtablissment;
	}
	
	public int getIdDemandeTransport() {
		return this._idDemandeTransport;
	}

	public void setIdDemandeTransport(int idDemandeTransport) {
		this._idDemandeTransport = idDemandeTransport;
	}
	
	public int getEtablissement() {
		return this._idEtablissment;
	}
	
	public void setEtablissement(int etablissment) {
		this._idEtablissment = etablissment;
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
	
	public String getAdresseDebut() {
		return this._adresseDebut;
	}
	
	public void setAdresseDebut(String adresseDebut) {
		this._adresseFin = adresseDebut;
	}
	
	public String getAdresseFin() {
		return this._adresseFin;
	}
	
	public void setAdresseFin(String adresseFin) {
		this._adresseFin = adresseFin;
	}
	
	public EtatDemandeTranposrt getEtatDemandeTransport() {
		return _etatDemandeTransport;
	}

	public void setEtatDemandeTransport(EtatDemandeTranposrt etatDemandeTransport) {
		this._etatDemandeTransport = etatDemandeTransport;
	}
}