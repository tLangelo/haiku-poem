package data;

import analysis.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class Writer { //class to write to the file
    // Making UUID to every file
    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public void registerPoem(HaikuPoem poem, String path){
        String fileName = path + poem.getAuthor() + "-" + poem.getTitle() + ".txt"; // How the file should be saved
        File newFile = new File(fileName);
        try {
            FileWriter fr = new FileWriter(newFile);
            System.out.println("Writing Haiku poem with ID: " + poem.getID());
            fr.write(poem.getText());
            fr.close();
        } catch (IOException e) {
            System.out.println("Failed to create FileWriter");
            e.printStackTrace();
        }

    }


}
