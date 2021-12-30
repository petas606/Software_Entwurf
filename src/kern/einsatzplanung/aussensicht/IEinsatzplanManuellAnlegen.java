package kern.einsatzplanung.aussensicht;

import java.util.Collection;

public interface IEinsatzplanManuellAnlegen {
	public boolean einsatzplanAnlegen(EinsatzplanTO einsatzplanTO);
	public Collection<StraﬂenwartTO> straﬂenw‰rterAnzeigen();
}
