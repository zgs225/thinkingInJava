package string;

import utils.PrintUtil;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-11
 * Time: 下午9:20
 */
public class BetterReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.61803")));
        PrintUtil.print("What your name?");
        String name = scanner.nextLine();
        PrintUtil.print(name);
        PrintUtil.print("How old are you? What's your favorite double?");
        PrintUtil.print("(input: <age> <double>)");
        int age = scanner.nextInt();
        double favorite = scanner.nextDouble();
        PrintUtil.print(age);
        PrintUtil.print(favorite);
        System.out.format("Hi %s.\n", name);
        System.out.format("In 5 years you will be %d.\n", age);
        System.out.format("My favorite double is %f.", favorite);
    }
}
