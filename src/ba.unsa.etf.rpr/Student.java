package ba.unsa.etf.rpr;

public class Student {
    private String ime, prezime;
    private static int br=10000;
    int brIndeksa;
    public Student(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
        this.brIndeksa=br++;
    }
    public Student(String ime, String prezime,int brIndeksa){
        this.ime=ime;
        this.prezime=prezime;
        this.brIndeksa=brIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrIndeksa() {
        return brIndeksa;
    }

    public void setBrIndeksa(int brIndeksa) {
        this.brIndeksa = brIndeksa;
    }
    @Override
    public int hashCode() {
        return getBrIndeksa()*getIme().length() *getPrezime().length();
    }

    @Override
    public String toString() {
        return getIme()+ " "+ getPrezime()+ " " + getBrIndeksa();
    }

    @Override
    public boolean equals(Object obj) {
        Student s= (Student) obj;
        return this.toString().equalsIgnoreCase(obj.toString());
    }
}
