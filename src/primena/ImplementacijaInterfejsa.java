package primena;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.KursValute;
import menjacnica.Valuta;

public class ImplementacijaInterfejsa implements InterfejsMenjacnica {
	
	LinkedList<Valuta> valute = new LinkedList<Valuta>();

	public boolean dodajKurs(String naziv, String skraceni, double prodajni,
			double kupovni, double srednji) {
		GregorianCalendar dan = new GregorianCalendar();
		Valuta v = new Valuta();
		v.setNaziv(naziv);
		v.setSkraceniNaziv(skraceni);
		KursValute k = new KursValute();
		k.setProdajniKurs(prodajni);
		k.setKupovniKurs(kupovni);
		k.setSrednjiKurs(srednji);
		k.setDatum(new GregorianCalendar());
		v.setKurs(k);
		
		if(valute.isEmpty()) {
		valute.add(v);
		return true;	
		}
		for (int i = 0; i < valute.size(); i++) {
			if(dan.compareTo(valute.get(i).getKurs().getDatum()) == 0) {
				valute.get(i).setKurs(k);
			}
			else
				valute.add(v);
		}
		return true;
	}

	public boolean obrisiKurs(String naziv, int godina, int mesec, int dan) {
		GregorianCalendar datum = new GregorianCalendar(godina, mesec-1, dan);
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).getNaziv().equals(naziv) && valute.get(i).getKurs().getDatum().compareTo(datum) == 0) {
					valute.remove(i);
					return true;
			}
		}
		return false;
	}

	public KursValute nadjiKurs(String naziv, int godina, int mesec, int dan) {
		GregorianCalendar datum = new GregorianCalendar(godina, mesec-1, dan);
		KursValute k = new KursValute();
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).getNaziv().equals(naziv) && valute.get(i).getKurs().getDatum().compareTo(datum) == 0)
			    k = valute.get(i).getKurs();	
		}
		return k;
	}

}
