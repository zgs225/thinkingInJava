package containers;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yuez on 14-1-11.
 *
 */
class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("hello")));
        PrintUtil.print(list);
        Collections.fill(list, new StringAddress("world"));
        PrintUtil.print(list);
    }
}
