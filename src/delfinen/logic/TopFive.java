package delfinen.logic;

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
     *
     * @param time
     * @param timeHolder
     */
    public void checkAndChangetopFive(double time, String timeHolder) {
        if (timeHolder != null && !timeHolder.isEmpty()) {
            boolean notDuplicate = true;
            for (String[] strings : topFive) {
                if (strings[0] != null && strings[0].equals(timeHolder)) {
                    notDuplicate = false;
                }
            }
            for (int i = 4; i >= 0; i--) {
                if (time > topFiveTimes[i] && i < 4 && notDuplicate) {
                    topFiveTimes[i + 1] = topFiveTimes[i]; // time as double
                    topFive[0][i + 1] = topFive[0][i]; // time holder
                    topFive[1][i + 1] = topFive[1][i]; // time as string
                    topFiveTimes[i] = time;
                    topFive[0][i] = String.valueOf(time);
                    topFive[1][i] = timeHolder;
                }
            }
        }
    }
    /**
     *
     */

}
