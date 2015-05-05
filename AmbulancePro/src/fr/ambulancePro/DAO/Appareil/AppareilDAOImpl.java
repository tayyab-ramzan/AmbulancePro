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
	public static final String SQL_INSERT = "INSERT INTO appareil (id_appareil, nom_appareil,quantite_disponible,cout_supp,quantite_total) VALUES (?,?,?,?,?)";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbAppareils FROM appareil";
	
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
		fr.ambulancePro.Model.Appareil appareil = new fr.ambulancePro.Model.Appareil();
		appareil.set_idAppareil( resultSet.getString("id_appareil") );
		appareil.set_coutSupp( resultSet.getFloat("cout_supp") );
		appareil.set_qtyDispo( resultSet.getInt("quantite_disponible") );
		appareil.set_qtyTotal( resultSet.getInt("quantite_total") );
		appareil.setNomAppareil( resultSet.getString("nom_appareil") );
	    return appareil;
	}

	@Override
	public void creer(Appareil a) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			 /* R�cup�ration d'une connexion depuis la Factory */
			 connexion = daoFactory.getConnection();
			 String idAppareil = "AP" + String.format("%04d", this.count()+1);
			 preparedStatement = initialisationRequetePrepared( connexion, SQL_INSERT, false,idAppareil,a.getNomAppareil(), a.get_qtyDispo(),a.get_coutSupp(),a.get_qtyTotal());
			 int statut = preparedStatement.executeUpdate();
			 /* Analyse du statut retourné par la requête d'insertion */
			 if ( statut == 0 ) {
				 throw new DAOException( "Echec de la cr�ation de l'Etablissement, aucune ligne ajout�e dans la table." );
			 }  
			 a.set_idAppareil(idAppareil);
		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
				 fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
		}
	}

	@Override
	public int count() throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int nbAppareils = 0;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_COUNT, false );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	nbAppareils = resultSet.getInt("nbAppareils") ;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return nbAppareils;
	}

}
