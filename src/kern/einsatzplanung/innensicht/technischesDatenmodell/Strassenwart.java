package kern.einsatzplanung.innensicht.technischesDatenmodell;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.aussensicht.StrassenwartTO;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Fahrzeugklasse;

public class Strassenwart {
	private int strassenwartId;
	private String vorname;
	private String nachname;
	private String mobilfunknummer;
	private Set<Fahrzeugklasse> berechtigteFahrzeugklasse;
	private Set<Einsatzplan> zugehoerigeEinsatzplaene;
	
	public Strassenwart() {
		berechtigteFahrzeugklasse = new HashSet<Fahrzeugklasse>();
		zugehoerigeEinsatzplaene = new HashSet<Einsatzplan>();
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getMobilfunknummer() {
		return mobilfunknummer;
	}
	public void setMobilfunknummer(String mobilfunknummer) {
		this.mobilfunknummer = mobilfunknummer;
	}
	public Set<Fahrzeugklasse> getBerechtigteFahrzeugklasse() {
		return berechtigteFahrzeugklasse;
	}
	public void setBerechtigteFahrzeugklasse(Set<Fahrzeugklasse> berechtigteFahrzeugklasse) {
		this.berechtigteFahrzeugklasse = berechtigteFahrzeugklasse;
	}
	public Set<Einsatzplan> getZugehoerigeEinsatzplaene() {
		return zugehoerigeEinsatzplaene;
	}
	
	public void addZugehoerigeEinsatzplan(Einsatzplan einsatzplan) 
	{
		this.zugehoerigeEinsatzplaene.add(einsatzplan);
	}
	
	public void addBerechtigteFahrzeugklasse(Fahrzeugklasse fahrzeugklasse) 
	{
		this.berechtigteFahrzeugklasse.add(fahrzeugklasse);
	}
	
	public void setZugehoerigeEinsatzplaene(Set<Einsatzplan> zugehoerigeEinsatzplaene) {
		this.zugehoerigeEinsatzplaene = zugehoerigeEinsatzplaene;
	}

	public int getStrassenwartId() {
		return strassenwartId;
	}

	public void setStrassenwartId(int strassenwartId) {
		this.strassenwartId = strassenwartId;
	}
	
	public StrassenwartTO toStrassenwartTO() 
	{
		StrassenwartTO strassenwartTO = new StrassenwartTO();
		strassenwartTO.setVorname(vorname);
		strassenwartTO.setNachname(nachname);
		strassenwartTO.setStrassenwartId(strassenwartId);
		strassenwartTO.setMobilfunknummer(mobilfunknummer);
		strassenwartTO.setBerechtigteFahrzeugklasse(berechtigteFahrzeugklasse);
		return strassenwartTO;
	}
	
	@Override
	public String toString() {
		return vorname + " " + nachname;
	}

}
