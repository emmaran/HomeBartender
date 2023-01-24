package org.launchcode.HomeBartender.models;

import org.launchcode.HomeBartender.controllers.AuthenticationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity

public class User {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 6, max = 20, message = "Password must be at least 6 characters")
    private String pwHash;

//    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String email;

    private String userName;

    @OneToMany(mappedBy = "author")
    private List<UserRecipe> recipes = new ArrayList<>();

    public User() {
    }

    public User(String username, String pwHash) {
        this.userName=username;
        this.pwHash=pwHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
//            this.pwHash = encoder.encode(pwHash);
        }
//        public boolean isMatchingPassword(String password) {
//            return encoder.matches(password, pwHash);
//        }

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

    public List<UserRecipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<UserRecipe> recipes) {
        this.recipes = recipes;
    }

//    not sure how to make this work.......
//    public User(String username, String password) {
//        this.username = username;
//        this.pwHash = encoder.encode(password);
//    }
//
//    public boolean isMatchingPassword(String password) {
//        return encoder.matches(password, pwHash);
//    }


//Got this from the text-Authentication

//
//    // gets the hash value stored on their object
//    String passwordHash = user.getPwHash();
//
//    // hashes the submitted password
//    String submittedpwHash = h(submittedPsw);
//
//if (pwHash.equals(submittedpwHash)) {
//        // the hashes are the same, the passwords can be assumed to be the same
//    } else {
//        // the hashes are different, so the passwords are definitely different
//    }

//    Can't get encoder to not be red
//    public boolean isMatchingPassword(String password) {
//        return encoder.matches(password, pwHash);
//    }
//    DOn't know if I need. GOt this from Chapter 19
//    public User(String username, String password) {
//        this.userName = username;
//        this.pwHash = encoder.encode(password);
    }



////    @OneToMany(mappedBy = "user")
////    private final List<Event> events = new ArrayList<>();
//
////    CONSTRUCTORS NEEDED
//}

