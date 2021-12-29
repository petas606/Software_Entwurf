package kern.einsatzplanung.innensicht.technischesDatenmodell;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;

public class Autobahnabschnitt {
	private String autobahnnummer;
	private double autobahnKilometerStart;
	private double autobahnKilometerEnde;
	private int reihenfolge;
	private Set<Einsatzplan> zugeh�rigeEinsatzpl�ne;
	
	public void anlegen() 
	{
		//TODO
	}
	
	public Autobahnabschnitt() {
		zugeh�rigeEinsatzpl�ne = new HashSet<Einsatzplan>();
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
	public Set<Einsatzplan> getZugeh�rigeEinsatzpl�ne() {
		return zugeh�rigeEinsatzpl�ne;
	}
	
	public void addZugeh�rigeEinsatzplan(Einsatzplan einsatzplan) 
	{
		this.zugeh�rigeEinsatzpl�ne.add(einsatzplan);
	}
	
	public void setZugeh�rigeEinsatzpl�ne(Set<Einsatzplan> zugeh�rigeEinsatzpl�ne) {
		this.zugeh�rigeEinsatzpl�ne = zugeh�rigeEinsatzpl�ne;
	}
	
	public AutobahnabschnittTO toAutobahnabschnittTO () {
		AutobahnabschnittTO autobahnabschnittTO = new AutobahnabschnittTO();
		autobahnabschnittTO.setAutobahnnummer(this.getAutobahnnummer());
		autobahnabschnittTO.setAutobahnKilometerStart(this.getAutobahnKilometerStart());
		autobahnabschnittTO.setAutobahnKilometerEnde(this.getAutobahnKilometerEnde());
		autobahnabschnittTO.setReihenfolge(this.getReihenfolge());
		autobahnabschnittTO.setZugeh�rigeEinsatzpl�ne(this.getZugeh�rigeEinsatzpl�ne());
		return autobahnabschnittTO;
	}
}
