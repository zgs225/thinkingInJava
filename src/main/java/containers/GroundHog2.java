package containers;

/**
 * Created by yuez on 14-1-13.
 */
public class GroundHog2 extends GroundHog {
    public GroundHog2(int n) {
        super(n);
    }

    public int hashCode() {
        return number;
    }

    public boolean equals(Object o) {
        return o instanceof GroundHog2 &&
                (number == ((GroundHog2) o).number);
    }

    public static void main(String[] args) throws Exception {
        SpringDetector.detectSpring(GroundHog2.class);
    }
}
