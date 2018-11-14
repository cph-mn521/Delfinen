package delfinen.logic;

import delfinen.logic.Member.Status;

/**
 *
 * @author martin b.
 */
public class Subscription {
    private int year;
    private Price price;
    private int age;

    public Subscription(int year, Price price, int age, Status status) {
        this.year = year;
        this.price = price;
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
