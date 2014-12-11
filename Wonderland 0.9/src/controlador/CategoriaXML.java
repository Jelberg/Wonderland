/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Productos;
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
public class CategoriaXML {
 
    private Element root;

    private String fileLocation = "src//Archivos//categorias.xml";

    public CategoriaXML() {
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

    private Element ProductotoXmlElement(Productos pro) {
        Element produc = new Element("Categ");
        Element categoria = new Element("Categoria");
        categoria.setText(pro.getCategoria());
        Element serial = new Element("Serial");
        serial.setText(pro.getSerial());
        produc.addContent(categoria);
        produc.addContent(serial);
        return produc;
    }

    private Productos ProductoToObject(Element element) throws ParseException {
        Productos lib = new Productos("", "","","", element.getChildText("Categoria"), element.getChildText("Serial"));
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

    public static Element buscar(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("Categoria").getText())) {
                return e;
            }
        }
        Logger log = Logger.getLogger("Busco");
        return null;
    }
      public boolean borrarCategoria(Productos pro) {
        boolean resultado = false;
        Element aux = new Element("Categ");
        List Productos = this.root.getChildren("Categ");
        while (aux != null) {
            aux = CategoriaXML.buscar(Productos, pro.getSerial());
            if (aux != null) {
                Productos.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
    public Productos buscarCategoria(Productos pro) {
        Element aux = new Element("Categ");
        List Productos = this.root.getChildren("Categ");
        while (aux != null) {
            aux = CategoriaXML.buscar(Productos,pro.getSerial());
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
    public Productos buscarCategoriacat(String pro) {
        Element aux = new Element("Categ");
        List Productos = this.root.getChildren("Categ");
        while (aux != null) {
            aux = CategoriaXML.buscar(Productos,pro);
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
    
        public boolean actualizarCategoria (Productos nE) {
        boolean resultado = false;
        Element aux = new Element("Categ");
        List Productos = this.root.getChildren("Categ");
        while (aux != null) {
            aux = CarritoXML.buscar(Productos, nE.getSerial());
            int prueba;
            prueba=1;
            if (prueba==1) {
                Productos.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarCategoria(nE);
        return resultado;
    }
    

    public boolean agregarCategoria(Productos nE) {
        boolean resultado = false;
        root.addContent(ProductotoXmlElement((Productos) nE));
        resultado = updateDocument();
        return resultado;
    }

    public ArrayList<Productos> todaslasCategorias() {
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
