package kern.einsatzplanung.innensicht.technischesDatenmodell;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;

public class Autobahnabschnitt {
	private int autobahnAbschnittID;
	public int getAutobahnAbschnittID() {
		return autobahnAbschnittID;
	}

	public void setAutobahnAbschnittID(int autobahnAbschnittID) {
		this.autobahnAbschnittID = autobahnAbschnittID;
	}

	private String autobahnnummer;
	private double autobahnKilometerStart;
	private double autobahnKilometerEnde;
	private int reihenfolge;
	private Set<Einsatzplan> zugehoerigeEinsatzplaene;
	
	public void anlegen() 
	{
		//TODO
	}
	
	public Autobahnabschnitt() {
		zugehoerigeEinsatzplaene = new HashSet<Einsatzplan>();
	}
	public String getAutobahnnummer() {
		return autobahnnummer;
	}
	public void setAutobahnnummer(String autobahnnummer) {
		this.autobahnnummer = autobahnnummer;
	}
	public double getAutobahnKilometerStart() {
		return autobahnKilometerStart;
	}
	public void setAutobahnKilometerStart(double autobahnKilometerStart) {
		this.autobahnKilometerStart = autobahnKilometerStart;
	}
	public double getAutobahnKilometerEnde() {
		return autobahnKilometerEnde;
	}
	public void setAutobahnKilometerEnde(double autobahnKilometerEnde) {
		this.autobahnKilometerEnde = autobahnKilometerEnde;
	}
	public int getReihenfolge() {
		return reihenfolge;
	}
	public void setReihenfolge(int reihenfolge) {
		this.reihenfolge = reihenfolge;
	}
	public Set<Einsatzplan> getZugehoerigeEinsatzplaene() {
		return zugehoerigeEinsatzplaene;
	}
	
	public void addZugehoerigeEinsatzplan(Einsatzplan einsatzplan) 
	{
		this.zugehoerigeEinsatzplaene.add(einsatzplan);
	}
	
	public void setZugehoerigeEinsatzplaene(Set<Einsatzplan> zugehoerigeEinsatzplaene) {
		this.zugehoerigeEinsatzplaene = zugehoerigeEinsatzplaene;
	}
	
	public AutobahnabschnittTO toAutobahnabschnittTO () {
		AutobahnabschnittTO autobahnabschnittTO = new AutobahnabschnittTO();
		autobahnabschnittTO.setAutobahnnummer(this.getAutobahnnummer());
		autobahnabschnittTO.setAutobahnKilometerStart(this.getAutobahnKilometerStart());
		autobahnabschnittTO.setAutobahnKilometerEnde(this.getAutobahnKilometerEnde());
		autobahnabschnittTO.setReihenfolge(this.getReihenfolge());
		autobahnabschnittTO.setAutobahnAbschnittID(this.autobahnAbschnittID);
		autobahnabschnittTO.setZugehoerigeEinsatzplaene(this.getZugehoerigeEinsatzplaene());
		return autobahnabschnittTO;
	}
}
