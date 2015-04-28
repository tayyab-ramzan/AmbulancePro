package fr.ambulancePro.Model;

public class Vehicule {
	
	private String _numeroImatriculation ;

	public Vehicule(String numeroImatriculation) {
		_numeroImatriculation = numeroImatriculation;
	}

	public String getNumeroImatriculation() {
		return _numeroImatriculation;
	}

	public void setNumeroImatriculation(String numeroImatriculation) {
		_numeroImatriculation = numeroImatriculation;
	}
}
