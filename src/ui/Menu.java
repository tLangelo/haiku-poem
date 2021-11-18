package ui;
import analysis.*;
import data.*;
import java.util.Scanner;

public class Menu {

    private int lineIdx = 0;

    public void showMenu(){
        //Objects
        Scanner scan = new Scanner(System.in);
        Writer writer = new Writer();
        HaikuPoem poem = new HaikuPoem();
        StringBuilder sb = new StringBuilder();
        AnalysisEngine analysis = new AnalysisEngine();

        welcomeMessage();
        poem.setAuthor(scan.nextLine());
        System.out.println("Title: ");
        poem.setTitle(scan.nextLine());
        System.out.println("Enter poem: ");

        //Making sure only 3 lines can be made
        while (lineIdx != 3){
            analysis.setLineCount(lineIdx); // setting linecount
            String currString = scan.nextLine(); //concatenating so it wont throw exception(hopefully)
            if(analysis.isValidHaikuPoemLine(currString))
                sb.append(currString).append("\n"); //using stringbuilder to format for each line
            lineIdx++;

        }
        if(analysis.validatePoem()){ // making the poem here after its been validated
            poem.setText(sb.toString()); //making stringbuilder a string
            poem.setID(Writer.generateID());
            writer.registerPoem(poem, "poems/");//saving to poems directory
        }
        else System.out.println("Invalid poem");

    }

    private void welcomeMessage(){
        System.out.println("-HAIKU-\n\nPlease type in your name:");
    }
}
