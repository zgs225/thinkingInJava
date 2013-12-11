package string;

import java.util.Formatter;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-10
 * Time: 下午9:00
 */
public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f    = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d, %d)\n", name, x, y);
    }

    public static void main(String[] args) {
        Turtle tommy = new Turtle("tommy", new Formatter(System.err));
        Turtle terry = new Turtle("terry", new Formatter(System.out));
        tommy.move(1, 2);
        terry.move(2, 3);
        tommy.move(5, 6);
        terry.move(4, 7);
    }
}
