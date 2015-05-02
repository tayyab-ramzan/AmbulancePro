package fr.ambulancePro.DAO.Etablissement;

import java.util.ArrayList;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.Model.EnsembleEtablissement;
import fr.ambulancePro.Model.EtablissementSante;

public interface EtablissementDao {
	public void creer(EtablissementSante etablissement) throws DAOException;
	public EtablissementSante trouver(int id) throws DAOException;
	public int count() throws DAOException;
	public EnsembleEtablissement recupererEnsemble() throws DAOException;
}