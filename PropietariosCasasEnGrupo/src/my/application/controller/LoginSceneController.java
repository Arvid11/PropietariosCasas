
package my.application.controller;

import my.application.controller.utils.SceneController;
import my.application.controller.utils.SceneController.SceneName;
import my.application.controller.utils.SceneStyle;
import my.application.model.utils.ConexionMySql;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
public class LoginSceneController implements Initializable {
    
    // Elementos de la Vista
    @FXML private Button v_button_acceder;
    @FXML private TextField v_textField_usuario;
    @FXML private TextField v_textField_contrasena;
    @FXML private TextField v_textField_urlBbdd;
    
    // Elementos del Controlador
    private SceneController sceneController;
    private SceneStyle sceneStyle;
    
    public void conectarBbddMySql(MouseEvent event, String urlBbdd, String usuario, String contrasena) {
        
        ConexionMySql.cargarDriverMysql();
        
        try (
            Connection con = ConexionMySql.mysql(urlBbdd, usuario, contrasena);
        ) {
            Scene scene = this.sceneController.getSceneMap().get(SceneName.MAIN).getScene();
            this.sceneController.getStage().setScene(scene);
        }catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No se ha podido establecer la conexion");
            ex.printStackTrace();    
        }
        //https://stackoverflow.com/questions/12804664/how-to-swap-screens-in-a-javafx-application-in-the-controller-class
        //Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        /*Scene scene = this.sceneController.getSceneMap().get(SceneName.MAIN).getScene();
        this.sceneController.getStage().setScene(scene);*/

        //https://stackoverflow.com/questions/12804664/how-to-swap-screens-in-a-javafx-application-in-the-controller-class
        //Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        /*Scene scene = this.sceneController.getSceneMap().get(SceneName.MAIN).getScene();
        this.sceneController.getStage().setScene(scene);*/
    }
    
    public void loginEvent(MouseEvent event) {
        String urlBbdd = v_textField_urlBbdd.getText();
        String usuario = v_textField_usuario.getText();
        String contrasena = v_textField_contrasena.getText();
        conectarBbddMySql(event, urlBbdd, usuario, contrasena);
    }
    
    public void setEvents() {
        v_button_acceder.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> { loginEvent(event); });
    }
    
    public void initializeWithParameters(SceneController sceneController) {
        this.sceneController = sceneController;
        Scene thisScene = this.sceneController.getSceneMap().get(SceneName.LOGIN).getScene();
        URL stylesheet = getClass().getResource("/my/application/view/styles/LoginScene.css");
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
    public void initialize(URL url, ResourceBundle rb) { }
    
}
