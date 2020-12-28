package entity;

public class DonazioneTab {
	private String tipologia;
	private String Descrizione;
	private String indirizzo;
	
	
	
	public DonazioneTab(String tipo, String desc, String ind) {
		this.tipologia = tipo;
		this.Descrizione = desc;
		this.indirizzo = ind;
	}
	
	
	
	
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getDescrizione() {
		return Descrizione;
	}
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
	
	

}
