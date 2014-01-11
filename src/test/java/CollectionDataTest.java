import utils.CollectionData;
import generics.Generator;
import utils.PrintUtil;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by yuez on 14-1-11.
 *
 */
public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 15));
        set.addAll(CollectionData.list(new Government(), 15));
        PrintUtil.print(set);
    }
}

class Government implements Generator<String> {
    String[] foundation = ("strange women lying in ponds distributing swords is no basis for a system of government").split(" ");
    private int index;
    public String next() { return foundation[index ++]; }
}
