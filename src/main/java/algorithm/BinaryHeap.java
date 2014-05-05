package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-5-5
 *         An implementation of binary heap
 *         用一个表示堆大小的int和一个数组表示
 *         binary heap可以轻易的用一个数组来实现，
 *         对于任意当前元素i，其左儿子为2i，右儿子为2i + 1，
 *         其父元素为i / 2
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    public BinaryHeap() {
        // TODO
    }

    public BinaryHeap(int capacity) {
        // TODO
    }

    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (AnyType item : items)
            array[i++] = item;
        buildHeap();
    }

    public void insert(AnyType x) {
        if (currentSize == array.length - 1)
            enlargeArray(2 * array.length + 1);
        // Percolate up
        int hole = ++currentSize;
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    public AnyType findMin() {
        // TODO
        return null;
    }

    public AnyType deleteMin() {
        if (isEmpty())
            throw new NullPointerException();
        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    public boolean isEmpty() {
        // TODO
        return false;
    }

    public void makeEmpty() {
        // TODO
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize; // Number of elements in heap
    private AnyType[] array; // The heap array

    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else break;
        }

        array[hole] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    private void enlargeArray(int newSize) {
        // TODO
    }
}
