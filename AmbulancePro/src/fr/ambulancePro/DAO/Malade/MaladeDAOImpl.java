package fr.ambulancePro.DAO.Malade;

import static fr.ambulancePro.DAO.DAOUtilitaire.fermeturesSilencieuses;
import static fr.ambulancePro.DAO.DAOUtilitaire.initialisationRequetePrepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Adresse.AdresseDaoImpl;
import fr.ambulancePro.Model.Adresse;
import fr.ambulancePro.Model.Malade;

public class MaladeDAOImpl implements MaladeDao {
	
	private DAOFactory _daoFactory;
	
	public static final String SQL_SELECT_PAR_ID = "SELECT * FROM malades, adresse WHERE id_malade = ? AND adresse_malade = id_adresse ";
	public static final String SQL_INSERT = "INSERT INTO malades (id_malade, nom_malade, prenom_malade, adresse_malade) VALUES (?, ?, ?, ?)";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbMalades FROM malades";
	
	public MaladeDAOImpl(DAOFactory daoFactory) {
		this._daoFactory = daoFactory;
	}
	
	@Override
	public Malade trouver(String id) throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Malade malade = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = this._daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_PAR_ID, false, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	malade = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return malade;
	}

	@Override
	public void creer(Malade m) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			 /* R�cup�ration d'une connexion depuis la Factory */
			 connexion = _daoFactory.getConnection();
			 String idMalade = "MA" + String.format("%04d", this.count()+1);
			 preparedStatement = initialisationRequetePrepared( connexion, SQL_INSERT, false,idMalade, m.getNomMalade(), m.getNomMalade(), m.getAdresseMalade().getIdAdresse() );
			 int statut = preparedStatement.executeUpdate();
			 /* Analyse du statut retourné par la requête d'insertion */
			 if ( statut == 0 ) {
				 throw new DAOException( "Echec de la creation de l'Etablissement, aucune ligne ajoutee dans la table." );
			 }
			m.setIdMalade(idMalade);
			        
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
	    int nbMalade = 0;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = _daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_COUNT, false );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	nbMalade = resultSet.getInt("nbMalades") ;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return nbMalade;
	}
	
	public static Malade map( ResultSet resultSet ) throws SQLException {
		Malade malade = new Malade();
		malade.setIdMalade( resultSet.getString( "id_malade" ) );
		malade.setNomMalade( resultSet.getString( "nom_malade" ) );
		malade.setPrenomMalade( resultSet.getString( "prenom_malade" ) );
		malade.setAdresseMalade( AdresseDaoImpl.map(resultSet));
	    return malade;
	}

}
