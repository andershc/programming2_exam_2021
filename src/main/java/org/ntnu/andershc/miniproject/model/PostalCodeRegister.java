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
     * @param postalCode
     * @param postalName
     * @param municipalCode
     * @param municipalName
     * @param category
     * @throws AddException if the postal code already exists in the register
     */
    public void addPostalCode(String postalCode, String postalName,
                           String municipalCode, String municipalName,
                           String category) throws AddException {
        if(!postalCodes.containsKey(postalCode)){
            postalCodes.put(postalCode,
                    new PostalCode(postalCode, postalName, municipalCode, municipalName, category.charAt(0)));
        }
        else{
            throw new AddException(postalCode + " is already registered.");
        }
    }

    /**
     * Method that returns all postal codes in the register.
     * @return
     */
    public HashMap<String, PostalCode> getAllPostalCodes(){
        HashMap<String, PostalCode> allPostalCodes = new HashMap<>();
        for(PostalCode postalCode: postalCodes.values()){
            allPostalCodes.put(postalCode.getPostalCode(), postalCode);
        }
        return allPostalCodes;
    }
}
