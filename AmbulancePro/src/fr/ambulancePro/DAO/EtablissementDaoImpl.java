package fr.ambulancePro.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static fr.ambulancePro.DAO.DAOUtilitaire.*;
import fr.ambulancePro.Model.EtablissementSante;

public class EtablissementDaoImpl implements EtablissementDao {
	private DAOFactory daoFactory;
	
	private static final String SQL_SELECT_PAR_ID = "SELECT * FROM etablissement WHERE id = ?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM etablissement";
	private static final String SQL_INSERT = "INSERT INTO etablissement (nom_etablissement, adresse_etablissement, mail_etablissement, tel_etablissement) VALUES (?, ?, ?, ?)";
	
	public EtablissementDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void creer(EtablissementSante etablissement) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, etablissement.getNomEtablissement(), etablissement.getAdresseEtablissment(), etablissement.getMailEtablissment(), etablissement.getTelEtablissment() );
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création de l'établissement, aucune ligne ajoutée dans la table." );
	        }
	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	            etablissement.setIdEtablissement( valeursAutoGenerees.getInt( 1 ) );
	        } else {
	            throw new DAOException( "Échec de la création de l'établissement en base, aucun ID auto-généré retourné." );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
	}

	@Override
	public EtablissementSante trouver(int id) throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    EtablissementSante etablissement = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_ID, false, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	            etablissement = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return etablissement;
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des utilisateurs (un
	 * ResultSet) et un bean Utilisateur.
	 */
	private static EtablissementSante map( ResultSet resultSet ) throws SQLException {
		EtablissementSante etablissement = new EtablissementSante();
		etablissement.setIdEtablissement( resultSet.getInt( "id_etablissement" ) );
		etablissement.setNomEtablissment( resultSet.getString( "nom_etablissement" ) );
		etablissement.setAdresseEtablissment( resultSet.getString( "adresse_etablissement" ) );
		etablissement.setTelEtablissment( resultSet.getString( "tel_etablissement" ) );
		etablissement.setMailEtablissment( resultSet.getString( "mail_etablissement" ) );
	    return etablissement;
	}

	@Override
	public ArrayList<EtablissementSante> recupererEnsemble() throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    ArrayList<EtablissementSante> etablissements = new ArrayList<EtablissementSante>();
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	etablissements.add(map( resultSet ));
			}
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return etablissements;
	}
}
