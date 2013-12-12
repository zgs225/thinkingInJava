package typeinfo;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-12
 * Time: 下午9:13
 */
public class CharArrayIsObject {
    public static void main(String[] args) {
        char[] chars = new char[2];
        PrintSuperClass.print(chars.getClass());
    }
}
