package ua.khpi.oop.kushch11;

import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        ListLink<Human> humans = new ListLink<>();

        ConsoleUI consoleUI = new ConsoleUI(humans);

        if (args.length > 0 && args[0].equals("-auto")) {
            consoleUI.autoMode();
        } else {
            consoleUI.dialogMode();
        }
    }
}
