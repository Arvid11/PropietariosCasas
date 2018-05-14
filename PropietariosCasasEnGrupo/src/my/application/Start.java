
package my.application;

import my.application.controller.LoginSceneController;
import my.application.controller.MainSceneController;
import my.application.controller.utils.SceneController;
import my.application.controller.utils.SceneController.SceneName;
import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
public class Start extends Application {
    
    private SceneController sceneController;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // Instanciar sceneController
        this.sceneController = new SceneController();
        
        // Guardar stage en sceneController
        this.sceneController.setStage(stage);
        
        // Obtener URLs de los archivos fxml
        URL loginSceneFxmlUrl = getClass().getResource("view/LoginScene.fxml");
        URL mainSceneFxmlUrl = getClass().getResource("view/MainScene.fxml");
        
        // Crear y guardar instancias Scene en HashMap
        this.sceneController.loadScene(loginSceneFxmlUrl, SceneName.LOGIN);
        this.sceneController.loadScene(mainSceneFxmlUrl, SceneName.MAIN);
        
        // Pasar objeto sceneController a todos los controladores
        ( (LoginSceneController) this.sceneController.getSceneMap().get(SceneName.LOGIN).getController() )
                .initializeWithParameters(sceneController);
        ( (MainSceneController) this.sceneController.getSceneMap().get(SceneName.MAIN).getController() )
                .initializeWithParameters(sceneController);
        
        // Mostrar la escena de turno
        this.sceneController.showScene(SceneName.LOGIN);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
