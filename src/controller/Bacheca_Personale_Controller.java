package controller;

import java.util.List;

import dao.Bacheca_dao;
import entity.Bacheca_entity;
import entity.Necessit�;

public class Bacheca_Personale_Controller {
	
	private Bacheca_dao bacheca;
	private int id_caritas;
	private Bacheca_entity bacheca_e;
	private List<Necessit�> necessit�;

	
	
	
	
	
	
	
	public boolean elimina_annuncio(int nece) {
	
		return	bacheca.elimina_necessit�(nece); 
		
		
	}
	
	
	
	public List<Necessit�> loadForm(int id_car) {
		this.id_caritas = id_car;
		bacheca = new Bacheca_dao();
		bacheca_e = new Bacheca_entity();
		necessit� = bacheca.visualizza_necessit�(id_car);
		bacheca_e.setNecessit�(necessit�);
	
		return necessit�;
	}
	
}
