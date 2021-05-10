package org.ntnu.andershc.miniproject.fileHandling;

import org.ntnu.andershc.miniproject.model.PostalCode;
import org.ntnu.andershc.miniproject.model.PostalCodeRegister;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Write {
    /**
     * Path to write to
     */
    private final String writePath;
    /**
     * Constructor for class, sets the path
     * @param writePath Path were file is written
     */
    public Write(String writePath){
        this.writePath = writePath;
    }

    /**
     * Method for writing the register to a .txt file
     */
    public void writeRegister(PostalCodeRegister register) {
        if(!writePath.contains(".txt")){
            throw new IllegalArgumentException("Path must be to a .txt file");
        }else {
            PrintWriter printWriter = null;
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writePath, false));
                printWriter = new PrintWriter(bufferedWriter);
                for (PostalCode p : register.getAllPostalCodes().values()) {
                    String string = p.getPostalCode() + "\t" +
                            p.getPostalName() + "\t" +
                            p.getMunicipalCode() + "\t" +
                            p.getMunicipalName() + "\t" +
                            p.getCategory();
                    printWriter.println(string);
                }

            } catch (IOException i) {
                System.out.println(i.getMessage());
            } finally { //The files will close even tough an exception will be caught when writing a file.
                try {
                    printWriter.close();
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
