package fr.ambulancePro.Model;

import java.sql.Date;
import java.sql.Time;

public class Transport {

	
	    private Date  DateTransport;
	    private Time HeureTransport;
		private String AdresseDebut;
		private String  AdresseFin;
		private boolean Urgent;
		private enum EtatTranposrt{EnAttente, Commencé, Ternminé,Facturé};
		private boolean Assise ;
		private Malade Malade;
		private EtablissmentSante Etablissment;
		

		


		public Transport(Date dateTransport, Time heureTransport,
				String adresseDebut, String adresseFin, boolean urgent,
				boolean assise, Malade malade,
				EtablissmentSante etablissment) {
			super();
			DateTransport = dateTransport;
			HeureTransport = heureTransport;
			AdresseDebut = adresseDebut;
			AdresseFin = adresseFin;
			Urgent = urgent;
			Assise = assise;
			Malade = malade;
			Etablissment = etablissment;
		}




		public void CalculCourt(){
			
		}


		
		
		public Malade getMalade() {
			return Malade;
		}
		
		public void setMalade(Malade malade) {
			Malade = malade;
		}
		
		public EtablissmentSante getEtablissment() {
			return Etablissment;
		}
		
		public void setEtablissment(EtablissmentSante etablissment) {
			Etablissment = etablissment;
		}
		
		
		public Date getDateTransport() {
			return DateTransport;
		}


		public void setDateTransport(Date dateTransport) {
			DateTransport = dateTransport;
		}


		public Time getHeureTransport() {
			return HeureTransport;
		}


		public void setHeureTransport(Time heureTransport) {
			HeureTransport = heureTransport;
		}


		public String getAdresseDebut() {
			return AdresseDebut;
		}


		public void setAdresseDebut(String adresseDebut) {
			AdresseDebut = adresseDebut;
		}


		public String getAdresseFin() {
			return AdresseFin;
		}


		public void setAdresseFin(String adresseFin) {
			AdresseFin = adresseFin;
		}


		public boolean isUrgent() {
			return Urgent;
		}


		public void setUrgent(boolean urgent) {
			Urgent = urgent;
		}


		public boolean isAssise() {
			return Assise;
		}


		public void setAssise(boolean assise) {
			Assise = assise;
		}

		
		
}
