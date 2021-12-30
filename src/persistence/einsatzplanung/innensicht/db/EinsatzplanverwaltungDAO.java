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
import persistence.einsatzplanung.aussensicht.IEinsatzplanverwaltungDAO;
import persistence.kundenverwaltung.innensicht.db.Persistence;

public class EinsatzplanverwaltungDAO implements IEinsatzplanverwaltungDAO {

	@Override
	public Collection<EinsatzplanTO> einsatzpl‰neAnzeigen() {
		ArrayList<EinsatzplanTO> einsatzplanTOs = new ArrayList<EinsatzplanTO>();
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		try 
		{
			String aStatement = 
					"SELECT A.*,C.*,D.STRASSENWART_ID AS STRASSENWART_ID2,"
					+ "D.VORNAME as VORNAME2,D.NACHNAME AS NACHNAME2,D.MOBILFUNKNUMMER AS MOBILFUNKNUMMER2,"
					+ "E.* FROM EINSATZPLAN A "
					+ "LEFT JOIN EINSATZPLAN_AUTOBAHNABSCHNITT B ON A.EINSATZPLAN_ID = B.EINSATZPLAN_ID "
					+ "LEFT JOIN STRASSENWART C ON C.STRASSENWART_ID = A.STRASSENWART_ID_1 "
					+ "LEFT JOIN STRASSENWART D ON D.STRASSENWART_ID = A.STRASSENWART_ID_2 "
					+ "LEFT JOIN AUTOBAHNABSCHNITT E ON E.AUTOBAHNABSCHNITT_ID = B.AUTOBAHNABSCHNITT_ID "
					+ "ORDER BY A.EINSATZPLAN_ID";
			resultSet = Persistence.executeQueryStatement(aConnection, aStatement);
			EinsatzplanTO previousObj = new EinsatzplanTO();
			while(resultSet.next()) 
			{
				
				previousObj = resultToEinsatzplanTO(resultSet, previousObj);
				if( previousObj != null) 
				{ 
					einsatzplanTOs.add(previousObj);
				}
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return einsatzplanTOs;
	}
	
	private EinsatzplanTO resultToEinsatzplanTO(final ResultSet resultset, EinsatzplanTO previousObj) throws SQLException 
	{
		EinsatzplanTO einsatzplanTO = new EinsatzplanTO();
		if(previousObj.getEinsatplanId() == resultset.getInt("EINSATZPLAN_ID")) 
		{
			AutobahnabschnittTO autobahnabschnittTO = new AutobahnabschnittTO();
		    autobahnabschnittTO.setAutobahnAbschnittID(resultset.getInt("AUTOBAHNABSCHNITT_ID"));
		    autobahnabschnittTO.setAutobahnnummer(resultset.getString("AUTOBAHNNUMMER"));
		    autobahnabschnittTO.setAutobahnKilometerStart(resultset.getDouble("AUTOBAHNKILOMETERSTART"));
		    autobahnabschnittTO.setAutobahnKilometerEnde(resultset.getDouble("AUTOBAHNKILOMETERENDE"));
		    autobahnabschnittTO.setReihenfolge(resultset.getInt("REIHENFOLGE"));
		    previousObj.addAutobahnabschnitt(autobahnabschnittTO);
			return null;
		}
		try 
		{
			StraﬂenwartTO strassenwart1 = new StraﬂenwartTO();
			StraﬂenwartTO strassenwart2 = new StraﬂenwartTO();
		    Einsatzzeit einsatzzeit = new Einsatzzeit();
		    
		    strassenwart1.setStraﬂenwartId(resultset.getInt("STRASSENWART_ID"));
		    strassenwart1.setVorname(resultset.getString("VORNAME"));
		    strassenwart1.setNachname(resultset.getString("NACHNAME"));
		    strassenwart1.setMobilfunknummer(resultset.getString("MOBILFUNKNUMMER"));
		    
		    strassenwart1.setStraﬂenwartId(resultset.getInt("STRASSENWART_ID2"));
		    strassenwart2.setVorname(resultset.getString("VORNAME2"));
		    strassenwart2.setNachname(resultset.getString("NACHNAME2"));
		    strassenwart2.setMobilfunknummer(resultset.getString("MOBILFUNKNUMMER2"));
		    
		    einsatzzeit.setTageszeit(Tageszeit.valueOf(resultset.getString("TAGESZEIT")));
		    einsatzzeit.setWochentstag(WochenTag.valueOf(resultset.getString("WOCHENTAG")));
		    
		    AutobahnabschnittTO autobahnabschnittTO = new AutobahnabschnittTO();
		    autobahnabschnittTO.setAutobahnAbschnittID(resultset.getInt("AUTOBAHNABSCHNITT_ID"));
		    autobahnabschnittTO.setAutobahnnummer(resultset.getString("AUTOBAHNNUMMER"));
		    autobahnabschnittTO.setAutobahnKilometerStart(resultset.getDouble("AUTOBAHNKILOMETERSTART"));
		    autobahnabschnittTO.setAutobahnKilometerEnde(resultset.getDouble("AUTOBAHNKILOMETERENDE"));
		    autobahnabschnittTO.setReihenfolge(resultset.getInt("REIHENFOLGE"));
		    
			einsatzplanTO.setFahrzeugKennzeichen(resultset.getString("FAHRZEUGKENNZEICHEN"));
			einsatzplanTO.setStrassenwart1(strassenwart1);
			einsatzplanTO.setStrassenwart2(strassenwart2);
			einsatzplanTO.addAutobahnabschnitt(autobahnabschnittTO);
			einsatzplanTO.setEinsatzzeit(einsatzzeit);
			einsatzplanTO.setEinsatplanId(resultset.getInt("EINSATZPLAN_ID"));
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return einsatzplanTO;
	}

	@Override
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatzplanTO) {
		Connection aConnection = Persistence.getConnection();
		try {
			Persistence.executeUpdateStatement(
					aConnection, 
					"INSERT INTO EINSATZPLAN("
					+ "FAHRZEUGKENNZEICHEN,TAGESZEIT,WOCHENTAG,STRASSENWART_ID_1,STRASSENWART_ID_2) "
					+ "VALUES ( " +
					     einsatzplanTO.getFahrzeugKennzeichen() + "," +
					"'"+ einsatzplanTO.getEinsatzzeit().getWochentag() + "'," +
					"'"+ einsatzplanTO.getEinsatzzeit().getTageszeit() + "'," +
					"'"+ einsatzplanTO.getStrassenwart1() + "'," +
					"'"+ einsatzplanTO.getStrassenwart2() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Persistence.closeConnection(aConnection);
		}
		
		return false;
	}

	@Override
	public boolean istEinsatzzeitVorhanden(Einsatzzeit einsatzzeit, String fahrzeugKennzeichen) {
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		//TODO
			
		return false;
	}
}
