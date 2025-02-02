package no.hvl.data102.filmarkiv.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Filmarkiv2Test {

	@Test
	public void testLeggTilFilm() {
	    Filmarkiv2 filmarkiv = new Filmarkiv2();
	    Film film = new Film(1, "Film 1", "Produsent 1", Sjanger.DRAMA);
	    filmarkiv.leggTilFilm(film);
	    assertEquals(1, filmarkiv.antall());
	}
}