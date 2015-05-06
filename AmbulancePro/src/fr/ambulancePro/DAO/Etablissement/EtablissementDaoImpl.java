package fr.ambulancePro.DAO.Etablissement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static fr.ambulancePro.DAO.DAOUtilitaire.*;
import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Adresse.AdresseDao;
import fr.ambulancePro.DAO.Adresse.AdresseDaoImpl;
import fr.ambulancePro.Model.EtablissementSante;
import fr.ambulancePro.Model.Ensemble.EnsembleEtablissement;

public class EtablissementDaoImpl implements EtablissementDao {
	private DAOFactory daoFactory;
	
	public static final String SQL_SELECT_PAR_ID = "SELECT * FROM etablissement , adresse WHERE id_etablissement = ? AND adresse_etablissement = id_adresse";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbEtablissement FROM etablissement";
	public static final String SQL_SELECT_ALL = "SELECT * FROM etablissement E, adresse A WHERE E.adresse_etablissement = A.id_adresse";
	public static final String SQL_INSERT = "INSERT INTO etablissement (id_etablissement, nom_etablissement, adresse_etablissement, mail_etablissement, tel_etablissement) VALUES (?, ?, ?, ?, ?)";
	
	private AdresseDao _daoAdresse;
	
	public EtablissementDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
		this._daoAdresse = daoFactory.getAdresseDAO();
	}
	
	@Override
	public void creer(EtablissementSante etablissement) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;

	    try {
	    	
	    	//Sauvegarde de l'adresse dans la base de données
	    	this._daoAdresse.creer(etablissement.getAdresseEtablissement());
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        String idEtablissement = "ES" + String.format("%04d", this.count()+1);
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_INSERT, false,idEtablissement, etablissement.getNomEtablissement(), etablissement.getAdresseEtablissement().getIdAdresse(), etablissement.getMailEtablissment(), etablissement.getTelEtablissment() );
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Echec de la creation de l'Etablissement, aucune ligne ajout�e dans la table." );
	        }
	        etablissement.setIdEtablissement( idEtablissement );
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
	}

	@Override
	public EtablissementSante trouver(String id) throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    EtablissementSante etablissement = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_PAR_ID, false, id );
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
	 * mapping) entre une ligne issue de la table etablissement (un
	 * ResultSet) et un bean etablissement.
	 */
	public static EtablissementSante map( ResultSet resultSet ) throws SQLException {
		EtablissementSante etablissement = new EtablissementSante();
		etablissement.setIdEtablissement( resultSet.getString( "id_etablissement" ) );
		etablissement.setNomEtablissment( resultSet.getString( "nom_etablissement" ) );
		etablissement.setTelEtablissment( resultSet.getString( "tel_etablissement" ) );
		etablissement.setMailEtablissment( resultSet.getString( "mail_etablissement" ) );
		etablissement.setAdresseEtablissment( AdresseDaoImpl.map(resultSet) );
	    return etablissement;
	}

	@Override
	public EnsembleEtablissement recupererEnsemble() throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    EnsembleEtablissement etablissements = new EnsembleEtablissement();
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_ALL, false );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	etablissements.addEtablissement(map( resultSet ));
			}
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return etablissements;
	}

	@Override
	public int count() throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int nbEtablissement = 0;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_COUNT, false );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	            nbEtablissement = resultSet.getInt("nbEtablissement") ;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return nbEtablissement;
	}
}
