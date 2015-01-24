/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import java.awt.Image;
import model.Usuario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import org.jdom.Document;
import org.jdom.Element;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author essteeli
 */
public class UsuarioXML {
    private Element root;
 
    private String fileLocation = "src//Archivos//Usuarios.xml";
   
    public UsuarioXML() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    }
 
    private Element UsuariotoXmlElement( Usuario usuarioNuevo) {
        
        Element UsuarioAux = new Element("Usuario");
        Element nombre = new Element("nombre");
        nombre.setText(usuarioNuevo.getNombre());
        Element apellido = new Element("apellido");
        apellido.setText(usuarioNuevo.getApellido());
        Element cedula = new Element("cedula");
        cedula.setText(usuarioNuevo.getCedula());
        Element email = new Element("email");
        email.setText(usuarioNuevo.getCorreo());
        Element clave = new Element("clave");
        clave.setText(usuarioNuevo.getClave());
        Element seudonimo = new Element("seudonimo");
        seudonimo.setText(usuarioNuevo.getSeudonimo());
        Element direccion = new Element("direccion");
        direccion.setText(usuarioNuevo.getDireccion());
        Element freg = new Element("freg");
        freg.setText(usuarioNuevo.getFReg());
        Element fnac= new Element("fnac");
        fnac.setText(usuarioNuevo.getFNac());
        Element rol = new Element("rol");
        rol.setText(usuarioNuevo.getRol());
        UsuarioAux.addContent(nombre);
        UsuarioAux.addContent(apellido);
        UsuarioAux.addContent(cedula);
        UsuarioAux.addContent(email);
        UsuarioAux.addContent(direccion);
        UsuarioAux.addContent(clave);
        UsuarioAux.addContent(seudonimo);     
        UsuarioAux.addContent(freg);
        UsuarioAux.addContent(fnac);
        UsuarioAux.addContent(rol);
        return UsuarioAux;
    }


    private Usuario UsuarioToObject(Element element) throws ParseException {
        Usuario usuarioNuevo = new Usuario ( element.getChildText("nombre"),element.getChildText("apellido"),element.getChildText("cedula"),
                                             element.getChildText("email"),element.getChildText("direccion"),element.getChildText("clave"),
                                             element.getChildText("seudonimo"),element.getChildText("freg"),element.getChildText("fnac"),
                                             element.getChildText("rol") ,"","","","");
        return usuarioNuevo;
    }

  
    private boolean updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

 
    public static Element buscar(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("seudonimo").getText())) {
                return e;
            }
        }
        return null;
    }
public static Element buscarCambio(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("cambio").getText())) {
                return e;
            }
        }
        return null;
    }

    public boolean agregarUsuario(Usuario usuarioNuevo) {
        
        boolean resultado = false;
        root.addContent(UsuariotoXmlElement((Usuario) usuarioNuevo));
        resultado = updateDocument();
        return resultado;
    }

 
 
    public Usuario buscarPersona(String seudonimo) {
        Element aux = new Element("Usuario");
        List usuarios = this.root.getChildren("Usuario");
        while (aux != null) {
            aux = UsuarioXML.buscar(usuarios,(seudonimo));
            if (aux != null) {
                try {
                    return UsuarioToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
   
       public Usuario buscarCambio(String seudonimo) {
        Element aux = new Element("Usuario");
        List usuarios = this.root.getChildren("Usuario");
        while (aux != null) {
            aux = UsuarioXML.buscar(usuarios,(seudonimo));
            if (aux != null) {
                try {
                    return UsuarioToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }


    public boolean actualizarUsuario (Usuario nE) {
        boolean resultado = false;
        Element aux = new Element("Usuario");
        List Usuario = this.root.getChildren("Usuario");
        while (aux != null) {
            aux = UsuarioXML.buscar(Usuario, nE.getSeudonimo());
            int prueba;
            prueba=1;
            if (prueba==1) {
                Usuario.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarUsuario(nE);
        return resultado;
    }
    
    
    public boolean borrarPersona(String cedula) {
        boolean resultado = false;
        Element aux = new Element("Usuario");
        List Usuario = this.root.getChildren("Usuario");
        while (aux != null) {
            aux = UsuarioXML.buscar(Usuario, cedula);
            if (aux !=null) {
                Usuario.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }

   
    public ArrayList<Usuario> todosLosUsuarios() {
        ArrayList<Usuario> resultado = new ArrayList<Usuario>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(UsuarioToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
         }
}






    
   