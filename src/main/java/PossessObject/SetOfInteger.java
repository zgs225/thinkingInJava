package PossessObject;

import utils.PrintUtil;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-4
 * Time: 下午8:43
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random();
        Set<Integer> intset = new HashSet<Integer>();
        for(int i=0; i<10000; i++) {
            intset.add(rand.nextInt(30));
        }
        PrintUtil.print(intset);
    }
}
