package kern.einsatzplanung.innensicht.useCases;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.IEinsatzplanManuellAnlegen;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;

public class EinsatzplanManuellAnlegen implements IEinsatzplanManuellAnlegen {

	@Override
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatzplanTO) {
		EinsatzplanManager einsatzplanManager = new EinsatzplanManager();
		if (this.einsatzplanValidieren (einsatzplanManager, einsatzplanTO.getEinsatzzeit(), einsatzplanTO.getFahrzeugKennzeichen())) {
			einsatzplanManager.einsatzplanAnlegen(new Einsatzplan(einsatzplanTO.getFahrzeugKennzeichen(), einsatzplanTO.toEinsatzPlan().getEinsatzzeit(), einsatzplanTO.toEinsatzPlan().getStrassenwart1(), einsatzplanTO.toEinsatzPlan().getAutobahnabschnitte()));
			return true;
		} else {
			return false;
		}
	}
	
	public boolean einsatzplanValidieren (EinsatzplanManager einsatzplanManager, Einsatzzeit einsatzzeit, String fahrzeugkennzeichen) {
		if(einsatzplanManager.istEinsatzplanVorhanden(einsatzzeit, fahrzeugkennzeichen)) {
			System.out.println("Einsatzplan schon vorhanden!");
			return false;
		} else {
			return true;
		}
	}

}
