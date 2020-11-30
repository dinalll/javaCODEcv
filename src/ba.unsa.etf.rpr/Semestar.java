package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Semestar {
    int brSemestra,ciklus;
    ArrayList<Predmet> predmeti= new ArrayList<Predmet>();

    public Semestar(int brSemestra, int ciklus, ArrayList<Predmet> predmeti) {
        this.brSemestra = brSemestra;
        this.ciklus = ciklus;
        this.predmeti = predmeti;
    }

    public int getBrSemestra() {
        return brSemestra;
    }

    public void setBrSemestra(int brSemestra) {
        this.brSemestra = brSemestra;
    }

    public int getCiklus() {
        return ciklus;
    }

    public void setCiklus(int ciklus) {
        this.ciklus = ciklus;
    }

    public ArrayList<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(ArrayList<Predmet> predmeti) {
        this.predmeti = predmeti;
    }
    void dodajPredmet(Predmet p){
        predmeti.add(p);
    }
}
