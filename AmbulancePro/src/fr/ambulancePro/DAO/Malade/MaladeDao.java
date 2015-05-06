package fr.ambulancePro.DAO.Malade;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.Model.Malade;

public interface MaladeDao {
	public Malade trouver(String id) throws DAOException;
	public void creer(Malade m)throws DAOException;
	public int count()throws DAOException;
}
