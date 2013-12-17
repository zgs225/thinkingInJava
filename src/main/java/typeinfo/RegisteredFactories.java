package typeinfo;

import utils.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-15
 * Time: 下午8:49
 */
public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            PrintUtil.print(Part.createRandom());
        }
    }
}
