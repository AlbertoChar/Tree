package Albero;


public class Run {
	
		// Nome: Alberto Charabati
		// Matricola: 7031859

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		
		AlberoLF<String> Tree = new AlberoLF<>();
		
		NodoLF<String> Marco = Tree.aggiungiRadice("Marco");
		
		//Cambio di radice:
		NodoLF<String> Claudia = new NodoLF<>("Claudia");
		Tree.aggiungiNuovaRadice(Claudia, 1);
		
		NodoLF<String> Luca = Tree.aggiungiNodo(Claudia, "Luca");
		NodoLF<String> Giulia = Tree.aggiungiNodo(Claudia, "Giulia");
		
		NodoLF<String> Silvia = Tree.aggiungiNodo(Marco, "Silvia");
		
		//Cambio informazione di un nodo:
		NodoLF<String> Elia = Tree.aggiungiNodo(Marco, "Elia");
		Elia.setInfo("Ugo");
		
		NodoLF<String> Andrea = Tree.aggiungiNodo(Giulia, "Andrea");
		NodoLF<String> Gianna = Tree.aggiungiNodo(Giulia, "Gianna");
		
		NodoLF<String> Carlo = Tree.aggiungiNodo(Andrea, "Carlo");

		
		System.out.println("Radice: " + Tree.getRadice().getInfo());
		System.out.println("Altezza: " + Tree.altezza());
		System.out.println("Numero di nodi: " + Tree.numNodi());
		System.out.println("Numero di foglie: " + Tree.getnumFoglie());
		System.out.println();
		System.out.println("Livello Claudia: " + Claudia.livello());
		System.out.println("Livello Marco: " + Marco.livello());
		System.out.println("Livello Silvia: " + Silvia.livello());
		System.out.println("Livello Andrea: " + Andrea.livello());
		System.out.println("Livello Carlo: " + Carlo.livello());
		System.out.println();
		
		System.out.println("Padre di Carlo: " + Carlo.getPadre().getInfo());
		System.out.println("Padre di Andrea: " + Andrea.getPadre().getInfo());
		System.out.println();
		
		System.out.println("Primo figlio di Claudia: " + Claudia.getFiglio(1).getInfo());
		System.out.println("Secondo figlio di Claudia: " + Claudia.getFiglio(2).getInfo());
		System.out.println();
		
		System.out.println("Grado di Claudia: " + Claudia.getGrado());
		System.out.println("Grado di Andrea: " + Andrea.getGrado());
		System.out.println("Grado di Luca: " + Luca.getGrado());
		System.out.println();
		
		System.out.println("figli di Claudia: ");
		Claudia.ListaInfoNodiInterni().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Visita in Profondita: " + Tree.visitaProf());
		System.out.println();
		System.out.println("Visita in Ampiezza: " + Tree.visitaAmpiezza());
		System.out.println();
		System.out.println("Representazione in String: " + Tree.toString());
		System.out.println();
	}

}

