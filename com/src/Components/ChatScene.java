package Components;
import java.util.HashMap;
import java.util.function.Consumer;

import Controllers.Scenes.ChatSceneController;
import javafx.scene.*;

//Note, may transition from fxml to programmatic scene creation

public class ChatScene extends Scene {
    //use the id of the component that triggers the transition as the key for the transition map
    public HashMap<String, ChatScene> transitionMap = new HashMap<String, ChatScene>();
    public ChatSceneController controller;
    private Consumer<String> onTransition;
    Parent root = null;

    public ChatScene(Parent root) {
        super(root);
    }
    public ChatScene(Parent root, double width, double height) {
        super(root, width, height);
    }
    public void addTransition(String name, ChatScene s) {
        transitionMap.put(name, s);
    }

    public void setOnTransition(Consumer<String> r) {
        onTransition = r;
    }

    public void transition(String name) {
        onTransition.accept(name);
    }
}
