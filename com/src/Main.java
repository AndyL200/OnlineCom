import java.io.IOException;
import java.util.*;

import Controllers.SceneController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("OnlineCom");
        Scene fxscene = null;
        //load resources
        try {
            HBox hbox = FXMLLoader.load(getClass().getResource("/Views/oc.fxml"));
            fxscene = new Scene(hbox, 800, 600);
            //stage.getIcons().add(new Image("../assets/icon.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        stage.setScene(fxscene);
        stage.show();
    }
}