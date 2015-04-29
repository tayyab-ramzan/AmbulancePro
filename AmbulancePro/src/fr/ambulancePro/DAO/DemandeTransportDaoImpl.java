package fr.ambulancePro.DAO;

import static fr.ambulancePro.DAO.DAOUtilitaire.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.ambulancePro.Model.DemandeTransport;
import fr.ambulancePro.Model.EtablissementSante;
import fr.ambulancePro.Model.Malade;

public class DemandeTransportDaoImpl implements DemandeTransportDao {
	
	private DAOFactory daoFactory;
	
	public static final String SQL_SELECT_PAR_ID = "SELECT * FROM demande_transport WHERE id_demande_transport = ?";
	public static final String SQL_SELECT_ALL = "SELECT * FROM demande_transport";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbDemandeTransport  FROM demande_transport";
	public static final String SQL_INSERT = "INSERT INTO demande_transport (id_demande_transport, date_demande_transport, heure_demande_transport, adresse_debut, adresse_fin,id_etablissement,id_malade) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_INSERT_MALADE = "INSERT INTO malade (nom_malade, prenom_malade, adresse_malade) VALUES(?, ?, ?)";
	
	public DemandeTransportDaoImpl(DAOFactory daoFactory) {
		// TODO Auto-generated constructor stub
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void creer(DemandeTransport demandeTransport, Malade malade) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet valeursAutoGenerees = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        
	        // Requetr pour la création d'un malade
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_INSERT_MALADE, true, malade.getNomMalade(), malade.getPrenomMalade(), malade.getAdresseMalade());
	        int statut = preparedStatement.executeUpdate();
	        /* Analyse du statut retourné par la requête d'insertion */
	        if ( statut == 0 ) {
	            throw new DAOException( "Echec de la cr�tion du malade, aucune ligne ajout�e dans la table." );
	        }
	        /* Récupération de l'id auto-généré par la requête d'insertion */
	        valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	        if ( valeursAutoGenerees.next() ) {
	            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	            malade.setIdMalade( valeursAutoGenerees.getInt( 1 ) );
	        } else {
	            throw new DAOException( "Échec de la création du malade en base, aucun ID auto-généré retourné." );
	        }
	        
	        //Requete pour la création d'une demande de transport
	        String idDemandeTransport = "DT" + String.format("%04d", this.count()+1);
	        preparedStatement = initialisationRequetePrepared(connexion, SQL_INSERT, false,idDemandeTransport, demandeTransport.getDateTransport(), demandeTransport.getHeureTransport(), demandeTransport.getAdresseDebut(), demandeTransport.getAdresseFin(),demandeTransport.getEtablissement().getIdEtablissement(),malade.getIdMalade());;
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
	    DemandeTransport demandeTransport = null;
	    EtablissementSante etablissement = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = this.daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_PAR_ID, false, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	demandeTransport = map( resultSet );
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
		demande.setAdresseDebut( resultSet.getString( "adresse_debut" ) );
		demande.setAdresseFin( resultSet.getString( "adresse_fin" ) );
		return demande;
	}
	
	@Override
	public ArrayList<DemandeTransport> listeDemandeTransport()
			throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    ResultSet resultSet2 = null;
	    ArrayList<DemandeTransport> demandes = new ArrayList<DemandeTransport>();
	    
	    try {
	        /* R�cup�ration d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_ALL, false );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	DemandeTransport demande = map( resultSet );
	        	preparedStatement = initialisationRequetePrepared(connexion, EtablissementDaoImpl.SQL_SELECT_PAR_ID, false, resultSet.getString("id_etablissement"));
	        	resultSet2 = preparedStatement.executeQuery();
	        	if (resultSet2.next()) {
					demande.setEtablissement(new EtablissementSante(resultSet2.getString("id_etablissement"), resultSet2.getString("nom_etablissement"), resultSet2.getString("adresse_etablissement"), resultSet2.getString("mail_etablissement"), resultSet2.getString("tel_etablissement")));
				}
	        	demandes.add(demande);
			}
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    //System.out.println(demandes.get(0).getIdDemandeTransport());
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
