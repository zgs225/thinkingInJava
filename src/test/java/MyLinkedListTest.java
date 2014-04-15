import algorithm.MyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-15
 * @see algorithm.MyLinkedList
 */
@RunWith(JUnit4.class)
public class MyLinkedListTest {
    MyLinkedList<Integer> list;

    @Before
    public void init() {
        list = new MyLinkedList<Integer>();
    }

    @Test
    public void work() {
        int capacity = 10;

        Assert.assertTrue(list.isEmpty());
        Assert.assertEquals(list.size(), 0);

        for (int i = 0; i < capacity; i++)
            list.add(i);
        Assert.assertEquals(list.size(), capacity);
        for (int i = 0; i < capacity; i++)
            Assert.assertEquals(list.get(i).intValue(), i);
        list.add(3, 10);
        Assert.assertEquals(list.get(3).intValue(), 10);
        list.remove(list.size() - 1);
        Assert.assertEquals(list.size(), capacity);

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
