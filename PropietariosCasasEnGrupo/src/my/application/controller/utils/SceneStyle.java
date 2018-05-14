
package my.application.controller.utils;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.Scene;

/**
 *
 * @author Adrián Gutiérrez & Arvid Zabel
 */
public class SceneStyle {
    
    private Scene scene;
    private ArrayList<URL> stylesheets;

    public SceneStyle() { }

    public SceneStyle(Scene scene, ArrayList<URL> stylesheets) {
        this.scene = scene;
        this.stylesheets = new ArrayList<URL>();
    }
    
    public SceneStyle(Scene scene, URL stylesheet) {
        this(scene, new ArrayList<URL>(Arrays.asList(stylesheet)));
    }

    public ArrayList<URL> getStylesheets() {
        return stylesheets;
    }
    
    public void setStylesheets(ArrayList<URL> stylesheets) {
        this.stylesheets = stylesheets;
    }
    
    public void addStylesheet(URL stylesheet) {
        this.stylesheets.add(stylesheet);
    }
    
    public void stylize() {
        for (URL stylesheet : stylesheets) {
            if (stylesheet == null) {
                System.out.println("Resource not found. Aborting.");
                System.exit(-1);
            }
            String css = stylesheet.toExternalForm();
            this.scene.getStylesheets().add(css);
        }
    }

}
