package entity;

import java.util.List;

public class Bacheca_entity {
	private int id_caritas;
	private List<NecessitÓ> necessitÓ;
	
	
	
	public Bacheca_entity() {
		
	}
	
	
	
	public int getId_caritas() {
		return id_caritas;
	}
	public void setId_caritas(int id_caritas) {
		this.id_caritas = id_caritas;
	}
	public List<NecessitÓ> getNecessitÓ() {
		return necessitÓ;
	}
	public void setNecessitÓ(List<NecessitÓ> necessitÓ) {
		this.necessitÓ = necessitÓ;
	}
}
