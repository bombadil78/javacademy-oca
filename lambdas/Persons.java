import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Persons {

    private final List<Person> persons = new ArrayList<>();

    public Persons() {
        persons.addAll(Arrays.asList(
                new Person("Amanda", "Pettersson", 4),
                new Person("Sebastian", "Pettersson", 6),
                new Person("Tina", "Pettersson", 39),
                new Person("Christoph", "Keller", 39)
        ));
    }

    public void process(Predicate<Person> filter, Consumer<Person> action) {
        persons.stream()
                .filter(x -> filter.test(x))
                .forEach(x -> action.accept(x));
    }

    public static void main(String[] args) {
        new Persons().process(x -> x.getAge() == 39, System.out::println);
        new Persons().process(x -> x.getFirstName().equals("Sebastian"), x -> {});
    }
}

class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", firstName, lastName, age);
    }
}