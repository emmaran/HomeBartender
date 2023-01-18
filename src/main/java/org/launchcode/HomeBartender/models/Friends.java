package org.launchcode.HomeBartender.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Friends {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

//    private int birthday;

    public Friends(int id, String name) {
        this.id = id;
        this.name = name;
//        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(int birthday) {
//        this.birthday = birthday;
//    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id")
//    private User user;


    @Override
    public String toString() {
        return name;
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
