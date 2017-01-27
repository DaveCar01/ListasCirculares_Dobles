package strc;

import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;

public class ListasCD
{
	protected Nodos primero;
	protected Nodos ultimo;
	protected long size;
	
	public ListasCD ()
	{
		primero = null; //la lista existe cuando se construye el primer nodo
		ultimo= null;
	}
	public void ingresarNodo( int lista)
	{
		Nodos NuevoNodo = new Nodos();
		
		NuevoNodo.dato= lista;
		if ( primero == null)
		{
			primero = NuevoNodo; // nuevo se guarda dentro de primero
			primero.siguiente=primero;
			NuevoNodo.anterior = ultimo; //
			ultimo= NuevoNodo;
		}
		else
		{
			ultimo.siguiente= NuevoNodo; // el ultimo que apunta a primero que apunta a siguiente que se asigne el valor de nuevo nodo
			NuevoNodo.siguiente=primero; // el nuevo nodo que apunta a siguiente ya pase apuntar al primero
			NuevoNodo.anterior=ultimo;  // el nuevo nodo que apunta al anterior ya apunte hacia el ultimo
			ultimo= NuevoNodo; // pasa apuntar al primer nodo o nuevo
			primero.anterior=ultimo;  // apunta al anteriro 
		}
		size++;
	}
	public void ingresarNodoalFinal( int lista)
	{
		Nodos NuevoNodo = new Nodos();
		
		NuevoNodo.dato= lista;
		if ( ultimo == null)
		{
			ultimo = NuevoNodo; // nuevo se guarda dentro de ultimo
			ultimo.anterior=ultimo;
			NuevoNodo.siguiente = primero; //
			ultimo= NuevoNodo;
		}
		else
		{
			primero.anterior= NuevoNodo; // el primero que apunta a ultimo que apunta al anterior que se asigne el valor de nuevo nodo
			NuevoNodo.anterior=ultimo; // el nuevo nodo que apunta a anterior y a pasa apuntar al ultimo
			NuevoNodo.siguiente=primero;  // el nuevo nodo que apunta al siguiente y a apunte hacia el primero
			primero= NuevoNodo; // pasa apuntar al primer nodo o nuevo
			ultimo.siguiente=primero;  // apunta al anteriro 
		}
		size++;
	}
	/*public void insertarAlInicio(int lista)
	 {
	    Nodos auxActual = new Nodos();
        auxActual.setDato(lista);
        if (estaVacia()) {
            primero= auxActual; //al primero y al ultimo le das el mismo valor
            ultimo=auxActual;  
            ultimo.setSiguiente(primero);// ultimo apunta al primero los dos nodos apunta a un mismo nodo
        } else{
            auxActual.setSiguiente(primero); // el nuevo dato va a ser el primero 
            primero= auxActual;
            ultimo.setSiguiente(primero); // el ultimo apunta al primero
        }
        size++;
		
	}
	
	
	public void insertarAlFinal(int lista)
	 {
	    Nodos auxActual = new Nodos();
	    auxActual.setDato(lista);
        if (estaVacia()) {
            ultimo= auxActual; //al primero y al ultimo le das el mismo valor
            primero=auxActual;  
            primero.setSiguiente(ultimo);// primero apunta al ultimo los dos nodos apunta a un mismo nodo
        } else{
            auxActual.setSiguiente(ultimo); // el nuevo dato va a ser el ultimo 
            primero= auxActual;
            ultimo.setSiguiente(ultimo); // el primero apunta al ultimo
        }
        size++;
		
	}*/
    
	
	public void ingresarmitad(int dato, int referencia)

