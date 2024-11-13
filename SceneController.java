package application;


import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SceneController extends AnchorPane{
    private HashMap<String, Pane> sceneMap = new HashMap<>();
    private Scene main;

    public SceneController(Scene main) {
        this.main = main;
    }

    protected void addScene(String name, Pane pane){
         sceneMap.put(name, pane);
    }

    protected void removeScene(String name){
        sceneMap.remove(name);
    }

    protected void activate(String name){
        main.setRoot(sceneMap.get(name));
    }
}
