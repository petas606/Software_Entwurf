package kern.einsatzplanung.innensicht.technischesDatenmodell;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;

public class Einsatzplan {
	private Einsatzzeit einsatzzeit;
	private String fahrzeugKennzeichen;
	private Stra�enwart strassenwart1;
	private Stra�enwart strassenwart2;
	private Collection<Autobahnabschnitt> autobahnabschnitte;
	private String planer;
	
	public Einsatzplan() {
		autobahnabschnitte = new ArrayList<Autobahnabschnitt>();
	}
	
	public void anlegen() 
	{
		//TODO
	}
	
	public Einsatzzeit getEinsatzzeit() {
		return einsatzzeit;
	}
	public void setEinsatzzeit(Einsatzzeit einsatzzeit) {
		this.einsatzzeit = einsatzzeit;
	}
	public String getFahrzeugKennzeichen() {
		return fahrzeugKennzeichen;
	}
	public void setFahrzeugKennzeichen(String fahrzeugKennzeichen) {
		this.fahrzeugKennzeichen = fahrzeugKennzeichen;
	}
	public Stra�enwart getStrassenwart1() {
		return strassenwart1;
	}
	public void setStrassenwart1(Stra�enwart strassenwart1) {
		this.strassenwart1 = strassenwart1;
	}
	public Stra�enwart getStrassenwart2() {
		return strassenwart2;
	}
	public void setStrassenwart2(Stra�enwart strassenwart2) {
		this.strassenwart2 = strassenwart2;
	}
	
	public Collection<Autobahnabschnitt> getAutobahnabschnitte() {
		return autobahnabschnitte;
	}
	
	public void setAutobahnabschnitte(Collection<Autobahnabschnitt> autobahnabschnitte) {
		this.autobahnabschnitte = autobahnabschnitte;
	}
	
	public void addAutobahnabschnitt(Autobahnabschnitt autobahnabschnitt) 
	{
		this.autobahnabschnitte.add(autobahnabschnitt);
	}
	
	public String getPlaner() {
		return planer;
	}
	public void setPlaner(String planer) {
		this.planer = planer;
	}
	@Override
	public boolean equals(Object obj) {
		Einsatzplan temp = (Einsatzplan) obj;
		return this.fahrzeugKennzeichen == temp.fahrzeugKennzeichen 
				&& einsatzzeit.getWochentag() == temp.einsatzzeit.getWochentag() 
				&& einsatzzeit.getTageszeit() == temp.einsatzzeit.getTageszeit();
	}
}