	{
		Nodos nuevoMitad= new Nodos();
		Nodos auxiliar = new Nodos();
		Nodos auxiliar1= new Nodos();
		
		auxiliar= primero;
		for(int i=0;i<size;i++ )
		{
			if(auxiliar.getDato()== referencia )
			{
				nuevoMitad.setDato(dato);					//toma el dato 
				nuevoMitad.setSiguiente(auxiliar); // este apunta al aux
				auxiliar1.setSiguiente(nuevoMitad);//el anterior del aux1 apunta al nuevomitad
				nuevoMitad.setAnterior(auxiliar.getAnterior());// el anterior del nuevo nodo apunta al anteior del aux
				auxiliar.setAnterior(nuevoMitad); //el anterior del aux apunta al nuevo nodo 
				// el aux sirve para coger el anteior 
				size ++;
				return ;
			}
			else
			{
				//System.out.println("elemento no encotrado");
				auxiliar1= auxiliar;
				auxiliar=auxiliar.getSiguiente();
			}
		}
		
	}
	
	//recorre desde el ultimo al primerp
	
	public void buscarNodo(int lista)
	{
		Nodos auxActual = new Nodos();
		auxActual = ultimo;
		boolean encontrado= false;
		do
		{
			if(auxActual.dato== lista)
			{
				encontrado = true;   //el nodo actual que permite rrecorrer la lista este obtiene el valor del ultimo dato 
			}						// y recorre la lista ingresada asta encontrar el nodo correcpondiente
			auxActual = auxActual;
			
		}
		while (auxActual != ultimo  && encontrado != true);//al momento que llegue a terminar el ciclo apunta al anterior 
		
		if ( encontrado == true)
		{
			//JOptionPane.showInputDialog("Nodo encontrado \n:"+encontrado);
			//JOptionPane.showMessageDialog(null, "Nodo encontrado: \n ");
			System.out.println("NODO ENCONTRADO \n:"+auxActual.getDato());
		}
		else{
			//JOptionPane.showInputDialog("el nodo que busca no fue ingresado");
			//JOptionPane.showMessageDialog(null, "EL nodo no fue ingresado");
			System.out.println("NODO NO ENCONTRADO \n:");
		}
	}
	
	
	public void eliminarNodo(int lista)
	{
		Nodos auxActual= new Nodos();
		Nodos auxAnterior= new Nodos();
		auxActual= primero;
		auxAnterior= ultimo;
		do
		{
			if(auxActual.dato == lista)
			{
				if(auxActual == primero)
				{
					primero = primero.siguiente;
					ultimo.siguiente= primero;// actualiza el valor que se asigna al primero
					primero.anterior= ultimo; // 
					
				}
				else if (auxActual == ultimo)
				{
					ultimo = auxAnterior; // se acutaliza los apuntadores para no perder la referencia
					primero.anterior= ultimo; // termina apuntado al ultimo
					ultimo.siguiente= primero; // el nuevo ultimo que apunta al siguiente sera el primero
				}
				else 
				{
					auxAnterior.siguiente = auxActual.siguiente; // 
					auxActual.siguiente.anterior = auxAnterior; // con eso salto el nodo que quiero eliminar
				}
				
			}
			auxAnterior = auxActual;
			auxActual = auxActual.siguiente;
		}
		while(auxActual != primero);
	}
	
	
	public void imprimirListaInicioFin()
	{
		Nodos actual = new Nodos();
		actual = primero;
		
		do {
			//JOptionPane.showMessageDialog(null, actual.dato);
			System.out.println(actual.dato);
			actual= actual.siguiente;
			
		}while(actual!= primero);
		
		
	}
	public void imprimirListaFinaInicio()
	{
		Nodos actual = new Nodos();
		actual = ultimo;
		
		do {
			//JOptionPane.showMessageDialog(null, actual.dato);
			System.out.println(actual.dato);
			actual= actual.anterior;
			
		}while(actual!= ultimo);
		
		
	}
	
	
	
	public boolean estaVacia(){
		return (primero== null);
	}
	
	
	public Nodos buscarporIndice(int indice){
		
		Nodos aux=primero;
		int cont=0;
		
		if (estaVacia()){
			return null;}
		else {
		while(aux!=null){
			cont++;
			if (cont==indice){
				return aux;}
			else {
				aux=aux.getSiguiente();}
					}
		return null;			
		}
	}
}
