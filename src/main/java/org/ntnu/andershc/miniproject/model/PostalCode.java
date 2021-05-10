package org.ntnu.andershc.miniproject.model;

import java.util.Objects;

public class PostalCode {
    private String postalCode;
    private String postal;
    private String municipalCode;
    private String municipalName;
    private char category;

    public PostalCode(String postalCode, String postal, String municipalCode, String municipalName, char category) {
        if(postalCode.length() != 4){
            throw new IllegalArgumentException("Postal code must be 4 digits");
        }
        if(postal.equals("")){
            throw new IllegalArgumentException("Postal can't be empty");
        }
        if(municipalCode.length() != 4){
            throw new IllegalArgumentException("Municipal code must be 4 digits");
        }
        if(municipalName.equals("")){
            throw new IllegalArgumentException("Municipal name can't be empty");
        }
        if(!Character.isLetter(category)){
            throw new IllegalArgumentException("Category must be a letter");
        }
        this.postalCode = postalCode;
        this.postal = postal;
        this.municipalCode = municipalCode;
        this.municipalName = municipalName;
        this.category = category;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getMunicipalCode() {
        return municipalCode;
    }

    public void setMunicipalCode(String municipalCode) {
        this.municipalCode = municipalCode;
    }

    public String getMunicipalName() {
        return municipalName;
    }

    public void setMunicipalName(String municipalName) {
        this.municipalName = municipalName;
    }

    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostalCode)) return false;
        PostalCode postalCode = (PostalCode) o;
        return getPostalCode().equals(postalCode.getPostalCode());
    }

    @Override
    public String toString() {
        return "PostalCode: " +
                "postalCode:" + postalCode +
                ", postal:" + postal +
                ", municipalCode:" + municipalCode +
                ", municipalName:" + municipalName +
                ", category:" + category;
    }
}
