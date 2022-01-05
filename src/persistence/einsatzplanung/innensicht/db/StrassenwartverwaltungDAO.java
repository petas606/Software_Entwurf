package persistence.einsatzplanung.innensicht.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.aussensicht.Stra�enwartTO;
import persistence.einsatzplanung.aussensicht.IStra�enwartverwaltungDAO;

public class Stra�enwartverwaltungDAO implements IStra�enwartverwaltungDAO {

	@Override
	public Collection<Stra�enwartTO> stra�enw�rteAnzeigen() {
		ArrayList<Stra�enwartTO> stra�enwartTOs = new ArrayList<Stra�enwartTO>();
		Connection aConnection = Persistence.getConnection();
		ResultSet resultSet;
		try 
		{
			String aStatement = "SELECT * FROM STRASSENWART";
			resultSet = Persistence.executeQueryStatement(aConnection, aStatement);
			Stra�enwartTO currentStra�enwart;
			while(resultSet.next()) 
			{
				
				currentStra�enwart = resultToStra�enwartTO(resultSet);
				if( currentStra�enwart != null) 
				{ 
					stra�enwartTOs.add(currentStra�enwart);
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
		return stra�enwartTOs;
	}

	private Stra�enwartTO resultToStra�enwartTO(ResultSet resultSet) {
		Stra�enwartTO strassenwart = new Stra�enwartTO();
	    try {
			strassenwart.setStra�enwartId(resultSet.getInt("STRASSENWART_ID"));
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
