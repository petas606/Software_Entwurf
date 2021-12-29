package persistence.einsatzplanung.aussensicht;

import java.util.Collection;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;

public interface IEinsatzplanverwaltungDAO {
	public Collection<EinsatzplanTO> einsatzpläneAnzeigen();
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatplan);
	public boolean istEinsatzplanVorhanden(EinsatzplanTO einsatzplan);
}
