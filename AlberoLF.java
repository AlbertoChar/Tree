package Albero;

import java.util.LinkedList;

public class AlberoLF<T> {
	
	// Nome: Alberto Charabati
	// Matricola: 7031859
	
	private NodoLF<T> radice;
	private int numNodi, numFoglie, altezza;
	
	
	//costruttore:
		public AlberoLF() {
			radice = null;
			numNodi = 0;
			numFoglie = 0;
			altezza = 0;
		}
		
		public int altezza() {
			return altezza;
		}

		public int numNodi() {
			return numNodi;
		}
		
		public int getnumFoglie() {
			return numFoglie;
		}
		
		public NodoLF<T> getRadice() {
			return radice;
		}
		
		public NodoLF<T> aggiungiRadice(T info) {
			if(radice != null) {
				return null;
			}
			numNodi = 1;
			numFoglie = 1;
			altezza = 1; //conto anche nodi esterni 
			return radice = new NodoLF<T>(info);
		}
		
		public NodoLF<T> aggiungiNuovaRadice(NodoLF<T> u, int pos) {
			if(radice == null) {
				return null;
			} if (pos < 1) {
				return null;
			}
			u.setPadre(null);
			u.setFiglio(radice);
			radice.setPadre(u);
			radice = u;
			altezza++;
			numNodi++;
			
			return radice;
		}
		
		public NodoLF<T> aggiungiNodo(NodoLF<T> u, T info) {
			NodoLF<T> v = new NodoLF<T>(info);
			u.setFiglio(v);
			v.setPadre(u);
			numNodi++;
			if(v.livello() > altezza) {
				altezza = v.livello();
			}
			if(u.getGrado() > 1) {
				numFoglie++;
			}
			return v;
		}
				
		//Visita in Profondita:
		public LinkedList<T> visitaProf() {
			LinkedList<T> infoNodiAlberoProf = new LinkedList<>();
			LinkedList<NodoLF<T>> pila = new LinkedList<>();
			
			pila.addFirst(radice);
			while(!pila.isEmpty()) {
				NodoLF<T> u = pila.removeFirst();
				infoNodiAlberoProf.add(u.getInfo());
				
				for(int i = u.getGrado()-1; i >=0; i--) {
					if(u.getFigli().get(i) != null) {
						pila.addFirst(u.getFigli().get(i));
					}
				}
			}
			return infoNodiAlberoProf;
		}
		
		
		//Visita in Ampiezza:
		public LinkedList<T> visitaAmpiezza() {
			LinkedList<T> infoNodiAlberoLiv = new LinkedList<>();
			LinkedList<NodoLF<T>> coda = new LinkedList<>();
			
			coda.addLast(radice);
			while(!coda.isEmpty()) {
				NodoLF<T> u = coda.removeFirst();
				infoNodiAlberoLiv.add(u.getInfo());
				
				for(int i = 0; i < u.getGrado(); i++) {
					if(u.getFigli().get(i) != null) {
						coda.addLast(u.getFigli().get(i));
					}
				}
			}
			return infoNodiAlberoLiv;
		}
		
		
		//Tree to String:
		public String toString() {
			String[] t = {""};
			stringMaker(radice, t);
			t[0] = t[0]+"]";
			t[0] = t[0].replace("],]", "]]");
			return t[0];
		}
	
		private void stringMaker(NodoLF<T> v, String[] t) {
			if(v == null) {
				t[0] = t[0] + "null";
				return;
			}
			t[0] = t[0] + v.getInfo();
			for(int i = 1; i <= v.getGrado(); i++) {
				if(i == 1) {
				t[0] = t[0] + "[";
				}
			stringMaker(v.getFiglio(i), t);
			if(v.getFiglio(i).getGrado() == 0) {
				t[0] = t[0] + "[]";
				if(i == v.getGrado()) {
					t[0] = t[0] + "],";
				}
				if(i < v.getGrado()) {
					if(v.getFiglio(i).livello() >= v.getFiglio(i+1).livello()) {
						t[0] = t[0] + ",";
					}
				}
			}
		}
	}	
		
}
