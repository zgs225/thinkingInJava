package algorithm;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-21
 *         Avl tree implemetation
 */
public class AvlTree<AnyType extends Comparable<? super AnyType>> {
    public AvlTree() {
        root = null;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null)
            return new AvlNode<AnyType>(x);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.lt = insert(x, t.lt);
        else if (compareResult > 0)
            t.rt = insert(x, t.rt);
        return balance(t);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    private AvlNode<AnyType> remove(AnyType x, AvlNode<AnyType> t) {
        if (t == null)
            return null;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.lt = remove(x, t.lt);
        else if (compareResult > 0)
            t.rt = remove(x, t.rt);
        else if (t.lt != null && t.rt != null) {
            t.element = findMin(t.rt).element;
            t.rt = remove(t.element, t.rt);
        } else {
            t = (t.lt != null) ? t.lt : t.rt;
        }
        return balance(t);
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new NullPointerException();
        return findMin(root).element;
    }

    private AvlNode<AnyType> findMin(AvlNode<AnyType> t) {
        if (t == null)
            return null;
        while (t.lt != null)
            t = t.lt;
        return t;
    }

    public AnyType findMax() {
        if (isEmpty())
            throw new NullPointerException();
        return findMax(root).element;
    }

    private AvlNode<AnyType> findMax(AvlNode<AnyType> t) {
        if (t == null)
            return null;
        while (t.rt != null)
            t = t.rt;
        return t;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    private boolean contains(AnyType x, AvlNode<AnyType> t) {
        while (t != null) {
            int compareResult = x.compareTo(t.element);
            if (compareResult > 0)
                t = t.rt;
            else if (compareResult < 0)
                t = t.lt;
            else
                return true;
        }
        return false;
    }

    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null)
            return null;
        if (height(t.lt) - height(t.rt) > ALLOWED_IMBALANCE) {
            if (height(t.lt.lt) >= height(t.lt.rt))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        } else if (height(t.rt) - height(t.lt) > ALLOWED_IMBALANCE) {
            if (height(t.rt.rt) >= height(t.rt.lt))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);
        }
        t.height = Math.max(height(t.lt), height(t.rt)) + 1;
        return t;
    }

    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.lt;
        k2.rt = k1.lt;
        k1.rt = k2;
        k2.height = Math.max(height(k2.lt), height(k2.rt)) + 1;
        k1.height = Math.max(height(k1.lt), k2.height) + 1;
        return k1;
    }

    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.lt = rotateWithRightChild(k3.rt);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {
        k3.rt = rotateWithLeftChild(k3.lt);
        return rotateWithRightChild(k3);
    }

    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.rt;
        k2.rt = k1.lt;
        k1.lt = k2;
        k2.height = Math.max(height(k2.lt), height(k2.rt)) + 1;
        k1.height = Math.max(height(k1.rt), k2.height) + 1;
        return k1;
    }

    public void checkBalance() {
        checkBalance(root);
    }

    private int checkBalance(AvlNode<AnyType> t) {
        if (t == null)
            return -1;
        else {
            int hl = checkBalance(t.lt);
            int hr = checkBalance(t.rt);
            if (Math.abs(height(t.lt) - height(t.rt)) > 1 ||
                    height(t.lt) != hl || height(t.rt) != hr)
                System.out.println("OOPS");
            return height(t);
        }
    }

    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    private void printTree(AvlNode<AnyType> t) {
        if (t != null) {
            printTree(t.lt);
            System.out.println(t.element);
            printTree(t.rt);
        }
    }

    private static class AvlNode<AnyType> {
        private AvlNode(AnyType element) {
            this(element, null, null);
        }

        private AvlNode(AnyType element, AvlNode<AnyType> lt, AvlNode<AnyType> rt) {
            this.element = element;
            this.lt = lt;
            this.rt = rt;
            this.height = 0;
        }

        AnyType element;
        AvlNode<AnyType> lt;
        AvlNode<AnyType> rt;
        int height;
    }

    private AvlNode<AnyType> root;

    public static void main(String[] args) {
        AvlTree<Integer> t = new AvlTree<Integer>();
        final int NUMS = 1000000;
        final int GAP = 37;

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS) {
            t.insert(i);
        }

        for (int i = 1; i < NUMS; i += 2) {
            t.remove(i);
        }

        if (t.findMin() != 2 || t.findMax() != NUMS - 2)
            System.out.println("FindMin or FindMax error!");

        for (int i = 2; i < NUMS; i += 2)
            if (!t.contains(i))
                System.out.println("Find error1!");

        for (int i = 1; i < NUMS; i += 2) {
            if (t.contains(i))
                System.out.println("Find error2!");
        }
    }
}
