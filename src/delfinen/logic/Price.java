package delfinen.logic;

import delfinen.logic.Member.Status;
import delfinen.logic.Price.Prices;

/**
 *
 * @author martin b.
 */
public class Price {

    private int age;
    private Status status;
    private Prices pris;

    public enum Prices {
        ungdomsPris,
        seniorPris,
        pensionistPris;
    }

    public Price(Status status) {
        this.status = status;
    }

    public Price(int age, Status status) {
        this.age = age;
        this.status = status;
        if (age < 18) {
            pris = Prices.ungdomsPris;
        }
        if (age >= 18 && age < 60) {
            pris = Prices.seniorPris;
        }
        if (age >= 60) {
            pris = Prices.pensionistPris;
        }
    }

    public int priceSubscription() {
        if (status == Status.Passive) {
            return 500;
        } else {
            switch (pris) {

                case ungdomsPris:
                    return 1000;

                case seniorPris:
                    return 1600;

                case pensionistPris:
                    return (int) (1600 * 0.75);

                default:
                    return 500;

            }
        }
    }
}
