package kern.einsatzplanung.innensicht.technischesDatenmodell;

import java.util.HashSet;
import java.util.Set;

import kern.einsatzplanung.innensicht.technischesDatenmodell.type.Fahrzeugklasse;

public class Stra�enwart {
	private String vorname;
	private String nachname;
	private String mobilfunknummer;
	private Set<Fahrzeugklasse> berechtigteFahrzeugklasse;
	private Set<Einsatzplan> zugeh�rigeEinsatzpl�ne;
	
	public Stra�enwart() {
		berechtigteFahrzeugklasse = new HashSet<Fahrzeugklasse>();
		zugeh�rigeEinsatzpl�ne = new HashSet<Einsatzplan>();
	}
	
	public void anlegen() 
	{
		//TODO
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
	public Set<Einsatzplan> getZugeh�rigeEinsatzpl�ne() {
		return zugeh�rigeEinsatzpl�ne;
	}
	
	public void addZugeh�rigeEinsatzplan(Einsatzplan einsatzplan) 
	{
		this.zugeh�rigeEinsatzpl�ne.add(einsatzplan);
	}
	
	public void addBerechtigteFahrzeugklasse(Fahrzeugklasse fahrzeugklasse) 
	{
		this.berechtigteFahrzeugklasse.add(fahrzeugklasse);
	}
	
	public void setZugeh�rigeEinsatzpl�ne(Set<Einsatzplan> zugeh�rigeEinsatzpl�ne) {
		this.zugeh�rigeEinsatzpl�ne = zugeh�rigeEinsatzpl�ne;
	}

}
