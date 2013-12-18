package generics;

import utils.PrintUtil;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-18
 * Time: 下午8:32
 */
public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("Hi", 23);
    }

    static TwoTuple<Amphibian, Vehicle> g() {
        return new TwoTuple<Amphibian, Vehicle>(new Amphibian(), new Vehicle());
    }

    public static void main(String[] args) {
        PrintUtil.print(f());
        PrintUtil.print(g());
    }
}

class Amphibian{}

class Vehicle{}
