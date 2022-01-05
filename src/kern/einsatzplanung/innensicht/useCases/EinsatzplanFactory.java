package kern.einsatzplanung.innensicht.useCases;

import kern.einsatzplanung.aussensicht.IEinsatzplanFactory;
import kern.einsatzplanung.aussensicht.IEinsatzplanManuellAnlegen;
import kern.einsatzplanung.aussensicht.IEinsatzplanlisteAnzeigen;

public class EinsatzplanFactory implements IEinsatzplanFactory {

	@Override
	public IEinsatzplanlisteAnzeigen einsatzplanAnzeigen() {
		return new EinsatzplanlisteAnzeigen();
	}

	@Override
	public IEinsatzplanManuellAnlegen einsatzplanManuellAnlegen() {
		return new EinsatzplanManuellAnlegen();
	}
}
