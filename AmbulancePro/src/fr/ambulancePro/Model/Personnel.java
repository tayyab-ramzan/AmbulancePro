package fr.ambulancePro.Model;

public class Personnel implements Comparable<Personnel>{

	  private String NomPersonnel;
	    private String PrenomPersonnel;
		private String LoginPersonnel;
		private String  MdpPersonnel;
		private StrategiePersonnel Strategie;
		
		
		
		
		public Personnel(String loginPersonnel, String mdpPersonnel) {
			super();
			LoginPersonnel = loginPersonnel;
			MdpPersonnel = mdpPersonnel;
		}



		public Personnel(String nomPersonnel, String prenomPersonnel,
				String loginPersonnel, String mdpPersonnel , StrategiePersonnel start) {
			super();
			NomPersonnel = nomPersonnel;
			PrenomPersonnel = prenomPersonnel;
			LoginPersonnel = loginPersonnel;
			MdpPersonnel = mdpPersonnel;
			Strategie = start;
		}

	
		
		public void changerStrategie(StrategiePersonnel s){
			
		}
		
		
		
		public String getNomPersonnel() {
			return NomPersonnel;
		}
		public void setNomPersonnel(String nomPersonnel) {
			NomPersonnel = nomPersonnel;
		}
		public String getPrenomPersonnel() {
			return PrenomPersonnel;
		}
		public void setPrenomPersonnel(String prenomPersonnel) {
			PrenomPersonnel = prenomPersonnel;
		}
		public String getLoginPersonnel() {
			return LoginPersonnel;
		}
		public void setLoginPersonnel(String loginPersonnel) {
			LoginPersonnel = loginPersonnel;
		}
		public String getMdpPersonnel() {
			return MdpPersonnel;
		}
		public void setMdpPersonnel(String mdpPersonnel) {
			MdpPersonnel = mdpPersonnel;
		}
		
		public StrategiePersonnel getStrategie() {
			return Strategie;
		}

		public void setStrategie(StrategiePersonnel strategie) {
			Strategie = strategie;
		}



		@Override
		public int compareTo(Personnel o) {
			// TODO Auto-generated method stub
			
			if(o.getLoginPersonnel().compareTo(this.LoginPersonnel) == 0){
				
				if(o.getMdpPersonnel().compareTo(this.MdpPersonnel) == 0){
					return 0;
				}
				return -1;
			}
			
			return -1;
		}

		
		
		
}
