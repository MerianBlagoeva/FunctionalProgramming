package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterByAge {

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Function<Scanner, Person> readPerson = scanner -> {
            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            return new Person(name, age);
        };

//        List<Person> people = IntStream.range(0, n)
//                .mapToObj(i -> readPerson.apply(sc))
//                .collect(Collectors.toList());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Person p = readPerson.apply(sc);
            people.add(p);
        }

        String condition = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        Predicate<Person> ageFilter = getFilter(condition, age);
        Consumer<Person> printer = getPrinter(format);

        people.stream()
                .filter(ageFilter)
                .forEach(printer);

    }

    private static Consumer<Person> getPrinter(String format) {
        return switch (format) {
            case "name" -> p -> System.out.println(p.name);
            case "age" -> p -> System.out.println(p.age);
            case "name age" -> p -> System.out.printf("%s - %d%n", p.name, p.age);
            default -> throw new IllegalArgumentException("Unknown print format " + format);
        };
    }

    private static Predicate<Person> getFilter(String condition, int age) {
        return switch (condition) {
            case "older" -> p -> p.age >= age;
            case "younger" -> p -> p.age <= age;
            default -> throw new IllegalArgumentException("Unknown condition " + condition);
        };
    }
}
