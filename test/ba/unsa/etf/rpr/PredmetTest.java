package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {
    Profesor pr = new Profesor("Mito","Mitić");
    Predmet p = new Predmet("MATEMATIKA",10,pr,6);
    Student s=new Student ("Studo","Studić");
    Student s1= new Student ("Pado","Padić");
    Student s2= new Student ("Pado","Padić");
    IzborniPredmet pi= new IzborniPredmet("FIZIKA",120,pr,5);
    ObavezniPredmet po= new ObavezniPredmet("HISTORIJA",35,new Profesor("Histo","Histić"),6)   ;
    @Test
    void getNazivPredmeta() {
        assertEquals("MATEMATIKA",p.getNazivPredmeta());
    }

    @Test
    void getProfesor() {
        assertEquals("Mito Mitić",p.getProfesor().toString());
    }

    @Test
    void dodajStudenta() {
        p.dodajStudenta(s);
        p.dodajStudenta(s1);
        p.dodajStudenta(s2);
        assertEquals(3,p.getLista().size());
        try{
            p.dodajStudenta(s);
        }
        catch (IllegalArgumentException x){
            assertEquals( x,x);
        }
    }
    @Test
    void ocjeni() {
        p.dodajStudenta(s1);
        p.ocjeni(s1,10);
        assertEquals(10,p.dajOcjenu(s1));
    }
    @Test
    void testEquals(){
        assertEquals(true,p.equals(p));
    }
    @Test
    void testIzborniPredmet(){
        assertEquals(true,pi instanceof IzborniPredmet);
    }
    @Test
    void testObavezniPredmet(){
        assertEquals(true,po instanceof ObavezniPredmet);
    }
}