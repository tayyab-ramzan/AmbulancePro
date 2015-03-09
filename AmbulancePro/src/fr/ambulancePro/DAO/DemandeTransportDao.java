package fr.ambulancePro.DAO;

import fr.ambulancePro.Model.DemandeTransport;
import fr.ambulancePro.Model.Malade;

public interface DemandeTransportDao {
	void creer(DemandeTransport demandeTransport, Malade malade) throws DAOException;
	DemandeTransport trouver(int id) throws DAOException;
}
