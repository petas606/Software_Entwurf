package kern.einsatzplanung.aussensicht;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.innensicht.technischesDatenmodell.Einsatzplan;
import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Fahrzeugklasse;

public class Stra�enwartTO {
	private int stra�enwartId;
	private String vorname;
	private String nachname;
	private String mobilfunknummer;
	
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

	public void setZugeh�rigeEinsatzpl�ne(Set<Einsatzplan> zugeh�rigeEinsatzpl�ne) {
		this.zugeh�rigeEinsatzpl�ne = zugeh�rigeEinsatzpl�ne;
	}

	private Set<Fahrzeugklasse> berechtigteFahrzeugklasse;
	private Set<Einsatzplan> zugeh�rigeEinsatzpl�ne;
	
	public Stra�enwartTO() {
		berechtigteFahrzeugklasse = new HashSet<Fahrzeugklasse>();
		zugeh�rigeEinsatzpl�ne = new HashSet<Einsatzplan>();
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

	public void setZugeh�rigeEinsatzpl�ne(Set<Einsatzplan> zugeh�rigeEinsatzpl�ne) {
		this.zugeh�rigeEinsatzpl�ne = zugeh�rigeEinsatzpl�ne;
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

	public int getStra�enwartId() {
		return stra�enwartId;
	}

	public void setStra�enwartId(int stra�enwartId) {
		this.stra�enwartId = stra�enwartId;
	}

}
