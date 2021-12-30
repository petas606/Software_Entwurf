package persistence.einsatzplanung.aussensicht;

import java.util.Collection;

import kern.einsatzplanung.aussensicht.EinsatzplanTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Einsatzzeit;

public interface IEinsatzplanverwaltungDAO {
	public Collection<EinsatzplanTO> einsatzplšneAnzeigen();
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatplan);
	public boolean istEinsatzzeitVorhanden(Einsatzzeit einsatzzeit, String fahrzeugKennzeichen);
}
