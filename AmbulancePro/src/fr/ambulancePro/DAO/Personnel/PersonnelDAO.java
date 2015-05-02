package fr.ambulancePro.DAO.Personnel;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.Model.EnsemblePersonnel;

public interface PersonnelDAO {
	public EnsemblePersonnel recupererEnsemblePersonnel() throws DAOException;
}
