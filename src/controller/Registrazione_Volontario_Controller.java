package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import bean.User_Home_Boundary;
import dao.VolunteerRepository;
import entity.VolunteerUser;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Date;

public class Registrazione_Volontario_Controller implements Initializable {


    public Registrazione_Volontario_Controller() {
    
    }



   
   public void backButtonPressed(Window event) {
    	
	    try {
			Parent root = FXMLLoader.load(getClass().getResource("/boundary/RegistrazioneMenu.fxml"));
			Stage signUp = (Stage) event.getScene().getWindow();
			Scene scene = new Scene(root,600,400);
			signUp.setScene(scene);
			signUp.show();
			signUp.setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }


   public VolunteerUser completaButtonPressed( String nome, String cognome, String passwordVolontario, String via, String telefono, String email, String date2, String cittadiResidenza) {

    		
        	VolunteerUser newUser = new VolunteerUser(nome, cognome, passwordVolontario, via, telefono, email, null,date2,cittadiResidenza );
        	VolunteerRepository vrep = new VolunteerRepository();
        	int id = vrep.insertVolunteer(newUser);
        	newUser.setID(id);
        	
        	return newUser;
        	//Manda alla home dopo la registrazione
        	
    	

    }




@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
}



    
   

}