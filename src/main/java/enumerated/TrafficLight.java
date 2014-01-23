package enumerated;

import utils.PrintUtil;

/**
 * Created by yuez on 14-1-23.
 * Enums in switch statements
 */
enum Signal {
    RED, YELLO, GREEN
}

public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case YELLO:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLO;
                break;
        }
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            PrintUtil.print(t.color);
            t.change();
        }
    }
}
