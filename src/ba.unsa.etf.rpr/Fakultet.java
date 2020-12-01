package ba.unsa.etf.rpr;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fakultet {
    String nazivFakulteta;
    ArrayList<Semestar> semestar = new ArrayList<Semestar>();

    public Fakultet(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }

    public String getNazivFakulteta() {
        return nazivFakulteta;
    }

    public void setNazivFakulteta(String nazivFakulteta) {
        this.nazivFakulteta = nazivFakulteta;
    }

    public ArrayList<Semestar> getSemestar() {
        return semestar;
    }

    public void setSemestar(ArrayList<Semestar> semestar) {
        this.semestar = semestar;
    }


    public void dodajSemestar(Semestar s) {
        semestar.add(s);
    }

    public String dajSNormom() {
        ArrayList<Profesor> ponavljanje = new ArrayList<Profesor>();
        String povratni = "Preko norme:\n";
        String povratni2 = "\nBez norme :\n";
        for (Semestar c : this.getSemestar()) {
            for (int i = 0; i < c.getPredmeti().size(); i++) {
                int norma = 0;
                for (int j = 0; j < c.getPredmeti().size(); j++) {
                    if (c.getPredmeti().get(i).getProfesor().equals(c.getPredmeti().get(j).getProfesor())) {
                        norma += c.getPredmeti().get(j).getBrojCasova();
                    }
                }
                if (ponavljanje.contains(c.getPredmeti().get(i).getProfesor()) == false) {
                    ponavljanje.add(c.getPredmeti().get(i).getProfesor());
                    if (norma > 150)
                        povratni += "Profesor : " + c.getPredmeti().get(i).getProfesor() + " Norma: " + norma + "\n";
                    else if (norma < 120)
                        povratni2 += "Profesor : " + c.getPredmeti().get(i).getProfesor() + " Norma: " + norma + "\n";
                }
            }
        }
        return  povratni+povratni2;
    }

    public void sortirajPoNormi() {
        Map<Profesor, Integer> ponavljanje = new HashMap<Profesor, Integer>();
        for (Semestar c : this.getSemestar()) {
            for (int i = 0; i < c.getPredmeti().size(); i++) {
                int norma = 0;
                for (int j = 0; j < c.getPredmeti().size(); j++) {
                    if (c.getPredmeti().get(i).getProfesor().equals(c.getPredmeti().get(j).getProfesor())) {
                        norma += c.getPredmeti().get(j).getBrojCasova();
                    }
                }
                if (ponavljanje.containsKey(c.getPredmeti().get(i).getProfesor()) == false) {
                    ponavljanje.put(c.getPredmeti().get(i).getProfesor(), norma);
                }
            }
        }
        System.out.println("\nLista profesora sortirana po normi: ");
        ponavljanje.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);

    }
    public void sortirajPoBrojuStudenata(){
        Map<Profesor, Integer> ponavljanje = new HashMap<Profesor, Integer>();
        for (Semestar c : this.getSemestar()) {
            for (int i = 0; i < c.getPredmeti().size(); i++) {
                int br_studenata = 0;
                for (int j = 0; j < c.getPredmeti().size(); j++) {
                    if (c.getPredmeti().get(i).getProfesor().equals(c.getPredmeti().get(j).getProfesor())) {
                        br_studenata += c.getPredmeti().get(j).getLista().size();
                    }
                }
                if (ponavljanje.containsKey(c.getPredmeti().get(i).getProfesor()) == false) {
                    ponavljanje.put(c.getPredmeti().get(i).getProfesor(), br_studenata);
                }
            }
        }
        System.out.println("\nLista profesora sortirana po broju studenata: ");
        ponavljanje.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach((System.out::println));
    }
    public String prepisOcjena(Student s){
        String povratni="\nStudent :"+s.toString();
        for(Semestar c:this.getSemestar()){
            for(int i=0;i<c.getPredmeti().size();i++){
                if(c.getPredmeti().get(i).dajOcjenu(s)!=0) {
                    povratni += "\n" + c.getPredmeti().get(i).getNazivPredmeta() + " : ";
                    povratni +="Ocjena (" + c.getPredmeti().get(i).dajOcjenu(s)+ ")";
                }
            }
        }
        return povratni;
    }
}

