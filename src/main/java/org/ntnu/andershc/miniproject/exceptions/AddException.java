package org.ntnu.andershc.miniproject.exceptions;
/**
 * AddException class
 * Used when trying to add a postal code that already exists in the register.
 */
public class AddException extends Exception{
    private static final long serialVersionUID = 1L;

    /**
     * @param postalCode that already exists.
     */
    public AddException(String postalCode){
        super(postalCode);
    }
}
