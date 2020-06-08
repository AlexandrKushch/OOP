package ua.khpi.oop.kushch13;

import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;
import ua.khpi.oop.kushch12.RegSearch;

public class CountRegSearch extends Thread {
    private ListLink<Human> humans;

    public CountRegSearch(ListLink<Human> humans) {
        this.humans = humans;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Started");
        int count = 0;
        for (Human h : humans) {
            if (RegSearch.nameSearch(h.getName()) && RegSearch.ageSearch(Integer.toString(h.getAge()))) {
                count++;
            }
        }
        System.out.println("Count of items matching the criteria: " + count);
        System.out.println(Thread.currentThread().getName() + ": Ended");
    }
}
