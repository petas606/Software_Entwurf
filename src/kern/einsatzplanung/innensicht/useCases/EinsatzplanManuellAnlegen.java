package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.IEinsatzplanManuellAnlegen;
import kern.einsatzplanung.aussensicht.Stra�enwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Stra�enwart;
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
		
		if(einsatzplanTO.getStrassenwart1().getStra�enwartId() == einsatzplanTO.getStrassenwart2().getStra�enwartId()) 
		{
			System.out.println("Dupizierte Stra�enwart");
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
	
	public Collection<Stra�enwartTO> stra�enw�rterAnzeigen() {
		EinsatzplanManager einsatzplanManager = new EinsatzplanManager();
		Collection<Stra�enwart> stra�enwarts = einsatzplanManager.stra�enw�rterAnzeigen();
		if(stra�enwarts.isEmpty()) 
		{
			return new ArrayList<Stra�enwartTO>();
		}
		ArrayList<Stra�enwartTO> stra�enwartTOs = new ArrayList<Stra�enwartTO>();
		for(Stra�enwart stra�enwart : stra�enwarts) 
		{
			stra�enwartTOs.add(stra�enwart.toStra�enwartTO());
		}
		return stra�enwartTOs;
	}
}
