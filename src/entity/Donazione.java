package entity;

import com.sothawo.mapjfx.Coordinate;

public class Donazione {
	private String descrizione;
	private String indirizzo;
	private int id_utente;
	private int id_caritas;
	private Coordinate coordDonazione;
	private int tipologia;
	

	public Donazione( String descrizione, String indirizzo,int id_utente, int id_caritas, Coordinate coordDonazione, int tipologia) {
		this.descrizione = descrizione;
		this.indirizzo = indirizzo;
		this.id_caritas = id_caritas;
		this.id_utente = id_utente;
		this.coordDonazione = coordDonazione;
		this.tipologia = tipologia;
	}

	public Donazione() {
		this.descrizione = "";
		this.indirizzo= "";
		this.id_utente= 0;
		this.id_caritas= 0;
		this.coordDonazione= null;
		this.tipologia= 0;
		
	}
	

	public String getCoord() {
		
		return ""+ this.coordDonazione + "";
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getId_utente() {
		return id_utente;
	}

	public void setId_utente(int id_utente) {
		this.id_utente = id_utente;
	}

	public int getId_caritas() {
		return id_caritas;
	}

	public void setId_caritas(int id_caritas) {
		this.id_caritas = id_caritas;
	}

	public Coordinate getCoordDonazione() {
		return coordDonazione;
	}

	public void setCoordDonazione(Coordinate coordDonazione) {
		this.coordDonazione = coordDonazione;
	}

	public int getTipologia() {
		return tipologia;
	}

	public void setTipologia(int tipologia) {
		this.tipologia = tipologia;
	}
	

	
	
}
