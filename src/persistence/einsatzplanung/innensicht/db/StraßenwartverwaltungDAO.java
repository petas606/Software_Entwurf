package persistence.einsatzplanung.innensicht.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.StraﬂenwartTO;
import persistence.einsatzplanung.aussensicht.IStraﬂenwartverwaltungDAO;

public class StraﬂenwartverwaltungDAO implements IStraﬂenwartverwaltungDAO {

	@Override
	public Collection<StraﬂenwartTO> straﬂenw‰rteAnzeigen() {
		ArrayList<StraﬂenwartTO> straﬂenwartTOs = new ArrayList<StraﬂenwartTO>();
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		try 
		{
			String aStatement = "SELECT * FROM STRASSENWART";
			resultSet = Persistence.executeQueryStatement(aConnection, aStatement);
			StraﬂenwartTO currentStraﬂenwart;
			while(resultSet.next()) 
			{
				
				currentStraﬂenwart = resultToStraﬂenwartTO(resultSet);
				if( currentStraﬂenwart != null) 
				{ 
					straﬂenwartTOs.add(currentStraﬂenwart);
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
		return straﬂenwartTOs;
	}

	private StraﬂenwartTO resultToStraﬂenwartTO(ResultSet resultSet) {
		StraﬂenwartTO strassenwart = new StraﬂenwartTO();
	    try {
			strassenwart.setStraﬂenwartId(resultSet.getInt("STRASSENWART_ID"));
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
