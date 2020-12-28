package entity;

import javafx.beans.property.SimpleStringProperty;

public class Evento {
	
	private SimpleStringProperty NomeEvento;
	private String TipoEvento;
	private String NoteEvento;
	private float PrezzoEvento;
	private int id_negozio;
	private String coord;
	private int id_caritas;

	
	
	public Evento(String NomeEvento,String TipoEvento,String NoteEvento,float PrezzoEvento,int id_negozio,String coord, int id_caritas) {
		
		this.NomeEvento = new SimpleStringProperty(NomeEvento);
		this.TipoEvento = TipoEvento;
		
		this.PrezzoEvento = PrezzoEvento;
		this.id_negozio = id_negozio;
		this.coord = coord;
		this.id_caritas = id_caritas;
	}
	
	public Evento(String NomeEvento,String TipoEvento,String NoteEvento,float PrezzoEvento,int id_negozio, int id_caritas) {
		this.NomeEvento = new SimpleStringProperty(NomeEvento);
		this.TipoEvento = TipoEvento;
	
		this.PrezzoEvento = PrezzoEvento;
		this.id_negozio = id_negozio;
		this.id_caritas = id_caritas;
	}
	
	
	public String getNomeEvento() {
		return NomeEvento.get();
	}

	public void setNomeEvento(String nomeEvento) {
		NomeEvento.set(nomeEvento);
	}

	public String getTipo() {
		return this.TipoEvento;
	}
	public String getNote() {
		return this.NoteEvento;
	}
	
	public float getPrezzo() {
		return this.PrezzoEvento;
	}
	public int getNeg() {
		return this.id_negozio;
	}
	public String getCoord() {
		return this.coord;
	}
	
	
	public void setCoord(String coordinate) {
		 this.coord = coordinate;
	}

	public int getId_caritas() {
		return id_caritas;
	}

	public void setId_caritas(int id_caritas) {
		this.id_caritas = id_caritas;
	}
	
	
}
