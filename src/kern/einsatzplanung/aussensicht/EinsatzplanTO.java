package kern.einsatzplanung.aussensicht;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Straßenwart;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;

public class EinsatzplanTO {
	private int einsatplanId;
	private Einsatzzeit einsatzzeit;
	private String fahrzeugKennzeichen;
	private StraßenwartTO strassenwart1;
	private StraßenwartTO strassenwart2;
	private Collection<AutobahnabschnittTO> autobahnabschnitte;
	private String planer;
	
	public EinsatzplanTO() {
		autobahnabschnitte = new ArrayList<AutobahnabschnittTO>();
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

	public void setAutobahnabschnitte(Collection<AutobahnabschnittTO> autobahnabschnitte) {
		this.autobahnabschnitte = autobahnabschnitte;
	}

	public void setPlaner(String planer) {
		this.planer = planer;
	}

	public StraßenwartTO getStrassenwart1() {
		return strassenwart1;
	}
	
	public void setStrassenwart1(StraßenwartTO strassenwart1) {
		this.strassenwart1 = strassenwart1;
	}
	
	public StraßenwartTO getStrassenwart2() {
		return strassenwart2;
	}
	
	public void setStrassenwart2(StraßenwartTO strassenwart2) {
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
		ArrayList<Autobahnabschnitt> autobahnabschnitts = new ArrayList<Autobahnabschnitt>();
		for(AutobahnabschnittTO temp: this.autobahnabschnitte) 
		{
			autobahnabschnitts.add(temp.toAutobahnAbschnitt());
		}
		Einsatzplan einsatzplan = new Einsatzplan();
		einsatzplan.setStrassenwart1(this.strassenwart1.toStraßenwart());
		einsatzplan.setStrassenwart2(this.strassenwart2.toStraßenwart());
		einsatzplan.setEinsatzzeit(this.einsatzzeit);
		einsatzplan.setFahrzeugKennzeichen(this.fahrzeugKennzeichen);
		einsatzplan.setAutobahnabschnitte(autobahnabschnitts);
		einsatzplan.setEinsatzplanId(einsatplanId);
		return einsatzplan;
	}

	public int getEinsatplanId() {
		return einsatplanId;
	}

	public void setEinsatplanId(int einsatplanId) {
		this.einsatplanId = einsatplanId;
	}

	
}
