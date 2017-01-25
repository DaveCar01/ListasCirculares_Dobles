package strc;

import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;

public class ListasCD
{
	Nodos primero;
	Nodos ultimo;
	//private int size;
	
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
			auxActual = auxActual.anterior;
			
		}
		while (auxActual != ultimo  && encontrado != true);//al momento que llegue a terminar el ciclo apunta al anterior 
		
		if ( encontrado == true)
		{
			//JOptionPane.showInputDialog("Nodo encontrado \n:"+encontrado);
			//JOptionPane.showMessageDialog(null, "Nodo encontrado: \n ");
			System.out.println("NODO ENCONTRADO \n:");
		}
		else{
			//JOptionPane.showInputDialog("el nodo que busca no fue ingresado");
			//JOptionPane.showMessageDialog(null, "EL nodo no fue ingresado");
			System.out.println("NODO NO ENCONTRADO \n:");
		}
	}
	/*public int tamaño()
	{
		Nodos aux=primero;
		while(aux.getSiguiente()!=primero)
		{
			size ++;
			aux=aux.getSiguiente();
		}
		return size;
		
	}
	public Nodos buscarNodo(int posicion){
	    Nodos aux=primero;
	    
	    int cont=1;
	    
	    if(posicion <1 || posicion>tamaño()){
	        System.out.println("La posicion insertada no es correcta");
	        
	    }else{
	        while(aux.getSiguiente()!=primero){
	            if (posicion == cont){

	                return aux; 
	            }

	            aux=aux.getSiguiente();
	            cont++;   
	        }   
	    }
	    return aux;
	    
	}*/
	
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
	
	
	public void imprimirLista()
	{
		Nodos actual = new Nodos();
		actual = primero;
		
		do {
			//JOptionPane.showMessageDialog(null, actual.dato);
			System.out.println(actual.dato);
			actual= actual.siguiente;
			
		}while(actual!= primero);
		
		
	}
	/*public String mostrarlistardeiniciofin(){
		String salida="";
		if(!estaVacia()){
		salida+="<=> ";
			Nodos aux = primero;
			while(aux!=null){
				salida= salida +"["+aux.getDato() + "]<=>";
				aux=aux.siguiente;
			}
		}
		return salida;
	}
	
	public String mostrarlistardefininicio(){
		String salida="";
		if(!estaVacia()){
		salida+="<=> ";
			Nodos aux = ultimo;
			while(aux!=null){
				salida= salida +"["+aux.getDato() + "]<=>";
				aux= aux.anterior;
			}
		}
		return salida;
	}*/
	
	
	/*public boolean estaVacia(){
		return (primero== null);
	}
	public Nodos buscarporDato(String dato){
		Nodos aux=primero;
		if (estaVacia()){
			return null;
			}
		else {
		while(aux!=null){
			
			if( aux.getDato().equalsIgnoreCase(dato)){
				return aux;
				}
			aux=aux.getSiguiente();
			}
		
		}
		return null;		
	}*/
	
/*public Nodos buscarporIndice(int indice){
		
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
	}*/
}
