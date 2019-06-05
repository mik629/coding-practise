import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static List<String> transformToUpperCase(List<String> collection) {
        List<String> res = new ArrayList<>();
        for (String s : collection) {
            res.add(s.toUpperCase());
        }
        return res;
    }

    public static List<String> transformToUpperCase8(List<String> collection) {
        return collection.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<String> filterOutLongStrings(List<String> collection) {
        List<String> res = new ArrayList<>();
        for (String s : collection) {
            if (s.length() < 4) {
                res.add(s);
            }
        }
        return res;
    }

    public static List<String> filterOutLongStrings8(List<String> collection) {
        return collection.stream()
                .filter(s -> s.length() < 4)
                .collect(Collectors.toList());
    }

    public static List<String> flatten(List<List<String>> collection) {
        List<String> res = new ArrayList<>();
        for (List<String> list : collection) {
            res.addAll(list);
        }
        return res;
    }

    public static List<String> flatten8(List<List<String>> collection) {
        return collection.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static Person getOldestPerson(List<Person> people) {
        int maxAge = 0;
        Person oldy = null;
        for (Person person : people) {
            int age = person.getAge();
            if (age > maxAge) {
                maxAge = age;
                oldy = person;
            }
        }
        return oldy;
    }

    public static Person getOldestPerson8(List<Person> people) {
        return people.stream().max(Comparator.comparingInt(Person::getAge)).get();
    }

    public static int calculate(List<Integer> collection) {
        int sum = 0;
        for (Integer num : collection) {
            sum += num;
        }
        return sum;
    }

    public static int calculate8(List<Integer> collection) {
        return collection.stream().reduce(0, Integer::sum);
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> collection) {
        Map<Boolean, List<Person>> res = new HashMap<>();
        res.put(true, new ArrayList<>());
        res.put(false, new ArrayList<>());
        for (Person person : collection) {
            res.get(person.getAge() >= 18).add(person);
        }
        return res;
    }

    public static Map<Boolean, List<Person>> partitionAdults8(List<Person> collection) {
        return collection.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
    }

    public static String namesToString(List<Person> people) {
        return "Names: " +
                people.stream()
                        .map(Person::getName)
                        .collect(Collectors.joining(", ")) + ".";
    }
}
