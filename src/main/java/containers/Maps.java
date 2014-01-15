package containers;

import utils.PrintUtil;

import java.util.Map;

/**
 * Created by yuez on 14-1-13.
 * Things you can do with Maps
 */
public class Maps {
    public static void printKeys(Map<Integer, String> map) {
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys: ");
        System.out.print(map.keySet());
    }

    public static void test(Map<Integer, String> map) {
        PrintUtil.print(map.getClass().getSimpleName());
    }
}
