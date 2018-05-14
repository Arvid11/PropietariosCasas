
package my.application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
@XmlRootElement(name = "owner")
public class Propietario implements Serializable {

    int id;
    String nombre;
    String apellidos;
    GregorianCalendar nacimiento;
    private ArrayList<Casa> casas;

    /**
     * Constructor por defecto
     * Es necesario para poder usar la librería de XML
     */
    public Propietario() {}

    /**
     * Constructor con parametros
     * @param id
     * @param nombre
     * @param apellidos
     * @param nacimiento 
     * @param casas 
     */
    public Propietario(int id, String nombre, String apellidos, GregorianCalendar nacimiento, ArrayList<Casa> casas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.casas = casas;
    }

    /**
     * Constructor con parametros
     * @param id
     * @param nombre
     * @param apellidos 
     */
    public Propietario(int id, String nombre, String apellidos) {
        this(id, nombre, apellidos, new GregorianCalendar(), new ArrayList<Casa>());
    }

    /**
     * Getter del atributo dni
     * Incluye anotaciones para usar la librería de XML
     * @return 
     */
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }
    
    /**
     * Setter del atributo dni
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter del atributo nombre
     * Incluye anotaciones para usar la librería de XML
     * @return 
     */
    @XmlElement(name = "name")
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Setter del atributo nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Getter del atributo apellidos
     * Incluye anotaciones para usar la librería de XML
     * @return 
     */
    @XmlElement(name = "surname")
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Setter del atributo apellidos
     * @param apellidos 
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /**
     * Getter del atributo nacimiento
     * Incluye anotaciones para usar la librería de XML
     * @return 
     */
    @XmlTransient
    public GregorianCalendar getNacimiento() {
        return nacimiento;
    }

    /**
     * Setter del atributo nacimiento
     * @param nacimiento 
     */
    public void setNacimiento(GregorianCalendar nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    /**
     * Getter del atributo casas
     * Incluye anotaciones para usar la librería de XML
     * Para usar la librería de XML con ArrayLists es necesario un getter
     * @return 
     */
    @XmlElementWrapper(name="homes")
    @XmlElement(name="home")
    public ArrayList<Casa> getCasas() {
        return casas;
    }

    /**
     * Setter del atributo casas
     * @param casas 
     */
    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }
    
    /**
     * Metodo para agregar un objeto Casa al atributo casas
     * @param casa 
     */
    public void addCasa(Casa casa) {
        this.casas.add(casa);
    }

    /**
     * Sobreescritura del metodo toString
     * @return 
     */
//    @Override
//    public String toString() {
//        return "Propietario{" + "dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nacimiento=" + nacimiento + ", casas=" + casas + '}';
//    }
       
}
