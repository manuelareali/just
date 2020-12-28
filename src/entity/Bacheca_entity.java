package entity;

import java.util.List;

public class Bacheca_entity {
	private int id_caritas;
	private List<Necessità> necessità;
	
	
	
	public Bacheca_entity() {
		
	}
	
	
	
	public int getId_caritas() {
		return id_caritas;
	}
	public void setId_caritas(int id_caritas) {
		this.id_caritas = id_caritas;
	}
	public List<Necessità> getNecessità() {
		return necessità;
	}
	public void setNecessità(List<Necessità> necessità) {
		this.necessità = necessità;
	}
}
