package persistence.einsatzplanung.innensicht.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.StraßenwartTO;
import persistence.einsatzplanung.aussensicht.IStraßenwartverwaltungDAO;

public class StraßenwartverwaltungDAO implements IStraßenwartverwaltungDAO {

	@Override
	public Collection<StraßenwartTO> straßenwärteAnzeigen() {
		ArrayList<StraßenwartTO> straßenwartTOs = new ArrayList<StraßenwartTO>();
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		try 
		{
			String aStatement = "SELECT * FROM STRASSENWART";
			resultSet = Persistence.executeQueryStatement(aConnection, aStatement);
			StraßenwartTO currentStraßenwart;
			while(resultSet.next()) 
			{
				
				currentStraßenwart = resultToStraßenwartTO(resultSet);
				if( currentStraßenwart != null) 
				{ 
					straßenwartTOs.add(currentStraßenwart);
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
		return straßenwartTOs;
	}

	private StraßenwartTO resultToStraßenwartTO(ResultSet resultSet) {
		StraßenwartTO strassenwart = new StraßenwartTO();
	    try {
			strassenwart.setStraßenwartId(resultSet.getInt("STRASSENWART_ID"));
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
