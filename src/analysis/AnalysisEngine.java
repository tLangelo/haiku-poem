package analysis;

import java.util.Arrays;

public class AnalysisEngine {
    private final Character[] vowels = {'a','e','i','o','u','y'};
    private final int[] syllableCounter = {0,0,0};
    private int lineCount = 0;

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public boolean isValidHaikuPoemLine(String lineToCheck) {
        if (lineCount == 0 || lineCount == 2) {
            checkForVowels(lineToCheck);
            return syllableCounter[lineCount] == 5;
        }
        else{
            checkForVowels(lineToCheck);
            return syllableCounter[lineCount] == 7;
        }
    }

    private void checkForVowels(String lineToCheck) {
        for (int i = 0; i < lineToCheck.length(); i++) {
            char currChar = lineToCheck.toLowerCase().toCharArray()[i];
            if (Arrays.asList(vowels).contains(currChar)) {
                try {
                    char nextChar = lineToCheck.charAt(i + 1);
                    syllableCounter[lineCount]++;
                    if (nextChar == currChar) {
                        i++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("EOL");
                }
            }
        }
    }

    public boolean validatePoem(){
        return syllableCounter[0] == 5 && syllableCounter[1] == 7 && syllableCounter[2] == 5;
    }
}
