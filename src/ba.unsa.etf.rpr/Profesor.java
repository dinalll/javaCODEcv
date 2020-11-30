package ba.unsa.etf.rpr;

public class Profesor {
    String Ime,prezime;
    int norma;

    public Profesor(String ime, String prezime, int norma) {
        Ime = ime;
        this.prezime = prezime;
        this.norma = norma;
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

    public int getNorma() {
        return norma;
    }

    public void setNorma(int norma) {
        this.norma = norma;
    }

    @Override
    public String toString() {
        return  Ime +" "+ prezime;
    }
}
