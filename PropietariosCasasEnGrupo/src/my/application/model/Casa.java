
package my.application.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
@XmlRootElement(name="home")
public class Casa implements Serializable {
    
    private String direccion;
    private double metros;
    private transient ArrayList<Propietario> propietarios = new ArrayList<Propietario>();

    /**
     * Constructor por defecto
     * Es necesario para poder usar la librería de XML
     */
    public Casa() {}

    /**
     * Constructor con parametros
     * @param direccion
     * @param metros 
     */
    public Casa(String direccion, double metros) {
        this.direccion = direccion;
        this.metros = metros;
    }

    /**
     * Getter del atributo direccion
     * Incluye anotaciones para usar la librería de XML
     * @return 
     */
    @XmlElement(name="address")
    public String getDireccion() {
        return direccion;
    }

    /**
     * Setter del atributo direccion
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Getter del atributo metros
     * Incluye anotaciones para usar la librería de XML
     * @return 
     */
    @XmlElement(name="meters")
    public double getMetros() {
        return metros;
    }

    /**
     * Setter del atributo metros
     * @param metros 
     */
    public void setMetros(double metros) {
        this.metros = metros;
    }

    /**
     * Getter del atributo propietarios
     * Incluye anotaciones para usar la librería de XML
     * Para usar la librería de XML con ArrayLists es necesario un getter
     * @return 
     */
    @XmlTransient
    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    /**
     * Setter del atributo propietarios
     * @param propietarios 
     */
    public void setPropietarios(ArrayList<Propietario> propietarios) {
        this.propietarios = propietarios;
    }
    
    /**
     * Metodo para agregar un objeto Propietario al atributo propietarios
     * @param propietario 
     */
    public void addPropietario(Propietario propietario) {
        this.propietarios.add(propietario);
    }

    /**
     * Sobreescritura del metodo toString
     * @return 
     */
//    @Override
//    public String toString() {
//        return "Casa{" + "direccion=" + direccion + ", metros=" + metros + ", propietarios=" + propietarios + '}';
//    }
    
}
