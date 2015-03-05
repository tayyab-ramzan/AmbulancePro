package fr.ambulancePro.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connexion {

	private static Connexion connexion;
	
	/* La liste qui contiendra tous les résultats de nos essais */
    private List<String> messages = new ArrayList<String>();
    
	protected Connexion(){
		/* Chargement du driver JDBC pour MySQL */
        try {
            messages.add( "Chargement du driver..." );
            Class.forName( "com.mysql.jdbc.Driver" );
            messages.add( "Driver chargé !" );
        } catch ( ClassNotFoundException e ) {
            messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                    + e.getMessage() );
        }
        
        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/ambulance_pro";
        String utilisateur = "root";
        String motDePasse = "";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        messages.add( "Connexion à la base de données..." );
        try {
			connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
			messages.add( "Connexion réussie !" );
		} catch (SQLException e) {
			 messages.add( "Erreur lors de la connexion : <br/>"
	                    + e.getMessage() );
		}        
        System.out.println(messages);
	}
	
	public static Connexion getConnexion(){
		if(connexion == null)
			connexion = new Connexion();
		return connexion;
	}
	
	public Statement getStatement(){
		return null;
		
	}
	
}
