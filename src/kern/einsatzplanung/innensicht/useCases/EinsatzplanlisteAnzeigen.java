package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.IEinsatzplanlisteAnzeigen;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;

public class EinsatzplanlisteAnzeigen implements IEinsatzplanlisteAnzeigen {

	@Override
	public Collection<EinsatzplanTO> einsatzplaeneAnzeigen() {
		EinsatzplanManager einsatzplanManager = new EinsatzplanManager();
		Collection<Einsatzplan> einsatzplans = einsatzplanManager.einsatzplaeneAnzeigen();
		if(einsatzplans.isEmpty()) 
		{
			return new ArrayList<EinsatzplanTO>();
		}
		ArrayList<EinsatzplanTO> einsatzplanTOs = new ArrayList<EinsatzplanTO>();
		for(Einsatzplan einsatzplan : einsatzplans) 
		{
			einsatzplanTOs.add(einsatzplan.toEinsatzplanTO());
		}
		return einsatzplanTOs;
	}

}
