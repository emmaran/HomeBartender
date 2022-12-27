package org.launchcode.HomeBartender.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class user {
    @Id
    @GeneratedValue
private int id;

private String password;

private String email;

private int DOB;

private String userName;



}
