package bean;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.Gestisci_eventi_Controller;
import entity.CaritasUser;
import entity.EventTab;
import entity.Evento;
import entity.Necessità;
import entity.Partecipanti_evento;
import entity.ShopUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Gestisci_eventi_Boundary {

	private Gestisci_eventi_Controller gest_event_c;
	private int id_shop;
	private List<EventTab> list_ev;
	private EventTab event;
	private ShopUser shop;
	
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button caritas;

	@FXML
	private TableView<EventTab> table;

	@FXML
	private TableColumn<EventTab, String> nome_evento;

	@FXML
	private TableColumn<EventTab, String> nome_caritas;
	 @FXML
	 private TableColumn<EventTab, Integer> note_evento;

	@FXML
	private TableColumn<EventTab, Integer> num_partecipanti;
	@FXML
	private TableColumn<EventTab, Float> importo;
	  @FXML
	    private Button modifica_e;

	    @FXML
	    private Button Elimina_e;

	    @FXML
	    private Button back;

	    @FXML
	    void backButtonPressed(ActionEvent event) {
	    	 try {
	 			FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/ShopHomePage.fxml"));
	 			Parent root = loader.load();
	 			Shop_Home_Boundary ShopHomeBoundary = Shop_Home_Boundary.getInstance();
	 			ShopHomeBoundary = loader.getController();
	 			ShopHomeBoundary.initData(shop);
	 			Stage home = (Stage) back.getScene().getWindow();
	 			home.setScene(new Scene(root, 800, 600));
	 			
	 			home.show();
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}
	    	
	    	
	    }

	    @FXML
	    void contatta_caritas(ActionEvent event) {
	    	try {

    	        FXMLLoader fxmlLoader = new FXMLLoader();
    	        Parent rootNode = fxmlLoader.load(getClass().getResourceAsStream("/boundary/Email.fxml"));
    	       
    	       // donationController = fxmlLoader.getController();
    	        EmailBoundary email = fxmlLoader.getController();
    	        email.load_email(this.id_shop, this.event.getId_caritas());
    	        Stage stage = new Stage();
	    		stage.setTitle("Email");
	    		
	    		
	    		stage.setScene(new Scene(rootNode, 800, 500));
	    		stage.setResizable(false);
	    		stage.show();
	    		
	    		
	    		
	    		
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
	    	
	    }

	    @FXML
	    boolean elimina_evento(ActionEvent event) {
	    	return gest_event_c.elimina_evento(this.event.getNomeEvento());
	    }

	    @FXML
	    void modifica_evento(ActionEvent event) {
	    	
	    	
	    	
	    	
	    }

	    @FXML
	    void prendi_evento(MouseEvent e) {
	    	this.event = table.getSelectionModel().getSelectedItem();
	    	System.out.println(event.getNomeEvento());
	    }


	public Gestisci_eventi_Boundary() {

		gest_event_c = new Gestisci_eventi_Controller();

	}

	public Gestisci_eventi_Boundary(int i) {

		gest_event_c = new Gestisci_eventi_Controller();
		this.id_shop = i;

	}
	
	
	

	public void load_shop(int id_shop) {
		this.id_shop = id_shop;
		list_ev = gest_event_c.carica_eventi(this.id_shop);
		System.out.println(list_ev.get(0).getNomeEvento());

		ObservableList<EventTab> data = FXCollections.observableArrayList(list_ev);
		nome_evento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
		importo.setCellValueFactory(new PropertyValueFactory<>("rapportoDenaro"));
		nome_caritas.setCellValueFactory(new PropertyValueFactory<>("NomeCaritas"));
		note_evento.setCellValueFactory(new PropertyValueFactory<>("NoteEvento"));
		num_partecipanti.setCellValueFactory(new PropertyValueFactory<>("NumPartecipanti"));
	
		
		
		table.setItems(data);
		// table.getColumns().addAll(nome_evento);

		/*
		 * for (int i = 0; i < list_ev.size(); i++) { Evento tmp = list_ev.get(i);
		 * System.out.println(tmp.getNome());
		 * 
		 * // Id_evento.setCellValueFactory(new PropertyValueFactory<>("NomeEvento"));
		 * // table.setItems(data); //Id_evento.setCellFactory( new
		 * PropertyValueFactory<Evento,Integer>(tmp.getNome() ));
		 * 
		 * //id_caritas.setText(Integer.toString(tmp.getId_caritas()));
		 * 
		 * // initialize(); }
		 */

	}

	public ShopUser getShop() {
		return shop;
	}

	public void setShop(ShopUser shop) {
		this.shop = shop;
	}

}