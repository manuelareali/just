package entity;

public class Turno {
	private String ora_inizio, ora_fine, giorno;
	int id_turno;



	public Turno() {
		this.ora_inizio ="";
		this.ora_fine ="";
		this.giorno ="";
		this.id_turno = 0;
	}
	
	public Turno(String Giorno, String ora_in, String ora_fin) {
		this.giorno = Giorno;
		this.ora_fine = ora_fin;
		this.ora_inizio = ora_in;
	
	}
	
	public String getOrai() {
		return this.ora_inizio;
	}
	
	
	public String getOraf() {
		return this.ora_fine;
	}
	
	
	public String getGiorno() {
		return this.giorno;
	}
	
	

	public int getId_turno() {
		return id_turno;
	}

	public void setId_turno(int id_turno) {
		this.id_turno = id_turno;
	}

	
	
	public void setOrai(String orai) {
		this.ora_inizio = orai;
		
	}
	public void setOraf(String oraf) {
		this.ora_fine = oraf;
	}
	
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
}
