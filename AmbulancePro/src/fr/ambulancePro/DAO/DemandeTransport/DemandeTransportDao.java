package fr.ambulancePro.DAO.DemandeTransport;

import java.util.ArrayList;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.Model.DemandeTransport;
import fr.ambulancePro.Model.Malade;
import fr.ambulancePro.Model.Ensemble.EnsembleDemandeTransport;

public interface DemandeTransportDao {
	public void creer(DemandeTransport demandeTransport) throws DAOException;
	public DemandeTransport trouver(String id) throws DAOException;
	public int count() throws DAOException;
	public EnsembleDemandeTransport listeDemandeTransport () throws DAOException ;
}
