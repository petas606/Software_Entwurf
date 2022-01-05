package kern.einsatzplanung.aussensicht;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.Strassenwart;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Fahrzeugklasse;

public class StrassenwartTO {
	private int strassenwartId;
	private String vorname;
	private String nachname;
	private String mobilfunknummer;

	private Set<Fahrzeugklasse> berechtigteFahrzeugklasse;
	private Set<Einsatzplan> zugehoerigeEinsatzplaene;
	
	public StrassenwartTO() {
		berechtigteFahrzeugklasse = new HashSet<Fahrzeugklasse>();
		zugehoerigeEinsatzplaene = new HashSet<Einsatzplan>();
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

	public void setZugehoerigeEinsatzplaene(Set<Einsatzplan> zugehoerigeEinsatzplaene) {
		this.zugehoerigeEinsatzplaene = zugehoerigeEinsatzplaene;
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
	
	public Set<Einsatzplan> getZugehoerigeEinsatzplaene() {
		return zugehoerigeEinsatzplaene;
	}

	public int getStrassenwartId() {
		return strassenwartId;
	}

	public void setStrassenwartId(int strassenwartId) {
		this.strassenwartId = strassenwartId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(vorname == null && nachname == null) 
		{
			return "";
		}
		String fullname = vorname + " " + nachname;
		return fullname;
	}
	
	
	public Strassenwart toStrassenwart() 
	{
		Strassenwart strassenwart = new Strassenwart();
		strassenwart.setMobilfunknummer(this.mobilfunknummer);
		strassenwart.setBerechtigteFahrzeugklasse(berechtigteFahrzeugklasse);
		strassenwart.setNachname(nachname);
		strassenwart.setVorname(vorname);
		strassenwart.setStrassenwartId(strassenwartId);
		return strassenwart;
	}

}
