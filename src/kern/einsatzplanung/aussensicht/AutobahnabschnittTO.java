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
	private Set<Einsatzplan> zugeh�rigeEinsatzpl�ne;
	
	public AutobahnabschnittTO() {
		zugeh�rigeEinsatzpl�ne = new HashSet<Einsatzplan>();
	}
	public void setAutobahnnummer(String autobahnnummer) {
		this.autobahnnummer = autobahnnummer;
	}
	public void setAutobahnKilometerEnde(double autobahnKilometerEnde) {
		this.autobahnKilometerEnde = autobahnKilometerEnde;
	}
	public void setAutobahnKilometerStart(double autobahnKilometerStart) {
		this.autobahnKilometerStart = autobahnKilometerStart;
	}
	public void setReihenfolge(int reihenfolge) {
		this.reihenfolge = reihenfolge;
	}
	public void setZugeh�rigeEinsatzpl�ne(Set<Einsatzplan> zugeh�rigeEinsatzpl�ne) {
		this.zugeh�rigeEinsatzpl�ne = zugeh�rigeEinsatzpl�ne;
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
	public void setZugeh�rigeEinsatzpl�ne(Set<Einsatzplan> zugeh�rigeEinsatzpl�ne) {
		this.zugeh�rigeEinsatzpl�ne = zugeh�rigeEinsatzpl�ne;
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

	public Set<Einsatzplan> getZugeh�rigeEinsatzpl�ne() {
		return zugeh�rigeEinsatzpl�ne;
	}
	
	public Autobahnabschnitt toAutobahnAbschnitt() 
	{
		return new Autobahnabschnitt();
	}
	public int getAutobahnAbschnittID() {
		return autobahnAbschnittID;
	}
	public void setAutobahnAbschnittID(int autobahnAbschnittID) {
		this.autobahnAbschnittID = autobahnAbschnittID;
	}
}
