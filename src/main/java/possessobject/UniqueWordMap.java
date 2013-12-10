package possessobject;

import utils.PrintUtil;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-4
 * Time: 下午10:03
 */
public class UniqueWordMap {
    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        String greeting = "Hello, I'm Li XiaoRan, I'm 15 years old. What's your name?";
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(greeting);
        while (matcher.find()) {
            String s = matcher.group();
            Integer freq = m.get(s);
            m.put(s, freq == null ? 1 : freq + 1);
        }
        PrintUtil.print(m);
        LinkedHashMap<String, Integer> lm = new LinkedHashMap<String, Integer>();
        TreeSet<String> keyset = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        keyset.addAll(m.keySet());
        for(String s : keyset) {
            lm.put(s, m.get(s));
        }
        PrintUtil.print(lm);
    }
}
