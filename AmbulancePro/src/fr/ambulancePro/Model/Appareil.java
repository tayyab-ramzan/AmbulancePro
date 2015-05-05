package fr.ambulancePro.Model;

public class Appareil {
	
	private String _idAppareil;
	private String _nomAppareil;
	private int _qtyTotal;
	private int _qtyDispo;
	private float _coutSupp;
	
	
	
	public Appareil(String _idAppareil, String _nomAppareil, int _qtyTotal,int _qtyDispo, float _coutSupp) {
		this._idAppareil = _idAppareil;
		this._nomAppareil = _nomAppareil;
		this._qtyTotal = _qtyTotal;
		this._qtyDispo = _qtyDispo;
		this._coutSupp = _coutSupp;
	}

	public Appareil(String _nomAppareil, int _qtyTotal, int _qtyDispo,float _coutSupp){
		this._nomAppareil = _nomAppareil;
		this._qtyTotal = _qtyTotal;
		this._qtyDispo = _qtyDispo;
		this._coutSupp = _coutSupp;
	}

	public Appareil() {
	}

	public String getNomAppareil() {
		return _nomAppareil;
	}

	public void setNomAppareil(String nomAppareil) {
		_nomAppareil = nomAppareil;
	}

	public String get_idAppareil() {
		return _idAppareil;
	}

	public void set_idAppareil(String _idAppareil) {
		this._idAppareil = _idAppareil;
	}

	public int get_qtyTotal() {
		return _qtyTotal;
	}

	public void set_qtyTotal(int _qtyTotal) {
		this._qtyTotal = _qtyTotal;
	}

	public int get_qtyDispo() {
		return _qtyDispo;
	}

	public void set_qtyDispo(int _qtyDispo) {
		this._qtyDispo = _qtyDispo;
	}

	public float get_coutSupp() {
		return _coutSupp;
	}

	public void set_coutSupp(float _coutSupp) {
		this._coutSupp = _coutSupp;
	}
	
}
