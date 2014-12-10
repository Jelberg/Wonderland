/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import static controlador.Validar.validarRango;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;



public class Validar {
    ButtonGroup SeleccionarBusqueda;
    JRadioButton nombre,categoria;
    // Validar es una Clase Utilitaria solo contiene métodos no es empleada para almacenar datos

    // Validar es una Clase Utilitaria solo contiene métodos no es empleada para almacenar datos
 
      public Validar(ButtonGroup SeleccionarBusqueda, JRadioButton nombre, JRadioButton categoria) {
        this.SeleccionarBusqueda = SeleccionarBusqueda;
        this.nombre = nombre;
        this.categoria = categoria;
    }
   
 public static int validarVacio (JTextField campo, String mensaje){
       if (campo.getText().isEmpty())
          { JOptionPane.showMessageDialog(null, mensaje, "Notificacion", JOptionPane.INFORMATION_MESSAGE); 
            return 0; 
          }
       else
            return 1;
   }  
 
 public static int validarEntero (String numero, String mensaje){
   try{
         int numero1 = Integer.parseInt(numero);
         return 1; 
      }
   catch(NumberFormatException ex){
      JOptionPane.showMessageDialog(null,mensaje,"Tipo De Dato No es un Entero", JOptionPane.ERROR_MESSAGE);
      return 0;
       }
}
 public void SeleccionarBusqueda(){
     SeleccionarBusqueda.add(nombre);
     SeleccionarBusqueda.add(categoria);
     
 }
 
 public static int validarRango(float numero,String mensaje)
   {
      if (numero < 0 || numero > 10000)
        {JOptionPane.showMessageDialog(null,mensaje,"Valor no valido", JOptionPane.ERROR_MESSAGE);
         return 0;
        }
      else
        return 1;   
   }
 
 public static int validarReal (String numero, String mensaje)
  {
    try{
       float numero1 = Float.parseFloat(numero); 
       return validarRango(numero1,"Valor Invalido");
       
      }
   catch(NumberFormatException ex){
    JOptionPane.showMessageDialog(null,mensaje,"Tipo De Dato No es un Real", JOptionPane.ERROR_MESSAGE);
    return 0;
     }
    
 }
}
