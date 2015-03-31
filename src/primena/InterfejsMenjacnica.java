package primena;

import menjacnica.KursValute;

public interface InterfejsMenjacnica {
	
	public boolean dodajKurs (String naziv, String skraceni, double prodajni, double kupovni, double srednji);
	public boolean obrisiKurs(String naziv, int godina, int mesec, int dan);
	public KursValute nadjiKurs(String naziv, int godina, int mesec, int dan);
}
