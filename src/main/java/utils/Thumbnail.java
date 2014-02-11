package utils;

/**
 * @author <a href="http://yuez.me">yuez</a> created at 14-2-3
 * @version 0.1
 *          Used to make image thumbnail through console
 */
public class Thumbnail {
    private int width = 100;  // Default thumbnail width
    private int height = 100; // Default thumbnail height

    public static void main(String[] args) {
        if (args.length == 0) {
            // 如果没有任何参数，则打印工具使用方法
            PrintUtil.print("Usage: java Thumbnail [options] file...");
            PrintUtil.print("Option: ");
            PrintUtil.print("w: width");
            PrintUtil.print("h: height");
        }
    }
}
