package fr.ambulancePro.Model;

import java.sql.Date;
import java.sql.Time;

public class Transport {

	private Date _dateTransport;
	private Time _heureTransport;
	private String _adresseDebut;
	private String  _adresseFin;
	private boolean _urgent;
	private boolean _assise ;
	private Malade _malade;
	private EtablissementSante _etablissment;
		
	private enum EtatTranposrt{ENATTENTE, COMMENCER, TERMINER,FACTURER};
	private EtatTranposrt _etatTransport;
		
	public Transport(Date dateTransport,Time heureTransport,String adresseDebut, String adresseFin, boolean urgent,boolean assise, Malade malade,EtablissementSante etablissment) {
		this._dateTransport = dateTransport;
		this._heureTransport = heureTransport;
		this._adresseDebut = adresseDebut;
		this._adresseFin = adresseFin;
		this._urgent = urgent;
		this._assise = assise;
		this._malade = malade;
		this._etablissment = etablissment;
		this._etatTransport = EtatTranposrt.ENATTENTE;
	}

	public void CalculCourt(){
			
	}
		
	public Malade getMalade() {
		return this._malade;
	}
		
	public void setMalade(Malade malade) {
		this._malade = malade;
	}
		
	public EtablissementSante getEtablissment() {
		return this._etablissment;
	}
		
	public void setEtablissment(EtablissementSante etablissment) {
		this._etablissment = etablissment;
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
		this._adresseDebut = adresseDebut;
	}

	public String getAdresseFin() {
		return this._adresseFin;
	}

	public void setAdresseFin(String adresseFin) {
		this._adresseFin = adresseFin;
	}

	public boolean isUrgent() {
		return this._urgent;
	}

	public void setUrgent(boolean urgent) {
		this._urgent = urgent;
	}

	public boolean isAssise() {
		return this._assise;
	}

	public void setAssise(boolean assise) {
		this._assise = assise;
	}
}
