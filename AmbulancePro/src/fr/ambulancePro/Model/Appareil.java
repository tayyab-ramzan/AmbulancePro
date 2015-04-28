package fr.ambulancePro.Model;

public class Appareil {
	
	private String _nomAppareil ;

	public Appareil(String nomAppareil) {
		_nomAppareil = nomAppareil;
	}

	public String getNomAppareil() {
		return _nomAppareil;
	}

	public void setNomAppareil(String nomAppareil) {
		_nomAppareil = nomAppareil;
	}
}
