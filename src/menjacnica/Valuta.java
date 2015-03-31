package menjacnica;

public class Valuta {
	
	private String naziv;
	private String skraceniNaziv;
	KursValute kurs;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		if(naziv == null || naziv.isEmpty())
			throw new RuntimeException("Naziv ne sme biti prazan String ili null.");
		this.naziv = naziv;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		if(skraceniNaziv == null || skraceniNaziv.isEmpty())
			throw new RuntimeException("Skraceni naziv ne sme biti prazan String ili null.");
		this.skraceniNaziv = skraceniNaziv;
	}
	public KursValute getKurs() {
		return kurs;
	}
	public void setKurs(KursValute kurs) {
		if(kurs == null || !(kurs instanceof KursValute)) 
			throw new RuntimeException("Uneti objekat ne sme biti null ili objekat klase različite od KursValute");
		this.kurs = kurs;
	}
	public String toString() {
		return "Valuta u pitanju je " + naziv +" " + skraceniNaziv + ",a kurs za datu valutu je " + kurs;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kurs == null) ? 0 : kurs.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result
				+ ((skraceniNaziv == null) ? 0 : skraceniNaziv.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof Valuta) {
			Valuta v = (Valuta) obj;
			if(naziv.equals(v.getNaziv()) && skraceniNaziv.equals(v.getSkraceniNaziv()) && kurs.equals(v.getKurs()))
				return true;
		}
		return false;
	}
}
