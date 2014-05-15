package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-5-8
 *         左式堆
 */
public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {
    // Root
    private Node<AnyType> root;

    private static class Node<AnyType> {
        AnyType element;
        Node<AnyType> left;
        Node<AnyType> right;
        int npl;

        Node(AnyType element) {
            this(element, null, null);
        }

        Node(AnyType element, Node<AnyType> left, Node<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.npl = 0;
        }
    }

    public LeftistHeap() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public void merge(LeftistHeap<AnyType> rhs) {
        if (this == rhs)
            return;
        root = merge(root, rhs.root);
        rhs.root = null;
    }

    public void insert(AnyType x) {
        root = merge(new Node<AnyType>(x), root);
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new NullPointerException();
        return root.element;
    }

    public AnyType deleteMin() {
        if (isEmpty())
            throw new NullPointerException();
        AnyType minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;
    }

    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        if (h1.element.compareTo(h2.element) < 0)
            return merge1(h1, h2);
        else
            return merge1(h2, h1);
    }

    private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1.left == null)
            h1.left = h2;
        else {
            h1 = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl)
                swapChildren(h1);
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<AnyType> t) {
        Node<AnyType> tmp = t.left;
        t.left = t.right;
        t.right = tmp;
    }
}
