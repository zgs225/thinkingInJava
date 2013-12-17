package typeinfo.nullobject;

/**
 * Created with IntelliJ IDEA.
 * User: yuez
 * Date: 13-12-17
 * Time: 下午9:15
 */
public class Position {
    private String title;
    private Person person;

    public Position(String jobTitle, Person employee) {
        title = jobTitle;
        person = employee;
        if(person == null)
            person = Person.NULL;
    }

    public Position(String jobTitle) {
        title = jobTitle;
        person = Person.NULL;
    }

    public String getTitle() { return title; }

    public Person getPerson() { return person; }

    public void setPerson(Person newPerson) {
        person = newPerson;
        if(person == null)
            person = Person.NULL;
    }

    public String toString() {
        return "Position: " + title + " " + person;
    }
}
