package possessobject;

import utils.PrintUtil;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-3
 * Time: 下午10:22
 */
public class SimpleLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0; i<100; i++) {
            list.add(list.size()/2, new Random().nextInt());
        }
        PrintUtil.print(list);
    }
}
