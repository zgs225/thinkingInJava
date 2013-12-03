package PossessObject;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-3
 * Time: 下午10:06
 */
public class SimpleListIterator {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for(int i=0; i<10; i++) {
            l1.add(new Random().nextInt());
            l2.add(new Random().nextInt());
        }
        PrintUtil.print(l1);
        PrintUtil.print(l2);
        PrintUtil.print("");
        for(int i=l1.size(); i>0; i--) {
            l2.add(l1.get(i - 1));
        }
        PrintUtil.print(l2);
        PrintUtil.print("");

        ListIterator<Integer> lit = l1.listIterator(l1.size()-1);
        while(lit.hasPrevious()) {
            l2.add(lit.previous());
        }
        PrintUtil.print(l2);
    }
}
