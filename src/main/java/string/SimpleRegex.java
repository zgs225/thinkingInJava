package string;

import utils.PrintUtil;

import java.util.regex.Pattern;

/**
 * User: yuez
 * Date: 13-12-11
 * Time: 下午8:20
 */
public class SimpleRegex {
    public static void main(String[] args) {
        PrintUtil.print(validate("A32."));
        PrintUtil.print(validate("a32."));
        PrintUtil.print(validate("^A23."));
    }

    public static boolean validate(String v) {
        Pattern p = Pattern.compile("^[A-Z].*\\.$");
        return p.matcher(v).find();
    }
}
