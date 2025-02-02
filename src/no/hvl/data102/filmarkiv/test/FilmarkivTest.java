package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.*;

public class FilmarkivTest {
	@Test
	void testUtvidTabell() {
		Filmarkiv filmarkiv = new Filmarkiv(2);
	    Film film1 = new Film(1, "To All The Boys", 2018, "Netflix");
	    Film film2 = new Film(2, "Home Alone", 2005, "Paramount Picture");
	    Film film3 = new Film(3, "Moana", 2022, "Disney");

	    filmarkiv.leggTilFilm(film1);
	    filmarkiv.leggTilFilm(film2);
	    filmarkiv.leggTilFilm(film3);

	    Film[] filmer = filmarkiv.hentFilmer();
	    assertEquals(3, filmer.length, "Tabellen ble ikke utvidet som forventet.");
	}
	
	@Test
	void testLeggTilFilm() {
		Filmarkiv filmarkiv = new Filmarkiv(2);
	    Film film1 = new Film(1, "To All The Boys", 2018, "Netflix");

	    filmarkiv.leggTilFilm(film1);
	    Film[] filmer = filmarkiv.hentFilmer();

	    assertEquals(1, filmer.length, "Filmen ble ikke lagt til i filmarkivet.");
	    assertEquals("Film 1", filmer[0].getTittel(), "Filmen har feil tittel.");	
	    
	    Filmarkiv2 filmarkiv = new Filmarkiv2();
	    Film film = new Film(1, "Film 1", "Produsent 1", Sjanger.DRAMA);
	    filmarkiv.leggTilFilm(film);
	    assertEquals(1, filmarkiv.antall());
	    }
	
	@Test
	void testHentFilmer() {
		Filmarkiv filmarkiv = new Filmarkiv(2);
	    Film film1 = new Film(1, "To All The Boys", 2018, "Netflix");
	    Film film2 = new Film(2, "Home Alone", 2005, "Paramount Picture");

	    filmarkiv.leggTilFilm(film1);
	    filmarkiv.leggTilFilm(film2);
	    
	    Film[] filmer = filmarkiv.hentFilmer();

	    assertEquals(2, filmer.length, "Feil antall filmer hentet.");
	    assertEquals("To All The Boys", filmer[0].getTittel(), "Filmen 1 ble ikke hentet korrekt.");
	    assertEquals("Home Alone", filmer[1].getTittel(), "Filmen 2 ble ikke hentet korrekt.");
	}	
	
	@Test
	void testFinnFilm() {
		Filmarkiv filmarkiv = new Filmarkiv(2);
	    Film film1 = new Film(1, "To All The Boys", 2018, "Netflix");
	    Film film2 = new Film(2, "Home Alone", 2005, "Paramount Picture");

	    filmarkiv.leggTilFilm(film1);
	    filmarkiv.leggTilFilm(film2);
	    
	    Film film = filmarkiv.finnFilm("To All The Boys");

	    assertNotNull(film, "Fant ikke filmen.");
	    assertEquals("To All The Boys", film.getTittel(), "Feil film funnet.");
			}
	
	@Test
	void testFinnFilmerAvSjanger() {
		Filmarkiv filmarkiv = new Filmarkiv(2);
	    Film film1 = new Film(1, "To All The Boys", 2018, "Netflix");
	    Film film2 = new Film(2, "Home Alone", 2005, "Paramount Picture");
	    Film film3 = new Film(3, "Moana", 2022, "Disney");
	    
	    film1.setSjanger(Sjanger.ACTION);
	    film2.setSjanger(Sjanger.ACTION);
	    film3.setSjanger(Sjanger.COMEDY);

	    filmarkiv.leggTilFilm(film1);
	    filmarkiv.leggTilFilm(film2);
	    filmarkiv.leggTilFilm(film3);
	    
	    Film[] actionFilmer = filmarkiv.finnFilmerAvSjanger(Sjanger.ACTION);
	    
	    assertEquals(2, actionFilmer.length, "Feil antall filmer for sjangeren ACTION.");
	    assertEquals("To All The Boys", actionFilmer[0].getTittel(), "Feil film for sjangeren ACTION.");
	    assertEquals("Home Alone", actionFilmer[1].getTittel(), "Feil film for sjangeren ACTION.");
	}
	
	@Test
	void testTrimTabell() {
		Filmarkiv filmarkiv = new Filmarkiv(3);
	    Film film1 = new Film(1, "To All The Boys", 2018, "Netflix");
	    Film film2 = new Film(2, "Home Alone", 2005, "Paramount Picture");

	    filmarkiv.leggTilFilm(film1);
	    filmarkiv.leggTilFilm(film2);

	    filmarkiv.fjernFilm(1);
	    filmarkiv.fjernFilm(2);

	    Film[] filmer = filmarkiv.hentFilmer();
	    assertEquals(0, filmer.length, "Tabellen ble ikke trimmet etter at filmer ble fjernet.");
	}
	}

}