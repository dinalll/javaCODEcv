package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Semestar {
    int brSemestra,ciklus;
    ArrayList<Predmet> predmeti= new ArrayList<Predmet>();

    public Semestar(int brSemestra, int ciklus) {
        this.brSemestra = brSemestra;
        this.ciklus = ciklus;
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
    @Override
    public String toString() {
        String izlaz="\n";
        for(int i=0;i<this.getPredmeti().size();i++){
            izlaz+=" "+(i+1)+"-"+predmeti.get(i).getNazivPredmeta();
            if(predmeti.get(i) instanceof ObavezniPredmet) izlaz+="(O) ";
            else izlaz+="(I) ";
        }
        return "\n" + brSemestra+". Semestar " + ciklus+
                ". ciklusa studija ,Predmeti: " + izlaz;
    }
}
