package menjacnica;

public class Valuta {
	
	private String naziv;
	private String skraceniNaziv;
	KursValute kurs;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	public KursValute getKurs() {
		return kurs;
	}
	public void setKurs(KursValute kurs) {
		this.kurs = kurs;
	}
	
	
	

}
