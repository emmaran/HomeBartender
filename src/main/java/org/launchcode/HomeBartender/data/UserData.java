package org.launchcode.HomeBartender.data;

import org.apache.catalina.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    private String psw;
    private String pswRepeat;

    private String email;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
