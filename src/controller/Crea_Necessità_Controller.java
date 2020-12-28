package controller;

import dao.Bacheca_dao;
import entity.Necessità;

public class Crea_Necessità_Controller {
	private Bacheca_dao crea_n;
	private Necessità necessità;
	private int id_caritas;
	
	public Crea_Necessità_Controller() {
		crea_n = new Bacheca_dao();
		
	}
	
	public int crea_necessità(String tipo, String urg, String desc) {
		
		necessità = new Necessità(tipo, desc, urg);
		
		
		crea_n.crea_necessità(necessità, id_caritas);
		return 0;
		
	}
	
	
	
	public void inizializza(int cod_car) {
		this.id_caritas = cod_car;
	}
	
}
