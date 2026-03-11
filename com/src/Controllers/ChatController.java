package Controllers;

import java.util.List;

import Components.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class ChatController {
    @FXML private VBox messagesBox;
    @FXML private TextField messageField;
    public String chatlogName;
    private Settings settings;
    private Config config;

    @FXML
    public void sendMessage(ActionEvent e) {
        String txt = messageField.getText().trim();
        if (txt.isEmpty()) return;
        messagesBox.getChildren().add(new Label(txt));
        messageField.clear();
    }

    ChatController() {
        //initialize chatlog
        messageField.onKeyPressedProperty().addListener((obs, old, new_val) -> typing(obs, old, new_val));
    }

    private void typing() {
        if (old.trim().isEmpty()) {
            // disable send button
            return;
        }
        if(msgStrOld + new_val != msgStrOld) {
            //send typing signal
        }
        msgStrOld += new_val;

        
        
        if(new_val.getCode() == KeyCode.ENTER) {
            sendMessage(null);
        }

        fireTypingSignal();
        
    }

    private void fireTypingSignal() {
        //send typing signal to server
        
    }
    public void fillChat(List<Message> data) {
        //parse data and fill messagesBox
        for(Message m : data) {
            messagesBox.getChildren().add(new Label(m.sender + ": " + new String(m.messageData)));
        }
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
    
}
