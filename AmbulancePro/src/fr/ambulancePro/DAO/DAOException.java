package fr.ambulancePro.DAO;

public class DAOException extends RuntimeException {

	public DAOException(String message) {
		// TODO Auto-generated constructor stub
		super( message );
	}
	
	public DAOException(String message, Throwable cause) {
		// TODO Auto-generated constructor stub
		super( message, cause);
	}
	
	public DAOException( Throwable cause) {
		// TODO Auto-generated constructor stub
		super( cause );
	}
}
