package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predmet {
    private String nazivPredmeta;
    private Profesor profesor;
    private Map<Student,Integer> lista =new HashMap<Student, Integer>();
    private int brojEcts,brojCasova;
    public Predmet(String nazivPredmeta, int brojCasova,Profesor profesor, int brojEcts) {
        this.nazivPredmeta = nazivPredmeta;
        this.profesor = profesor;
        this.brojEcts = brojEcts;
        this.brojCasova=brojCasova;
    }

    public int getBrojCasova() {
        return brojCasova;
    }
    public void setBrojCasova(int brojCasova) {
        this.brojCasova = brojCasova;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Map<Student, Integer> getLista() {
        return lista;
    }

    public int getBrojEcts() {
        return brojEcts;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setLista(Map<Student, Integer> lista) {
        this.lista = lista;
    }

    public void setBrojEcts(int brojEcts) {
        this.brojEcts = brojEcts;
    }

    public void dodajStudenta(Student s)throws IllegalArgumentException{
        if(lista.containsKey(s)) throw new IllegalArgumentException("Student je već prijavljen na kurs");
        else {lista.put(s,0);}
    }
    public void ocjeni(Student s,int ocjena)throws IllegalArgumentException{
        if(ocjena<5 || ocjena>10)throw new IllegalArgumentException("Neispravna ocjena");
        else if(lista.containsKey(s)==false)throw new IllegalArgumentException("Student ne pohađa dati kurs");
        for (Map.Entry<Student, Integer> entry : lista.entrySet()) {
            if(entry.getKey().toString().equals(s.toString()))entry.setValue(ocjena);
        }
    }
    public int dajOcjenu(Student s)throws IllegalArgumentException{
        for(Map.Entry<Student,Integer> entry: lista.entrySet()){
            if(entry.getKey().equals(s))return entry.getValue();
        }
        throw new IllegalArgumentException("Student nije ocjenjen");
    }
    @Override
    public boolean equals(Object a){
        Predmet p= (Predmet) a;
        return p.getNazivPredmeta().equalsIgnoreCase(this.getNazivPredmeta());
    }

    @Override
    public String toString() {
        String ispis="\n";
        for(Map.Entry<Student,Integer> entry: lista.entrySet()){
            ispis+=entry.getKey()+" "+entry.getValue()+"\n";
        }
        return "\n Predmet: "+this.getNazivPredmeta() + ispis;
    }
}
