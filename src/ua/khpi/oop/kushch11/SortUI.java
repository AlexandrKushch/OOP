package ua.khpi.oop.kushch11;

import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;

import java.util.Scanner;

public class SortUI {
    public static int sortUI(ListLink<Human> humans) {
        int command = 0;
        System.out.println("List:");
        for (Human h : humans) {
            System.out.println(h.toString());
        }

        System.out.println("Sorting by:\n\t1. Name\n\t2. Age\n\t3. Birthday date\nPress '9' to exit.");
        Scanner in = new Scanner(System.in);

        System.out.print("Enter key: ");
        command = in.nextInt();

        return command;
    }
}
