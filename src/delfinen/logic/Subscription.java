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

    public Price getPrice() {
        return price;
    }

    public int getAge() {
        return age;
    }

}
