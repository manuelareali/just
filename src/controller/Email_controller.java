package controller;


import dao.Email_dao;
import entity.Email_entity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Email_controller {

	private Email_dao email_d;
	private Email_entity email_e;
	private String[] email_list;
	
    public int send_message_controller(String mit, String dest, String mess, String ogg) {
    	
    	int i=0;
    	email_e = new Email_entity(mit, dest, mess, ogg);

    	email_d = new Email_dao();
    	i = email_d.invia_email(email_e);
    	return i;
    	
    }
    
    public String[] load_mittente_destinatario_c(int id_dest, int id_mit) {
    	email_d = new Email_dao();
    	email_list = email_d.visualizza_mittente_destinatario(id_dest, id_mit);
    	return email_list;
    	
    }
    
    
    
}
	
