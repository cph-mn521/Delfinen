package delfinen.logic;

import delfinen.logic.Member.Status;
import delfinen.logic.Price.Prices;

/** Currently. Might be unused.
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
    
    /**
     * Constructor for a new price object. Calculates the price for the Age and Status.
     * @param age       Integer. For this price.
     * @param status    Enum. Status for this price.
     */
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
    
    /**
     * Getter for this price age.
     * @return 
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter for this pice Status.
     * @return 
     */
    public Status getStatus() {
        return status;
    }
    
    /**
     * Getter for this price actual price.
     * @return    Integer. Actual price. Always integer.
     */
        public int getPris() {
        return priceSubscription();
    }
    
    /**
     * Function for returning the actual price of this object.
     * @return Integer. Actual price. Always integer.
     */
    private int priceSubscription() {
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
