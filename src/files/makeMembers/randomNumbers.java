package files.makeMembers;

import java.util.Random;

/**
 * random numbers generator
 *
 * @author martin b.
 */
public class randomNumbers {

    private int max;
    private int min;
    private Random rand = new Random();

    public randomNumbers(int max) {
        this.max = max;
    }

    public int getRandom() {
        int value = rand.nextInt((max) + 1);
        return value;
    }

    public double getRandomDouble() {
        double value = rand.nextDouble() * max;
        return value;
    }

    public float getRandomFloat() {
        Float value = rand.nextFloat() * max;
        return value;
    }
}
