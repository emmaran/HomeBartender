package org.launchcode.HomeBartender.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public class User {
    @Id
    @GeneratedValue
    private int id;

    @Size(min = 6, max = 20, message = "Password must be at least 6 characters")
    private String pwHash;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    private String email;

    private String userName;

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
        this.pwHash = getPwHash();
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
//
////    @OneToMany(mappedBy = "user")
////    private final List<Event> events = new ArrayList<>();
//
////    CONSTRUCTORS NEEDED
//}

