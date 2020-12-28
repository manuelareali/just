package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;






public class ShopMenuController {
	Stage primary;
	

   public void CercaCaritas(ActionEvent event) {
    	RicercaCaritasNegozioController Rcnc = new RicercaCaritasNegozioController();
    	Rcnc.showStage();
    }

 
    public void GestEventi(ActionEvent event) {
    	
    	try {
    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("../boundary/Gestisci_eventi.fxml"));

                // Set this class as the controller
          

                // Load the scene
                primary.setScene(new Scene(loader.load()));

                // Setup the window/stage
                primary.setTitle("Shop Menù");

            } catch (IOException e) {
                e.printStackTrace();
            }
    	
    }

  
   public void Indietro(ActionEvent event) {

    }

   
   public void ModInfo(ActionEvent event) {

    }

	
public ShopMenuController() {
	primary = new Stage();
	
	try {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("../boundary/ShopMenuBoundary.fxml"));

            // Set this class as the controller
      

            // Load the scene
            primary.setScene(new Scene(loader.load()));

            // Setup the window/stage
            primary.setTitle("Shop Menù");

        } catch (IOException e) {
            e.printStackTrace();
        }
	
	
		
}
public void showStage() {
	primary.showAndWait();
}



}
