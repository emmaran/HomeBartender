package org.launchcode.HomeBartender.data;

import org.apache.catalina.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;




public class UserData {

    private String psw;
    private String pswRepeat;

    private String email;
    private int DOB;
    private String userName;

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getPswRepeat() {
        return pswRepeat;
    }

    public void setPswRepeat(String pswRepeat) {
        this.pswRepeat = pswRepeat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDOB() {
        return DOB;
    }

    public void setDOB(int DOB) {
        this.DOB = DOB;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
//
////Maps allow for key/value pairs
//    //need a place to put users
//    private static final Map<Integer, User> users = new HashMap<>();
//
//    //get all users
//public static Collection<User> getAll() {
//    return users.values();
//}
//    //get a single user
//    public static User getById(int id) {
//        return users.get(id);
//    }
//    //add a user
//    public static void add(User user) {
//        users.put(user.get(id), user);
//    }
//    //remove a user
//    public static void remove(int id) {
//    users.remove(id);
//    }
//}
