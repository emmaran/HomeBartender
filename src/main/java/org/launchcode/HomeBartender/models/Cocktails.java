package org.launchcode.HomeBartender.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

//this  lets you pass over any value from the json data that is not you don't want to include
@JsonIgnoreProperties(ignoreUnknown = true)
//this allows you to ignore all values that are null
@JsonInclude(JsonInclude.Include.NON_NULL)

@Entity
public class Cocktails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cocktails_id")
    private int id;

    @Column(name ="drink", unique = true)
    private String strDrink;

//    @OneToOne(mappedBy = "cocktails", fetch = FetchType.LAZY)
//    private Recipes recipes;

    public Cocktails() {
    }

    public Cocktails(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }
}
