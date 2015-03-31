package primena;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.KursValute;
import menjacnica.Valuta;

public class ImplementacijaInterfejsa implements InterfejsMenjacnica {

	LinkedList<Valuta> valute = new LinkedList<Valuta>();

	public boolean dodajKurs(String naziv, String skraceni, double prodajni,
			double kupovni, double srednji) {
		GregorianCalendar datum = new GregorianCalendar();
		int god = datum.get(GregorianCalendar.YEAR);
		int dan = datum.get(GregorianCalendar.DAY_OF_MONTH);
		int mesec = datum.get(GregorianCalendar.MONTH) + 1;
		Valuta v = new Valuta();
		v.setNaziv(naziv);
		v.setSkraceniNaziv(skraceni);
		KursValute k = new KursValute();
		k.setProdajniKurs(prodajni);
		k.setKupovniKurs(kupovni);
		k.setSrednjiKurs(srednji);
		k.setDatum(new GregorianCalendar());
		v.setKurs(k);
		int godk = k.getDatum().get(GregorianCalendar.YEAR);
		int dank = k.getDatum().get(GregorianCalendar.DAY_OF_MONTH);
		int meseck = k.getDatum().get(GregorianCalendar.MONTH) + 1;
		for (int i = 0; i < valute.size(); i++) {
			if(god == godk && dan == dank && mesec == meseck) {
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
