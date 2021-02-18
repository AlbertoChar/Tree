package Albero;

import java.util.LinkedList;


public class NodoLF<T> {
	
	// Nome: Alberto Charabati
	// Matricola: 7031859
	
	private T info;
	private NodoLF<T> padre;
	private LinkedList<NodoLF<T>> figli;
	
	//costruttore:
	public NodoLF(T dato) {
		info = dato;
		figli = new LinkedList<NodoLF<T>>();
		padre = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NodoLF<T> getPadre() {
		return padre;
	}

	public void setPadre(NodoLF<T> padre) {
		this.padre = padre;
	}

	public LinkedList<NodoLF<T>> getFigli() {
		return figli;
	}

	public void setFiglio(NodoLF<T> u) {
		figli.addLast(u);
	}
	
	
	public NodoLF<T> getFiglio(int pos) {
		return figli.get(pos-1);
	}
	
	
	public int getGrado() {
		int count = 0;
		for(int i = 0; i<figli.size(); i++) {
			if(figli.get(i) != null) {
				count++;
			}
		}
		return count;
	}
	
	
	//Quanti nodi interni ci sono nell'albero:
	public LinkedList<T> ListaInfoNodiInterni() {
		LinkedList<T> r = new LinkedList<>();
		for(int i = 0; i < figli.size(); i++) {
			if(figli.get(i) != null) {
				r.add(figli.get(i).getInfo());
			}
		}
		return r;
	}
	
	
	//Restituisce il livello del nodo dentro l'albero:
	public int livello() {
		int livello = 0;
		NodoLF<T> temp = padre;
		while(temp != null) {
			livello++;
			temp = temp.getPadre();
		}
		return livello;
	}
	

}
