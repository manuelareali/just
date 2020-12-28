package bean;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import entity.CaritasUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Caritas_Home_Boundary {

	private Image img1 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestain.PNG");
	private Image img2 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/PelleDrago.PNG");
	private Image img3 = new Image("file:/C:/Users/PRX/Desktop/TZEDAKAH/DragoInizio/DragoForestaIniz.PNG");
	private Image[] images = { img1, img2, img3 };
	private int currentImage = 0;
	private  static Caritas_Home_Boundary instance = null;

	private CaritasUser currentUser;

	private Bacheca_Personale_Boundary bacheca;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="CreaPacco"
	private Button CreaPacco; // Value injected by FXMLLoader

	@FXML // fx:id="arrowLeft"
	private ImageView arrowLeft; // Value injected by FXMLLoader

	@FXML // fx:id="arrowRight"
	private ImageView arrowRight; // Value injected by FXMLLoader

	@FXML // fx:id="deleteAccountButton"
	private Button deleteAccountButton; // Value injected by FXMLLoader

	@FXML // fx:id="helpButton"
	private Button helpButton; // Value injected by FXMLLoader

	@FXML // fx:id="imagePresentation"
	private ImageView imagePresentation; // Value injected by FXMLLoader

	@FXML // fx:id="leftArrowButton"
	private Button leftArrowButton; // Value injected by FXMLLoader

	@FXML // fx:id="logoutButton"
	private Button logoutButton; // Value injected by FXMLLoader

	@FXML // fx:id="nomeCognome"
	private Text nomeCognome; // Value injected by FXMLLoader

	@FXML // fx:id="profileButton"
	private Button profileButton; // Value injected by FXMLLoader

	@FXML // fx:id="profileImage"
	private ImageView profileImage; // Value injected by FXMLLoader

	@FXML // fx:id="rightArrowButton"
	private Button rightArrowButton; // Value injected by FXMLLoader

	@FXML
	private Button v_bacheca; // Value injected by FXMLLoader

	@FXML 
	private Text textOverImages; // Value injected by FXMLLoader
	
	
	
	public static Caritas_Home_Boundary getInstance() {
		if (instance == null) {
			instance = new Caritas_Home_Boundary();
			}
		return instance;
	}
	
	

	public Caritas_Home_Boundary() {
		bacheca = new Bacheca_Personale_Boundary();
	}

	@FXML
	void Gestisci_donazioni(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void Gestisci_eventi(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void Gestisci_turni(ActionEvent event) {
		// handle the event here
	}

	@FXML  // dobbiamo far fare un controllo alla bacheca_controller nel quale a seconda di chi entra ( carita o altri ) il tasto indietro porta alla schermata giusta.
	void Visualizza_bacheca(ActionEvent event) {
		try {     
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Bacheca_Personale.fxml"));
			Parent root = loader.load();

			Stage home = (Stage) v_bacheca.getScene().getWindow();
			home.setScene(new Scene(root,775, 500));
			home.show();
    		
    		 bacheca = loader.getController();
    		 bacheca.set_currentUser(this.currentUser);
    		 bacheca.loadFormBoundary(currentUser.getID());

    		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@FXML
	void deleteAccountButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void helpButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void leftArrowPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void logoutButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void profileButtonPressed(ActionEvent event) {
		// handle the event here
	}

	@FXML
	void rightArrowPressed(ActionEvent event) {
		// handle the event here
	}

	public CaritasUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CaritasUser currentUser) {
		this.currentUser = currentUser;
	}

	public void initData(CaritasUser user) {
		setCurrentUser(user);
		nomeCognome.setText(user.getNomeCaritas());
		final Circle clip = new Circle();
		clip.setCenterX(25);
		clip.setCenterY(58);
		clip.setRadius(200);
		profileImage.setClip(clip);
		long delay = 3000; // update once per 3 seconds.
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				imagePresentation.setImage(images[currentImage++]);
				if (currentImage >= images.length) {
					currentImage = 0;
				}
			}
		}, 0, delay);

	}

	@FXML
	void initialize() {

	}

}
