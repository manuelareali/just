package entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Necessit� {
	private SimpleIntegerProperty id_nece;
	private SimpleStringProperty Tipologia;
	private SimpleStringProperty Descrizione;
	private SimpleStringProperty Urgenza;

	
	public Necessit�(int nece, String tipo, String descr, String urg) {
		this.Descrizione= new SimpleStringProperty(descr);
		this.Tipologia = new SimpleStringProperty(tipo);
		this.Urgenza = new SimpleStringProperty(urg);
		this.id_nece = new SimpleIntegerProperty(nece);
	}
	
	public Necessit�( String tipo, String descr, String urg) {
		this.Descrizione= new SimpleStringProperty(descr);
		this.Tipologia = new SimpleStringProperty(tipo);
		this.Urgenza = new SimpleStringProperty(urg);
		
	}
	


	public Necessit�() {
		
	}


	public String getTipologia() {
		return Tipologia.get();
	}


	public void setTipologia(String tipologia) {
		Tipologia.set(tipologia);
	}


	public String getDescrizione() {
		return Descrizione.get();
	}


	public void setDescrizione(String descrizione) {
		Descrizione.set(descrizione);
	}


	public String getUrgenza() {
		return Urgenza.get();
	}


	public void setUrgenza(String urgenza) {
		this.Urgenza.set(urgenza);
	}


	public int getId_nece() {
		return id_nece.get();
	}


	public void setId_nece(int id_nece) {
		this.id_nece.set(id_nece);
	}
}
