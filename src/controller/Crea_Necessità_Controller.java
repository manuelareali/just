package controller;

import dao.Bacheca_dao;
import entity.Necessit�;

public class Crea_Necessit�_Controller {
	private Bacheca_dao crea_n;
	private Necessit� necessit�;
	private int id_caritas;
	
	public Crea_Necessit�_Controller() {
		crea_n = new Bacheca_dao();
		
	}
	
	public int crea_necessit�(String tipo, String urg, String desc) {
		
		necessit� = new Necessit�(tipo, desc, urg);
		
		
		crea_n.crea_necessit�(necessit�, id_caritas);
		return 0;
		
	}
	
	
	
	public void inizializza(int cod_car) {
		this.id_caritas = cod_car;
	}
	
}
