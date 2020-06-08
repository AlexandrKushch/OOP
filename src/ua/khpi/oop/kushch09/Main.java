package ua.khpi.oop.kushch09;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        ListLink<Human> humans = new ListLink<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        humans.add(new Human("Danya", 21, simpleDateFormat.parse("06-06-1999"), true));
        humans.add(new Human("Dasha", 20, simpleDateFormat.parse("26-10-2000"), false));
        humans.add(new Human("Misha", 39, simpleDateFormat.parse("13-03-1981"), true));
        humans.add(new Human("Sasha", 19, simpleDateFormat.parse("15-06-2001"), true));

        for (Human h : humans) {
            System.out.println(h.getName());
        }

        System.out.println("-----delete-----");
        humans.delete(3);
        for (Human h : humans) {
            System.out.println(h.getName());
        }

        Human[] humansArr = new Human[humans.size()];
        humansArr = humans.toArray(humansArr);
        System.out.println("ToArray\t" + Arrays.toString(humansArr));

        System.out.println("\nToString:\t" + humans.toString());

        try {
            humans.save();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ListLink<Human> newHumans;
        try {
            newHumans = humans.upload();
            System.out.println("------newHumans------");
            for (Human h : newHumans) {
                System.out.println(h.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        humans.clear();
    }
}
