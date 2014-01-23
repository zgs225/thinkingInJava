package utils;

import java.util.Random;

/**
 * Created by yuez on 14-1-23.
 */
public class Enums {
    private static Random rand = new Random();

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T extends Enum<T>> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
