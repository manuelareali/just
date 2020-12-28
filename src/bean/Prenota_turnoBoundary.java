package bean;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.Prenota_turno_controller;
import dao.Prenota_dao;
import entity.Orario;
import entity.Turno;
import entity.partecipa_turno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Prenota_turnoBoundary {
		private int id_caritas;
		private int id_volontario;
		private List<Orario> oraArrayList;
		private String[] giorni;
		
		
		
		private Prenota_turno_controller Prenota_c;
	
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ChoiceBox<String> Turni;

	    @FXML
	    private ChoiceBox<String> cb_ora_inizio;

	    @FXML
	    private ChoiceBox<String> cb_ora_fine;

	    @FXML
	    private TextField CV;

	    @FXML
	    private Button indietro;

	    @FXML
	    private Button prenota;
	    
	    @FXML
	    void indietro(ActionEvent event) {

	    }
	    
	    
	    public Prenota_turnoBoundary() {
	    	
	    }
	    
	    @FXML
	    void prenota_turno(ActionEvent event) { 
		
	    	Prenota_c.prenota_turno(Turni.getValue().toString(), cb_ora_inizio.getValue().toString(), cb_ora_fine.getValue().toString(), CV.getText());
	    	Stage st = (Stage) prenota.getScene().getWindow();
	    	st.close();
		}
	    
	    public boolean checker() {
	    	
	    	 
			//Controlla che non ci siano campi lasciati vuoti
	    	
				if (CV.getText().isEmpty()) {
					
					return false;
				}
			return true;
	    	
	  }
	    

	    @FXML
	    void initialize() {
	    	Prenota_c = new Prenota_turno_controller();
	    	
	    	this.giorni = new String[8];
		
	    	
	    	giorni = Prenota_c.inizializza_giorni();
	   
	    	
	    	for(int i=0; i<8; i++) {
	    		Turni.getItems().add(giorni[i]);
	    	}
	    	
	    	
	    	oraArrayList =Prenota_c.initializza_orari();
	    	//ora = (Orario[]) oraArrayList.toArray();
	    	
	    	int i = 0;
	    	while(i<oraArrayList.size()) {
	    
		    	cb_ora_inizio.getItems().add(oraArrayList.get(i).getOra_fine());
		    	
		    	cb_ora_fine.getItems().add(oraArrayList.get(i).getOra_inizio());
		    	
		    	i++;
		    	
	    	}
	    	
	    }
	    
	    public void setData(int id_car, int id_ute) {
		  	Prenota_c.setData_controller(id_car, id_ute);
		  }
}
