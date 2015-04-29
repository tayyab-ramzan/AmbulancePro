package fr.ambulancePro.Model;

public class EtablissementSante implements Comparable<EtablissementSante>{
	
	private String _idEtablissement;	
	private String _nomEtablissement;
	private String _adresseEtablissment;
	private String _mailEtablissment;
	private String _telEtablissment;	
	
	public EtablissementSante() {
		// TODO Auto-generated constructor stub
	}
	
	public EtablissementSante(String nomEtablissment,String adresseEtablissment, String mailEtablissment,String telEtablissment) {
		_nomEtablissement = nomEtablissment;
		_adresseEtablissment = adresseEtablissment;
		_mailEtablissment = mailEtablissment;
		_telEtablissment = telEtablissment;
	}
	
	public EtablissementSante(String idEtablissement, String nomEtablissment,String adresseEtablissment, String mailEtablissment,String telEtablissment) {
		this._idEtablissement = idEtablissement;
		this._nomEtablissement = nomEtablissment;
		this._adresseEtablissment = adresseEtablissment;
		this._mailEtablissment = mailEtablissment;
		this._telEtablissment = telEtablissment;
	}
	
	public String getIdEtablissement() {
		return _idEtablissement;
	}

	public void setIdEtablissement(String idEtablissement) {
		this._idEtablissement = idEtablissement;
	}
	
	public String getNomEtablissement() {
		return _nomEtablissement;
	}
	public void setNomEtablissment(String nomEtablissment) {
		_nomEtablissement = nomEtablissment;
	}
	public String getAdresseEtablissment() {
		return _adresseEtablissment;
	}
	public void setAdresseEtablissment(String adresseEtablissment) {
		_adresseEtablissment = adresseEtablissment;
	}
	public String getMailEtablissment() {
		return _mailEtablissment;
	}
	public void setMailEtablissment(String mailEtablissment) {
		_mailEtablissment = mailEtablissment;
	}
	public String getTelEtablissment() {
		return _telEtablissment;
	}
	public void setTelEtablissment(String telEtablissment) {
		_telEtablissment = telEtablissment;
	}
	
	@Override
	public int compareTo(EtablissementSante es) {
		// TODO Auto-generated method stub
		if(es._idEtablissement.compareTo(this._idEtablissement) == 0){
			return 0;
		}			
			return -1;
	}
	
	@Override
	public boolean equals(Object e){
		boolean equals = false;
		if (e instanceof EtablissementSante) {
			EtablissementSante etablissement = (EtablissementSante) e;
			equals = (etablissement.getIdEtablissement() == this._idEtablissement);
		}
		return equals;
	}
}
