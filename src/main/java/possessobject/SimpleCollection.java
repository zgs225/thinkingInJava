package possessobject;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-2
 * Time: 下午10:24
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0; i<10; i ++) {
            s.add(i);
        }
        for(int i=0; i<5; i++) {
            s.add(i);
        }
        for(int i : s) {
            System.out.print(i + " ");
        }
    }
}
