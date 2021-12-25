package kern.einsatzplanung.aussensicht;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Straﬂenwart;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;

public class EinsatzplanTO {
	private Einsatzzeit einsatzzeit;
	private String fahrzeugKennzeichen;
	private Straﬂenwart strassenwart1;
	private Straﬂenwart strassenwart2;
	private Collection<AutobahnabschnittTO> autobahnabschnitte;
	private String planer;
	
	
	public Einsatzzeit getEinsatzzeit() {
		return einsatzzeit;
	}
	
	public String getFahrzeugKennzeichen() {
		return fahrzeugKennzeichen;
	}
	
	public Straﬂenwart getStrassenwart1() {
		return strassenwart1;
	}
	
	public Straﬂenwart getStrassenwart2() {
		return strassenwart2;
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
