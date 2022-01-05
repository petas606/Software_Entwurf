package persistence.einsatzplanung.innensicht.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.StrassenwartTO;
import persistence.einsatzplanung.aussensicht.IStrassenwartverwaltungDAO;

public class StrassenwartverwaltungDAO implements IStrassenwartverwaltungDAO {

	@Override
	public Collection<StrassenwartTO> strassenwaerteAnzeigen() {
		ArrayList<StrassenwartTO> strassenwartTOs = new ArrayList<StrassenwartTO>();
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		try 
		{
			String aStatement = "SELECT * FROM STRASSENWART";
			resultSet = Persistence.executeQueryStatement(aConnection, aStatement);
			StrassenwartTO currentStrassenwart;
			while(resultSet.next()) 
			{
				
				currentStrassenwart = resultToStrassenwartTO(resultSet);
				if( currentStrassenwart != null) 
				{ 
					strassenwartTOs.add(currentStrassenwart);
				}
			}
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		finally {
			Persistence.closeConnection(aConnection);
		}
		return strassenwartTOs;
	}

	private StrassenwartTO resultToStrassenwartTO(ResultSet resultSet) {
		StrassenwartTO strassenwart = new StrassenwartTO();
	    try {
			strassenwart.setStrassenwartId(resultSet.getInt("STRASSENWART_ID"));
			strassenwart.setVorname(resultSet.getString("VORNAME"));
		    strassenwart.setNachname(resultSet.getString("NACHNAME"));
		    strassenwart.setMobilfunknummer(resultSet.getString("MOBILFUNKNUMMER"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
		return strassenwart;
	}

}
