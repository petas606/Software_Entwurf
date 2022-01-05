package dialog_javafx.einsatzplanung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

import dialog_javafx.Hauptmenue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.IEinsatzplanFactory;
import kern.einsatzplanung.aussensicht.IEinsatzplanManuellAnlegen;
import kern.einsatzplanung.aussensicht.StrassenwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Tageszeit;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.WochenTag;
import kern.einsatzplanung.innensicht.useCases.EinsatzplanFactory;
import kern.einsatzplanung.innensicht.useCases.EinsatzplanManuellAnlegen;

public class EinsatzplanManuelleAnlage_Controller {
	@FXML
	TextField txtAutobahnnummer;
	@FXML
	TextField txtAutobahnkilometerStart;
	@FXML
	TextField txtAutobahnkilometerEnde;
	@FXML
	TextField txtFahrzeug;
	@FXML
	ComboBox<WochenTag> cboWochentag;
	@FXML
	RadioButton rbTagsüber;
	@FXML
	RadioButton rbNacht;
	@FXML
	ComboBox<StrassenwartTO> cboStrassenwart2;
	@FXML
	ComboBox<StrassenwartTO> cboStrassenwart1;
	
	private Hauptmenue screencontroller;
	
	public void setScreenController (Hauptmenue screencontroller) {
    	this.screencontroller = screencontroller;
    }
	
	public void initialize() 
	{
		IEinsatzplanFactory factory = new EinsatzplanFactory();
		IEinsatzplanManuellAnlegen einsatzplanManuellAnlegen = factory.einsatzplanManuellAnlegen();
		ObservableList<StrassenwartTO> straßenwartTOs = FXCollections.observableArrayList();
		straßenwartTOs.addAll(einsatzplanManuellAnlegen.straßenwärterAnzeigen());
		cboStrassenwart1.setItems(straßenwartTOs);
		cboStrassenwart2.setItems(straßenwartTOs);
		
		ObservableList<WochenTag> wochenTags = FXCollections.observableArrayList();
		wochenTags.addAll(Arrays.asList(WochenTag.class.getEnumConstants()));
		cboWochentag.setItems(wochenTags);
	}
	
	public void weiterePerson() 
	{
		cboStrassenwart2.setVisible(true);
	}
	
	public void rbTagesüberSelected() 
	{
		if(rbNacht.isSelected())
		{
			rbNacht.setSelected(false);
		}
	}
	
	public void rbNachtsSelected() 
	{
		if(rbTagsüber.isSelected()) 
		{
			rbTagsüber.setSelected(false);
		}
	}
	
	public void abbrechen() 
	{
		screencontroller.anzeigen(Hauptmenue.EINSATZPLANLISTE);
		EinsatzplanListeAnzeige_Controller.show();
	}
	
	public void anlegen() 
	{
		EinsatzplanFactory factory = new EinsatzplanFactory();
		IEinsatzplanManuellAnlegen einsatzplanManuellAnlegen = factory.einsatzplanManuellAnlegen();
		
		Collection<AutobahnabschnittTO> autobahnabschnittTOs = new ArrayList<AutobahnabschnittTO>();
		AutobahnabschnittTO autobahnabschnittTO = new AutobahnabschnittTO();
		
		autobahnabschnittTO.setAutobahnnummer(txtAutobahnnummer.getText());
		autobahnabschnittTO.setAutobahnKilometerStart(Double.parseDouble(
		txtAutobahnkilometerStart.getText()));
		autobahnabschnittTO.setAutobahnKilometerEnde(Double.parseDouble(
		txtAutobahnkilometerEnde.getText())); autobahnabschnittTO.setReihenfolge(1);
		autobahnabschnittTOs.add(autobahnabschnittTO);
		 
		
		StrassenwartTO straßenwart1 = cboStrassenwart1.getValue();
		StrassenwartTO straßenwart2 = cboStrassenwart2.getValue();
		
		if(straßenwart2 == null) 
		{
			straßenwart2 = new StrassenwartTO();
		}
		
		EinsatzplanTO einsatzplanTO = new EinsatzplanTO();
		einsatzplanTO.setAutobahnabschnitte(autobahnabschnittTOs);
		einsatzplanTO.setStrassenwart1(straßenwart1);
		einsatzplanTO.setStrassenwart2(straßenwart2);
		
		Einsatzzeit einsatzzeit = new Einsatzzeit();
		einsatzzeit.setWochentstag(cboWochentag.getValue());
		if(rbTagsüber.isSelected()) 
		{
			einsatzzeit.setTageszeit(Tageszeit.TAGSUEBER);
		}else
		{
			einsatzzeit.setTageszeit(Tageszeit.NACHTS);
		}
		
		einsatzplanTO.setEinsatzzeit(einsatzzeit);
		einsatzplanTO.setFahrzeugKennzeichen(txtFahrzeug.getText());
		
		einsatzplanManuellAnlegen.einsatzplanAnlegen(einsatzplanTO);		
	}


}
