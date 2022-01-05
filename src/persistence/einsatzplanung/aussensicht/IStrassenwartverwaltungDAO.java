package persistence.einsatzplanung.aussensicht;

import java.util.Collection;

import kern.einsatzplanung.aussensicht.StrassenwartTO;

public interface IStrassenwartverwaltungDAO {
	public Collection<StrassenwartTO> strassenwaerteAnzeigen();
}
