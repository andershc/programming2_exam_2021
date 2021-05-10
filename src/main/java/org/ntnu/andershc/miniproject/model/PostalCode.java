package org.ntnu.andershc.miniproject.model;

/**
 * PostalCode class stores information about a postal code
 */
public class PostalCode {
    private String postalCode;
    private String postalName;
    private String municipalCode;
    private String municipalName;
    private char category;

    /**
     * Constructor for the postal code.
     * Throws IllegalArgumentException if the postal code or municipal code isn't 4 digits.
     * Throws IllegalArgumentException if the postal name or municipal name is empty.
     * Throws IllegalArgumentException if the category isn't a letter.
     * @param postalCode
     * @param postalName
     * @param municipalCode
     * @param municipalName
     * @param category
     */
    public PostalCode(String postalCode, String postalName, String municipalCode, String municipalName, char category) {
        if(postalCode.length() != 4){
            throw new IllegalArgumentException("Postal code must be 4 digits");
        }
        if(postalName.equals("")){
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
        this.postalName = postalName;
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

    public String getPostalName() {
        return postalName;
    }

    public void setPostalName(String postalName) {
        this.postalName = postalName;
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
                ", postal:" + postalName +
                ", municipalCode:" + municipalCode +
                ", municipalName:" + municipalName +
                ", category:" + category;
    }
}
