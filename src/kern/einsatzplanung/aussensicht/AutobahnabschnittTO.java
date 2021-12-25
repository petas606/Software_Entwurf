package kern.einsatzplanung.aussensicht;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;

public class AutobahnabschnittTO {
	private String autobahnnummer;
	private double autobahnKilometerStart;
	private double autobahnKilometerEnde;
	private int reihenfolge;
	private Set<Einsatzplan> zugehörigeEinsatzpläne;
	
	public AutobahnabschnittTO() {
		zugehörigeEinsatzpläne = new HashSet<Einsatzplan>();
	}
	public String getAutobahnnummer() {
		return autobahnnummer;
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

	public Set<Einsatzplan> getZugehörigeEinsatzpläne() {
		return zugehörigeEinsatzpläne;
	}
	
	public Autobahnabschnitt toAutobahnAbschnitt() 
	{
		return new Autobahnabschnitt();
	}
}
