package bean;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.sothawo.mapjfx.Projection;

import controller.Cerca_caritas;
import controller.DonationController;
import controller.Profile_Controller;
import controller.User_Home_Controller;
import entity.VolunteerUser;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@SuppressWarnings("serial")
public class User_Home_Boundary implements Serializable{
/**
	 * 
	 */

private static User_Home_Boundary instance = null;

private VolunteerUser currentUser;
	
	private User_Home_Controller user_c ;
	private int idUtente;
	
	//Images slideshow
	private Image img1 ;
	private Image img2;
	private Image img3;
	private Image[] images = {img1, img2, img3};
	private int currentImage;
	
	public VolunteerUser getCurrentUser() {
		return this.currentUser;
	}

	public void setCurrentUser(VolunteerUser currentUser) {
		this.currentUser = currentUser;
	}
	
	public static User_Home_Boundary getInstance() {
		if (instance == null) {
			instance = new User_Home_Boundary();
			}
		return instance;
	}
	
	
	public User_Home_Boundary() {
		img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
		 img2 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/PelleDrago.PNG");
		 img3 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestaIniz.PNG");
		 currentImage = 0;
		 user_c = new User_Home_Controller();
	
	}
	
	@FXML
    private Text nomeCognome;
	
	@FXML
    private Button profileButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button deleteAccountButton;

    @FXML
    private ImageView imagePresentation;
    
    @FXML
    private ImageView profileImage;
    
    @FXML
    private Button searchCaritasButton;

    @FXML
    private Button logoutButton;
    
    @FXML
    private Button leftArrowButton;

    @FXML
    private Button rightArrowButton;

    @FXML
    void deleteAccountButtonPressed(ActionEvent event) {

    }

    @FXML
    void profileButtonPressed(ActionEvent event) {
    	Profile_Boundary profileController;
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserProfilePage.fxml"));
			Parent root = loader.load();
			profileController = loader.getController();
			profileController.initData(getCurrentUser());
			
			Stage home = (Stage) this.profileButton.getScene().getWindow();
			home.setScene(new Scene(root, 800, 600));
			
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void helpButtonPressed(ActionEvent event) {
    	this.user_c.helpButtonPressed(this.helpButton.getScene().getWindow());
    }

    @FXML
    void leftArrowPressed(ActionEvent event) {
    	
    	//Se � la prima riparti dall'ultima
    	if (currentImage == 0) {
    		currentImage = 2;
    		imagePresentation.setImage(images[currentImage]);
    	} else {
    		currentImage--;
    		imagePresentation.setImage(images[currentImage]);
    	}
    }

    @FXML
    void logoutButtonPressed(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Logout");
    	alert.setHeaderText("Dovrai accedere di nuovo se vuoi tornare alla home");
    	alert.setContentText("Sei sicuro di voler eseguire il logout?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Login_boundary.fxml"));
    			Parent root = loader.load();
    			Stage home = (Stage) logoutButton.getScene().getWindow();
    			home.setScene(new Scene(root, 600, 385));
    			home.show();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        	
    	} else {
    	    //nothing
    	}
    	
	}

    @FXML
    void rightArrowPressed(ActionEvent event) {
    	
    	//Se � l'ultima riparti dalla prima
    	if (currentImage == 2) {
    		currentImage = 0;
    		imagePresentation.setImage(images[currentImage]);
    	} else {
    		currentImage++;
    		imagePresentation.setImage(images[currentImage]);
    	}
    }

    @FXML
    void searchCaritasButtonPressed(ActionEvent event) {
    	try {

    		
	        String fxmlFile = "/boundary/Cerca_caritas.fxml";
	      
	        FXMLLoader fxmlLoader = new FXMLLoader();
	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream(fxmlFile));
	       
	        final Cerca_caritas controller = fxmlLoader.getController();
	        final Projection projection = /*getParameters().getUnnamed().contains("wgs84")
	            ? Projection.WGS_84 : */Projection.WEB_MERCATOR;
	        controller.initMapAndControls(projection);
	        controller.setIdUtente(currentUser.getID());

	        Scene scene = new Scene(rootNode);
	        Stage primaryStage = (Stage) searchCaritasButton.getScene().getWindow();

	        primaryStage.setTitle("sothawo mapjfx demo application");
	        primaryStage.setScene(scene);
	      
	        primaryStage.show();
	        
	        
	        

	     
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
  
   
    }
 

	public void initData(VolunteerUser user) {
    	setCurrentUser(user);
    	this.nomeCognome.setText(user.getNome() + " "+ user.getCognome());
    	final Circle clip = new Circle();
    	clip.setCenterX(25);
    	clip.setCenterY(58);
    	clip.setRadius(200);
        this.profileImage.setClip(clip);
    	long delay = 3000; //update once per 3 seconds.
    	new Timer().schedule(new TimerTask() {

    	    @Override
    	    public void run() {
    	        User_Home_Boundary.this.imagePresentation.setImage(images[User_Home_Boundary.this.currentImage++]);
    	        if (User_Home_Boundary.this.currentImage >= User_Home_Boundary.this.images.length) {
    	            User_Home_Boundary.this.currentImage = 0;
    	        }
    	    }
    	}, 0, delay);
    	
    	this.user_c.setCurrentUser(user);
    }
    
    

	public void setIdUtente(int id_utente) {
		this.idUtente = id_utente;
		
	}

}


