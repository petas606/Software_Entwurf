package kern.einsatzplanung.aussensicht;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Fahrzeugklasse;

public class StraßenwartTO {
	private String vorname;
	private String nachname;
	private String mobilfunknummer;
	private Set<Fahrzeugklasse> berechtigteFahrzeugklasse;
	private Set<Einsatzplan> zugehörigeEinsatzpläne;
	
	public StraßenwartTO() {
		berechtigteFahrzeugklasse = new HashSet<Fahrzeugklasse>();
		zugehörigeEinsatzpläne = new HashSet<Einsatzplan>();
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public String getMobilfunknummer() {
		return mobilfunknummer;
	}
	
	public Set<Fahrzeugklasse> getBerechtigteFahrzeugklasse() {
		return berechtigteFahrzeugklasse;
	}
	
	public Set<Einsatzplan> getZugehörigeEinsatzpläne() {
		return zugehörigeEinsatzpläne;
	}

}
