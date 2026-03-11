package Controllers;

import java.util.List;

import Network.User;

public class Config {
    private List<User> users;
    public List<User> getUsers() {
        return users;
    }
    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }
}
