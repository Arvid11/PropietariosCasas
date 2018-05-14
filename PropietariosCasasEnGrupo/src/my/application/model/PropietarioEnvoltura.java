
package my.application.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
@XmlRootElement(name="propietarios")
public class PropietarioEnvoltura {
    
    public ArrayList<Propietario> conjunto;

    /**
     * Constructor por defecto
     * Es necesario para poder usar la librería de XML
     */
    public PropietarioEnvoltura() { }

    /**
     * Getter del atributo conjunto
     * @return 
     */
    @XmlElementWrapper(name="owners")
    @XmlElement(name="owner")
    public ArrayList<Propietario> getConjunto() {
        return conjunto;
    }

    /**
     * Setter del atributo conjunto
     * @param conjunto 
     */
    public void setConjunto(ArrayList<Propietario> conjunto) {
        this.conjunto = conjunto;
    }

}
