package kern.einsatzplanung.aussensicht;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Fahrzeugklasse;

public class Stra�enwartTO {
	private String vorname;
	private String nachname;
	private String mobilfunknummer;
	private Set<Fahrzeugklasse> berechtigteFahrzeugklasse;
	private Set<Einsatzplan> zugeh�rigeEinsatzpl�ne;
	
	public Stra�enwartTO() {
		berechtigteFahrzeugklasse = new HashSet<Fahrzeugklasse>();
		zugeh�rigeEinsatzpl�ne = new HashSet<Einsatzplan>();
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
	
	public Set<Einsatzplan> getZugeh�rigeEinsatzpl�ne() {
		return zugeh�rigeEinsatzpl�ne;
	}

}
