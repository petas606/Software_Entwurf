package persistence.einsatzplanung.aussensicht;

import java.util.Collection;

import kern.einsatzplanung.aussensicht.Stra�enwartTO;

public interface IStra�enwartverwaltungDAO {
	public Collection<Stra�enwartTO> stra�enw�rteAnzeigen();
}
