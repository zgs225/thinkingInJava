package containers;

import utils.PrintUtil;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuez on 14-1-13.
 */
public class SpringDetector {
    public static <T extends GroundHog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> constructor = type.getConstructor(int.class);
        Map<GroundHog, Prediction> map = new HashMap<GroundHog, Prediction>();
        for (int i = 0; i < 10; i++)
            map.put(constructor.newInstance(i), new Prediction());
        PrintUtil.print("map = " + map);
        GroundHog groundHog = constructor.newInstance(3);
        PrintUtil.print("Looking up prediction for " + groundHog);
        if (map.containsKey(groundHog))
            PrintUtil.print(map.get(groundHog));
        else
            PrintUtil.print("Key not found: " + groundHog);
    }

    public static void main(String[] args) throws Exception {
        detectSpring(GroundHog.class);
    }
}
