package sk.mysterum.backend.services;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class TextService {
    private final String TEXT_PATH = "~/Web-Data";

    public String getTextForDay(int day){

        File file = new File(TEXT_PATH + day + ".txt");
        try {

            // Create tools for reading files
            BufferedReader read = new BufferedReader(new FileReader(file));
            StringBuilder data = new StringBuilder();
            String line = read.readLine();


            while (line != null){
                data.append(line);
                line = read.readLine();
            }
            // Return built contents of file
            return data.toString();


        } catch (IOException IOE) {

            IOE.printStackTrace();
            return "No data for day " + day + " found";

        }
    }
}
