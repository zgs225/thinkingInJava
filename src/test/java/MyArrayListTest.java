import algorithm.MyArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-4-14
 * @see algorithm.MyArrayList
 */
public class MyArrayListTest {
    @Test
    public void canWork() {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i < 15; i++)
            list.add(i);
        Assert.assertEquals((long) 0, (long) list.get(0));
        Assert.assertEquals((long) 1, (long) list.get(1));

        list.add(15);
        Assert.assertEquals((long) 15, (long) list.get(list.size() - 1));

        list.remove(0);
        Assert.assertNotEquals((long) 0, (long) list.get(0));
    }
}
