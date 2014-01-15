package containers;

/**
 * Created by yuez on 14-1-13.
 * Look plausible, but doesn't work as a HashMap Key
 */
public class GroundHog {
    protected int number;

    public GroundHog(int n) {
        number = n;
    }

    public String toString() {
        return "Groundhog #" + number;
    }
}
