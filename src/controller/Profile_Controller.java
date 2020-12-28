package controller;

import java.io.IOException;

import bean.User_Home_Boundary;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Profile_Controller {
	private User_Home_Boundary userHomeBoundary;
	private VolunteerUser currentUser;

    public VolunteerUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(VolunteerUser currentUser) {
		this.currentUser = currentUser;
	}

	@FXML
    private ImageView profileImageEdit;

    @FXML
    private Button backHomeButton;

    @FXML
    private Button editButton;

    @FXML
    private ImageView donazioniImage;

    @FXML
    private ImageView eventiImage;

    @FXML
    private Text nomeCognomeEdit;

    @FXML
    private Text emailEdit;

    @FXML
    private Text cittaEdit;

    @FXML
    private Text telefonoEdit;

    
    public Profile_Controller() {
    	userHomeBoundary = new User_Home_Boundary();
    }
    
   
   public void backHomeButtonPressed(Window window) {
    	
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
			Parent root = loader.load();
			userHomeBoundary = loader.getController();
			userHomeBoundary.initData(currentUser);
			Stage home = (Stage) window.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    
   public void editButtonPressed(ActionEvent event) {

    }
    

}