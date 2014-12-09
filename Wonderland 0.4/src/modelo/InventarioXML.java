/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Jessica
 */
public class InventarioXML {

    private Element root;

    private String fileLocation = "src//Archivos//inventario.xml";

    public InventarioXML() {
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
        Element produc = new Element("Producto");
        Element nombre = new Element("Nombre");
        nombre.setText(pro.getNombre());
        Element descripcion = new Element("Descripcion");
        descripcion.setText(pro.getDescripcion());
        Element monto = new Element("Monto");
        monto.setText(pro.getMonto());
        Element cantidad = new Element("Cantidad");
        cantidad.setText(pro.getCantidad());
        Element serial = new Element("Serial");
        serial.setText(pro.getSerial());
        produc.addContent(nombre);
        produc.addContent(descripcion);
        produc.addContent(monto);
        produc.addContent(cantidad);
        produc.addContent(serial);
        return produc;
    }

    private Productos ProductoToObject(Element element) throws ParseException {
        Productos lib = new Productos(element.getChildText("Nombre"), element.getChildText("Descripcion"),
                element.getChildText("Monto"), element.getChildText("Cantidad"),
                "", element.getChildText("Serial"));
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

    public boolean agregarProducto(Productos nE) {
        boolean resultado = false;
        root.addContent(ProductotoXmlElement((Productos) nE));
        resultado = updateDocument();
        return resultado;
    }

    public Productos buscarProducto(String dato) {
        Element aux = new Element("Producto");
        List Libro = this.root.getChildren("Producto");
        while (aux != null) {
            aux = InventarioXML.buscar(Libro, dato);
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

    public boolean actualizarProducto(Productos nE) {
        boolean resultado = false;
        Element aux = new Element("Producto");
        List Producto = this.root.getChildren("Producto");
        while (aux != null) {
            aux = InventarioXML.buscar(Producto, nE.getNombre());
            if (aux != null) {
                Producto.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarProducto(nE);
        return resultado;
    }

    public boolean borrarProducto(String Producto) {
        boolean resultado = false;
        Element aux = new Element("Producto");
        List Productos = this.root.getChildren("Producto");
        while (aux != null) {
            aux = InventarioXML.buscar(Productos, Producto);
            if (aux != null) {
                Productos.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }

    public ArrayList<Productos> inventario() {
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
