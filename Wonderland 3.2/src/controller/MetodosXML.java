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
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Jessica
 */
public class MetodosXML {

    private Element root;

    private String fileLocation = "src//Archivos//MetodosDePago.xml";

    public MetodosXML() {
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

    private Element MetodostoXmlElement(Usuario metodoNuevo) {

        Element UsuarioAux = new Element("Metodo");
        Element numero = new Element("numTarj");
        numero.setText(metodoNuevo.getNumTarjCredito());
        Element marca = new Element("marcaComecial");
        marca.setText(metodoNuevo.getMarcaComercial());
        Element fecha = new Element("fecVencimiento");
        fecha.setText(metodoNuevo.getFecVencimiento());
        Element codigo = new Element("codigo");
        codigo.setText(metodoNuevo.getCodigo());
        Element seudonimo = new Element("seudonimo");
        seudonimo.setText(metodoNuevo.getSeudonimo());

        UsuarioAux.addContent(numero);
        UsuarioAux.addContent(marca);
        UsuarioAux.addContent(fecha);
        UsuarioAux.addContent(codigo);
        UsuarioAux.addContent(seudonimo);

        return UsuarioAux;
    }

    private Usuario MetodosToObject(Element element) throws ParseException {
        Usuario usuarioNuevo = new Usuario("", "", "", "", "", "", element.getChildText("seudonimo"), "", "","",
                element.getChildText("numTarj"),
                element.getChildText("marcaComecial"),
                element.getChildText("fecVencimiento"),
                element.getChildText("codigo"));
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

    public boolean agregarUsuario(Usuario usuarioNuevo) {
        boolean resultado = false;
        root.addContent(MetodostoXmlElement((Usuario) usuarioNuevo));
        resultado = updateDocument();
        return resultado;
    }

    public Usuario buscarPersona(String seudonimo) {
        Element aux = new Element("Metodos");
        List usuarios = this.root.getChildren("Metodos");
        while (aux != null) {
            aux = MetodosXML.buscar(usuarios, (seudonimo));
            if (aux != null) {
                try {
                    return MetodosToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public boolean actualizarMetodos(Usuario nE) {
        boolean resultado = false;
        Element aux = new Element("Metodos");
        List Usuario = this.root.getChildren("Metodos");
        while (aux != null) {
            aux = MetodosXML.buscar(Usuario, nE.getSeudonimo());
            int prueba;
            prueba = 1;
            if (prueba == 1) {
                Usuario.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarUsuario(nE);
        return resultado;
    }

    public boolean borrarPersona(String cedula) {
        boolean resultado = false;
        Element aux = new Element("Metodos");
        List Usuario = this.root.getChildren("Metodos");
        while (aux != null) {
            aux = MetodosXML.buscar(Usuario, cedula);
            if (aux != null) {
                Usuario.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }

    public ArrayList<Usuario> todosLosMetodos() {
        ArrayList<Usuario> resultado = new ArrayList<Usuario>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                resultado.add(MetodosToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }
}
