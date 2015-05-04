package fr.ambulancePro.DAO.Vehicule;

import static fr.ambulancePro.DAO.DAOUtilitaire.fermeturesSilencieuses;
import static fr.ambulancePro.DAO.DAOUtilitaire.initialisationRequetePrepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.Model.Personnel;
import fr.ambulancePro.Model.StrategieAdmin;
import fr.ambulancePro.Model.StrategieChauffeur;
import fr.ambulancePro.Model.StrategieFacuration;
import fr.ambulancePro.Model.StrategieOperateur;
import fr.ambulancePro.Model.StrategiePlanning;
import fr.ambulancePro.Model.Ensemble.EnsemblePersonnel;
import fr.ambulancePro.Model.Ensemble.EnsembleVehicule;
import fr.ambulancePro.Servlet.Vehicule;

public class VehiculeDAOImpl implements VehiculeDao {
	
	public static final String SQL_SELECT_ALL = "SELECT * FROM vehicule";
	public static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM personnel P, role_personnel RP WHERE P.id_role_personnel = RP.id_role_personnel AND login_personnel = ? AND mdp_personnel = ?";	
	public static final String SQL_SELECT_ROLE_BY_NAME = "SELECT id_role_personnel FROM role_personnel WHERE libelle = ?";
	public static final String SQL_INSERT = "INSERT INTO vehicule (id_vehicule, numero_imatriculation_vehicule) VALUES (?,?)";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbVehicule FROM vehicule";
	
	private DAOFactory daoFactory;

	public VehiculeDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public EnsembleVehicule recupererEnsemble() throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		EnsembleVehicule vehicule = new EnsembleVehicule();
			    
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_ALL, false );
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while (resultSet.next()) {				
				vehicule.addVehicule( map( resultSet ) );
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
	    } finally {
	    	fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return vehicule;
	}
	
	public static fr.ambulancePro.Model.Vehicule map( ResultSet resultSet ) throws SQLException {
		fr.ambulancePro.Model.Vehicule vehicule = new fr.ambulancePro.Model.Vehicule( resultSet.getString("numero_imatriculation_vehicule") );
	    return vehicule;
	}

	@Override
	public void creer(fr.ambulancePro.Model.Vehicule v) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			 /* R�cup�ration d'une connexion depuis la Factory */
			 connexion = daoFactory.getConnection();
			 preparedStatement = initialisationRequetePrepared( connexion, SQL_INSERT, false,v.getNumeroImatriculation(), v.getNumeroImatriculation());
			 int statut = preparedStatement.executeUpdate();
			 /* Analyse du statut retourné par la requête d'insertion */
			 if ( statut == 0 ) {
				 throw new DAOException( "Echec de la cr�ation de l'Etablissement, aucune ligne ajout�e dans la table." );
			 }        
		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
				 fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
		}
	}
}
