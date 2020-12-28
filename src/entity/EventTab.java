package entity;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class EventTab {

	private SimpleStringProperty NomeEvento;
	private SimpleStringProperty TipoEvento;
	private SimpleStringProperty NoteEvento;
	private SimpleFloatProperty PrezzoEvento;
	private SimpleIntegerProperty NumPartecipanti;
	private SimpleFloatProperty ImportoRaggiunto;
	private SimpleStringProperty NomeCaritas;
	private SimpleStringProperty rapportoDenaro;
	private SimpleIntegerProperty Codice_caritas;
	private SimpleIntegerProperty completamento;

	public EventTab(String NomeEvento, String TipoEvento, String NoteEvento, float PrezzoEvento, String coord,
			String nome_caritas, float ImportoRaggiunto) {

		this.NomeEvento = new SimpleStringProperty(NomeEvento);
		this.TipoEvento = new SimpleStringProperty(TipoEvento);

		this.PrezzoEvento = new SimpleFloatProperty(PrezzoEvento);
		this.NoteEvento = new SimpleStringProperty(NoteEvento);
		this.NomeCaritas = new SimpleStringProperty(nome_caritas);
		this.ImportoRaggiunto = new SimpleFloatProperty(ImportoRaggiunto);

	}

	public EventTab(String NomeEvento, String nome_caritas, String NoteEvento, float PrezzoEvento,
			float ImportoRaggiunto, int NumPartecipanti, int id_caritas, int complet) {
		this.NomeEvento = new SimpleStringProperty(NomeEvento);
		this.NomeCaritas = new SimpleStringProperty(nome_caritas);
		if (complet == 1) {
			this.NoteEvento = new SimpleStringProperty("COMPLETATO");
		} else {
			this.NoteEvento = new SimpleStringProperty(NoteEvento);
		}

		this.NumPartecipanti = new SimpleIntegerProperty(NumPartecipanti);
		this.PrezzoEvento = new SimpleFloatProperty(PrezzoEvento);
		this.ImportoRaggiunto = new SimpleFloatProperty(ImportoRaggiunto);
		this.rapportoDenaro = new SimpleStringProperty(ImportoRaggiunto + "/" + PrezzoEvento);
		this.Codice_caritas = new SimpleIntegerProperty(id_caritas);
		this.completamento = new SimpleIntegerProperty(complet);
	}

	public String getNomeEvento() {
		return NomeEvento.get();
	}

	public void setNomeEvento(String nomeEvento) {
		NomeEvento.set(nomeEvento);
	}

	public String getTipoEvento() {
		return TipoEvento.get();
	}

	public void setTipoEvento(String tipoEvento) {
		TipoEvento.set(tipoEvento);
	}

	public String getNoteEvento() {
		return NoteEvento.get();
	}

	public void setNoteEvento(String noteEvento) {
		NoteEvento.set(noteEvento);
	}

	public float getPrezzoEvento() {
		return PrezzoEvento.get();
	}

	public void setPrezzoEvento(float prezzoEvento) {
		PrezzoEvento.set(prezzoEvento);
	}

	public int getNumPartecipanti() {
		return NumPartecipanti.get();
	}

	public void setNumPartecipanti(int numPartecipanti) {
		NumPartecipanti.set(numPartecipanti);
	}

	public float getImportoRaggiunto() {
		return ImportoRaggiunto.get();
	}

	public void setImportoRaggiunto(float importoRaggiunto) {
		ImportoRaggiunto.set(importoRaggiunto);
	}

	public String getNomeCaritas() {
		return NomeCaritas.get();
	}

	public void setNomeCaritas(String nomeCaritas) {
		NomeCaritas.set(nomeCaritas);
	}

	public String getRapportoDenaro() {
		return rapportoDenaro.get();
	}

	public void setRapportoDenaro(String rapportoDenaro) {
		this.rapportoDenaro.set(rapportoDenaro);
	}

	public int getId_caritas() {
		return Codice_caritas.get();
	}

	public void setId_caritas(int id_caritas) {
		this.Codice_caritas.set(id_caritas);
		;
	}

	public int getCompletamento() {
		return completamento.get();
	}

	public void setCompletamento(int completamento) {
		this.completamento.set(completamento);
	}

}
