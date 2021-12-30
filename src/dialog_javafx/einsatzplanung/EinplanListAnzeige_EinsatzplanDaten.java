package dialog_javafx.einsatzplanung;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EinplanListAnzeige_EinsatzplanDaten {

	private  StringProperty einsatplanId;
	private  StringProperty einsatzzeit;
	private  StringProperty fahrzeugKennzeichen;
	private  StringProperty strassenwart1;
	private  StringProperty strassenwart2;
	private  StringProperty autobahnabschnitte;
	
	public EinplanListAnzeige_EinsatzplanDaten(String einsatplanId, String einsatzzeit,
			String fahrzeugKennzeichen, String strassenwart1, String strassenwart2,
			String autobahnabschnitte) {
		super();
		this.einsatplanId = new SimpleStringProperty(einsatplanId);
		this.einsatzzeit = new SimpleStringProperty(einsatzzeit);
		this.fahrzeugKennzeichen = new SimpleStringProperty(fahrzeugKennzeichen);
		this.strassenwart1 = new SimpleStringProperty(strassenwart1);
		this.strassenwart2 = new SimpleStringProperty(strassenwart2);
		this.autobahnabschnitte = new SimpleStringProperty(autobahnabschnitte);
	}
	
	public EinplanListAnzeige_EinsatzplanDaten() {
		this(null,null,null,null,null,null);
	}
	
	public StringProperty einsatzplanIdProperty() {
		return einsatplanId;
    }
	
	public String getEinsatplanId() {
		return einsatplanId.get();
	}

	public void setEinsatplanId(String einsatplanId) {
		this.einsatplanId.set(einsatplanId);
	}
	
	public StringProperty einsatzzeitProperty() {
		return einsatzzeit;
    }

	public String getEinsatzzeit() {
		return einsatzzeit.get();
	}

	public void setEinsatzzeit(String einsatzzeit) {
		this.einsatzzeit.set(einsatzzeit);
	}
	
	public StringProperty fahrzeugKennzeichenProperty() {
		return fahrzeugKennzeichen;
    }

	public String getFahrzeugKennzeichen() {
		return fahrzeugKennzeichen.get();
	}

	public void setFahrzeugKennzeichen(String fahrzeugKennzeichen) {
		this.fahrzeugKennzeichen.set(fahrzeugKennzeichen);
	}

	public StringProperty strassenwart1Property() {
		return strassenwart1;
    }
	
	public String getStrassenwart1() {
		return strassenwart1.get();
	}

	public void setStrassenwart1(String strassenwart1) {
		this.strassenwart1.set(strassenwart1);
	}
	
	public StringProperty strassenwart2Property() {
		return strassenwart2;
    }

	public String getStrassenwart2() {
		return strassenwart2.get();
	}

	public void setStrassenwart2(String strassenwart2) {
		this.strassenwart2.set(strassenwart2);
	}
	
	public StringProperty autobahnabschnittProperty() {
		return autobahnabschnitte;
    }

	public String getAutobahnabschnitte() {
		return autobahnabschnitte.get();
	}

	public void setAutobahnabschnitte(String autobahnabschnitte) {
		this.autobahnabschnitte.set(autobahnabschnitte);
	}

	
	
}
