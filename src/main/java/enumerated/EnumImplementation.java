package enumerated;

import utils.PrintUtil;

/**
 * Created by yuez on 14-1-23
 */
public class EnumImplementation {
    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOS;
        for (int i = 0; i < 10; i++)
            PrintUtil.print(cc.next());
    }
}
