package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakultetTest {
    Fakultet faks= new Fakultet("Fakultet");
    Semestar s= new Semestar(1,1);
    Predmet p1=new ObavezniPredmet("Historija",50,new Profesor("Histo","Histic"),6);
    Predmet p2=new ObavezniPredmet("Matematika",50,new Profesor("Matko","Matic"),7);
    Predmet p3=new ObavezniPredmet("Fiziologija",50,new Profesor("Fizo","Fistic"),8);
    Predmet p4=new IzborniPredmet("Dinamika",50,new Profesor("Dino","Dinic"),6);
    Predmet p5=new IzborniPredmet("Likovno",50,new Profesor("Liko","Likic"),6);
    Predmet p7=new IzborniPredmet("Fizicko",50,new Profesor("Fizo","Fizic"),6);
    Predmet p8=new IzborniPredmet("Fizicko",50,new Profesor("Fizo","Fizic"),6);
    Predmet p9=new IzborniPredmet("Fizicko",50,new Profesor("Fizo","Fizic"),6);
    Predmet p10=new IzborniPredmet("Fizicko",50,new Profesor("Fizo","Fizic"),6);

    @Test
    void dodajSemestar() {
        faks.dodajSemestar(s);
        s.dodajPredmet(p1);s.dodajPredmet(p2);s.dodajPredmet(p3);s.dodajPredmet(p4);s.dodajPredmet(p5);
        p1.dodajStudenta(new Student("Niko","Nikic"));
        p2.dodajStudenta(new Student("Niko","Nikic"));
        p3.dodajStudenta(new Student("Niko","Nikic"));
        p4.dodajStudenta(new Student("Niko","Nikic"));
        p5.dodajStudenta(new Student("Niko","Nikic"));
    }

    @Test
    void dajSNormom() {
        s.dodajPredmet(p1);s.dodajPredmet(p2);s.dodajPredmet(p3);s.dodajPredmet(p4);
        for(int i=0;i<5;i++){
            s.dodajPredmet(p5);s.dodajPredmet(p7);
        }
        faks.dodajSemestar(s);
        String s = "Preko norme:\n" +
                "Profesor : Liko Likic Norma: 250\n" +
                "Profesor : Fizo Fizic Norma: 250\n" +
                "\n" +
                "Bez norme :\n" +
                "Profesor : Histo Histic Norma: 50\n" +
                "Profesor : Matko Matic Norma: 50\n" +
                "Profesor : Fizo Fistic Norma: 50\n" +
                "Profesor : Dino Dinic Norma: 50\n";
        assertEquals(s,faks.dajSNormom());
    }
}