package PossessObject;

import utils.PrintUtil;

import java.util.*;

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
        Map<String, Gerbil> gerbilMap = new HashMap<String, Gerbil>();
        for(int i=0; i<5; i++) {
            gerbilMap.put("gerbil" + String.valueOf(i), new Gerbil());
        }
        Set<String> names = gerbilMap.keySet();
        for (String key : names) {
            PrintUtil.print(key);
            gerbilMap.get(key).hope();
        }
    }
}