package fr.ambulancePro.Model;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.ambulancePro.DAO.DAOFactory;
import fr.ambulancePro.DAO.Personnel.PersonnelDAO;

public class Personnel implements Comparable<Personnel>{
	
	  private String _idPersonnel;
	  private String _nomPersonnel;
	  private String _prenomPersonnel;
	  private String _loginPersonnel;
	  private String  _mdpPersonnel;
	  private int _niveauAcces;
	  private StrategiePersonnel _strategie;
	  
	  /*
	   *DAO pour le personnel 
	   */
	  private PersonnelDAO _dao;
	  public static final String CONF_DAO_FACTORY = "DAOFACTORY";

	  private ServletContext context;
		
	  public Personnel(String loginPersonnel, String mdpPersonnel) {
		  this._loginPersonnel = loginPersonnel;
		  this._mdpPersonnel = mdpPersonnel;
		  this._dao = ( (DAOFactory) context.getAttribute( CONF_DAO_FACTORY ) ).getPersonnelDAO();
	  }

	  public Personnel(String nomPersonnel, String prenomPersonnel,String loginPersonnel, String mdpPersonnel , StrategiePersonnel start) {
		  this._nomPersonnel = nomPersonnel;
		  this._prenomPersonnel = prenomPersonnel;
		  this._loginPersonnel = loginPersonnel;
		  this._mdpPersonnel = mdpPersonnel;
		  this._strategie = start;
	  }
		
	  public Personnel() {
		// TODO Auto-generated constructor stub
	  }

	  public String getIdPersonnel() {
		return this._idPersonnel;
	  }

	  public void setIdPersonnel(String _idPersonnel) {
		this._idPersonnel = _idPersonnel;
	  }

	  public void changerStrategie(StrategiePersonnel s){	
		  this._strategie = s;
	  }
		
	  public String getNomPersonnel() {
		  return this._nomPersonnel;
	  }
	  
	  public void setNomPersonnel(String nomPersonnel) {
		  this._nomPersonnel = nomPersonnel;
	  }
	  
	  public String getPrenomPersonnel() {
		  return this._prenomPersonnel;
	  }
	  
	  public void setPrenomPersonnel(String prenomPersonnel) {
			this._prenomPersonnel = prenomPersonnel;
	  }
	  
	  public String getLoginPersonnel() {
		  return this._loginPersonnel;
	  }
		
	  public void setLoginPersonnel(String loginPersonnel) {
		  this._loginPersonnel = loginPersonnel;
	  }
	  
	  public String getMdpPersonnel() {
		  return this._mdpPersonnel;
	  }
	  
	  public void setMdpPersonnel(String mdpPersonnel) {
		  this._mdpPersonnel = mdpPersonnel;
	  }
	  
		
	  public int getNiveauAcces() {
		return this._niveauAcces;
	  }

	  public void setNiveauAcces(int _niveauAcces) {
		this._niveauAcces = _niveauAcces;
	  }

	  public StrategiePersonnel getStrategie() {
		  return this._strategie;
	  }

	  public void setStrategie(StrategiePersonnel strategie) {
		  this._strategie = strategie;
	  }
	  
	  @Override
	  public int compareTo(Personnel p) {
		  if(p.getLoginPersonnel().compareTo(this._loginPersonnel) == 0){
	
			  if(p.getMdpPersonnel().compareTo(this._mdpPersonnel) == 0){
				  return 0;
			  }
			  	return -1;
			}			
			return -1;
	  }
	  
	  public boolean seConnecter(){
		return false;
	  }
}
