import analysis.HaikuPoem;
import data.Writer;
import ui.Menu;

import java.util.Scanner;


class Application{
    public void runApplication(){
        Menu haikuMenu = new Menu();

        haikuMenu.showMenu();

    }

}



public class Main {
    public static void main(String[] args) {
        new Application().runApplication();

    }
}
