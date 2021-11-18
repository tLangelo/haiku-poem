package analysis;

import java.util.Arrays;

public class AnalysisEngine {
    private final Character[] vowels = {'a','e','i','o','u','y'};
    private final int[] syllableCounter = {0,0,0};
    private int lineCount = 0;

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }
    //checking for the correct amount of syllables per line
    public boolean isValidHaikuPoemLine(String lineToCheck) {
        if (lineCount == 0 || lineCount == 2) { // for 1st and 3rd line
            checkForVowels(lineToCheck);
            return syllableCounter[lineCount] == 5;
        }
        else{
            checkForVowels(lineToCheck);
            return syllableCounter[lineCount] == 7; //for 2nd line
        }
    }

    private void checkForVowels(String lineToCheck){
        for (int i = 0; i < lineToCheck.length(); i++) {
            char currChar = lineToCheck.toLowerCase().toCharArray()[i]; //making chars to lowercase to match vowels[]
            if (Arrays.asList(vowels).contains(currChar)) {//using asList to check if any of the idx on vowels[] matches currChar
                syllableCounter[lineCount]++;
                try {// making try/catch to avoid OutOfBounds if the last letter on a line is a vowel
                    char nextChar = lineToCheck.charAt(i + 1);
                    if (nextChar == currChar || Arrays.asList(vowels).contains(nextChar)) {
                        i++; // skipping next iteration if true
                    }
                } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException ignored) {
                }//ignoring since we dont want anything to happen
            }
        }
    }


    public boolean validatePoem(){ //checking if the poem is valid
        return syllableCounter[0] == 5 && syllableCounter[1] == 7 && syllableCounter[2] == 5;
    }
}
