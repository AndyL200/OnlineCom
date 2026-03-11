package Network;

import java.io.Serializable;
import java.util.List;

import Controllers.Settings;
import Controllers.Config;
import Components.Message;

//cache the most necessary info for the server, (users, recent messages, and the chatlog)
public class ServerCache implements Serializable{
    private String SERVER_NAME;
    private List<User> users;
    private List<Message> recentMessages;
    private List<Message> chatlog;
    private Settings settings;
    private Config config;

    public List<User> getUsers() {
        return users;
    }
    public List<Message> getRecentMessages() {
        return recentMessages;
    }

    public List<Message> getChatlog() {
        return chatlog;
    }

    public String getServerName() {
        return SERVER_NAME;
    }

    ServerCache(String name, List<User> users, List<Message> recents, List<Message> chatlog) {

    }

}
