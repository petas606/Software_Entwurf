package persistence.einsatzplanung.innensicht.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import kern.einsatzplanung.aussensicht.AutobahnabschnittTO;
import persistence.einsatzplanung.aussensicht.*;

public class AutobahnabschnittverwaltungDAO implements IAutobahnabschnittverwaltungDAO {

	@Override
	public boolean autobahnAbschnittAnlegen(AutobahnabschnittTO autobahnabschnittTO) {
		Connection aConnection = Persistence.getConnection();
		try {
			Persistence.executeUpdateStatement(
					aConnection, 
					"INSERT INTO AUTOBAHNABSCHNITT ("
					+ "AUTOBAHNABSCHNITT_ID,AUTOBAHNNUMMER,AUTOBAHNKILOMETERSTART,AUTOBAHNKILOMETERENDE,REIHENFOLGE)"
					+ "VALUES ( " 
					+ autobahnabschnittTO.getAutobahnAbschnittID() + "," +
					"'"+ autobahnabschnittTO.getAutobahnnummer() + "'," +
					"'"+ autobahnabschnittTO.getAutobahnKilometerStart() + "'," +
					"'"+ autobahnabschnittTO.getAutobahnKilometerEnde() + "'," +
					"'"+ autobahnabschnittTO.getReihenfolge() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Persistence.closeConnection(aConnection);
		}	
		return false;
	}
	
	@Override
	public int getMaxAutobahnabschnittId() 
	{
		Connection aConnection = Persistence.getConnection();
		try {
			String aStatement = "SELECT MAX(AUTOBAHNABSCHNITT_ID) FROM AUTOBAHNABSCHNITT";
			ResultSet resultSet = Persistence.executeQueryStatement(aConnection, aStatement);
			if(resultSet.next())
				return resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Persistence.closeConnection(aConnection);
		}
		return 0;
	}

	@Override
	public int dupplicateAutobahnabschnitt(AutobahnabschnittTO autobahnabschnittTO) {
		Connection aConnection = Persistence.getConnection();
		try {
			String aStatement = "SELECT AUTOBAHNABSCHNITT_ID FROM AUTOBAHNABSCHNITT "
					+ "WHERE AUTOBAHNNUMMER = '" + autobahnabschnittTO.getAutobahnnummer() + 
					"' AND AUTOBAHNKILOMETERSTART ="+ autobahnabschnittTO.getAutobahnKilometerStart() + 
					"AND AUTOBAHNKILOMETERENDE = " + autobahnabschnittTO.getAutobahnKilometerEnde();
			ResultSet resultSet = Persistence.executeQueryStatement(aConnection, aStatement);
			if(resultSet.next())
				return resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Persistence.closeConnection(aConnection);
		}
		return 0;
	}

}
