package kern.einsatzplanung.aussensicht;

import java.util.Collection;

public interface IEinsatzplanManuellAnlegen {
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatzplanTO);
	public Collection<Stra�enwartTO> stra�enw�rterAnzeigen();
}
