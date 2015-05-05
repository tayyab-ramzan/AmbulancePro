package fr.ambulancePro.DAO.Appareil;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.Model.Appareil;
import fr.ambulancePro.Model.Ensemble.EnsembleAppareil;

public interface AppareilDao {
	public EnsembleAppareil recupererEnsemble() throws DAOException;
	public void creer(Appareil a) throws DAOException;
	public int count() throws DAOException;
}
