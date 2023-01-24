package org.launchcode.HomeBartender.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Friends extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @NotNull
    private String name;

    //may add birthday info in the future
//    private int birthday;

    public Friends(int id, String name) {
        super();
        this.name = name;
//        this.birthday = birthday;
    }

    public Friends(){

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
