package fr.ambulancePro.DAO.Adresse;

import static fr.ambulancePro.DAO.DAOUtilitaire.fermeturesSilencieuses;
import static fr.ambulancePro.DAO.DAOUtilitaire.initialisationRequetePrepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Etablissement.EtablissementDaoImpl;
import fr.ambulancePro.Model.Adresse;
import fr.ambulancePro.Model.DemandeTransport;
import fr.ambulancePro.Model.EtablissementSante;

public class AdresseDaoImpl implements AdresseDao {
	private DAOFactory _daoFactory;
	
	public static final String SQL_INSERT = "INSERT INTO adresse (id_adresse, numero, nom_rue, code_postal, ville) VALUES (?, ?, ?, ?, ?)";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbAdresse FROM adresse";
	public static final String SQL_SELECT_PAR_ID = "SELECT * FROM adresse WHERE id_adresse = ?";
	
	public AdresseDaoImpl(DAOFactory daoFactory) {
		this._daoFactory = daoFactory;
	}
	
	@Override
	public void creer(Adresse a) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;

	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = _daoFactory.getConnection();
	        String idAdresse = "AD" + String.format("%04d", this.count()+1);
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_INSERT, false,idAdresse, a.getNum(), a.getNomRue(), a.getCodePostal(), a.getVille() );
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Echec de la creation de l'Etablissement, aucune ligne ajoutee dans la table." );
	        }
	        a.setIdAdresse(idAdresse);
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
	}

	@Override
	public int count() throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    int nbAdresse = 0;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = _daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_COUNT, false );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	nbAdresse = resultSet.getInt("nbAdresse") ;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return nbAdresse;
	}
	
	public static Adresse map( ResultSet resultSet ) throws SQLException {
		Adresse adresse = new Adresse();
		adresse.setIdAdresse( resultSet.getString( "id_adresse" ) );
		adresse.setNum( resultSet.getInt( "numero" ) );
		adresse.setNomRue( resultSet.getString( "nom_rue" ) );
		adresse.setCodePostal( resultSet.getString( "code_postal" ) );
		adresse.setVille( resultSet.getString("ville") );
	    return adresse;
	}

	@Override
	public Adresse trouver(String id) throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Adresse adresse = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = this._daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_PAR_ID, false, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	adresse = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return adresse;
	}

}
