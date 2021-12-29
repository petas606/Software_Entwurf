package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import persistence.einsatzplanung.aussensicht.IAutobahnabschnittverwaltungDAO;
import persistence.einsatzplanung.aussensicht.IEinsatzplanverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.AutobahnabschnittverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.EinsatzplanverwaltungDAO;

public class EinsatzplanManager {
	private IEinsatzplanverwaltungDAO einsatzplanVerwalter = new EinsatzplanverwaltungDAO();
	private IAutobahnabschnittverwaltungDAO autobahnabschnittVerwalter= new AutobahnabschnittverwaltungDAO();
	
	public Collection<Einsatzplan> einsatzplaeneAnzeigen()
	{
		ArrayList<Einsatzplan> einsatzPlanArrayList = new ArrayList<Einsatzplan>();
		for(EinsatzplanTO temp : einsatzplanVerwalter.einsatzpläneAnzeigen()) 
		{
			einsatzPlanArrayList.add(temp.toEinsatzPlan());
		}
		return einsatzPlanArrayList;
	}
	
	public boolean einsatzplanAnlegen(Einsatzplan einsatzplan) 
	{
		this.autobahnabschnittVerwalter.autobahnAbschnittAnlegen((AutobahnabschnittTO)einsatzplan.getAutobahnabschnitte().toArray()[0]);
		return this.einsatzplanVerwalter.einsatzplanAnlegen(einsatzplan.toEinsatzplanTO());
	}
	
	public boolean autobahnabschnittAnlegen(AutobahnabschnittTO autobahnabschnitt) 
	{
		return this.autobahnabschnittVerwalter.autobahnAbschnittAnlegen(autobahnabschnitt);
	}
	
	public boolean istEinsatzplanVorhanden(Einsatzplan einsatzplan) 
	{
		if (!this.einsatzplanVerwalter.istEinsatzplanVorhanden(einsatzplan.toEinsatzplanTO()))
			return true;
		else {
			return false;
		}
	}
	
}
