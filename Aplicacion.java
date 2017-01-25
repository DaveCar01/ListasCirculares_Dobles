package strc;

import javax.swing.JOptionPane;

public class Aplicacion {

	//private static String lista;
	//static String elemento="";

	public static void main(String[] args)
	{
		int opcion=0;
		int elemento;
		int buscador = 0;
		ListasCD listaElementos = new ListasCD();
		
		do
		{
			try 
			{
				opcion =Integer.parseInt(JOptionPane.showInputDialog(null,
						  "MENU DE OPCIONES \n"
						 +"1. Insertar Nodo \n "
						 +"2. Buscar Nodo\n"
						 +"3. Modificar Nodo \n"
						 +"4. Eliminar NOdo\n"
						 +"5. Imprimir Lista\n"
						 +"6. Salir\n",JOptionPane.INFORMATION_MESSAGE));
				
				switch(opcion)
				{
				case 1:
					elemento= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento",JOptionPane.INFORMATION_MESSAGE));
					listaElementos.ingresarNodo(elemento);
					
					break;
				case 2:
					elemento=Integer.parseInt(JOptionPane.showInputDialog("EL nodo a buscar es:\n",JOptionPane.INFORMATION_MESSAGE));
					listaElementos.buscarNodo(elemento);
					//JOptionPane.showMessageDialog(null, "el nodo fue encontrado"+listaElementos.buscarNodo(buscador));
					//listaElementos.buscarNodo(elemento);
					/*elemento=JOptionPane.showInputDialog("Ingrese el dato a buscar");
					
					if(listaElementos.buscarporDato(elemento) !=null)
					{
					
					JOptionPane.showMessageDialog(null,listaElementos.buscarNodo(elemento).getDato());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "NO existe");
					}*/
					
					break;
				case 3:
					
		
					break;
					
				case 4:
					elemento = Integer.parseInt(JOptionPane.showInputDialog("ingrese el nodo que desea eliminar",JOptionPane.INFORMATION_MESSAGE));
					listaElementos.eliminarNodo(elemento);
					
					break;
				case 5:
					JOptionPane.showMessageDialog(null, "Lista de elementos");
					//elemento=JOptionPane.showInputDialog("La lista de elementos es: \n",JOptionPane.INFORMATION_MESSAGE);
					//listaElementos.mostrarlistardefininicio();
					//listaElementos.mostrarlistardeiniciofin();
					listaElementos.imprimirLista();
			
					break;
				case 6:
					JOptionPane.showMessageDialog(null, "Aplicacion fin","FIn",JOptionPane.INFORMATION_MESSAGE);
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "OPcion no valida","Error",JOptionPane.INFORMATION_MESSAGE);
				
				}	
		}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "error"+e.getMessage());
			}
			
		}
		while (opcion != 6);

	}

}
