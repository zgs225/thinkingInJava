import generics.Generator;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import utils.CountingGenerator;

import static java.lang.System.out;

/**
 * Created by yuez on 14-1-6.
 * Test CountingGenerator
 */
@RunWith(JUnit4.class)
public class GeneratorTest {
    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            out.print(type.getSimpleName() + ": ");
            try {
                Generator<?> generator = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++)
                    out.printf(generator.next() + " ");
                out.println();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
    }
}
