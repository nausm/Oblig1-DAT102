package no.hvl.data102.filmarkiv.klient;

import javax.swing.JOptionPane;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv){
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start(){
		// legg inn en del forhåndsdefinerte filmer for å teste metodene
		Film TOALLTHEBOYS = new Film(1, "To All The Boys",2018, "Netflix");
		Film HOMEALONE = new Film(2, "Home Alone", 2005, "Paramount Picture" );
		Film MOANA = new Film(3, "Moana", 2022, "Disney");
		
		filmarkiv.leggTilFilm(TOALLTHEBOYS);
		filmarkiv.leggTilFilm(HOMEALONE);
		filmarkiv.leggTilFilm(MOANA);
		
		// TODO
		while(true) {
			String valg = JOptionPane.showInputDialog("Velg et alternativ:\n" + 
					"1. Legg til film\n"+
					"2. Finn film etter tittel\n"+
					"3. Vis alle filmer\n"+
					"4. Finn filmer av sjanger\n"+
					"5. Avslutt"
			); 
			int valgTall = Integer.parseInt(valg);
			
			switch(valgTall) {
	        case 1:
	        	int filmNr = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn filmnr:"));
	        	String filmTittel = JOptionPane.showInputDialog("SKriv inn tittel:");
	        	int aar = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn utgivelsesår:"));
	        	String produsent = JOptionPane.showInputDialog("Skriv inn produsent:");
	        	
	        	Film nyFilm = new Film(filmNr, filmTittel, aar, produsent);
	            filmarkiv.leggTilFilm(nyFilm);
	            break;
	            
	        case 2:
	        	String tittel = JOptionPane.showInputDialog("Skriv inn tittelen på filmen:");
	        	Film resultat = filmarkiv.finnFilm(tittel);
	        	if (resultat != null) {
	        	    tekstgr.visFilm(resultat);
	        	} else {
	        	    JOptionPane.showMessageDialog(null, "Fant ingen film med tittelen: " + tittel);
	        	}
	        	
	            break;
	        case 3:
	        	Film[] alleFilmer = filmarkiv.hentFilmer();
	        	if (alleFilmer.length > 0) {
	        	    tekstgr.visFilmer(alleFilmer);
	        	} else {
	        	    JOptionPane.showMessageDialog(null, "Ingen filmer funnet.");
	        	}
	            break;
	            
	        case 4:
	        	 String sjangerStr = JOptionPane.showInputDialog("Skriv inn sjanger:");
                 Sjanger sjanger = Sjanger.valueOf(sjangerStr.toUpperCase());
                 Film[] sjangerResultat = filmarkiv.finnFilmerAvSjanger(sjanger);
                 if (sjangerResultat.length > 0) {
                     tekstgr.visFilmer(sjangerResultat);
                 } else {
                     JOptionPane.showMessageDialog(null, "Ingen filmer funnet i denne sjangeren.");
                 }
	            break;
	        case 5:
	            System.exit(0);
	            break;
	            
	        default:
	            JOptionPane.showMessageDialog(null, "Ugyldig valg, prøv igjen.");
			}
		}
	}
}
