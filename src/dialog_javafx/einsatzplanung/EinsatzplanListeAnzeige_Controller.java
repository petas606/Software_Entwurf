package dialog_javafx.einsatzplanung;

import java.util.Collection;

import dialog_javafx.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.IEinsatzplanFactory;
import kern.einsatzplanung.aussensicht.IEinsatzplanlisteAnzeigen;
import kern.einsatzplanung.innensicht.useCases.EinsatzplanFactory;

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
    	IEinsatzplanFactory factory = new EinsatzplanFactory();
    	IEinsatzplanlisteAnzeigen einsatzplanAnzeigen = factory.einsatzplanAnzeigen();
    	Collection<EinsatzplanTO> einsatzplanTOs = einsatzplanAnzeigen.einsatzplaeneAnzeigen();
    }
	
	public void einsatzplanAnlegenMaske() {
		screencontroller.anzeigen(Hauptmenue.EINSATZPLANANLEGEN);
	}
	
	
}
