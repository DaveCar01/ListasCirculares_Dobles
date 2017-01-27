package strc;

public class Nodos
{
	 protected int dato;
	 protected Nodos siguiente;
	 protected Nodos anterior;
	public Nodos() {
		super();
		this.dato = dato;
		this.siguiente = siguiente;
		this.anterior = anterior;
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodos getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(Nodos siguiente) {
		this.siguiente = siguiente;
	}
	public Nodos getAnterior() {
		return anterior;
	}
	public void setAnterior(Nodos anterior) {
		this.anterior = anterior;
	}
	

	/*public Nodos(int dato,Nodos siguiente,Nodos anterior ){
		this.dato=dato;
		this.siguiente = siguiente;
		this.anterior=anterior;
	}*/
	
	/*public Nodos(){
		// cuando no hay nodos
		//this.dato= dato;
		//this.atras=null;
		//this.despues=null;
		
		this(dato,null,null);//primer Nodo	
	}*/


	
}
