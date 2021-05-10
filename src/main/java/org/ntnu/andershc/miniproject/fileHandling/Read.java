package org.ntnu.andershc.miniproject.fileHandling;

import org.ntnu.andershc.miniproject.exceptions.AddException;
import org.ntnu.andershc.miniproject.model.PostalCodeRegister;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
    private String path;
    private String line;

    /**
     * Constructor for reader, takes in the path of the file
     * to be read.
     * @param path
     */
    public Read(String path){
        this.path = path;
        line = "";
    }

    /**
     * Method that reads the .csv file and adds the data to the register.
     * @param register
     */
    public void readFile(PostalCodeRegister register) {
        if(!path.endsWith(".txt")) {
            throw new IllegalArgumentException("The chosen file type is not valid.");
        } else {
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(path));
                while ((line = bufferedReader.readLine()) != null) {
                    String[] values = line.split("\t");
                    try {
                        register.addPostalCode(values[0], values[1], values[2], values[3], values[4]);
                    } catch (AddException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally { //The files will close even tough an exception will be caught when reading from task files.
                try {
                    bufferedReader.close();
                } catch (IOException i) {
                    System.out.println(i.getMessage());
                }
            }
        }
    }
}