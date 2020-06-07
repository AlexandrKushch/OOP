package ua.khpi.oop.kushch10;

import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private static Comparator<Human> NAME_COMPARATOR = Comparator.comparing(Human::getName);
    private static Comparator<Human> AGE_COMPARATOR = Comparator.comparing(Human::getAge);
    private static Comparator<Human> BIRTHDAY_COMPARATOR = Comparator.comparing(Human::getBirthday);

    private Sort<Human> sort;

    public void dialogMode(ListLink<Human> humans) {
        int command = 0;
        while (command != 9) {
            System.out.println("List:");
            for (Human h : humans) {
                System.out.println(h.toString());
            }

            System.out.println("Sorting by:\n\t1. Name\n\t2. Age\n\t3. Birthday date\nPress '9' to exit.");
            Scanner in = new Scanner(System.in);

            System.out.print("Enter key: ");
            command = in.nextInt();

            switch (command) {
                case 1:
                    sort = new Sort<>(NAME_COMPARATOR);
                    humans = sort.sort(humans);
                    break;
                case 2:
                    sort = new Sort<>(AGE_COMPARATOR);
                    humans = sort.sort(humans);
                    break;
                case 3:
                    sort = new Sort<>(BIRTHDAY_COMPARATOR);
                    humans = sort.sort(humans);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Key not found");
                    break;
            }
        }
    }

    public void autoMode(ListLink<Human> humans) {
        System.out.println("List:");
        for(Human h : humans){
            System.out.println(h.toString());
        }
        System.out.println("\nSorted");

        sort = new Sort<>(NAME_COMPARATOR);
        humans = sort.sort(humans);
        for(Human h : humans){
            System.out.println(h.toString());
        }
    }
}
