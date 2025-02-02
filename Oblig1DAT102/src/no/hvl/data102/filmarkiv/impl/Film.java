package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	public Film(int filmNr, String tittel, int lansering, String filmselskap) {
		this.filmNr = filmNr;
		this.tittel = tittel;
		this.lansering = lansering;
		this.filmselskap = filmselskap;
	}
	
	
	private int filmNr;
	private String tittel;
	private int lansering;
	@Override
	public int hashCode() {
		return Objects.hash(filmNr, filmselskap, lansering, tittel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmNr == other.filmNr && Objects.equals(filmselskap, other.filmselskap) && lansering == other.lansering
				&& Objects.equals(tittel, other.tittel);
	}


	private String filmselskap;
		
	private enum Sjanger{
		ACTION, DRAMA, HISTORY, SCIFI;
	}

	
	public int getFilmNr(){
	return filmNr;
	}
	
	public  String getTittel() {
		return tittel;
		
	}
	
	public  int getLansering() {
		return lansering;			
	}
	
	public  String getFilmselskap() {
		return filmselskap;			
	}
}
