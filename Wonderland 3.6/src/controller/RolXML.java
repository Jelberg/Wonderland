/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Usuario;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Jessica
 */
public class RolXML {
    
    private Element root;

    private String fileLocation = "src//Archivos//rol.xml";

    public RolXML() {
        BasicConfigurator.configure();        
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = null;
            doc = builder.build(fileLocation);
            root = doc.getRootElement();
            Logger log = Logger.getLogger("Revicion de error");
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    }

    private Element UsuariotoXmlElement(Usuario pro) {
        Element usuario = new Element("Cambio");
        Element seu = new Element("Seudonimo");
        seu.setText(pro.getSeudonimo());
        Element cambio = new Element("Tipo");
        cambio.setText(pro.getRol());
        Element mensaje = new Element("mensaje");
        mensaje.setText(pro.getApellido());
        Element Respuesta = new Element("Respuesta");
        Respuesta.setText(pro.getNombre());
        usuario.addContent(seu);
        usuario.addContent(cambio);
        usuario.addContent(mensaje);
        usuario.addContent(Respuesta);
        return usuario;
    }

    private Usuario UsuToObject(Element element) throws ParseException {
        Usuario lib = new Usuario(element.getChildText("Respuesta"),element.getChildText("mensaje"),"",
                "","","",element.getChildText("Seudonimo"),"","",element.getChildText("Tipo"),"","","","");
        return lib;
    }

    private boolean updateDocument() {
        Logger log = Logger.getLogger("Excepciones");
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

    public static Element buscarRol(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("Seudonimo").getText())) {
                return e;
            }
        }
        Logger log = Logger.getLogger("Busco");
        return null;
    }
      public boolean borrarUsu(Usuario pro) {
        boolean resultado = false;
        Element aux = new Element("Cambio");
        List Usuario = this.root.getChildren("Cambio");
        while (aux != null) {
            aux = RolXML.buscarRol(Usuario, pro.getSeudonimo());
            if (aux != null) {
                Usuario.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    public Usuario buscarUsuarioRol(Usuario pro) {
        Element aux = new Element("Cambio");
        List Productos = this.root.getChildren("Cambio");
        while (aux != null) {
            aux = RolXML.buscarRol(Productos,pro.getSeudonimo());
            if (aux != null) {
                try {
                    return UsuToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
    
      public static Element buscar1(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("Seudonimo").getText())) {
                return e;
            }
        }
        return null;
    }

    public Usuario buscarPersona(String seudonimo) {
        Element aux = new Element("Cambio");
        List usuarios = this.root.getChildren("Cambio");
        while (aux != null) {
            aux = RolXML.buscar1(usuarios,(seudonimo));
            if (aux != null) {
                try {
                    return UsuToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
    
    
    public boolean actualizarUsuarioCambio (Usuario nE) {
        boolean resultado = false;
        Element aux = new Element("Cambio");
        List Usuario = this.root.getChildren("Cambio");
        while (aux != null) {
            aux = RolXML.buscar1(Usuario, nE.getSeudonimo());
            int prueba;
            prueba=1;
            if (prueba==1) {
                Usuario.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarUsuarioRol(nE);
        return resultado;
    }

    public boolean agregarUsuarioRol(Usuario nE) {
        boolean resultado = false;
        root.addContent(UsuariotoXmlElement((Usuario) nE));
        resultado = updateDocument();
        return resultado;
    }

    public ArrayList<Usuario> todosUsuarioRol() {
        ArrayList<Usuario> resultado = new ArrayList<Usuario>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(UsuToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }
}
