/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Listas;
import java.util.*;
import modelo.Usuario;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author essteeli
 */
public class AgregarUsuarioLista {
    
     private List <Usuario> listusuarios;
    
   public AgregarUsuarioLista()
    {
        this.listusuarios = new LinkedList();
    }
   
    public boolean agregarUsuario (Usuario usuario){
       return this.listusuarios.add(usuario);
    }
    
    
     public void imprimirLista()
    {
        for (Usuario nodoActual : this.listusuarios)
        {
            
            System.out.println("Nombre: " + nodoActual.getApellido());
            System.out.println("Apellido: " + nodoActual.getNombre());
            System.out.println("CI: " + nodoActual.getCedula());
            System.out.println("Seudonimo: " + nodoActual.getSeudonimo());
            System.out.println("Clave: " + nodoActual.getClave());
            System.out.println("Correo: " + nodoActual.getCorreo());
            System.out.println("F actual: " + nodoActual.getFReg());
            System.out.println("F nacimiento: " + nodoActual.getFNac());
            System.out.println("Direccion: " + nodoActual.getDireccion());
            System.out.println("Rol: " + nodoActual.getRol());
            System.out.println("Tarjeta de credito: " + nodoActual.getNumTarjCredito());
            System.out.println("Marca Comercial " + nodoActual.getMarcaComercial());
            System.out.println("Fecha de vencimiento: " + nodoActual.getFecVencimiento());
            System.out.println("Codigo: " + nodoActual.getCodigo());

        }
    }
}

