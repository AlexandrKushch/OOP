package ua.khpi.oop.kushch12;

import org.w3c.dom.ls.LSOutput;
import ua.khpi.oop.kushch09.Human;
import ua.khpi.oop.kushch09.ListLink;
import ua.khpi.oop.kushch10.Sort;
import ua.khpi.oop.kushch11.Regex;
import ua.khpi.oop.kushch11.SortUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Scanner;

public class ConsoleUI {
    private static Comparator<Human> NAME_COMPARATOR = Comparator.comparing(Human::getName);
    private static Comparator<Human> AGE_COMPARATOR = Comparator.comparing(Human::getAge);
    private static Comparator<Human> BIRTHDAY_COMPARATOR = Comparator.comparing(Human::getBirthday);

    private Sort<Human> sort;

    private ListLink<Human> list;

    private Regex regex = new Regex();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");


    public ConsoleUI(ListLink<Human> list) {
        this.list = list;
    }

    public void dialogMode() throws ParseException {
        int command = 0;
        Scanner scan = new Scanner(System.in);

        String name;
        String age;
        String birthday;
        String gender;
        Boolean genderBoo;

        while(command != 9){
            name = "";
            age = "";
            birthday = "";
            gender = "";

            System.out.print("1. Add element\n2. Delete element\n3. Sort list\n4. Clear\n5. Print\n6. Search\n9. Exit\nEnter key: ");
            command = scan.nextInt();
            switch (command) {
                case 1:
                    while(!regex.matchName(name)){
                        System.out.print("Enter name: ");
                        name = scan.nextLine();
                    }
                    while(!regex.matchAge(age)){
                        System.out.print("Enter age: ");
                        age = scan.nextLine();
                    }
                    while(!regex.matchBirthday(birthday)){
                        System.out.print("Enter birthday: ");
                        birthday = scan.nextLine();
                    }
                    while(!regex.matchGender(gender)){
                        System.out.print("Enter gender(male/female): ");
                        gender = scan.nextLine();
                    }
                    if(gender.equals("male")){
                        genderBoo = true;
                    } else {
                        genderBoo = false;
                    }
                    list.add(new Human(name, Integer.parseInt(age), simpleDateFormat.parse(birthday), genderBoo));
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter index: ");
                    int index = scan.nextInt();
                    list.delete(index);
                    break;
                case 3:
                    int sortKey = SortUI.sortUI(list);
                    switch (sortKey) {
                        case 1:
                            sort = new Sort<>(NAME_COMPARATOR);
                            list = sort.sort(list);
                            break;
                        case 2:
                            sort = new Sort<>(AGE_COMPARATOR);
                            list = sort.sort(list);
                            break;
                        case 3:
                            sort = new Sort<>(BIRTHDAY_COMPARATOR);
                            list = sort.sort(list);
                            break;
                        case 9:
                            break;
                        default:
                            System.out.println("Key not found");
                            break;
                    }
                    System.out.println("----Sorted----");
                    print();
                    break;
                case 4:
                    list.clear();
                    break;
                case 5:
                    print();
                    break;
                case 6:
                    for(Human h : list){
                        if(RegSearch.nameSearch(h.getName()) && RegSearch.ageSearch(Integer.toString(h.getAge()))){
                            System.out.println(h.toString());
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void print(){
        if(list.isEmpty()){
            System.out.println("List is empty");
        } else {
            for(Human h : list){
                System.out.println(h.toString());
            }
        }
    }

    public void autoMode() throws ParseException {
        list.add(new Human("Danya", 21, simpleDateFormat.parse("06-06-1999"), true));
        list.add(new Human("Dasha", 20, simpleDateFormat.parse("26-10-2000"), false));
        list.add(new Human("Misha", 39, simpleDateFormat.parse("13-03-1981"), true));
        list.add(new Human("Sasha", 19, simpleDateFormat.parse("15-06-2001"), true));

        System.out.println("List:");
        print();
        System.out.println("\nSorted");

        sort = new Sort<>(NAME_COMPARATOR);
        list = sort.sort(list);
        print();

        System.out.println("\nSearching");
        for(Human h : list){
            if(RegSearch.nameSearch(h.getName()) && RegSearch.ageSearch(Integer.toString(h.getAge()))){
                System.out.println(h.toString());
            }
        }
    }
}
