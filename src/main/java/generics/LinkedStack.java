package generics;

import utils.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-18
 * Time: 下午8:38
 */
public class LinkedStack<T> {
    private class Node {
        T item;
        Node next;
        Node() { item = null; next = null; }
        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
        boolean end() { return item == null && next == null; }
    }

    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if(!top.end())
            top = top.next;
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<String>();
        for(String s : "Yuez is a man".split(" "))
            lss.push(s);
        String s;
        while((s = lss.pop()) != null)
            PrintUtil.print(s);
    }
}
