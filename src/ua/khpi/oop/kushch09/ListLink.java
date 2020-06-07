package ua.khpi.oop.kushch09;

import java.io.*;
import java.util.Iterator;

public class ListLink<T> implements Iterable<T>, Serializable {
    private T t;
    private ListLink<T> next;

    private int index = 0;

    public ListLink() {
    }

    public ListLink(T t, ListLink<T> next) {
        this.t = t;
        this.next = next;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public ListLink<T> getNext() {
        return next;
    }

    public void setNext(ListLink<T> next) {
        this.next = next;
    }

    public boolean isEmpty() {
        return getT() == null;
    }

    public int size() {
        int size = 0;
        ListLink<T> nextTemp = getNext();
        if (getT() != null) {
            size = 1;
        }
        while (nextTemp.getNext() != null) {
            size++;
            nextTemp = nextTemp.getNext();
        }
        return size;
    }

    public void add(T t) {
        if (getT() == null) {
            setT(t);
            setNext(new ListLink<>(null, null));
        } else if (getNext().getT() == null) {
            setNext(new ListLink<>(t, new ListLink<>()));
        } else {
            ListLink<T> nextTemp = getNext();
            while (nextTemp.getNext().getNext() != null) {
                nextTemp = nextTemp.getNext();
            }

            nextTemp.setNext(new ListLink<>(t, new ListLink<>()));
        }
    }

    public void delete(int index) {
        ListLink<T> nextTemp = this;
        if (index == 1) {
            setT(getNext().t);
            setNext(getNext().getNext());
            nextTemp = null;
        } else {
            for (int i = 1; i < index - 1; i++) {
                nextTemp = nextTemp.getNext();
            }

            nextTemp.setNext(nextTemp.getNext().getNext());
        }
    }

    public void clear() {
        setT(null);
        setNext(null);
    }

    public T get(int index) {
        ListLink<T> nextTemp = this;
        for (int i = 1; i <= index; i++) {
            nextTemp = nextTemp.getNext();
        }
        return nextTemp.getT();
    }

    @Override
    public String toString() {
        String result = "[";
        ListLink<T> nextTemp = this;

        while (nextTemp.getNext() != null) {
            result += nextTemp.getT().toString() + " ";
            nextTemp = nextTemp.getNext();
        }
        result += "]";

        return result;
    }

    public <T> T[] toArray(T[] a) {
        int i = 0;
        Object[] result = a;

        for (ListLink next = this; next.getT() != null; next = next.getNext()) {
            result[i++] = next.getT();
        }

        return a;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<T>(this);
    }

    public class CustomIterator<E> implements Iterator {
        int index = 0;
        ListLink<E> internalList;

        public CustomIterator(ListLink<E> internalList) {
            this.internalList = internalList;
        }

        @Override
        public boolean hasNext() {
            return index + 1 <= internalList.size();
        }

        @Override
        public E next() {
            E val = internalList.get(index);
            index++;
            return val;
        }
    }

    public void save() throws Exception {
        FileOutputStream fOut = new FileOutputStream("serialization");
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(this);
        oOut.close();
    }

    public ListLink<T> upload() throws Exception {
        FileInputStream fIn = new FileInputStream("serialization");
        ObjectInputStream oIn = new ObjectInputStream(fIn);
        ListLink<T> result = (ListLink<T>) oIn.readObject();
        oIn.close();
        return result;
    }
}
