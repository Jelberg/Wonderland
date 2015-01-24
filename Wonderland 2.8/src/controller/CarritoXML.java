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
import model.Productos;
import model.Usuario;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;



/**
 *
 * @author Jessica
 */
public class CarritoXML {
    
    private Element root;

    private String fileLocation = "src//Archivos//Carrito.xml";

    public CarritoXML() {
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

    private Element ProductotoXmlElement(Productos pro) {
        Element produc = new Element("Carrito");
        Element nombre = new Element("Nombre");
        nombre.setText(pro.getCategoria());
        Element serial = new Element("Serial");
        serial.setText(pro.getSerial());
        produc.addContent(nombre);
        produc.addContent(serial);
        return produc;
    }

    private Productos ProductoToObject(Element element) throws ParseException {
        Productos lib = new Productos(element.getChildText("Nombre"), "","","", "", element.getChildText("Serial"),"");
        return lib;
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
            if (dato.equals(e.getChild("Nombre").getText())) {
                return e;
            }
        }
        return null;
    }

   public static Element buscarSerial(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("Serial").getText())) {
                return e;
            }
        }
        return null;
    }
    public boolean agregarCarrito(Productos nE) {
        boolean resultado = false;
        root.addContent(ProductotoXmlElement((Productos) nE));
        resultado = updateDocument();
        return resultado;
    }
    
    public Productos buscarCarrito(Productos pro) {
        Element aux = new Element("Carrito");
        List Productos = this.root.getChildren("Carrito");
        while (aux != null) {
            aux = CarritoXML.buscar(Productos,pro.getNombre());
            if (aux != null) {
                try {
                    return ProductoToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
    
        public boolean actualizarCarrito (Productos nE) {
        boolean resultado = false;
        Element aux = new Element("Carrito");
        List Productos = this.root.getChildren("Carrito");
        while (aux != null) {
            aux = CarritoXML.buscar(Productos, nE.getNombre());
            int prueba;
            prueba=1;
            if (prueba==1) {
                Productos.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarCarrito(nE);
        return resultado;
    }
    
    
    public boolean borrarCarrito(Productos serial) {
        boolean resultado = false;
        Element aux = new Element("Carrito");
        List Productos = this.root.getChildren("Carrito");
        while (aux != null) {
            aux = CarritoXML.buscarSerial(Productos, serial.getSerial() );
            if (aux !=null) {
                Productos.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }

    public ArrayList<Productos> carrito() {
        ArrayList<Productos> resultado = new ArrayList<Productos>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(ProductoToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }  
}
