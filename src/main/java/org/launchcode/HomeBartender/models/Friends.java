package org.launchcode.HomeBartender.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Friends extends AbstractEntity{

//    @ManyToOne(targetEntity = User.class)
    @ManyToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn(name="user_id")
    private User user;


    @NotNull
    private String username;


    //may add birthday info in the future
//    private int birthday;

    public Friends(String username, User user) {
        super();
        this.username = username;
        this.user = user;
//        this.birthday = birthday;
    }

    public Friends(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    //    public int getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(int birthday) {
//        this.birthday = birthday;
//    }


    @Override
    public String toString() {
        return username;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
