package kern.einsatzplanung.innensicht.useCases;

import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.Stra�enwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Autobahnabschnitt;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Stra�enwart;
import persistence.einsatzplanung.aussensicht.IAutobahnabschnittverwaltungDAO;
import persistence.einsatzplanung.aussensicht.IEinsatzplanverwaltungDAO;
import persistence.einsatzplanung.aussensicht.IStra�enwartverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.AutobahnabschnittverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.EinsatzplanverwaltungDAO;
import persistence.einsatzplanung.innensicht.db.Stra�enwartverwaltungDAO;

public class EinsatzplanManager {
	private IEinsatzplanverwaltungDAO einsatzplanVerwalter = new EinsatzplanverwaltungDAO();
	private IAutobahnabschnittverwaltungDAO autobahnabschnittVerwalter= new AutobahnabschnittverwaltungDAO();
	private IStra�enwartverwaltungDAO stra�enwartVerwalter = new Stra�enwartverwaltungDAO();
	
	public Collection<Einsatzplan> einsatzplaeneAnzeigen()
	{
		ArrayList<Einsatzplan> einsatzPlanArrayList = new ArrayList<Einsatzplan>();
		for(EinsatzplanTO temp : einsatzplanVerwalter.einsatzpl�neAnzeigen()) 
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
	
	public Collection<Stra�enwart> stra�enw�rterAnzeigen()
	{
		Collection<Stra�enwart> stra�enwarts = new ArrayList<Stra�enwart>();
		for(Stra�enwartTO stra�enwartTO : this.stra�enwartVerwalter.stra�enw�rteAnzeigen()) 
		{
			stra�enwarts.add(stra�enwartTO.toStra�enwart());
		}
		return stra�enwarts;
	}
	
}
