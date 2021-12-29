package kern.einsatzplanung.aussensicht;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Stra�enwart;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;

public class EinsatzplanTO {
	private Einsatzzeit einsatzzeit;
	private String fahrzeugKennzeichen;
	private Stra�enwartTO strassenwart1;
	private Stra�enwartTO strassenwart2;
	private Collection<AutobahnabschnittTO> autobahnabschnitte;
	private String planer;
	
	
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

	public void setAutobahnabschnitte(Collection<AutobahnabschnittTO> autobahnabschnitte) {
		this.autobahnabschnitte = autobahnabschnitte;
	}

	public void setPlaner(String planer) {
		this.planer = planer;
	}

	public Stra�enwartTO getStrassenwart1() {
		return strassenwart1;
	}
	
	public void setStrassenwart1(Stra�enwartTO strassenwart1) {
		this.strassenwart1 = strassenwart1;
	}
	
	public Stra�enwartTO getStrassenwart2() {
		return strassenwart2;
	}
	
	public void setStrassenwart2(Stra�enwartTO strassenwart2) {
		this.strassenwart2 = strassenwart2;
	}
	
	public Collection<AutobahnabschnittTO> getAutobahnabschnitte() {
		return autobahnabschnitte;
	}
	
	public void addAutobahnabschnitt(AutobahnabschnittTO autobahnabschnitt) 
	{
		this.autobahnabschnitte.add(autobahnabschnitt);
	}	
	public String getPlaner() {
		return planer;
	}
	
	public Einsatzplan toEinsatzPlan() 
	{
		return new Einsatzplan();
	}
	
}
