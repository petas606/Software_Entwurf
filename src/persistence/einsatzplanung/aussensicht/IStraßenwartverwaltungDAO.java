package persistence.einsatzplanung.aussensicht;

import java.util.Collection;

import kern.einsatzplanung.aussensicht.StraßenwartTO;

public interface IStraßenwartverwaltungDAO {
	public Collection<StraßenwartTO> straßenwärteAnzeigen();
}
