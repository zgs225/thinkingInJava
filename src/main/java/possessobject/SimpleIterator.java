package possessobject;

import utils.PrintUtil;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-3
 * Time: 下午9:50
 */
public class SimpleIterator {
    public static final String name = "Hello";
    public static void display(Iterator it) {
        while(it.hasNext()) {
            PrintUtil.print(it.next());
        }
    }

    public static void main(String[] args) {
        ArrayList<String> movies_arraylist = new ArrayList<String>();
        LinkedList<String> movies_linkedlist = new LinkedList<String>();
        HashSet<String> movies_set = new HashSet<String>();
        TreeSet<String> movies_treeset = new TreeSet<String>();
        LinkedHashSet<String> movies_linkedhashset = new LinkedHashSet<String>();
        for(int i=0; i<5; i++) {
            movies_arraylist.add(name + String.valueOf(i));
            movies_linkedlist.add(name + String.valueOf(i));
            movies_set.add(name + String.valueOf(i));
            movies_treeset.add(name + String.valueOf(i));
            movies_linkedhashset.add(name + String.valueOf(i));
        }

        SimpleIterator.display(movies_arraylist.iterator());
        PrintUtil.print("");
        SimpleIterator.display(movies_linkedlist.iterator());
        PrintUtil.print("");
        SimpleIterator.display(movies_set.iterator());
        PrintUtil.print("");
        SimpleIterator.display(movies_treeset.iterator());
        PrintUtil.print("");
        SimpleIterator.display(movies_linkedhashset.iterator());
    }
}
