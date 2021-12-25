package dialog_javafx.einsatzplanung;

import dialog_javafx.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EinsatzplanListeAnzeige_Controller {
	@FXML
	TableView<Object> tblEinsatzplanung;
	@FXML
	Button btnButton;
	@FXML
	TableColumn<Object, String> tcEinsatzPlanId;
	@FXML
	TableColumn<Object, String> tcFahrzeug;
	@FXML
	TableColumn<Object, String> tcEinsatzzeit;
	@FXML
	TableColumn<Object, String> tcStraﬂenwart;
	@FXML
	TableColumn<Object, String> tcAutobahnabschnitt;
	private Hauptmenue screencontroller;
	
	public void setScreenController (Hauptmenue screencontroller) {
    	this.screencontroller = screencontroller;
    }
	
	public void einsatzplanAnlegenMaske() {
		screencontroller.anzeigen(Hauptmenue.EINSATZPLANANLEGEN);
	}
	
	
}
