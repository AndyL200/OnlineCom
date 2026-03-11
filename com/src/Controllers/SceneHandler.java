package Controllers;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

import Components.ChatScene;
import Network.ServerCache;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneHandler {
    public boolean active = false;
    public ChatScene current_scene = null;
    public Stage stage = null;
    List<ServerCache> servers = new ArrayList<ServerCache>(0);


    public SceneHandler(Stage stage, ChatScene scene) {
        this.stage = stage; current_scene = scene; active = true; this.stage.setScene(scene); current_scene.setOnTransition(this::TransitionScene);
        for(ServerCache s : servers) {
            if(s.getServerName() == scene.controller.chat.chatlogName) {
                //load chatlog with recents
                //Chat is a central component of a ChatScene, the chatlog is the message history of an ongoing chat
                //The look and feel of the chatlog is determined by Settings and Config which need to be passed to the ChatComponent
                scene.controller.chat.fillChat(s.getRecentMessages());
            }
        }
    }
    public SceneHandler(Stage stage, Scene scene) {
        this.stage = stage; active = true; this.stage.setScene(scene);
    }

    private void TransitionScene(String transition) {
        if(current_scene.transitionMap.containsKey(transition)) {
            stage.setScene(current_scene.transitionMap.get(transition));
        }
    }

}
