package algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-14
 *         实现ArrayList
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        clear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int idx) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public T set(int idx, T newValue) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        T old = theItems[idx];
        theItems[idx] = newValue;
        return old;
    }

    public void add(T t) {
        add(size(), t);
    }

    public void add(int idx, T t) {
        if (theItems.length == size())
            ensureCapacity(2 * size() + 1);
        System.arraycopy(theItems, idx, theItems, idx + 1, size() - idx);
        theItems[idx] = t;
        theSize++;
    }

    public T remove(int idx) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        T removedItem = theItems[idx];
        System.arraycopy(theItems, idx + 1, theItems, idx, size() - idx);
        theSize--;
        return removedItem;
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize)
            return;

        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        if (old != null)
            System.arraycopy(old, 0, theItems, 0, size());
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
