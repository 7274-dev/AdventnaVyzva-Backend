package sk.mysterum.backend.services;

import sk.mysterum.backend.exception.FileDoesntExistException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadPassword {

    public String getPassword(String locationToFile) throws FileDoesntExistException {

        File passwordFile = new File(locationToFile);
        try {
            Scanner pswrdData = new Scanner(passwordFile);
            return pswrdData.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileDoesntExistException();
        }

    }
    
}
