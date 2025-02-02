package no.hvl.data102.filmarkiv.impl;

public class Filmarkiv2 implements FilmarkivADT{
	private int antall;
    private LinearNode<Film> start;
 
    public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
    }
 
    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> gjeldendeNode = start;
        while (gjeldendeNode != null) {
            if (gjeldendeNode.data.getFilmNr() == nr) {
                return gjeldendeNode.data;
            }
            gjeldendeNode = gjeldendeNode.neste;
        }
        return null;  // Returner null hvis filmen ikke finnes
    }
 
    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.neste = start;  // Den nye noden peker til start (begynnelsen på listen)
        start = nyNode;  // Start pekeren oppdateres til den nye noden
        antall++;
    }
 
    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> gjeldendeNode = start;
        LinearNode<Film> forrigeNode = null;
 
        while (gjeldendeNode != null) {
            if (gjeldendeNode.data.getFilmNr() == filmnr) {
                if (forrigeNode == null) {
                    start = gjeldendeNode.neste;  // Hvis filmen er første node
                } else {
                    forrigeNode.neste = gjeldendeNode.neste;  // Kobler om nodene
                }
                antall--;
                return true;  // Filmen ble slettet
            }
            forrigeNode = gjeldendeNode;
            gjeldendeNode = gjeldendeNode.neste;
        }
        return false;  // Filmen ble ikke funnet
    }
 
    @Override
    public Film[] soekTittel(String delstreng) {
        List<Film> resultater = new ArrayList<>();
        LinearNode<Film> gjeldendeNode = start;
        while (gjeldendeNode != null) {
            if (gjeldendeNode.data.getTittel().contains(delstreng)) {
                resultater.add(gjeldendeNode.data);
            }
            gjeldendeNode = gjeldendeNode.neste;
        }
        return resultater.toArray(new Film[0]);
    }
 
    @Override
    public Film[] soekProdusent(String delstreng) {
        List<Film> resultater = new ArrayList<>();
        LinearNode<Film> gjeldendeNode = start;
        while (gjeldendeNode != null) {
            if (gjeldendeNode.data.getProdusent().contains(delstreng)) {
                resultater.add(gjeldendeNode.data);
            }
            gjeldendeNode = gjeldendeNode.neste;
        }
        return resultater.toArray(new Film[0]);
    }
 
    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        LinearNode<Film> gjeldendeNode = start;
        while (gjeldendeNode != null) {
            if (gjeldendeNode.data.getSjanger().equals(sjanger)) {
                count++;
            }
            gjeldendeNode = gjeldendeNode.neste;
        }
        return count;
    }
 
    @Override
    public int antall() {
        return antall;
    }
}
