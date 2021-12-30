package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.StraßenwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Straßenwart;
import persistence.einsatzplanung.aussensicht.IAutobahnabschnittverwaltungDAO;
import persistence.einsatzplanung.aussensicht.IEinsatzplanverwaltungDAO;
import persistence.einsatzplanung.aussensicht.IStraßenwartverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.AutobahnabschnittverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.EinsatzplanverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.StraßenwartverwaltungDAO;

public class EinsatzplanManager {
	private IEinsatzplanverwaltungDAO einsatzplanVerwalter = new EinsatzplanverwaltungDAO();
	private IAutobahnabschnittverwaltungDAO autobahnabschnittVerwalter= new AutobahnabschnittverwaltungDAO();
	private IStraßenwartverwaltungDAO straßenwartVerwalter = new StraßenwartverwaltungDAO();
	
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
		for(Autobahnabschnitt autobahnabschnitt : einsatzplan.getAutobahnabschnitte()) 
		{
			this.autobahnabschnittVerwalter.autobahnAbschnittAnlegen(autobahnabschnitt.toAutobahnabschnittTO());
		}
		
		return this.einsatzplanVerwalter.einsatzplanAnlegen(einsatzplan.toEinsatzplanTO());
	}
	
	public boolean autobahnabschnittAnlegen(AutobahnabschnittTO autobahnabschnitt) 
	{
		return this.autobahnabschnittVerwalter.autobahnAbschnittAnlegen(autobahnabschnitt);
	}
	
	public boolean istEinsatzplanVorhanden(EinsatzplanTO einsatzplanTO) 
	{
		if (this.einsatzplanVerwalter.istEinsatzzeitVorhanden(einsatzplanTO))
			return true;
		else {
			return false;
		}
	}
	
	public boolean istAutobahnAbschnittvorhanden(AutobahnabschnittTO autobahnabschnittTO) 
	{
		if(this.autobahnabschnittVerwalter.dupplicateAutobahnabschnitt(autobahnabschnittTO) != 0) 
		{
			return true;
		}
		return false;
	}
	
	public int naeschteAutobahnabschnittIdErmitteln()  
	{
		return this.autobahnabschnittVerwalter.getMaxAutobahnabschnittId()+1;
	}
	
	public int naeschteEinsatzplanIdErmitteln()  
	{
		return this.einsatzplanVerwalter.getMaxEinsatzplanId()+1;
	}
	
	public Collection<Straßenwart> straßenwärterAnzeigen()
	{
		Collection<Straßenwart> straßenwarts = new ArrayList<Straßenwart>();
		for(StraßenwartTO straßenwartTO : this.straßenwartVerwalter.straßenwärteAnzeigen()) 
		{
			straßenwarts.add(straßenwartTO.toStraßenwart());
		}
		return straßenwarts;
	}
	
}
