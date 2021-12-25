package kern.einsatzplanung.innensicht.technischesDatenmodell;

import java.util.HashSet;
import java.util.Set;

public class Autobahnabschnitt {
	private String autobahnnummer;
	private double autobahnKilometerStart;
	private double autobahnKilometerEnde;
	private int reihenfolge;
	private Set<Einsatzplan> zugehörigeEinsatzpläne;
	
	public void anlegen() 
	{
		//TODO
	}
	
	public Autobahnabschnitt() {
		zugehörigeEinsatzpläne = new HashSet<Einsatzplan>();
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
	public Set<Einsatzplan> getZugehörigeEinsatzpläne() {
		return zugehörigeEinsatzpläne;
	}
	
	public void addZugehörigeEinsatzplan(Einsatzplan einsatzplan) 
	{
		this.zugehörigeEinsatzpläne.add(einsatzplan);
	}
	
	public void setZugehörigeEinsatzpläne(Set<Einsatzplan> zugehörigeEinsatzpläne) {
		this.zugehörigeEinsatzpläne = zugehörigeEinsatzpläne;
	}
	
}
