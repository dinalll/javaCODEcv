package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemestarTest {
    Semestar semestar= new Semestar(1,1);
    Profesor pr = new Profesor("Mito","Mitić");
    Predmet p = new Predmet("MATEMATIKA",10,pr,6);
    Student s=new Student ("Studo","Studić");
    Student s1= new Student ("Pado","Padić");
    Student s2= new Student ("Pado","Padić");
    IzborniPredmet pi= new IzborniPredmet("FIZIKA",140,pr,5);
    ObavezniPredmet po= new ObavezniPredmet("HISTORIJA",99,new Profesor("Histo","Histić"),6)   ;

    @Test
    void dodajPredmet() {
        semestar.dodajPredmet(p);
        semestar.dodajPredmet(pi);
        semestar.dodajPredmet(po);
        assertEquals(3,semestar.getPredmeti().size());
    }
    @Test
    void testToString(){
        semestar.dodajPredmet(p);
        semestar.dodajPredmet(pi);
        semestar.dodajPredmet(po);
        pi.dodajStudenta(s1);
        p.dodajStudenta(s1);
        po.dodajStudenta(s1);
        assertEquals("\n1. Semestar 1. ciklusa studija ,Predmeti: \n" +
                " 1-MATEMATIKA(I)  2-FIZIKA(I)  3-HISTORIJA(O) ",semestar.toString());
    }
}