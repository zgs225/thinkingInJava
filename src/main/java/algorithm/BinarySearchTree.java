package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-18
 *         二叉查找树的实现
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class BinaryNode<T> {
        BinaryNode(T element) {
            this(element, null, null);
        }

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contain(T t) {
        return contain(t, root);
    }

    public T findMin() {
        if (isEmpty())
            throw new NullPointerException();
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty())
            throw new NullPointerException();
        return findMax(root).element;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        if (node == null)
            return new BinaryNode<T>(t);
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0)
            node.left = insert(t, node.left);
        else if (compareResult > 0)
            node.right = insert(t, node.right);
        return node;
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null)
            return null;

        int compareResult = t.compareTo(node.element);
        if (compareResult < 0)
            node.left = remove(t, node.left);
        else if (compareResult > 0)
            node.right = remove(t, node.right);
        else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else
            node = (node.left != null) ? node.left : node.right;
        return node;
    }

    private boolean contain(T t, BinaryNode<T> node) {
        if (node == null)
            return false;
        int comparedResult = t.compareTo(node.element);

        if (comparedResult > 0)
            return contain(t, node.right);
        else if (comparedResult < 0)
            return contain(t, node.left);
        else return true;
    }

    /**
     * 这是一种尾递归，可以使用一个while循环
     * 简单地替代它，详细历程见 findMax
     */
    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null)
            return null;
        else if (node.left == null)
            return node;
        else return findMin(node.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node != null)
            while (node.right != null)
                node = node.right;
        return node;
    }
}
