package dialog_javafx;

import dialog_javafx.einsatzplanung.EinsatzplanListeAnzeige_Controller;
import dialog_javafx.einsatzplanung.EinsatzplanManuelleAnlage_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Hauptmenue extends Application{
	
	public static void Start_Dialog() {
		launch();
	}
	
	private Scene einsatzplanListe;
	private Scene einsatzplanAnlegen;
	private Stage mainStage;
	
	public static final String EINSATZPLANLISTE = "einsatzpläne anzeigen";
	public static final String EINSATZPLANANLEGEN = "einsatzplan anlegen";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.mainStage = primaryStage;
		try {
			FXMLLoader loader;
			
			loader = new FXMLLoader(getClass().getResource("einsatzplanung/EinsatzplanListeAnzeige.fxml"));
			Parent listePane = (Parent) loader.load();
			this.einsatzplanListe = new Scene(listePane);
			EinsatzplanListeAnzeige_Controller ctrlEinsatzplaeneAnzeige = loader.getController();
			ctrlEinsatzplaeneAnzeige.setScreenController(this);
			
			
			loader = new FXMLLoader(getClass().getResource("einsatzplanung/EinsatzplanManuelleAnlage.fxml")); 
			Parent anlegenPane =(Parent) loader.load();
			this.einsatzplanAnlegen = new Scene(anlegenPane);
			EinsatzplanManuelleAnlage_Controller ctrlEinsatzPlanAnlegen =loader.getController(); 
			ctrlEinsatzPlanAnlegen.setScreenController(this);
			 
			
			anzeigen(Hauptmenue.EINSATZPLANLISTE);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void anzeigen (String screen) {			
			switch (screen) {
				case Hauptmenue.EINSATZPLANLISTE: mainStage.setScene(einsatzplanListe);
					break;
				case Hauptmenue.EINSATZPLANANLEGEN: mainStage.setScene(einsatzplanAnlegen);
					break;
			}
			
			mainStage.sizeToScene();
			mainStage.show();
	}

}
