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
	TableView<EinplanListAnzeige_EinsatzplanDaten> tblEinsatzplanung;
	@FXML
	Button btnEinsatzplanAnlegen;
	@FXML
	TableColumn<EinplanListAnzeige_EinsatzplanDaten, String> tcEinsatzPlanId;
	@FXML
	TableColumn<EinplanListAnzeige_EinsatzplanDaten, String> tcFahrzeug;
	@FXML
	TableColumn<EinplanListAnzeige_EinsatzplanDaten, String> tcEinsatzzeit;
	@FXML
	TableColumn<EinplanListAnzeige_EinsatzplanDaten, String> tcStrassenwart1;
	@FXML
	TableColumn<EinplanListAnzeige_EinsatzplanDaten, String> tcStrassenwart2;
	@FXML
	TableColumn<EinplanListAnzeige_EinsatzplanDaten, String> tcAutobahnabschnitt;
	private Hauptmenue screencontroller;
	private static ObservableList<EinplanListAnzeige_EinsatzplanDaten> einsatzplanListe = FXCollections.observableArrayList();
	
	 public void initialize()  {
		 tcEinsatzPlanId.setCellValueFactory(cellData -> cellData.getValue().einsatzplanIdProperty());
		 tcFahrzeug.setCellValueFactory(cellData -> cellData.getValue().fahrzeugKennzeichenProperty()); 
		 tcEinsatzzeit.setCellValueFactory(cellData -> cellData.getValue().einsatzzeitProperty());
		 tcStrassenwart1.setCellValueFactory(cellData -> cellData.getValue().strassenwart1Property());
		 tcStrassenwart2.setCellValueFactory(cellData -> cellData.getValue().strassenwart2Property());
		 tcAutobahnabschnitt.setCellValueFactory(cellData -> cellData.getValue().autobahnabschnittProperty());	
		 tblEinsatzplanung.setItems(show());
		 
	    }

	
	
	 public static ObservableList<EinplanListAnzeige_EinsatzplanDaten> show() { 
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
		return einsatzplanListe;
	}

	public void setScreenController (Hauptmenue screencontroller) {
    	this.screencontroller = screencontroller;
    	
    }
	
	public void einsatzplanAnlegenMaske() {
		screencontroller.anzeigen(Hauptmenue.EINSATZPLANANLEGEN);
	}
	
	
}
