package kern.einsatzplanung.innensicht.technischesDatenmodell.type;

public class Einsatzzeit {
	private WochenTag wochentstag;
	private Tageszeit tageszeit;
	
	public WochenTag getWochentag() {
		return wochentstag;
	}
	public void setWochentstag(WochenTag wochentstag) {
		this.wochentstag = wochentstag;
	}
	public Tageszeit getTageszeit() {
		return tageszeit;
	}
	public void setTageszeit(Tageszeit tageszeit) {
		this.tageszeit = tageszeit;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return wochentstag + " " + tageszeit;
	}
}
