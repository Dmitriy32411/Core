package lesson2.Task1;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    private static Person[] RAW_DATA = /**null;*/
            new Person[]{

            null,

            new Person(0, null),
            new Person(0, "Harry"),

            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),

    };

    public static Predicate <Person> noNullPerson= Objects::nonNull;
    public static Predicate <Person> noNullName= person->person.getName()!=null;
    public static Predicate <Person> noNull= noNullPerson.and(noNullName);
    static boolean ThisArrayIsNull(Person[] array) {
        return array != null;
    }

    public static void main(String[] args) {

       if (ThisArrayIsNull(RAW_DATA)){
           Map<String,List<String>> personMap = Arrays.stream(RAW_DATA)
                   .filter(noNull)
                   .distinct()
                   .sorted(Comparator.comparing(Person::getName))
                   .collect(Collectors.groupingBy(Person::getName,
                           Collectors.mapping(Person::getName,Collectors.toList())));

           Map<String,List<String>> sortedPersonMap = personMap.entrySet().stream()
                   .sorted(Map.Entry.comparingByKey())
                   .peek(person-> System.out.println("Key:" + person.getKey()+ "\nValue: " + person.getValue().size()))
                   .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
       }System.out.println("This array is NULL.");


    }

}
