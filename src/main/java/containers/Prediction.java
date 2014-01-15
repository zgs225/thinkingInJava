package containers;

import java.util.Random;

/**
 * Created by yuez on 14-1-13.
 * Predicting the weather with groundhogs
 */
public class Prediction {
    private static Random random = new Random();
    private boolean shadow = random.nextDouble() > 0.5;

    public String toString() {
        if (shadow)
            return "Six more weeks of Winter.";
        else
            return "Early Spring.";
    }
}
