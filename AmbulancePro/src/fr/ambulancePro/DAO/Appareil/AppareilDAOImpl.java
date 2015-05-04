package fr.ambulancePro.DAO.Appareil;

import static fr.ambulancePro.DAO.DAOUtilitaire.fermeturesSilencieuses;
import static fr.ambulancePro.DAO.DAOUtilitaire.initialisationRequetePrepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.Model.Appareil;
import fr.ambulancePro.Model.Ensemble.EnsembleAppareil;
import fr.ambulancePro.Model.Ensemble.EnsembleVehicule;

public class AppareilDAOImpl implements AppareilDao {
	
	public static final String SQL_SELECT_ALL = "SELECT * FROM appareil";
	public static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM personnel P, role_personnel RP WHERE P.id_role_personnel = RP.id_role_personnel AND login_personnel = ? AND mdp_personnel = ?";	
	public static final String SQL_SELECT_ROLE_BY_NAME = "SELECT id_role_personnel FROM role_personnel WHERE libelle = ?";
	public static final String SQL_INSERT = "INSERT INTO vehicule (id_vehicule, numero_imatriculation_vehicule) VALUES (?,?)";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbVehicule FROM vehicule";
	
	private DAOFactory daoFactory;

	public AppareilDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public EnsembleAppareil recupererEnsemble() throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		EnsembleAppareil appareils = new EnsembleAppareil();
			    
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_ALL, false );
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while (resultSet.next()) {				
				appareils.addAppareil( map( resultSet ) );
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
	    } finally {
	    	fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return appareils;
	}
	
	public static fr.ambulancePro.Model.Appareil map( ResultSet resultSet ) throws SQLException {
		fr.ambulancePro.Model.Appareil appareil = new fr.ambulancePro.Model.Appareil( resultSet.getString("numero_imatriculation_vehicule") );
	    return appareil;
	}

	@Override
	public void creer(Appareil a) throws DAOException {
		// TODO Auto-generated method stub

	}

}
