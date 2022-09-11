package lesson2.Task1;
import java.util.*;
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

    private static Person[] RAW_DATA = new Person[]{

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


    public static void main(String[] args) {
        Map<String,List<String>> personMap = Arrays.stream(RAW_DATA)
                .filter(person -> Objects.nonNull(person)&&person.getName()!=null)
                .distinct()
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.mapping(Person::getName,Collectors.toList())));


        Map<String,List<String>> sortedPersonMap = personMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        for (Map.Entry<String,List<String>> entry:sortedPersonMap.entrySet()){
            System.out.println("Key:" + entry.getKey()+ "\nValue: " + entry.getValue().size());
        }


    }
}
