package typeinfo.nullobject;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-17
 * Time: 下午9:06
 */
class Person {
    public final String first;
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null {
        private NullPerson() { super("None", "None", "None"); }
        public String toString() { return "NullPerson"; }
    }

    public static final Person NULL = new NullPerson();
}
