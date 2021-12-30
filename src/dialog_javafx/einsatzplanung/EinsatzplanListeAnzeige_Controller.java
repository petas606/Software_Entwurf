package dialog_javafx.einsatzplanung;

import java.util.Collection;

import dialog_javafx.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private ObservableList<EinplanListAnzeige_EinsatzplanDaten> einsatzplanListe = FXCollections.observableArrayList();
	
	public void setScreenController (Hauptmenue screencontroller) {
    	this.screencontroller = screencontroller;
    	IEinsatzplanFactory factory = new EinsatzplanFactory();
    	IEinsatzplanlisteAnzeigen einsatzplanAnzeigen = factory.einsatzplanAnzeigen();
    	Collection<EinsatzplanTO> einsatzplanTOs = einsatzplanAnzeigen.einsatzplaeneAnzeigen();
    	einsatzplanListe.clear();
    	for(EinsatzplanTO einsatzplanTO: einsatzplanTOs) 
    	{
    		EinplanListAnzeige_EinsatzplanDaten einsatzplanDaten = new EinplanListAnzeige_EinsatzplanDaten();
    		einsatzplanDaten.setEinsatplanId(Integer.toString(einsatzplanTO.getEinsatplanId()));
    		einsatzplanDaten.setEinsatzzeit(einsatzplanTO.getEinsatzzeit().toString());
    		einsatzplanDaten.setStrassenwart1(einsatzplanTO.getStrassenwart1().toString());
    		einsatzplanDaten.setStrassenwart2(einsatzplanTO.getStrassenwart2().toString());
    		einsatzplanDaten.setFahrzeugKennzeichen(einsatzplanTO.getFahrzeugKennzeichen());
    		einsatzplanDaten.setAutobahnabschnitte(einsatzplanTO.getAutobahnabschnitte().toString());
    		einsatzplanListe.add(einsatzplanDaten);
    	}
    }
	
	public void einsatzplanAnlegenMaske() {
		screencontroller.anzeigen(Hauptmenue.EINSATZPLANANLEGEN);
	}
	
	
}
