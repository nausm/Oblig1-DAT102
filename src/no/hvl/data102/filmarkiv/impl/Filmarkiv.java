package no.hvl.data102.filmarkiv.impl;
 
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
 
public class Filmarkiv implements FilmarkivADT {
 
    private Film[] filmer;
    private int antallFilmer;
 
    // Konstruktør som oppretter et tomt arkiv med en gitt størrelse
    public Filmarkiv(int kapasitet) {
        filmer = new Film[kapasitet]; 
        antallFilmer = 0;
    }
 
    // Hjelpemetode for å utvide tabellen hvis den er full
    private void utvidTabell() {
        Film[] nytabell = new Film[filmer.length * 2];
        for (int i = 0; i < filmer.length; i++) {
            nytabell[i] = filmer[i]; 
        }
        filmer = nytabell; 
    }
 
    // Metode for å legge til en ny film
    public void leggTilFilm(Film nyFilm) {
        if (filmer.length <= antallFilmer) {
            utvidTabell(); 
        }
        filmer[antallFilmer] = nyFilm; 
        antallFilmer++;
    }
 
    // Metode for å hente alle filmer (returnerer en kopi uten null-verdier)
    public Film[] hentFilmer() {
        Film[] nytabell = new Film[antallFilmer]; 
        for (int i = 0; i < antallFilmer; i++) {
            nytabell[i] = filmer[i]; 
        }
        return nytabell; 
    }
 
    // Metode for å finne filmer basert på tittel-søk
    public Film[] finnFilm(String delAvTittel) {
        Film[] treff = new Film[antallFilmer]; 
        int teller = 0;
 
        for (int i = 0; i < antallFilmer; i++) {
            if (filmer[i].getTittel().toLowerCase().contains(delAvTittel.toLowerCase())) {
                treff[teller] = filmer[i]; 
                teller++;
            }
        }
        return trimTabell(treff, teller); 
    }
 
    // Metode for å finne filmer basert på sjanger
    public Film[] finnFilmerAvSjanger(Sjanger sjanger) {
        Film[] treff = new Film[antallFilmer]; 
        int teller = 0;
 
        for (int i = 0; i < antallFilmer; i++) {
            if (filmer[i].getSjanger() == sjanger) {
                treff[teller] = filmer[i];
                teller++;
            }
        }
        return trimTabell(treff, teller);
    }
 
    // Privat metode for å trimme tabellen (fjerner null-verdier)
    private Film[] trimTabell(Film[] tabell, int lengde) {
        Film[] nyTabell = new Film[lengde]; 
        for (int i = 0; i < lengde; i++) {
            nyTabell[i] = tabell[i];
        }
        return nyTabell;
    }
}