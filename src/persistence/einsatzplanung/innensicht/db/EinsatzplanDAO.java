package persistence.einsatzplanung.innensicht.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.StraﬂenwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Tageszeit;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.WochenTag;
import persistence.einsatzplanung.aussensicht.IEinsatzplanDAO;

public class EinsatzplanDAO implements IEinsatzplanDAO {

	@Override
	public Collection<EinsatzplanTO> einsatzpl‰neAnzeigen() {
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		try {
			String aStatement = 
					"SELECT A.*,C.*,D.*,E* FROM EINSATZPLAN A "
					+ "LEFT JOIN EINSATZPLAN_AUTOBAHNABSCHNITT B ON A.EINSATZPLAN_ID = B.EINSATZPLAN_ID "
					+ "LEFT JOIN STRAﬂENWART C ON C.STRAﬂENWART_ID = A.STRAﬂENWART_ID_1 "
					+ "LEFT JOIN STRAﬂENWART D ON D.STRAﬂENWART_ID = A.STRAﬂENWART_ID_2 "
					+ "LEFT JOIN AUTOBAHNABSCHNITT E ON E.AUTOBAHNABSCHNITT_ID = B.AUTOBAHNABSCHNITT_ID "
					+ "ORDER BY A.EINSATZPLAN_ID";
			resultSet = Persistence.executeQueryStatement(aConnection, aStatement);
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	private EinsatzplanTO resultToEinsatzplanTO(final ResultSet resultset, EinsatzplanTO previousObj) throws SQLException 
	{
		EinsatzplanTO einsatzplanTO = new EinsatzplanTO();
		if(previousObj.getEinsatplanId() == resultset.getInt("A.EINSATZPLAN_ID")) 
		{
			return null;
		}
		try 
		{
			StraﬂenwartTO strassenwart1 = new StraﬂenwartTO();
			StraﬂenwartTO strassenwart2 = new StraﬂenwartTO();
			ArrayList<AutobahnabschnittTO> autobahnabschnitte = new ArrayList<AutobahnabschnittTO>();
		    Einsatzzeit einsatzzeit = new Einsatzzeit();
		    
		    strassenwart1.setVorname(resultset.getString("C.VORNAME"));
		    strassenwart1.setNachname(resultset.getString("C.NACHNAME"));
		    strassenwart1.setMobilfunknummer(resultset.getString("C.MOBILFUNKNUMMER"));
		    
		    strassenwart2.setVorname(resultset.getString("D.VORNAME"));
		    strassenwart2.setNachname(resultset.getString("D.NACHNAME"));
		    strassenwart2.setMobilfunknummer(resultset.getString("D.MOBILFUNKNUMMER"));
		    
		    einsatzzeit.setTageszeit(Tageszeit.valueOf(resultset.getString("A.TAGESZEIT")));
		    einsatzzeit.setWochentstag(WochenTag.valueOf(resultset.getString("A.WOCHENTAG")));
		    
		    AutobahnabschnittTO autobahnabschnittTO = new AutobahnabschnittTO();
		    autobahnabschnittTO.setAutobahnAbschnittID(resultset.getInt("E.AUTOBAHNNUMMER"));
		    autobahnabschnittTO.setAutobahnnummer(resultset.getString("E.AUTOBAHNNUMMER"));
		    autobahnabschnittTO.setAutobahnKilometerStart(resultset.getDouble("E.AUTOBAHNKILOMETERSTART"));
		    autobahnabschnittTO.setAutobahnKilometerEnde(resultset.getDouble("E.AUTOBAHNKILOMETERENDE"));
		    autobahnabschnittTO.setReihenfolge(resultset.getInt("E.AUTOBAHNNUMMER"));
		    
			einsatzplanTO.setFahrzeugKennzeichen(resultset.getString("A.FAHRZEUGKENNZEICHEN"));
			einsatzplanTO.setStrassenwart1(strassenwart1);
			einsatzplanTO.setStrassenwart2(strassenwart2);
			einsatzplanTO.setAutobahnabschnitte(autobahnabschnitte);
			einsatzplanTO.setEinsatzzeit(einsatzzeit);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return einsatzplanTO;
	}

	@Override
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatplan) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean istEinsatzplanVorhanden(EinsatzplanTO einsatzplan) {
		// TODO Auto-generated method stub
		return false;
	}
}
