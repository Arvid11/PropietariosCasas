
package my.application.controller.utils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
public class SceneController {
    
    public enum SceneName { LOGIN, MAIN };
    
    private Stage stage;
    private HashMap<SceneName, SceneData> sceneMap = new HashMap<SceneName, SceneData>();
    private SceneData currentScene;

    public SceneController() { }

    public Stage getStage() { return stage; }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public HashMap<SceneName, SceneData> getSceneMap() {
        return sceneMap;
    }

    public void setSceneMap(HashMap<SceneName, SceneData> sceneMap) {
        this.sceneMap = sceneMap;
    }
    
    public SceneData getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(SceneData currentScene) {
        this.currentScene = currentScene;
    }
    
    public SceneData createScene(URL fxmlUrl) {
        SceneData sceneData = new SceneData();
        sceneData.setPath(fxmlUrl);
        //sceneData.setFxmlLoader(new FXMLLoader(getClass().getResource(fxmlString)));
        sceneData.setFxmlLoader(new FXMLLoader(fxmlUrl));
        try {
            sceneData.setParent(sceneData.getFxmlLoader().load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sceneData.setScene(new Scene(sceneData.getParent()));
        sceneData.setController(sceneData.getFxmlLoader().<Object>getController());
        return sceneData;
    }
    
    public SceneData loadScene(URL fxmlUrl, SceneName sceneName) {
        SceneData sceneData = createScene(fxmlUrl);
        this.sceneMap.put(sceneName, sceneData);
        return sceneData;
    }
    
    public void showScene(SceneName sceneName){
        SceneData sceneData = this.sceneMap.get(sceneName);
        this.currentScene = sceneData;
        Scene scene = this.currentScene.getScene();
        this.stage.setScene(scene);
        this.stage.show();
    }

}
