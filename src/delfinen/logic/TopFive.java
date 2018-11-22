package delfinen.logic;

import java.util.Arrays;

/**
 * Class for keeping score on topFive recordholders
 *
 * @author martin b.
 */
public class TopFive {

    private String[][] topFive = new String[2][5];
    private double[] topFiveTimes = new double[5];

    /**
     *
     */
    public TopFive() {

    }

    /**
     * returner 2D string array til brug ved udfyldelse af Top 5 tabel
     *
     * @return
     */
    public String[][] getTopFive() {
        return topFive;
    }

    /**
     *  Method that keeps score of the Top 5 swimmers and the time they'ved clocked in
     * 
     * @param time
     * @param timeHolder
     */
    public void checkAndChangetopFive(double time, String timeHolder) {
        int counter = 0;
        for (double topFiveTime : topFiveTimes) {
            if (topFiveTime == 0.0) {
                counter++;
            }
        }
        if (counter==5) {
            Arrays.fill(topFiveTimes, 600.0); // initial start values. Should be higher than
                                              // expected competition times
        }
        if (timeHolder != null && !timeHolder.isEmpty()) {
            boolean notDuplicate = true;
            for (String[] strings : topFive) {
                if (strings[0] != null && strings[0].equals(timeHolder)) {
                    notDuplicate = false;
                }
            }
            for (int i = 4; i >= 0; i--) {
                if (time < topFiveTimes[i] && notDuplicate) {
                    if (i == 4) {
                        topFiveTimes[i] = time;
                        topFive[0][i] = String.valueOf(String.format("%.5s",time));
                        topFive[1][i] = timeHolder;
                    } else {
                        topFiveTimes[i + 1] = topFiveTimes[i]; // time as double
                        topFive[0][i + 1] = topFive[0][i]; // time holder
                        topFive[1][i + 1] = topFive[1][i]; // time as string
                        topFiveTimes[i] = time;
                        topFive[0][i] = String.valueOf(String.format("%.5s",time));
                        topFive[1][i] = timeHolder;
                    }
                }
            }
        }
    }
    /**
     *
     */

}
