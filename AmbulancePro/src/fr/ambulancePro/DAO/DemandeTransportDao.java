package fr.ambulancePro.DAO;

import java.util.ArrayList;

import fr.ambulancePro.Model.DemandeTransport;
import fr.ambulancePro.Model.Malade;

public interface DemandeTransportDao {
	public void creer(DemandeTransport demandeTransport, Malade malade) throws DAOException;
	public DemandeTransport trouver(String id) throws DAOException;
	public int count() throws DAOException;
	public ArrayList<DemandeTransport> listeDemandeTransport () throws DAOException ;
}
