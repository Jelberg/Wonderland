/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class ListaCategorias {

    private List< Productos> listPro;

    public ListaCategorias() {
        this.listPro = new LinkedList();
    }

    public void agregarLista() {
        // agrega a una lista para el combobox

    }

    public boolean agregarCateg(Productos pro) {
        // esta lista se usa para la lista de categorias 
        return this.listPro.add(pro);
    }

    public void imprimirLista() {
        for (Productos nodoActual : this.listPro) {
            System.out.println("Categoria: " + nodoActual.getCategoria());
            System.out.println("Serial: " + nodoActual.getSerial());
        }
    }
}
