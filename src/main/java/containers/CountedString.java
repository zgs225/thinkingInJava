package containers;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuez on 14-1-14.
 * Creating a good hashCode
 */
public class CountedString {
    private static List<String> created = new ArrayList<String>();
    private String s;
    private int id = 0;

    public CountedString(String s) {
        this.s = s;
        created.add(s);
        for (String s2 : created)
            if (s2.equals(s))
                id++;
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "CountedString{" +
                "s='" + s + '\'' +
                ", id=" + id +
                "hashCode=" + hashCode() + '}';
    }

    public boolean equals(Object o) {
        return o instanceof CountedString &&
                s.equals(((CountedString) o).s) &&
                id == ((CountedString) o).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<CountedString, Integer>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        PrintUtil.print(map);
        for (CountedString cstring : cs) {
            PrintUtil.print("Looking up " + cstring);
            PrintUtil.print(map.get(cstring));
        }
    }

}
