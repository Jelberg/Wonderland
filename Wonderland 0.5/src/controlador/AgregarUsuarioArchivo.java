/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;
import modelo.Usuario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author essteeli
 */
public class AgregarUsuarioArchivo {
    private Element root;
 
    private String fileLocation = "src//Archivos//Usuarios.xml";
   
    public AgregarUsuarioArchivo() {
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
        Element nombre = new Element("Nombre");
        nombre.setText(usuarioNuevo.getNombre());
        Element apellido = new Element("Apellido");
        apellido.setText(usuarioNuevo.getApellido());
        Element cedula = new Element("Cedula");
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
        Element NumTarjCredito = new Element("NumTarjCredito");
        NumTarjCredito.setText(usuarioNuevo.getNumTarjCredito());
        Element MarcaComercial = new Element("MarcaComercial");
        MarcaComercial.setText(usuarioNuevo.getMarcaComercial());
        Element FecVencimiento = new Element("FecVencimiento");
        FecVencimiento.setText(usuarioNuevo.getFecVencimiento());
        Element Codigo = new Element("Codigo");
        Codigo.setText(usuarioNuevo.getCodigo());
        Element direcFoto = new Element("direccionFoto");
        direcFoto.setText(usuarioNuevo.getDireccionFoto());
        
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
        UsuarioAux.addContent(NumTarjCredito);
        UsuarioAux.addContent(MarcaComercial);
        UsuarioAux.addContent(FecVencimiento);
        UsuarioAux.addContent(Codigo);
        UsuarioAux.addContent(direcFoto);
        return UsuarioAux;
    }


    private Usuario UsuarioToObject(Element element) throws ParseException {
        Usuario usuarioNuevo = new Usuario ( element.getChildText("nombre"),element.getChildText("apellido"),element.getChildText("cedula"),
                                             element.getChildText("email"),element.getChildText("direccion"),element.getChildText("clave"),
                                             element.getChildText("seudonimo"),element.getChildText("freg"),element.getChildText("fnac"),
                                             element.getChildText("rol") ,element.getChildText("NumTarjCredito"),element.getChildText("MarcaComercial"),
                                             element.getChildText("FecVencimiento"),element.getChildText("codigo"),element.getChildText("direccionFoto"));
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
            if (dato.equals(e.getChild("cedula").getText())) {
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

 
 
    public Usuario buscarPersona(String cedula) {
        Element aux = new Element("Usuario");
        List usuarios = this.root.getChildren("Usuario");
        while (aux != null) {
            aux = AgregarUsuarioArchivo.buscar(usuarios,(cedula));
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
            aux = AgregarUsuarioArchivo.buscar(Usuario, fileLocation);
            if (aux != null) {
                Usuario.remove(aux);
                resultado = updateDocument();
            }
        }
        agregarUsuario(nE);
        return resultado;
    }

    public boolean borrarPersona(Integer cedula) {
        boolean resultado = false;
        Element aux = new Element("Usuario");
        List Usuario = this.root.getChildren("Usuario");
        while (aux != null) {
            aux = AgregarUsuarioArchivo.buscar(Usuario, Integer.toString(cedula));
            if (aux != null) {
                Usuario.remove(aux);
                resultado = updateDocument();
            }
        }
        return resultado;
    }
 public String Fecha(String total){
         String day,month,year,total1;
         
         //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
          mes=mes+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        day = String.valueOf(dia);
        month = String.valueOf(mes);
        year = String.valueOf(año);
        
        total=day+"/"+month+"/"+year;
        
       
        /*System.out.println("Fecha Actual: "
                           + dia + "/" + (mes+1) + "/" + año);*/
        
        return total;
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






    
   