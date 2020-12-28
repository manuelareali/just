package entity;

public class TurnoTab {
	private String giorno;
	private String orario;
	private String note;
	private int partecipanti;
	
	
	public TurnoTab(String giorno, String orario, String note, int parte) {
		this.giorno = giorno;
		this.orario = orario;
		this.note = note;
		this.partecipanti = parte;
	}
	
	
	
	
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public String getOrario() {
		return orario;
	}
	public void setOrario(String orario) {
		this.orario = orario;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getPartecipanti() {
		return partecipanti;
	}
	public void setPartecipanti(int partecipanti) {
		this.partecipanti = partecipanti;
	}
	
	
	
	
	
}
