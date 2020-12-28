package bean;
import entity.DonazioneTab;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Gestisci_Donazioni_Boundary {
	
		@FXML
	    private TableView<DonazioneTab> table;

	    @FXML
	    private TableColumn<DonazioneTab, String> tipologia;

	    @FXML
	    private TableColumn<DonazioneTab, String> descirzione;

	    @FXML
	    private TableColumn<DonazioneTab, String> indirizzo;

	    @FXML
	    private Button ritira;

	    @FXML
	    private Button contatta;

	    @FXML
	    private Button back;

	    
	    
	    @FXML
	    void backPressed(ActionEvent event) {

	    }

	    @FXML
	    void contatta_volontario(ActionEvent event) {

	    }

	    @FXML
	    void ritira_donazione(ActionEvent event) {

	    }

	}


