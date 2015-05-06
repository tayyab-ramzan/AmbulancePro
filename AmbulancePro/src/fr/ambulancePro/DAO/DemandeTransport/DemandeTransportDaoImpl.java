package fr.ambulancePro.DAO.DemandeTransport;

import static fr.ambulancePro.DAO.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.ambulancePro.DAO.DAOException;
import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Adresse.AdresseDao;
import fr.ambulancePro.DAO.Etablissement.EtablissementDao;
import fr.ambulancePro.DAO.Etablissement.EtablissementDaoImpl;
import fr.ambulancePro.DAO.Malade.MaladeDao;
import fr.ambulancePro.Model.Adresse;
import fr.ambulancePro.Model.DemandeTransport;
import fr.ambulancePro.Model.EtablissementSante;
import fr.ambulancePro.Model.Malade;
import fr.ambulancePro.Model.Ensemble.EnsembleDemandeTransport;

public class DemandeTransportDaoImpl implements DemandeTransportDao {
	
	private DAOFactory daoFactory;
	
	private EtablissementDao _daoEtablissement;
	private AdresseDao _daoAdresse;
	private MaladeDao _daoMalade;
	
	public static final String SQL_SELECT_PAR_ID = "SELECT * FROM demande_transport WHERE id_demande_transport = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM demande_transport";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbDemandeTransport  FROM demande_transport";
	public static final String SQL_INSERT = "INSERT INTO demande_transport (id_demande_transport, date_demande_transport, heure_demande_transport, adresse_debut, adresse_fin,id_etablissement,id_malade) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public DemandeTransportDaoImpl(DAOFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
		this._daoAdresse = this.daoFactory.getAdresseDAO();
		this._daoEtablissement = this.daoFactory.getEtablissementDao();
		this._daoMalade = this.daoFactory.getMaladeDAO();
	}
	
	@Override
	public void creer(DemandeTransport demandeTransport) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        
	        //Malade
	        this._daoAdresse.creer(demandeTransport.getMalade().getAdresseMalade());
	        this._daoMalade.creer(demandeTransport.getMalade());
	        
	        //Adresses
	        this._daoAdresse.creer(demandeTransport.getAdresseDebut());
	        this._daoAdresse.creer(demandeTransport.getAdresseFin());
	        
	        int statut;
	        
	        //Requete pour la création d'une demande de transport
	        String idDemandeTransport = "DT" + String.format("%04d", this.count()+1);
	        preparedStatement = initialisationRequetePrepared(connexion, SQL_INSERT, false,idDemandeTransport, demandeTransport.getDateTransport(), demandeTransport.getHeureTransport(), demandeTransport.getAdresseDebut().getIdAdresse(), demandeTransport.getAdresseFin().getIdAdresse(),demandeTransport.getEtablissement().getIdEtablissement(),demandeTransport.getMalade().getIdMalade());
	        statut = preparedStatement.executeUpdate();
	        if ( statut == 0 ) {
	            throw new DAOException( "Échec de la création d'une demande de transport, aucune ligne ajoutée dans la table." );
	        }
	        demandeTransport.setIdDemandeTransport( idDemandeTransport );
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
	    }
		
	}

	@Override
	public DemandeTransport trouver(String id) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    ResultSet resultSet2 = null;
	    DemandeTransport demandeTransport = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = this.daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_PAR_ID, false, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	demandeTransport = map( resultSet );
	        	EtablissementSante etablissement = this._daoEtablissement.trouver(resultSet.getString("id_etablissement") );
	        	Malade malade = this._daoMalade.trouver(resultSet.getString("id_malade") );
	        	Adresse adresseDeb = this._daoAdresse.trouver(resultSet.getString("adresse_debut"));
	        	Adresse adresseFin = this._daoAdresse.trouver(resultSet.getString("adresse_fin"));
	        	
	        	demandeTransport.setAdresseDebut(adresseDeb);
	        	demandeTransport.setAdresseFin(adresseFin);
	        	demandeTransport.setEtablissement(etablissement);
	        	demandeTransport.setMalade(malade);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return demandeTransport;
	}
	
	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table demandeTransport (un
	 * ResultSet) et un bean demandeTransport.
	 */
	public static DemandeTransport map( ResultSet resultSet ) throws SQLException {
		DemandeTransport demande = new DemandeTransport();
		demande.setIdDemandeTransport( resultSet.getString( "id_demande_transport" ) );
		demande.setDateTransport( resultSet.getDate( "date_demande_transport" ) );
		demande.setHeureTransport( resultSet.getTime( "heure_demande_transport" ) );
		return demande;
	}
	
	@Override
	public EnsembleDemandeTransport listeDemandeTransport()
			throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    ResultSet resultSet2 = null;
	    EnsembleDemandeTransport demandes = new EnsembleDemandeTransport();
	    
	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_ALL, false );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	DemandeTransport demande = map( resultSet );
	        	EtablissementSante etablissement = this._daoEtablissement.trouver(resultSet.getString("id_etablissement") );
	        	Malade malade = this._daoMalade.trouver(resultSet.getString("id_malade") );
	        	Adresse adresseDeb = this._daoAdresse.trouver(resultSet.getString("adresse_debut"));
	        	Adresse adresseFin = this._daoAdresse.trouver(resultSet.getString("adresse_fin"));
	        	
	        	demande.setAdresseDebut(adresseDeb);
	        	demande.setAdresseFin(adresseFin);
	        	demande.setEtablissement(etablissement);
	        	demande.setMalade(malade);
	        	
	        	demandes.addDemandeTransport(demande);
			}
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return demandes;
	}

	@Override
	public int count() throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int nbDemandeTransport = 0;
		  
		try {
		    /* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_COUNT, false );
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			if ( resultSet.next() ) {
				nbDemandeTransport = resultSet.getInt("nbDemandeTransport") ;
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
		} finally {
			fermeturesSilencieuses( resultSet, preparedStatement, connexion );
		}
		return nbDemandeTransport;
	}
}
