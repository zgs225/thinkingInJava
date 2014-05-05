package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-29
 *         使用探测函数解决散列表中元素冲突的问题
 */
public class QuadraticProbingHashTable<AnyType> {
    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++)
            array[i] = null;
    }

    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    public void insert(AnyType x) {
        int currentPos = findPos(x);
        // 如果这个元素已经存在，则不做任何操作
        if (isActive(currentPos))
            return;
        array[currentPos] = new HashEntry<AnyType>(x);
        if (++currentSize > array.length / 2)
            rehash();
    }

    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos))
            array[currentPos].isActive = false;
    }

    private static class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive; // false if marked deleted

        public HashEntry(AnyType x) {
            this(x, true);
        }

        public HashEntry(AnyType x, boolean b) {
            element = x;
            isActive = b;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<AnyType>[] array;
    private int currentSize;

    private void allocateArray(int arraySize) {
        array = new HashEntry[arraySize];
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int findPos(AnyType x) {
        int offset = -1;
        int currentPos = myHash(x);
        while (array[currentPos] != null &&
                !array[currentPos].element.equals(x)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    private void rehash() {
        // TODO
    }

    private int myHash(AnyType x) {
        int hashVal = x.hashCode();
        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;
        return hashVal;
    }

    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n += 1;
        while (!isPrime(n)) {
            n += 2;
        }
        return n;
    }

    /**
     * 判断一个int数是否是素数
     *
     * @param n 需要判断的int
     * @return 是否是素数
     */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}
