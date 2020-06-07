package ua.khpi.oop.kushch09;

import java.io.Serializable;
import java.util.Date;

public class Human implements Serializable {
    private String name;
    private int age;
    private Date birthday;
    private boolean gender; // True - male, False - female

    public Human() {
    }

    public Human(String name, int age, Date birthday, boolean gender) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return getName() + ": " + getAge() + ": " + getBirthday().toString();
    }
}
