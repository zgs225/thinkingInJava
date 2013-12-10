package String;

import utils.PrintUtil;

/**
 * User: yuez
 * Date: 13-12-10
 * Time: 下午9:35
 */
public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for(byte b : data) {
            if( n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
        }
        if(n % 16 == 0)
            result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) {
        PrintUtil.print(format("Hex.class".getBytes()));
    }
}
