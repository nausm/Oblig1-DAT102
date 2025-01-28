package no.hvl.data102.filmarkiv.impl;

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
