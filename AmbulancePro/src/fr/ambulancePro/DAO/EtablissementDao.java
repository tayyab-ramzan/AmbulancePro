package fr.ambulancePro.DAO;

import java.util.ArrayList;

import fr.ambulancePro.Model.EtablissementSante;

public interface EtablissementDao {
	void creer(EtablissementSante etablissement) throws DAOException;
	EtablissementSante trouver(int id) throws DAOException;
	ArrayList<EtablissementSante> recupererEnsemble() throws DAOException;
}
