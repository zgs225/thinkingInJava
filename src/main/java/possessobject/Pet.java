package possessobject;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-3
 * Time: 下午9:04
 */
public class Pet {
    private static final int DEFAULT_NUMBER = 10;
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public static ArrayList<Pet> arrayList() {
        return Pet.arrayList(DEFAULT_NUMBER);
    }

    public static ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> pets = new ArrayList<Pet>();
        for(int i=0; i<size; i++) {
            pets.add(new Pet("Pet " + String.valueOf(i)));
        }
        return pets;
    }

    public static List<Pet> subList(int begin, int end, List<Pet> pets) {
        if(begin >= pets.size() || end >= pets.size()) throw new IndexOutOfBoundsException();
        List<Pet> l = new ArrayList<Pet>();
        for(int i=begin; i<end; i++) {
            l.add(pets.get(i));
        }
        return l;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = Pet.arrayList();
        PrintUtil.print(pets);
        List subList = Pet.subList(0, 5, pets);
        PrintUtil.print(subList);
        pets.removeAll(subList);
        PrintUtil.print(pets);
    }
}
