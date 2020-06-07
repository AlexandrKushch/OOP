package ua.khpi.oop.kushch10;

import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        ListLink<Human> humans = new ListLink<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        humans.add(new Human("Danya", 21, simpleDateFormat.parse("06-06-1999"), true));
        humans.add(new Human("Dasha", 20, simpleDateFormat.parse("26-10-2000"), false));
        humans.add(new Human("Misha", 39, simpleDateFormat.parse("13-03-1981"), true));
        humans.add(new Human("Sasha", 19, simpleDateFormat.parse("15-06-2001"), true));

        ConsoleUI consoleUI = new ConsoleUI();

        if (args.length > 0 && args[0].equals("-auto")) {
            consoleUI.autoMode(humans);
        } else {
            consoleUI.dialogMode(humans);
        }
    }
}
