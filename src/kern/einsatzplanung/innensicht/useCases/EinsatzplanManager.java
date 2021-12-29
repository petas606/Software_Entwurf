package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import persistence.einsatzplanung.aussensicht.IAutobahnAbschnittDAO;
import persistence.einsatzplanung.aussensicht.IEinsatzplanDAO;
import persistence.einsatzplanung.innensicht.db.AutobahnAbschnittDAO;
import persistence.einsatzplanung.innensicht.db.EinsatzplanDAO;

public class EinsatzplanManager {
	private IEinsatzplanDAO einsatzplanVerwalter = new EinsatzplanDAO();
	private IAutobahnAbschnittDAO autobahnabschnittVerwalter= new AutobahnAbschnittDAO();
	
	public Collection<Einsatzplan> einsatzplaeneAnzeigen()
	{
		ArrayList<Einsatzplan> einsatzPlanArrayList = new ArrayList<Einsatzplan>();
		for(EinsatzplanTO temp : einsatzplanVerwalter.einsatzpläneAnzeigen()) 
		{
			einsatzPlanArrayList.add(temp.toEinsatzPlan());
		}
		return einsatzPlanArrayList;
	}
	
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatplan) 
	{
		this.autobahnabschnittVerwalter.autobahnAbschnittAnlegen((AutobahnabschnittTO)einsatplan.getAutobahnabschnitte().toArray()[0]);
		return this.einsatzplanVerwalter.einsatzplanAnlegen(einsatplan);
	}
	
	public boolean autobahnabschnittAnlegen(AutobahnabschnittTO autobahnabschnitt) 
	{
		return this.autobahnabschnittVerwalter.autobahnAbschnittAnlegen(autobahnabschnitt);
	}
	
	public boolean istEinsatzplanVorhanden(EinsatzplanTO einsatzplanTO) 
	{
		return this.einsatzplanVerwalter.istEinsatzplanVorhanden(einsatzplanTO);
		
	}
	
}
