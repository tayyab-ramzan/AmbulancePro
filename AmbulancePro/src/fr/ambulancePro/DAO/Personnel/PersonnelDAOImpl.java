package fr.ambulancePro.DAO.Personnel;

import static fr.ambulancePro.DAO.DAOUtilitaire.fermeturesSilencieuses;
import static fr.ambulancePro.DAO.DAOUtilitaire.initialisationRequetePrepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.ambulancePro.Model.EnsembleEtablissement;
import fr.ambulancePro.Model.EnsemblePersonnel;
import fr.ambulancePro.Model.EtablissementSante;
import fr.ambulancePro.Model.Personnel;
import fr.ambulancePro.Model.StrategieAdmin;
import fr.ambulancePro.Model.StrategieChauffeur;
import fr.ambulancePro.Model.StrategieFacuration;
import fr.ambulancePro.Model.StrategieOperateur;
import fr.ambulancePro.Model.StrategiePlanning;
import static fr.ambulancePro.DAO.DAOUtilitaire.*;
import fr.ambulancePro.DAO.*;

public class PersonnelDAOImpl implements PersonnelDAO {
	
	private DAOFactory daoFactory;
	
	public static final String SQL_SELECT_ALL = "SELECT * FROM personnel P, role_personnel RP WHERE P.id_role_personnel = RP.id_role_personnel ";
	public static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM personnel P, role_personnel RP WHERE P.id_role_personnel = RP.id_role_personnel AND login_personnel = ? AND mdp_personnel = ?";	
	public static final String SQL_SELECT_ROLE_BY_NAME = "SELECT id_role_personnel FROM role_personnel WHERE libelle = ?";
	public static final String SQL_INSERT = "INSERT INTO personnel (id_personnel, nom_personnel, prenom_personnel, login_personnel, id_role_personnel) VALUES (?, ?, ?, ?, ?)";
	public static final String SQL_SELECT_COUNT = "SELECT COUNT(*) as nbPersonnel FROM personnel";
	
	public PersonnelDAOImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public EnsemblePersonnel recupererEnsemblePersonnel() throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		EnsemblePersonnel personnel = new EnsemblePersonnel();
			    
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_ALL, false );
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while (resultSet.next()) {
				personnel.addPersonnel( map( resultSet ) );
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
	    } finally {
	    	fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return personnel;
	}
	
	public static Personnel map( ResultSet resultSet ) throws SQLException {
		Personnel personnel = new Personnel();
		personnel.setIdPersonnel( resultSet.getString("id_personnel") );
		personnel.setNomPersonnel( resultSet.getString("nom_personnel") );
		personnel.setPrenomPersonnel( resultSet.getString("prenom_personnel") );
		personnel.setLoginPersonnel( resultSet.getString("login_personnel") );
		personnel.setMdpPersonnel( resultSet.getString("mdp_personnel") );
		personnel.setNiveauAcces( resultSet.getInt("niveau_acces") );
		
		switch ( resultSet.getString("libelle") ) {
		case "OPERATEUR":
			personnel.setStrategie(new StrategieOperateur());
			break;
		case "PLANNING":
			personnel.setStrategie(new StrategiePlanning());
			break;
		case "FACTURATION":
			personnel.setStrategie(new StrategieFacuration());
			break;
		case "CHAUFFEUR":
			personnel.setStrategie(new StrategieChauffeur());
		case "ADMINISTRATEUR":
			personnel.setStrategie(new StrategieAdmin());
		default:
			break;
		}
	    return personnel;
	}

	@Override
	public Personnel trouver(String login, String password) throws DAOException {
		
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Personnel personnel = null;
		
		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_BY_LOGIN, false, login, password );
			resultSet = preparedStatement.executeQuery();
			/* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			while (resultSet.next()) {
				personnel = ( map( resultSet ) );
			}
		} catch ( SQLException e ) {
			throw new DAOException( e );
	    } finally {
	    	fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return personnel;
	}

	@Override
	public void creer(Personnel p) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			 /* R�cup�ration d'une connexion depuis la Factory */
			 connexion = daoFactory.getConnection();
			 String idPersonnel = "PR" + String.format("%04d", this.count()+1);
			 preparedStatement = initialisationRequetePrepared( connexion, SQL_INSERT, false,idPersonnel, p.getNomPersonnel(), p.getPrenomPersonnel(), p.getLoginPersonnel(), getRoleId(p.getStrategie().get_intituleRole()) );
			 int statut = preparedStatement.executeUpdate();
			 /* Analyse du statut retourné par la requête d'insertion */
			 if ( statut == 0 ) {
				 throw new DAOException( "Echec de la cr�ation de l'Etablissement, aucune ligne ajout�e dans la table." );
			 }
			p.setIdPersonnel(idPersonnel);
			        
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
			    int nbPersonnel = 0;
			    
			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_COUNT, false );
			        resultSet = preparedStatement.executeQuery();
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        if ( resultSet.next() ) {
			        	nbPersonnel = resultSet.getInt("nbPersonnel") ;
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
			    }
			    return nbPersonnel;
	}

	@Override
	public String getRoleId(String role) throws DAOException {
		String id = null;
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePrepared( connexion, SQL_SELECT_ROLE_BY_NAME, false, role);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	id = resultSet.getString("id_role_personnel") ;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	    return id;
	}
}
