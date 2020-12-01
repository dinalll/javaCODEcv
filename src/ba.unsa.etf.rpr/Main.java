package ba.unsa.etf.rpr;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Fakultet faks= new Fakultet("Fakultet");
        Semestar s= new Semestar(1,1);
        Predmet p1=new ObavezniPredmet("Historija",50,new Profesor("Histo","Histic"),6);
        Predmet p2=new ObavezniPredmet("Matematika",50,new Profesor("Matko","Matic"),7);
        Predmet p3=new ObavezniPredmet("Fiziologija",50,new Profesor("Fizo","Fistic"),8);
        Predmet p4=new IzborniPredmet("Dinamika",50,new Profesor("Dino","Dinic"),6);
        Predmet p5=new IzborniPredmet("Likovno",50,new Profesor("Liko","Likic"),6);
        Predmet p6=new IzborniPredmet("Fizicko",50,new Profesor("Fizo","Fizic"),6);
        faks.dodajSemestar(s);
        s.dodajPredmet(p1);s.dodajPredmet(p2);s.dodajPredmet(p3);s.dodajPredmet(p4);s.dodajPredmet(p5);s.dodajPredmet(p6);
        p1.dodajStudenta(new Student("Niko","Nikic"));
        p2.dodajStudenta(new Student("Niko","Nikic"));
        p3.dodajStudenta(new Student("Niko","Nikic"));
        p4.dodajStudenta(new Student("Niko","Nikic"));
        p5.dodajStudenta(new Student("Niko","Nikic"));
        p6.dodajStudenta(new Student("Niko","Nikic"));
        System.out.println(faks.getSemestar().toString());
        for(;;){
            Scanner ulaz = new Scanner(System.in);
            System.out.println("Unesi ime fakulteta: ");
            Fakultet faks1 = new Fakultet(ulaz.nextLine());
            System.out.println("\nUnesi broj semsetra i ciklusa: ");
            Semestar s1 = new Semestar(ulaz.nextInt(),ulaz.nextInt());
            System.out.println("\nUnesi broj predmeta u semestru:");
            int predmeti=ulaz.nextInt();
            for(int i=0;i<predmeti;i++){
                System.out.println("\nUnesi "+ (i+1) +". predmet-> 1 za obavezni 2 za izborni: ");
                int priv=ulaz.nextInt();
                if(priv==1){
                    System.out.println("\nUnesi obavezni predmet format: naziv BrojCasova ImeProfesora PrezimeProfesora BrojEcts");
                    s1.dodajPredmet(new ObavezniPredmet(ulaz.next(),ulaz.nextInt(),new Profesor(ulaz.next(),ulaz.next()),ulaz.nextInt()));
                }
                if(priv==2){
                    System.out.println("\nUnesi obavezni predmet format: naziv BrojCasova ImeProfesora PrezimeProfesora BrojEcts");
                    s1.dodajPredmet(new IzborniPredmet(ulaz.next(),ulaz.nextInt(),new Profesor(ulaz.next(),ulaz.next()),ulaz.nextInt()));
                }
            }
            for(;;) {
                System.out.println("\n" + s1.toString() + "\n Dodajte studente na kurs (odaberite redni broj Izbornog kursa(I) ili 0 za prekid dodavanja: ");
                int predmet = ulaz.nextInt();
                if(predmet==-1)break;
                System.out.println("\nUnesite Ime i prezime studenta: ");
                s1.getPredmeti().get(predmet - 1).dodajStudenta(new Student(ulaz.next(), ulaz.next()));
            }
        System.out.println("\n Unesite broj komande za:\n 1)Informacije o normi profesora \n2)Sortiranje profesora po normi " +
                "\n3)sortiranje profesora po broju studenata na predmetima \n4)Za datog studenta ispisi prepis \n5)Za izlaz iz programa");

        }
    }
}