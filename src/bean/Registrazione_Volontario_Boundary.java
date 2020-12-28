package bean;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import controller.Registrazione_Volontario_Controller;
import dao.VolunteerRepository;
import entity.VolunteerUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Registrazione_Volontario_Boundary implements Initializable {
	private Registrazione_Volontario_Controller Reg_c;

	TextField[] textFields;


	    @FXML
	    private TextField cittaRes;

	    @FXML
	    private TextField via;

	    @FXML
	    private TextField civico;

	    @FXML
	    private TextField tel;

	    @FXML
	    private TextField mail;

	    @FXML
	    private TextField nome;

	    @FXML
	    private TextField cognome;

	    @FXML
	    private Button completaReg;

	    @FXML
	    private TextField codiceFisc;

	    @FXML
	    private Button backButton;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private PasswordField confermaPass;

	    @FXML
	    private Text passwordMatch;


	    @FXML
	    private TextField Date;
	  




	public Registrazione_Volontario_Boundary() {
		Reg_c = new Registrazione_Volontario_Controller();
	}

	@FXML
	void backButtonPressed(ActionEvent event) {

		Reg_c.backButtonPressed(backButton.getScene().getWindow());

	}

	@FXML
	void registraVolontarioPressed(ActionEvent event) {

		if (checker() == 0) {
			//Date date2 = java.sql.Date.valueOf(Date.getValue());
		VolunteerUser id =	Reg_c.completaButtonPressed( nome.getText(), cognome.getText(),
					password.getText(), via.getText(), tel.getText(), mail.getText(), Date.getText(),
					cittaRes.getText());
		
			try {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/UserHomePage.fxml"));
    			Parent root = loader.load();
    			User_Home_Boundary userHomeBoundary = loader.getController();
    			userHomeBoundary.initData(id);
    			Stage home = (Stage) completaReg.getScene().getWindow();
    			home.setScene(new Scene(root, 800, 600));
    			
    			home.show();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	

		}

	}

	public int checker() {

		// Controlla che non ci siano campi lasciati vuoti
		for (int i = 0; i < textFields.length; i++) {
			if (textFields[i].getText().isEmpty()) {
				passwordMatch.setText("Alcuni campi sono vuoti");
				passwordMatch.setVisible(true);
				return -1;
			}
		}

		// Valida che i campi password e conferma password siano uguali

		if (password.getText().equals(confermaPass.getText())) {
			passwordMatch.setVisible(false);
			System.out.println("Password confirmed");
			return 0;
		} else {
			passwordMatch.setText("Le password non corrispondono");
			passwordMatch.setVisible(true);
			return -1;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		passwordMatch.setVisible(false);
		textFields = new TextField[] { nome, mail, cittaRes, cognome, civico, via, tel };
		// Per rendere opzionale un campo basta rimuoverlo da questa lista
	}

}
