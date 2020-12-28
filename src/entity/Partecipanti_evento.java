package entity;

import java.util.List;

public class Partecipanti_evento {
	private List<partecipa_evento> partecipanti;
	private float importoTotale;
	private int count;
	
	
	
	
	public Partecipanti_evento() {
		
	}
	
	
	public List<partecipa_evento> getPartecipanti() {
		return partecipanti;
	}
	public void setPartecipanti(List<partecipa_evento> partecipanti) {
		this.partecipanti = partecipanti;
	}
	public float getImportoTotale() {
		return importoTotale;
	}
	public void setImportoTotale(float importoTotale) {
		this.importoTotale = importoTotale;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	

}
