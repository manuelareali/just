package entity;

public class Orario {
	private String ora_inizio;
	private String ora_fine;
	
	
	
	public Orario() {
		
	}



	public Orario(String ora_in, String ora_fin) {
		this.ora_fine= ora_in;
		this.ora_inizio= ora_fin;
	}



	public String getOra_inizio() {
		return ora_inizio;
	}



	public void setOra_inizio(String ora_inizio) {
		this.ora_inizio = ora_inizio;
	}



	public String getOra_fine() {
		return ora_fine;
	}



	public void setOra_fine(String ora_fine) {
		this.ora_fine = ora_fine;
	}
	
	
	
	
	
}
