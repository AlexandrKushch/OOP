package ua.khpi.oop.kushch13;

import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;

public class FindOlder extends Thread {
    private ListLink<Human> humans;

    FindOlder(ListLink<Human> humans) {
        this.humans = humans;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Started");
        int maxAge = 0;
        for (Human h : humans) {
            if (h.getAge() > maxAge) {
                maxAge = h.getAge();
            }
        }

        System.out.println("Humans with max age:");
        for (Human h : humans) {
            if (h.getAge() == maxAge) {
                System.out.println(Thread.currentThread().getName()+ "\t\t" + h.toString());
            }
        }
        System.out.println(Thread.currentThread().getName() + ": Ended");
    }
}
