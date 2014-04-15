package algorithm;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-15
 *         Linked list implementation
 */
public class MyLinkedList<T> implements Iterable<T> {
    /**
     * 用来储存MyLinkedList的链表数据
     * 包含当前current data object of T,
     * prev node and next node.
     */
    private static class Node<T> {
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T data;
        public Node<T> prev;
        public Node<T> next;
    }

    public MyLinkedList() {
        clear();
    }

    /**
     * 初始化MyLinkedList
     * 设置 beginMarker, endMarker, theSize
     */
    private void clear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T t) {
        add(size(), t);
    }

    public void add(int idx, T t) {
        addBefore(getNode(idx), t);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T old = p.data;
        p.data = newVal;
        return old;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(Node<T> p, T t) {
        Node<T> newNode = new Node<T>(t, p.prev, p);
        newNode.prev.next = p.prev = newNode;

        theSize++;
        modCount++;
    }

    private T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;

        theSize--;
        modCount++;
        return p.data;
    }

    private Node<T> getNode(int idx) {
        Node<T> p;

        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();

        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++)
                p = p.next;
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--)
                p = p.prev;
        }

        return p;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean preparedToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!hasNext())
                throw new NoSuchElementException();
            T nextItem = current.data;
            current = current.next;
            preparedToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!preparedToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(current.prev);
            preparedToRemove = false;
            expectedModCount++;
        }
    }

    /**
     * 代表MyLinkedList数组容量
     */
    private int theSize;

    /**
     * 计数器，用来表示对MyLinkedList进行的改变次数
     */
    private int modCount = 0;

    /**
     * 头结点
     */
    private Node<T> beginMarker;

    /**
     * 尾节点
     */
    private Node<T> endMarker;
}
