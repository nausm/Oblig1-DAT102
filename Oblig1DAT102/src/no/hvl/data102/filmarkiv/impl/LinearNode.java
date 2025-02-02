package no.hvl.data102.filmarkiv.impl;

public class LinearNode <T>{
	public T data;  // Dataen som lagres i noden
    public LinearNode<T> neste;  // Peker til neste node i listen
 
    public LinearNode(T data) {
        this.data = data;
        this.neste = null;  // Neste node er null til den blir satt
    }
}
