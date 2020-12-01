package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Fakultet {
    String nazivFakulteta;
    ArrayList<Semestar> semestar= new ArrayList<Semestar>();

    public Fakultet(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }

    public String getNazivFakulteta() {
        return nazivFakulteta;
    }

    public void setNazivFakulteta(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }

    public ArrayList<Semestar> getSemestar() {
        return semestar;
    }

    public void setSemestar(ArrayList<Semestar> semestar) {
        this.semestar = semestar;
    }

    public void dodajSemestar(Semestar s){
        semestar.add(s);
    }
}
