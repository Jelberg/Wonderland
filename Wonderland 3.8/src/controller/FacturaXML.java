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
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import model.Facturacion;

/**
 *
 * @author Jessica
 */
public class FacturaXML {

    private Element root;

    private String fileLocation = "src//Archivos//Factura.xml";

    public FacturaXML() {
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

    private Element FacturaciontoXmlElement(Facturacion lib) {
        Element librotrans = new Element("Facturacion");
        Element comprador = new Element("Comprador");
        comprador.setText(lib.getComprador());
        Element cantidad = new Element("Cantidad");
        cantidad.setText(lib.getCantidadpro());
        Element autor = new Element("Nombre");
        autor.setText(lib.getNombre());
        Element pro = new Element("Proveedor");
        pro.setText(lib.getProveedor());
        Element pv = new Element("Precio");
        pv.setText(lib.getPrecio());
        Element total = new Element("Total");
        total.setText(lib.getTotal());
        Element code = new Element("Codigo");
        code.setText(lib.getCodigo());
        Element ci = new Element("Cedula");
        ci.setText(lib.getCi());
        librotrans.addContent(pv);
        librotrans.addContent(comprador);
        librotrans.addContent(pro);
        librotrans.addContent(ci);
        librotrans.addContent(autor);
        librotrans.addContent(total);
        librotrans.addContent(cantidad);
        librotrans.addContent(code);
        return librotrans;
    }

    private Facturacion FacturacionToObject(Element element) throws ParseException {
        Facturacion lib = new Facturacion(element.getChildText("Comprador"),element.getChildText("Cantidad"), element.getChildText("Nombre"),
                element.getChildText("Proveedor"), element.getChildText("Precio"), element.getChildText("Total"),
                element.getChildText("Codigo"), element.getChildText("Cedula"));
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
            if (dato.equals(e.getChild("Codigo").getText())) {
                return e;
            }
        }
        return null;
    }

    public boolean agregarLibro(Facturacion nE) {
        boolean resultado = false;
        root.addContent(FacturaciontoXmlElement((Facturacion) nE));
        resultado = updateDocument();
        return resultado;
    }

    public Facturacion buscarLibro(String dato) {
        Element aux = new Element("Facturacion");
        List inventario = this.root.getChildren("Facturacion");
        while (aux != null) {
            aux = FacturaXML.buscar(inventario, dato);
            if (aux != null) {
                try {
                    return FacturacionToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public boolean actualizarFac(Facturacion nE) {
        boolean resultado = false;
        Element aux = new Element("Facturacion");
        List Facturacion = this.root.getChildren("Facturacion");
        while (aux != null) {
            aux = FacturaXML.buscar(Facturacion, nE.getCodigo());

            if (aux != null) {
                Facturacion.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarLibro(nE);
        return resultado;
    }

    public boolean borrarLibro(String code) {
        boolean resultado = false;
        Element aux = new Element("Facturacion");
        List Facturacion = this.root.getChildren("Facturacion");
        while (aux != null) {
            aux = FacturaXML.buscar(Facturacion, (code));
            if (aux != null) {
                Facturacion.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }

    public ArrayList<Facturacion> todosLosProductos() {
        ArrayList<Facturacion> resultado = new ArrayList<Facturacion>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(FacturacionToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

}
