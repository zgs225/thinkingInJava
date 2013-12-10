package possessobject;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-2
 * Time: 下午10:33
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> c =
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        c.addAll(Arrays.asList(moreInts));
        Collections.addAll(c, 11, 12, 13, 14, 15);
        Collections.addAll(c, moreInts);
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99);
        System.out.println(c);
//        list.add(21);
    }
}
