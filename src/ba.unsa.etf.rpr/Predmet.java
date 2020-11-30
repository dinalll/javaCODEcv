package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predmet {
    private String nazivPredmeta;
    private Profesor profesor;
    private Map<Student,Integer> lista =new HashMap<Student, Integer>();
    private int brojEcts;
    public Predmet(String nazivPredmeta, Profesor profesor, int brojEcts) {
        this.nazivPredmeta = nazivPredmeta;
        this.profesor = profesor;
        this.brojEcts = brojEcts;
    }
    public void dodajStudenta(Student s)throws IllegalArgumentException{
        if(lista.containsKey(s)) throw new IllegalArgumentException("Student je već prijavljen na kurs");
        else {lista.put(s,0);}
    }
    public void Ocjeni(Student s,int ocjena)throws IllegalArgumentException{
        if(ocjena<5 || ocjena>10)throw new IllegalArgumentException("Neispravna ocjena");
        else if(lista.containsKey(s)==false)throw new IllegalArgumentException("Student ne pohađa dati kurs");
        for (Map.Entry<Student, Integer> entry : lista.entrySet()) {
            if(entry.getKey().toString().equals(s.toString()))entry.setValue(ocjena);
        }

    }
}
