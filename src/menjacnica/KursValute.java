package menjacnica;

import java.util.GregorianCalendar;

public class KursValute {
	
	private double prodajniKurs;
	private double kupovniKurs;
	private double srednjiKurs;
	GregorianCalendar datum = new GregorianCalendar();
	
	public double getProdajniKurs() {
		return prodajniKurs;
	}
	public void setProdajniKurs(double prodajniKurs) {
		if(prodajniKurs < 0)
			throw new RuntimeException("Prodajni kurs mora biti veci od nule.");
		if(kupovniKurs != 0 && prodajniKurs < kupovniKurs)
			throw new RuntimeException("Prodajni kurs mora biti veci od kupovnog.");
		this.prodajniKurs = prodajniKurs;
	}
	public double getKupovniKurs() {
		return kupovniKurs;
	}
	public void setKupovniKurs(double kupovniKurs) {
		if(kupovniKurs < 0)
			throw new RuntimeException("Kupovni kurs mora biti veci od nule.");
		if(prodajniKurs != 0 && kupovniKurs > prodajniKurs)
			throw new RuntimeException("Kupovni kurs mora biti manji od prodajnog.");
		this.kupovniKurs = kupovniKurs;
	}
	public double getSrednjiKurs() {
		return srednjiKurs;
	}
	public void setSrednjiKurs(double srednjiKurs) {
		if(srednjiKurs < 0)
			throw new RuntimeException("Srednji kurs mora biti veci od nule.");
		if(prodajniKurs != 0 && kupovniKurs != 0) {
			if(srednjiKurs > prodajniKurs || srednjiKurs < kupovniKurs)
				throw new RuntimeException("Kupovni kurs mora biti izmedju prodajnog i kupovnog.");
		this.srednjiKurs = srednjiKurs;
		}
	}		
	public GregorianCalendar getDatum() {
		return datum;
	}
	public void setDatum(GregorianCalendar datum) {
		if(datum.after(new GregorianCalendar()))
			throw new RuntimeException("Uneti datum ne sme biti u buducnosti.");
		this.datum = datum;
	}
	public String toString() {
		return "Na datum " + datum.getTime() +", prodajni kurs = " + prodajniKurs + " , kupovni kurs = " + kupovniKurs + ", srednji = " + srednjiKurs;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(kupovniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prodajniKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(srednjiKurs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof KursValute) {
			KursValute kv = (KursValute) obj;
			if(datum.compareTo(kv.getDatum()) == 0) {
				double pomocna = 0.00001;
				double r1 = Math.abs(prodajniKurs - kv.getProdajniKurs());
				double r2 = Math.abs(kupovniKurs - kv.getKupovniKurs());
				double r3 = Math.abs(srednjiKurs - kv.getSrednjiKurs());
				if(r1 < pomocna && r2 < pomocna && r3 < pomocna)
					return true;	
			}
		}
		return false;
	}
	
}
