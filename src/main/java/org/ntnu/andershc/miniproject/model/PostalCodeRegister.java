package org.ntnu.andershc.miniproject.model;

import org.ntnu.andershc.miniproject.exceptions.AddException;

import java.util.HashMap;

/**
 * Postal code register that handles the postal codes in the register.
 */
public class PostalCodeRegister {
    private HashMap<String, PostalCode> postalCodes;

    public PostalCodeRegister() {
        postalCodes = new HashMap<>();
    }

    /**
     * Method for adding a postal code to the register
     * @throws AddException if the postal code already exists in the register
     */
    public void addPostalCode(String postalCode, String postalName,
                           String municipalCode, String municipalName,
                           String category) throws AddException {
        try{
            PostalCode newPostalCode = new PostalCode(postalCode, postalName, municipalCode, municipalName, category.charAt(0));
            if(!postalCodes.containsKey(postalCode)){
                postalCodes.put(postalCode, newPostalCode);
            }
            else{
                throw new AddException(postalCode + " is already registered.");
            }
        } catch(IllegalArgumentException | NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method that returns all postal codes in the register.
     */
    public HashMap<String, PostalCode> getAllPostalCodes(){
        HashMap<String, PostalCode> allPostalCodes = new HashMap<>();
        for(PostalCode postalCode: postalCodes.values()){
            allPostalCodes.put(postalCode.getPostalCode(), postalCode);
        }
        return allPostalCodes;
    }
}
