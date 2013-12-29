package generics;

import utils.PrintUtil;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-19
 * Time: 下午9:17
 */
public class BankTeller {
    public static void serve(Teller t, Customer c) {
        PrintUtil.print(t + " serve " + c);
    }

    public static void main(String[] args) {
        Random random = new Random(23);
        Queue<Customer> line = new LinkedList<Customer>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<Teller>();
        Generators.fill(tellers, Teller.generator(), 4);
        for(Customer c : line)
            serve(tellers.get(random.nextInt(tellers.size())), c);
    }
}

class Customer {
    private static long counter = 1;
    private final long id = counter ++;
    private Customer() {}
    public String toString() { return "Customer " + id; }

    public static Generator<Customer> generator() {
        return new Generator<Customer>() {
            @Override
            public Customer next() { return new Customer(); }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter ++;
    private Teller() {}
    public String toString() { return "Teller " + id; }

    public static Generator<Teller> generator() {
        return new Generator<Teller>() {
            @Override
            public Teller next() { return new Teller(); }
        };
    }
}
