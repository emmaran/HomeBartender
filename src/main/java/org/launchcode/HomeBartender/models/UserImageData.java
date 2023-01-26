package org.launchcode.HomeBartender.models;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
@Builder
public class UserImageData extends AbstractEntity {

    private String name;

    private String type;

    @Lob
    @Column(name="imageData")
    private byte[] imageData;

    @OneToOne(mappedBy = "image")
    private UserRecipe recipe;

    public UserImageData() {
    }

    public UserImageData(String name, String type, byte[] imageData, UserRecipe recipe) {
        this.name = name;
        this.type = type;
        this.imageData = imageData;
//        this.recipe = recipe;
    }

    public UserImageData(String name, String type, byte[] imageData) {
        this.name = name;
        this.type = type;
        this.imageData = imageData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

//    public UserRecipe getRecipe() {
//        return recipe;
//    }
//
//    public void setRecipe(UserRecipe recipe) {
//        this.recipe = recipe;
//    }
}
