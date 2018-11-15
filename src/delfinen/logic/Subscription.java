package delfinen.logic;

/** Possible Feature: Change prices to come from a potential data base. I.E Changeable.
 *
 * @author martin b. & Martin Wulff
 */
public class Subscription {
    private int year; // Is not a LocalDateTime obj since it would be overkill. Could be changed to sutch if we change to season based system.
    private Member holder; 
    private final float price;

    
    /**
     * Constructor for a subscription. Contains the year the subscription was payed for.
     * the holder of the subscription and from this calculates what price the holder had to pay.
     * @param year      Integer. The year this subscription is valid for.
     * @param holder    Member. The holder of this subscription.
     */         
    public Subscription(int year, Member holder) {
        this.year = year;
        this.holder = holder;
        this.price = calcPrice();
    }
    
    /**
     * Private function for calculating price according to provided price logic.
     * @return  Float. the actual price a member of this age has to pay.
     */
    private float calcPrice(){
        if(holder.getStatus() == Member.Status.Passive) return 500;
        
        int age = this.holder.getAge();
        if (age < 18) {
            return 1000;
        }
        if (age < 60) {
            return 1600;
        }
        else return (float) (1600 * 0.75);
        }
    
    
    
    
    
    
    ///////////////////////      GETTERS AND SETTERS       ////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////    
    /**
     * Getter for this.Year.
     * @return 
     */
    public int getYear() {
        return this.year;
    }
    /**
     * Getter for this.price.
     * @return 
     */
    public float getPrice() {
        return this.price;
    }
    
    /**
     * Getter for this.holder.
     * @return 
     */
    public Member getHolder() {
        return holder;
    }
    
        
}
