package algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-28
 *         一种散列表
 *         使用Separate chaining的方式解决散列表中key冲突
 */
public class SeparateChainingHashTable<AnyType> {
    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * 散列表储存一个指定容量双向链表
     *
     * @param size the chaining list size
     */
    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<AnyType>();
    }

    public void insert(AnyType x) {
        List<AnyType> whichList = theLists[myHash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);
            if (++currentSize > theLists.length)
                rehash();
        }
    }

    public void remove(AnyType x) {
        List<AnyType> whichList = theLists[myHash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    public boolean contains(AnyType x) {
        List<AnyType> whichList = theLists[myHash(x)];
        return whichList.contains(x);
    }

    /**
     * Make the hash table logically empty
     */
    public void makeEmpty() {
        for (List<AnyType> theList : theLists) theList.clear();
        currentSize = 0;
    }

    public static final int DEFAULT_TABLE_SIZE = 101;

    private List<AnyType>[] theLists;
    private int currentSize;

    private void rehash() {
        // TODO
    }

    private int myHash(AnyType x) {
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;
        return hashVal;
    }

    private static int nextPrime(int n) {
        // TODO
        return -1;
    }

    private static boolean isPrice(int n) {
        // TODO
        return false;
    }
}
