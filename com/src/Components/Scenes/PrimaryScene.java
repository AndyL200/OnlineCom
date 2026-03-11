package Components.Scenes;

import java.io.IOException;

import Components.ChatScene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

public class PrimaryScene extends ChatScene {
    private Parent root;
    public PrimaryScene(double width, double height) throws IOException {
        Parent root = FXMLLoader.load(PrimaryScene.class.getResource("/Views/oc.fxml"));
        super(root, width, height);
        this.root = root;
    }


}
