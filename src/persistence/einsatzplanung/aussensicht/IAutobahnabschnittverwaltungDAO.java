package persistence.einsatzplanung.aussensicht;

import kern.einsatzplanung.aussensicht.*;

public interface IAutobahnabschnittverwaltungDAO {
	public boolean autobahnAbschnittAnlegen(AutobahnabschnittTO autobahnabschnitt);
	public int dupplicateAutobahnabschnitt(AutobahnabschnittTO autobahnabschnittTO);
	public int getMaxAutobahnabschnittId();
}
