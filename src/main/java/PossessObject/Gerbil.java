package PossessObject;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gerbil {
    private static long counter;
    private int gerbilNumber;

    public Gerbil() {
        this.gerbilNumber = (int) counter ++;
    }

    public void hope() {
        System.out.println("I'm Gerbil No." + this.gerbilNumber + ", I'm jumping");
    }

    public static void hope(Iterator<Gerbil> it) {
        while(it.hasNext()) {
            PrintUtil.print(it.next());
        }
    }

    @Override
    public String toString() {
        return "I'm Gerbil No." + this.gerbilNumber + ", I'm jumping";
    }

    public static void main(String[] args) {
        List<Gerbil> gerbils = new ArrayList<Gerbil>();
        for(int i=0; i<5; i++) {
            gerbils.add(new Gerbil());
        }

        for(Gerbil b : gerbils) {
            b.hope();
        }

        Gerbil.hope(gerbils.iterator());
    }
}