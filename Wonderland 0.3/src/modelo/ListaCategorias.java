/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jessica
 */
public class ListaCategorias {

    private ArrayList <String> listPro;

    public ListaCategorias() {
        this.listPro = new ArrayList();
    }

    public void agregarLista() {
        // agrega a una lista para el combobox
    }

    public boolean agregarCateg(String pro) {
        // esta lista se usa para la lista de categorias 
        return this.listPro.add(pro);
    }
    
    public String posicion(int pos){
        return listPro.get(pos);
    }

    public void imprimirLista() {
        for (String nodoActual : this.listPro) {
            System.out.println("Categoria: " + nodoActual);
        }
    }
}
