package fr.ambulancePro.DAO.Adresse;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.Model.Adresse;

public interface AdresseDao {
	public void creer(Adresse a) throws DAOException;
	public int count() throws DAOException;
	public Adresse trouver(String id)throws DAOException;
}
