package fr.ambulancePro.Model;

public class Personnel implements Comparable<Personnel>{

	  private String _nomPersonnel;
	  private String _prenomPersonnel;
	  private String _loginPersonnel;
	  private String  _mdpPersonnel;
	  private StrategiePersonnel _strategie;
		
	  public Personnel(String loginPersonnel, String mdpPersonnel) {
		  this._loginPersonnel = loginPersonnel;
		  this._mdpPersonnel = mdpPersonnel;
	  }

	  public Personnel(String nomPersonnel, String prenomPersonnel,String loginPersonnel, String mdpPersonnel , StrategiePersonnel start) {
		  this._nomPersonnel = nomPersonnel;
		  this._prenomPersonnel = prenomPersonnel;
		  this._loginPersonnel = loginPersonnel;
		  this._mdpPersonnel = mdpPersonnel;
		  this._strategie = start;
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
}
