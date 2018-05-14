
package my.application.controller;

import my.application.controller.utils.SceneController;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import my.application.controller.utils.SceneStyle;
import my.application.model.utils.ConexionMySql;

/**
 * FXML Controller class
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
public class MainSceneController implements Initializable {

    // Elementos de la Vista
    @FXML private Button v_button_verPropietarios;
    @FXML private TableView<?> v_tableView_propietarios;
    @FXML private TextField v_textField_propietarioNombre;
    @FXML private TextField v_textField_propietarioApellidos;
    @FXML private Button v_button_anadirPropietario;
    @FXML private Button v_button_verCasas;
    @FXML private TableView<?> v_tableView_casas;
    @FXML private TextField v_textField_casaDireccion;
    @FXML private TextField v_textField_casaMetros;
    @FXML private Button v_button_anadirCasa;
    
    // Elementos del Controlador
    private SceneController sceneController;
    private SceneStyle sceneStyle;
    
    public void verCasas(MouseEvent event) {
        
    }
    
    public void verPropietarios(MouseEvent event) {
        try (
            Connection con = ConexionMySql.mysql("jdbc:mysql://172.19.99.232/catastro", "root", "1q2w3e4r");
        ) {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM propietarios");
            while(res.next()){
                System.out.print(res.getInt("id_propietario") + "; ");
                System.out.print(res.getString("nombre") + "; ");
                System.out.print(res.getString("apellidos") + "; ");
                System.out.println("");
            }
            st.close();
            
            
            /*st = con.createStatement();
            
            String nombre= "'NuevaEmpresa'";
            String telefono = "'922123456'";
            
            String sql = "INSERT INTO shippers" +
                            "(" +
                            "   CompanyName, " +
                            "   Phone " + 
                            ") " +
                            "VALUES (" +
                                nombre + ", " +
                                telefono  +
                            ")" ; 

            st.executeUpdate(sql);
            st.close();*/
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void anadirCasa(MouseEvent event) {
        
    }
    
    public void anadirPropietario(MouseEvent event) {
        String nombre = v_textField_propietarioNombre.getText();
        String apellidos = v_textField_propietarioApellidos.getText();
        try (
            Connection con = ConexionMySql.mysql("jdbc:mysql://172.19.99.232/catastro", "root", "1q2w3e4r");
        ) {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("INSERT INTO propietarios (nombre, apellidos) VALUES (" + nombre + ", " + apellidos + ");");
            st.close(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void setEvents() {
        v_button_anadirPropietario.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> { anadirPropietario(event); });
        v_button_verPropietarios.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> { verPropietarios(event); });
        v_button_anadirCasa.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> { anadirCasa(event); });
        v_button_verCasas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> { verCasas(event); });
    }
    
    public void initializeWithParameters(SceneController sceneController) {
        this.sceneController = sceneController;
        Scene thisScene = this.sceneController.getSceneMap().get(SceneController.SceneName.LOGIN).getScene();
        URL stylesheet = getClass().getResource("/my/application/view/styles/MainScene.css");
        this.sceneStyle = new SceneStyle(thisScene, stylesheet);
        this.sceneStyle.stylize();
        setEvents(); 
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
