package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneController {
    @FXML private VBox messagesBox;
    @FXML private TextField messageField;

    @FXML
    public void onSendMessage(ActionEvent e) {
        String txt = messageField.getText().trim();
        if (txt.isEmpty()) return;
        messagesBox.getChildren().add(new Label(txt));
        messageField.clear();
    }

    @FXML
    public void onHome() {

    }
    @FXML 
    public void onMessages() {

    }
    @FXML
    public void onSettings() {
        
    }
    @FXML
    public void onProfile() {
        
    }
    @FXML
    public void onLogout() {
        
    }

}
