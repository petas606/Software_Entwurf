package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.StrassenwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Strassenwart;
import persistence.einsatzplanung.aussensicht.IAutobahnabschnittverwaltungDAO;
import persistence.einsatzplanung.aussensicht.IEinsatzplanverwaltungDAO;
import persistence.einsatzplanung.aussensicht.IStrassenwartverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.AutobahnabschnittverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.EinsatzplanverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.StrassenwartverwaltungDAO;

public class EinsatzplanManager {
	private IEinsatzplanverwaltungDAO einsatzplanVerwalter = new EinsatzplanverwaltungDAO();
	private IAutobahnabschnittverwaltungDAO autobahnabschnittVerwalter= new AutobahnabschnittverwaltungDAO();
	private IStrassenwartverwaltungDAO strassenwartVerwalter = new StrassenwartverwaltungDAO();
	
	public Collection<Einsatzplan> einsatzplaeneAnzeigen()
	{
		ArrayList<Einsatzplan> einsatzPlanArrayList = new ArrayList<Einsatzplan>();
		for(EinsatzplanTO temp : einsatzplanVerwalter.einsatzplaeneAnzeigen()) 
		{
			einsatzPlanArrayList.add(temp.toEinsatzPlan());
		}
		return einsatzPlanArrayList;
	}
	
	public boolean einsatzplanAnlegen(Einsatzplan einsatzplan) 
	{
		for(Autobahnabschnitt autobahnabschnitt : einsatzplan.getAutobahnabschnitte()) 
		{
			int vorhandeneAutobahnabschnittId = this.autobahnabschnittVerwalter.dupplicateAutobahnabschnitt(autobahnabschnitt.toAutobahnabschnittTO());
			if(vorhandeneAutobahnabschnittId == 0)
			{
				this.autobahnabschnittVerwalter.autobahnAbschnittAnlegen(autobahnabschnitt.toAutobahnabschnittTO());
			}else 
			{
				autobahnabschnitt.setAutobahnAbschnittID(vorhandeneAutobahnabschnittId);
			}
			
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
	
	public Collection<Strassenwart> strassenwaerterAnzeigen()
	{
		Collection<Strassenwart> strassenwarts = new ArrayList<Strassenwart>();
		for(StrassenwartTO strassenwartTO : this.strassenwartVerwalter.strassenwaerteAnzeigen()) 
		{
			strassenwarts.add(strassenwartTO.toStrassenwart());
		}
		return strassenwarts;
	}
	
}
