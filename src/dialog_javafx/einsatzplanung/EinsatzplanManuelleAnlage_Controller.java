package dialog_javafx.einsatzplanung;

import dialog_javafx.Hauptmenue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class EinsatzplanManuelleAnlage_Controller {
	@FXML
	TextField txtAutobahnnummer;
	@FXML
	TextField txtAutobahnkilometerStart;
	@FXML
	TextField txtAutobahnkilometerEnde;
	@FXML
	ComboBox<Object> cboFahrzeug;
	@FXML
	ComboBox<Object> cboWochentag;
	@FXML
	RadioButton rbTagsüber;
	@FXML
	RadioButton rbNacht;
	@FXML
	ComboBox<Object> cboStraßenwart2;
	@FXML
	ComboBox<Object> cboStraßenwart1;
	
	private Hauptmenue screencontroller;
	
	public void setScreenController (Hauptmenue screencontroller) {
    	this.screencontroller = screencontroller;
    }
	
	public void weiterePerson() 
	{
		cboStraßenwart2.setVisible(true);
		System.out.println(cboStraßenwart2.isVisible());
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
	}
	
	public void anlegen() 
	{
		screencontroller.anzeigen(Hauptmenue.EINSATZPLANLISTE);
	}


}
