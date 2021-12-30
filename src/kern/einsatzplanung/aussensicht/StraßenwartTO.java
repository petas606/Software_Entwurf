package kern.einsatzplanung.aussensicht;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Straßenwart;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Fahrzeugklasse;

public class StraßenwartTO {
	private int straßenwartId;
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
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public void setMobilfunknummer(String mobilfunknummer) {
		this.mobilfunknummer = mobilfunknummer;
	}

	public void setBerechtigteFahrzeugklasse(Set<Fahrzeugklasse> berechtigteFahrzeugklasse) {
		this.berechtigteFahrzeugklasse = berechtigteFahrzeugklasse;
	}

	public void setZugehörigeEinsatzpläne(Set<Einsatzplan> zugehörigeEinsatzpläne) {
		this.zugehörigeEinsatzpläne = zugehörigeEinsatzpläne;
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

	public int getStraßenwartId() {
		return straßenwartId;
	}

	public void setStraßenwartId(int straßenwartId) {
		this.straßenwartId = straßenwartId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return vorname + " " + nachname;
	}
	
	
	public Straßenwart toStraßenwart() 
	{
		Straßenwart straßenwart = new Straßenwart();
		straßenwart.setMobilfunknummer(this.mobilfunknummer);
		straßenwart.setBerechtigteFahrzeugklasse(berechtigteFahrzeugklasse);
		straßenwart.setNachname(nachname);
		straßenwart.setVorname(vorname);
		straßenwart.setStraßenwartId(straßenwartId);
		return straßenwart;
	}

}
