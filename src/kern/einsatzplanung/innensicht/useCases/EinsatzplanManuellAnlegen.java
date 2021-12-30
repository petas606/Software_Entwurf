package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.IEinsatzplanManuellAnlegen;
import kern.einsatzplanung.aussensicht.StraﬂenwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Straﬂenwart;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;

public class EinsatzplanManuellAnlegen implements IEinsatzplanManuellAnlegen {

	@Override
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatzplanTO) {
		EinsatzplanManager einsatzplanManager = new EinsatzplanManager();
		einsatzplanTO.setEinsatplanId(einsatzplanManager.naeschteEinsatzplanIdErmitteln());
		int max = einsatzplanManager.naeschteAutobahnabschnittIdErmitteln();
		for(AutobahnabschnittTO autobahnabschnittTO : einsatzplanTO.getAutobahnabschnitte()) 
		{
			autobahnabschnittTO.setAutobahnAbschnittID(max);
			max = max+1;
		}
		
		if (this.einsatzplanValidieren (einsatzplanManager, einsatzplanTO)) {
			einsatzplanManager.einsatzplanAnlegen(einsatzplanTO.toEinsatzPlan());
			return true;
		}
		return false;
		
	}
	
	public boolean einsatzplanValidieren (EinsatzplanManager einsatzplanManager, EinsatzplanTO einsatzplanTO) {
		if(einsatzplanManager.istEinsatzplanVorhanden(einsatzplanTO)) {
			System.out.println("Einsatzplan schon vorhanden!");
			return false;
		}
		
		if(einsatzplanTO.getStrassenwart1().getStraﬂenwartId() == einsatzplanTO.getStrassenwart2().getStraﬂenwartId()) 
		{
			System.out.println("Dupizierte Straﬂenwart");
			return false;
		}
		
		for(AutobahnabschnittTO autobahnabschnitt : einsatzplanTO.getAutobahnabschnitte()) 
		{
			if(autobahnabschnitt.getAutobahnKilometerStart() >= autobahnabschnitt.getAutobahnKilometerEnde()) 
			{
				System.out.println("AutobahnKilometerStart muss kleiner als AutobahnKilometerEnde sein!!!");
				return false;
			}
		}
		return true;
	}
	
	public Collection<StraﬂenwartTO> straﬂenw‰rterAnzeigen() {
		EinsatzplanManager einsatzplanManager = new EinsatzplanManager();
		Collection<Straﬂenwart> straﬂenwarts = einsatzplanManager.straﬂenw‰rterAnzeigen();
		if(straﬂenwarts.isEmpty()) 
		{
			return new ArrayList<StraﬂenwartTO>();
		}
		ArrayList<StraﬂenwartTO> straﬂenwartTOs = new ArrayList<StraﬂenwartTO>();
		for(Straﬂenwart straﬂenwart : straﬂenwarts) 
		{
			straﬂenwartTOs.add(straﬂenwart.toStraﬂenwartTO());
		}
		return straﬂenwartTOs;
	}
}
