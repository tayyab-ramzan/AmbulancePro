package fr.ambulancePro.DAO.Vehicule;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.Model.Vehicule;
import fr.ambulancePro.Model.Ensemble.EnsembleVehicule;

public interface VehiculeDao {
	public EnsembleVehicule recupererEnsemble() throws DAOException;
	public void creer(Vehicule v) throws DAOException;
}
