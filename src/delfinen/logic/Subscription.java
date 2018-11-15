package delfinen.logic;

/**
 *
 * @author martin b.
 */
public class Subscription {
    private int year;
    private Member holder;
    private final float price;

    public Subscription(int year, Member holder) {
        this.year = year;
        this.holder = holder;
        this.price = calcPrice();
    }
    
    
    public int getYear() {
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }

    public Member getHolder() {
        return holder;
    }
    
    private float calcPrice(){
        int age = this.holder.getAge();
        if (age < 18) {
            return 1000;
        }
        if (age < 60) {
            return 1600;
        }
        else return (float) (1600 * 0.75);
        }
        
}
