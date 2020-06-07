package ua.khpi.oop.kushch09;

import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ListLink<Human> humans = new ListLink<>();

        humans.add(new Human("Danya", 21, new Date("1999-06-06"), true));
        humans.add(new Human("Dasha", 20, new Date("2000-10-26"), false));
        humans.add(new Human("Misha", 39, new Date("1981-03-13"), true));
        humans.add(new Human("Sasha", 19, new Date("2001-06-15"), true));

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
