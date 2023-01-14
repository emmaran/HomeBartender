package org.launchcode.HomeBartender.data;

import org.apache.catalina.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

//Maps allow for key/value pairs
    //need a place to put users
    private static final Map<Integer, User> users = new HashMap<>();

    //get all users
public static Collection<User> getAll() {
    return users.values();
}
    //get a single user
    public static User getById(int id) {
        return users.get(id);
    }
    //add a user
    public static void add(User user) {
        users.put(user.get(id), user);
    }
    //remove a user
    public static void remove(int id) {
    users.remove(id);
    }
}
