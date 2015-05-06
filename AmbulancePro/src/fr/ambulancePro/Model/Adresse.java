package fr.ambulancePro.Model;

public class Adresse {
	
	private String _idAdresse;
	private int _num;
	private String _nomRue;
	private String _codePostal;
	private String _ville;
	
	public Adresse() {
		// TODO Auto-generated constructor stub
	}
	
	public Adresse(int _num, String _nomRue, String _codePostal, String _ville) {
		super();
		this._num = _num;
		this._nomRue = _nomRue;
		this._codePostal = _codePostal;
		this._ville = _ville;
	}

	public String getIdAdresse() {
		return _idAdresse;
	}
	public void setIdAdresse(String _idAdresse) {
		this._idAdresse = _idAdresse;
	}
	public int getNum() {
		return _num;
	}
	public void setNum(int _num) {
		this._num = _num;
	}
	public String getNomRue() {
		return _nomRue;
	}
	public void setNomRue(String _nomRue) {
		this._nomRue = _nomRue;
	}
	public String getCodePostal() {
		return _codePostal;
	}
	public void setCodePostal(String _codePostal) {
		this._codePostal = _codePostal;
	}
	public String getVille() {
		return _ville;
	}
	public void setVille(String _ville) {
		this._ville = _ville;
	}
	
	public String toString(){
		String adresse = null;
		adresse = this._num + " " + this._nomRue + " " + this._codePostal + " " + this._ville;
		return adresse;
	}
}
