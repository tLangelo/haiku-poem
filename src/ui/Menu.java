package ui;
import analysis.AnalysisEngine;
import analysis.HaikuPoem;
import data.Writer;
import java.util.Scanner;

public class Menu {

    private int lineIdx = 0;

    public void showMenu(){
        Scanner scan = new Scanner(System.in);
        Writer rite = new Writer();
        HaikuPoem poem = new HaikuPoem();
        StringBuilder sb = new StringBuilder();
        AnalysisEngine analysis = new AnalysisEngine();

        welcomeMessage();
        poem.setAuthor(scan.nextLine());
        System.out.println("Title: ");
        poem.setTitle(scan.nextLine());
        System.out.println("Enter poem: ");


        while (lineIdx != 3){
            analysis.setLineCount(lineIdx);
            String currString = scan.nextLine();
            if(analysis.isValidHaikuPoemLine(currString))
                sb.append(currString).append("\n");
            lineIdx++;

        }
        if(analysis.validatePoem()){
            poem.setText(sb.toString());
            poem.setID(Writer.generateID());
            rite.registerPoem(poem, "poems\\");
        }
        else System.out.println("Invalid poem");

    }

    private void welcomeMessage(){
        System.out.println("-HAIKU-\n\nPlease type in your name:");
    }
}
