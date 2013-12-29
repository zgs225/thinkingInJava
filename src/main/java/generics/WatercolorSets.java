package generics;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-19
 * Time: 下午9:06
 */
public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.CERULEAN_BLUE_HUE);
    }
}
