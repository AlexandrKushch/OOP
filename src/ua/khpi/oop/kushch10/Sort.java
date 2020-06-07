package ua.khpi.oop.kushch10;

import ua.khpi.oop.kushch09.ListLink;

import java.util.Comparator;

public class Sort<T> {
    Comparator<T> comparator;

    public Sort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public ListLink<T> sort(ListLink<T> list) {
        for (int i = 1; i <= list.size(); i++) {
            ListLink<T> temp = list;
            ListLink<T> previous = temp;

            int j = 1;
            while(temp.getT() != null && temp.getNext().getT() != null){
                ListLink<T> first = temp;
                ListLink<T> second = temp.getNext();
                if (comparator.compare(first.getT(), second.getT()) > 0) {
                    if(j == 1){
                        first.setNext(second.getNext());
                        second.setNext(first);
                        temp = second;
                        list = second;
                    } else {
                        previous.setNext(second);
                        first.setNext(second.getNext());
                        second.setNext(first);
                    }
                }

                previous = temp;
                temp = temp.getNext();
                j++;
            }
        }
        return list;
    }
}
