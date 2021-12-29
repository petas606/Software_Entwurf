package persistence.einsatzplanung.aussensicht;

import java.util.Collection;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;

public interface IEinsatzplanDAO {
	public Collection<EinsatzplanTO> einsatzplšneAnzeigen();
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatplan);
	public boolean istEinsatzplanVorhanden(EinsatzplanTO einsatzplan);
}
