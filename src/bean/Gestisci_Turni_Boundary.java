package bean;
import entity.TurnoTab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
public class Gestisci_Turni_Boundary {

	  
		@FXML
	    private Button crea_t;

	    @FXML
	    private Button modifica_t;

	    @FXML
	    private Button elimina_t;

		@FXML
	    private TableColumn<TurnoTab, String> giorno;

	    @FXML
	    private TableColumn<TurnoTab, String> orario;

	    @FXML
	    private TableColumn<TurnoTab, Integer> partecipanti;

	    @FXML
	    private Button richieste;

	    @FXML
	    private Button back;

	    
	    
	    public Gestisci_Turni_Boundary() {}
	    
	    @FXML
	    void backPressed(ActionEvent event) {

	    }

	    @FXML
	    void crea_turno(ActionEvent event) {

	    }

	    @FXML
	    void elimina_turno(ActionEvent event) {

	    }

	    @FXML
	    void gestisci_richieste(ActionEvent event) {

	    }

	    @FXML
	    void modifica_turno(ActionEvent event) {

	    }


	}


