package persistence.einsatzplanung.innensicht.db;
import java.sql.Connection;
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
					+ "AUTOBAHNNUMMER,AUTOBAHNKILOMETERSTART,AUTOBAHNKILOMETERENDE,REIHENFOLGE)"
					+ "VALUES ( " +
					autobahnabschnittTO.getAutobahnnummer() + "," +
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

}
