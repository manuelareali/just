package controller;

import java.util.List;

import dao.Bacheca_dao;
import entity.Bacheca_entity;
import entity.Necessità;

public class Bacheca_Personale_Controller {
	
	private Bacheca_dao bacheca;
	private int id_caritas;
	private Bacheca_entity bacheca_e;
	private List<Necessità> necessità;

	
	
	
	
	
	
	
	public boolean elimina_annuncio(int nece) {
	
		return	bacheca.elimina_necessità(nece); 
		
		
	}
	
	
	
	public List<Necessità> loadForm(int id_car) {
		this.id_caritas = id_car;
		bacheca = new Bacheca_dao();
		bacheca_e = new Bacheca_entity();
		necessità = bacheca.visualizza_necessità(id_car);
		bacheca_e.setNecessità(necessità);
	
		return necessità;
	}
	
}
