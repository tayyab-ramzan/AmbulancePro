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
import static fr.ambulancePro.DAO.DAOUtilitaire.*;
import fr.ambulancePro.DAO.*;

public class PersonnelDAOImpl implements PersonnelDAO {
	
	private DAOFactory daoFactory;
	
	public static final String SQL_SELECT_ALL = "SELECT * FROM personnel P, role_personnel RP WHERE P.id_role_personnel = RP.id_role_personnel ";
	
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
		/*etablissement.setIdEtablissement( resultSet.getString( "id_etablissement" ) );
		etablissement.setNomEtablissment( resultSet.getString( "nom_etablissement" ) );
		etablissement.setAdresseEtablissment( resultSet.getString( "adresse_etablissement" ) );
		etablissement.setTelEtablissment( resultSet.getString( "tel_etablissement" ) );
		etablissement.setMailEtablissment( resultSet.getString( "mail_etablissement" ) );*/
	    return personnel;
	}

}
