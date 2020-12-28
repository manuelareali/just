package controller;

import java.util.List;

import bean.Gestisci_eventi_Boundary;
import dao.Evento_dao;
import entity.EventTab;
import entity.Evento;

public class Gestisci_eventi_Controller {
	private Gestisci_eventi_Boundary gestisci_eventi_b;
	private List<EventTab> lista_ev;
	private Evento_dao event_dao;
	
	
	
	public Gestisci_eventi_Controller() {
	
		event_dao = new Evento_dao();
	}
	
	
	public List<EventTab> carica_eventi(int id_shop){
		
		lista_ev = event_dao.cerca_eventi(id_shop);
		
		
		return lista_ev;
		
	}
	
	public boolean elimina_evento(String nomeEvento) {
		return event_dao.deliteEvent(nomeEvento);
	}
	
	
	public boolean modifica_note_evento(String noteEvento) {
		return false;
		
	}
	
}
