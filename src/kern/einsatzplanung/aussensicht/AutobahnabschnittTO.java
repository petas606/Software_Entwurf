package kern.einsatzplanung.aussensicht;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;

public class AutobahnabschnittTO {
	private int autobahnAbschnittID;
	private String autobahnnummer;
	private double autobahnKilometerStart;
	private double autobahnKilometerEnde;
	private int reihenfolge;
	private Set<Einsatzplan> zugehoerigeEinsatzplaene;
	
	public AutobahnabschnittTO() {
		zugehoerigeEinsatzplaene = new HashSet<Einsatzplan>();
	}
	public String getAutobahnnummer() {
		return autobahnnummer;
	}
	public void setAutobahnnummer(String autobahnnummer) {
		this.autobahnnummer = autobahnnummer;
	}
	public void setAutobahnKilometerStart(double autobahnKilometerStart) {
		this.autobahnKilometerStart = autobahnKilometerStart;
	}
	public void setAutobahnKilometerEnde(double autobahnKilometerEnde) {
		this.autobahnKilometerEnde = autobahnKilometerEnde;
	}
	public void setReihenfolge(int reihenfolge) {
		this.reihenfolge = reihenfolge;
	}
	public void setZugehoerigeEinsatzplaene(Set<Einsatzplan> zugehoerigeEinsatzplaene) {
		this.zugehoerigeEinsatzplaene = zugehoerigeEinsatzplaene;
	}
	public double getAutobahnKilometerStart() {
		return autobahnKilometerStart;
	}
	
	public double getAutobahnKilometerEnde() {
		return autobahnKilometerEnde;
	}
	
	public int getReihenfolge() {
		return reihenfolge;
	}

	public Set<Einsatzplan> getZugehoerigeEinsatzplaene() {
		return zugehoerigeEinsatzplaene;
	}
	
	public Autobahnabschnitt toAutobahnAbschnitt() 
	{
		Autobahnabschnitt autobahnabschnitt = new Autobahnabschnitt();
		autobahnabschnitt.setAutobahnKilometerEnde(autobahnKilometerEnde);
		autobahnabschnitt.setAutobahnKilometerStart(autobahnKilometerStart);
		autobahnabschnitt.setAutobahnnummer(autobahnnummer);
		autobahnabschnitt.setAutobahnAbschnittID(autobahnAbschnittID);
		autobahnabschnitt.setReihenfolge(reihenfolge);
		return autobahnabschnitt;
	}
	public int getAutobahnAbschnittID() {
		return autobahnAbschnittID;
	}
	public void setAutobahnAbschnittID(int autobahnAbschnittID) {
		this.autobahnAbschnittID = autobahnAbschnittID;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return autobahnnummer + " " + autobahnKilometerStart + " - " + autobahnKilometerEnde ;
	}
}
