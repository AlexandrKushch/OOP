package ua.khpi.oop.kushch13;

import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println(Thread.currentThread().getName() + ": Started");
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter timeout(ms): ");
        int timeout = scan.nextInt();

        ListLink<Human> humans = new ListLink<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        humans.add(new Human("Danya", 21, simpleDateFormat.parse("06-06-1999"), true));
        humans.add(new Human("Dasha", 20, simpleDateFormat.parse("26-10-2000"), false));
        humans.add(new Human("Misha", 39, simpleDateFormat.parse("13-03-1981"), true));
        humans.add(new Human("Sasha", 19, simpleDateFormat.parse("15-06-2001"), true));
        humans.add(new Human("Masha", 31, simpleDateFormat.parse("19-09-1989"), false));
        humans.add(new Human("Dima", 13, simpleDateFormat.parse("01-07-2007"), true));
        humans.add(new Human("Eduard", 49, simpleDateFormat.parse("01-10-1971"), true));
        humans.add(new Human("Christopher", 18, simpleDateFormat.parse("10-10-2002"), false));

        FindOlder findOlder = new FindOlder(humans);
        findOlder.start();

        CountRegSearch countRegSearch = new CountRegSearch(humans);
        countRegSearch.start();

        SelectGender selectGender = new SelectGender(humans);
        selectGender.start();

        try{
            Thread.sleep(timeout);
            findOlder.stop();
            countRegSearch.stop();
            selectGender.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": Ended");
    }
}
