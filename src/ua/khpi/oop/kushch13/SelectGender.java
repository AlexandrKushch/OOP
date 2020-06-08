package ua.khpi.oop.kushch13;

import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;

import java.util.Scanner;

public class SelectGender extends Thread {
    private ListLink<Human> humans;

    public SelectGender(ListLink<Human> humans) {
        this.humans = humans;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Started");

        System.out.println("List of males: ");
        for (Human h : humans) {
            if (h.isGender()) {
                System.out.println(Thread.currentThread().getName() + "\t\t" + h.toString());
            }
        }

        System.out.println(Thread.currentThread().getName() + ": Ended");
    }
}
