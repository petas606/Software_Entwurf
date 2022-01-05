package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.IEinsatzplanManuellAnlegen;
import kern.einsatzplanung.aussensicht.StrassenwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Strassenwart;
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
		
		if(einsatzplanTO.getStrassenwart1().getStrassenwartId() == einsatzplanTO.getStrassenwart2().getStrassenwartId()) 
		{
			System.out.println("Dupizierte Straßenwart");
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
	
	public Collection<StrassenwartTO> strassenwaerterAnzeigen() {
		EinsatzplanManager einsatzplanManager = new EinsatzplanManager();
		Collection<Strassenwart> strassenwarts = einsatzplanManager.strassenwaerterAnzeigen();
		if(strassenwarts.isEmpty()) 
		{
			return new ArrayList<StrassenwartTO>();
		}
		ArrayList<StrassenwartTO> strassenwartTOs = new ArrayList<StrassenwartTO>();
		for(Strassenwart strassenwart : strassenwarts) 
		{
			strassenwartTOs.add(strassenwart.toStrassenwartTO());
		}
		return strassenwartTOs;
	}
}
