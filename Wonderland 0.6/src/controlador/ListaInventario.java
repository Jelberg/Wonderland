/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.LinkedList;
import java.util.List;
import modelo.Productos;

/**
 *
 * @author Jessica
 */
public class ListaInventario {
     private List < Productos > list;
    
   public ListaInventario()
    {
        this.list = new LinkedList();
    }
   
    public boolean agregarProducto (Productos pro){
       return this.list.add(pro);
    }
    
    
     /*public void imprimirLista()
    {
        for (Productos nodoActual : this.list)
        {
            System.out.println("Autor: " + nodoActual.getAutor());
            System.out.println("Codigo: " + nodoActual.getCodigo());
            System.out.println("Edicion: " + nodoActual.getEdicion());
            System.out.println("Editorial: " + nodoActual.getEditorial());
            System.out.println("Formato: " + nodoActual.getFormato());
            System.out.println("Genero: " + nodoActual.getGenero());
            System.out.println("Titulo: " + nodoActual.getTitulo());
            System.out.println("Precio: " + nodoActual.getPrecio());
            
        }
    }*/
}
