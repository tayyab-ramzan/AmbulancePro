package fr.ambulancePro.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import fr.ambulancePro.DAO.Adresse.*;
import fr.ambulancePro.DAO.Appareil.AppareilDAOImpl;
import fr.ambulancePro.DAO.Appareil.AppareilDao;
import fr.ambulancePro.DAO.DemandeTransport.*;
import fr.ambulancePro.DAO.Etablissement.*;
import fr.ambulancePro.DAO.Malade.MaladeDAOImpl;
import fr.ambulancePro.DAO.Malade.MaladeDao;
import fr.ambulancePro.DAO.Personnel.*;
import fr.ambulancePro.DAO.Vehicule.VehiculeDAOImpl;
import fr.ambulancePro.DAO.Vehicule.VehiculeDao;

public class DAOFactory {
	
	private static DAOFactory instance;
	
	private static final String FICHIER_PROPERTIES       = "/fr/ambulancePro/DAO/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";

    private String              url;
    private String              username;
    private String              password;

    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }

        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }
        
        if (instance == null) {
        	instance = new DAOFactory( url, nomUtilisateur, motDePasse );
		} 
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
     /* package */ public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }

    /*
     * Méthodes de récupération de l'implémentation des différents DAO 
     */
    public EtablissementDao getEtablissementDao() {
        return new EtablissementDaoImpl( this );
    }
    
    public DemandeTransportDao getDemandeTransportDao(){
    	return new DemandeTransportDaoImpl(this);
    }
    
    public PersonnelDAO getPersonnelDAO() {
        return new PersonnelDAOImpl( this );
    }
    
    public VehiculeDao getVehiculeDAO(){
    	return new VehiculeDAOImpl( this );
    }
    
    public AppareilDao getAppareilDAO(){
    	return new AppareilDAOImpl( this );
    }
    
    public AdresseDao getAdresseDAO(){
    	return new AdresseDaoImpl( this ); 
    }
    
    public MaladeDao getMaladeDAO(){
    	return new MaladeDAOImpl( this );
    }
}
