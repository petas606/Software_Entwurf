package kern.einsatzplanung.innensicht.technischesDatenmodell;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;

public class Einsatzplan {
	private Einsatzzeit einsatzzeit;
	private String fahrzeugKennzeichen;
	private Straﬂenwart strassenwart1;
	private Straﬂenwart strassenwart2;
	private Collection<Autobahnabschnitt> autobahnabschnitte;
	private ArrayList<Autobahnabschnitt> autobahnabschnitteListe;
	
	private String planer;
	
	public Einsatzplan() {
		autobahnabschnitte = new ArrayList<Autobahnabschnitt>();
		autobahnabschnitteListe = new ArrayList<Autobahnabschnitt>();
	}
	
	public Einsatzplan(String fahrzeugKennzeichen, Einsatzzeit einsatzzeit, Straﬂenwart strassenwart, Collection<Autobahnabschnitt> autobahnabschnitte ) {
		this.fahrzeugKennzeichen = fahrzeugKennzeichen;
		this.einsatzzeit = einsatzzeit;
		this.strassenwart1 = strassenwart;
		this.autobahnabschnitte = autobahnabschnitte;
	}
	
	public Einsatzplan(String fahrzeugKennzeichen, Einsatzzeit einsatzzeit, Straﬂenwart strassenwart1, Straﬂenwart strassenwart2, Collection<Autobahnabschnitt> autobahnabschnitte ) {
		this.fahrzeugKennzeichen = fahrzeugKennzeichen;
		this.einsatzzeit = einsatzzeit;
		this.strassenwart1 = strassenwart1;
		this.strassenwart2 = strassenwart2;
		this.autobahnabschnitte = autobahnabschnitte;
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
	public Straﬂenwart getStrassenwart1() {
		return strassenwart1;
	}
	public void setStrassenwart1(Straﬂenwart strassenwart1) {
		this.strassenwart1 = strassenwart1;
	}
	public Straﬂenwart getStrassenwart2() {
		return strassenwart2;
	}
	public void setStrassenwart2(Straﬂenwart strassenwart2) {
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
	
	public EinsatzplanTO toEinsatzplanTO() {
		System.out.println("To EinsatzplanTO");
		ArrayList<AutobahnabschnittTO> autobahnabschnitteTO = new ArrayList<AutobahnabschnittTO>();
		for(Autobahnabschnitt autobahnabschnitt : this.autobahnabschnitte) 
		{
			autobahnabschnitteTO.add(autobahnabschnitt.toAutobahnabschnittTO());
		}
		EinsatzplanTO einsatzplanTO = new EinsatzplanTO();
		einsatzplanTO.setEinsatzzeit(this.getEinsatzzeit());
		einsatzplanTO.setFahrzeugKennzeichen(this.getFahrzeugKennzeichen());
		einsatzplanTO.setAutobahnabschnitte(autobahnabschnitteTO);
		return einsatzplanTO;
	}
}
