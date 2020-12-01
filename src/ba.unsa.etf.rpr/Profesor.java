package ba.unsa.etf.rpr;

import java.util.ArrayList;

public class Profesor {
    String Ime,prezime;

    public Profesor(String ime, String prezime) {
        Ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return  Ime +" "+ prezime;
    }

    @Override
    public boolean equals(Object obj) {
        Profesor p= (Profesor) obj;
        return (p.getIme()+p.getPrezime()).equalsIgnoreCase(this.getIme()+this.getPrezime());
    }
}
