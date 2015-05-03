package fr.ambulancePro.DAO.Personnel;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.Model.EnsemblePersonnel;
import fr.ambulancePro.Model.Personnel;

public interface PersonnelDAO {
	public void creer(Personnel p) throws DAOException;
	public EnsemblePersonnel recupererEnsemblePersonnel() throws DAOException;
	public Personnel trouver(String login, String password) throws DAOException;
	public int count() throws DAOException;
	public String getRoleId(String role) throws DAOException; 
}
