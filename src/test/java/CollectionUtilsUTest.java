import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

/*
Convert elements of a collection to upper case.
 */
public class CollectionUtilsUTest {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");
        Assert.assertEquals(CollectionUtils.transformToUpperCase(collection), expected);
        Assert.assertEquals(CollectionUtils.transformToUpperCase8(collection), expected);
    }

    @Test
    public void transformShouldFilterCollection() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        Assert.assertEquals(CollectionUtils.filterOutLongStrings(collection), expected);
        Assert.assertEquals(CollectionUtils.filterOutLongStrings8(collection), expected);
    }

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");

        long start = System.nanoTime();
        List<String> flatten = CollectionUtils.flatten(collection);
        long lasted = System.nanoTime() - start;
        System.out.println(lasted);

        Assert.assertEquals(flatten, expected);

        long start8 = System.nanoTime();
        List<String> flatten8 = CollectionUtils.flatten8(collection);
        long lasted8 = System.nanoTime() - start8;
        System.out.println(lasted8);

        Assert.assertEquals(flatten8, expected);
    }

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Assert.assertEquals(CollectionUtils.getOldestPerson(collection), eva);
        Assert.assertEquals(CollectionUtils.getOldestPerson8(collection), eva);
    }

    @Test
    public void collectShouldSumUpAllCollectionElements() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        int expected = 1 + 2 + 3 + 4 + 5;

        Assert.assertEquals(CollectionUtils.calculate(numbers), expected);
        Assert.assertEquals(CollectionUtils.calculate8(numbers), expected);
    }

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);

        Map<Boolean, List<Person>> result = CollectionUtils.partitionAdults(collection);
        List<Person> expectedTrue = asList(viktor, eva);
        List<Person> expectedFalse = asList(sara);
        Assert.assertTrue(
                result.get(true).size() == expectedTrue.size()
                        && result.get(true).containsAll(expectedTrue)
                        && expectedTrue.containsAll(result.get(true))
        );
        Assert.assertTrue(
                result.get(false).size() == expectedFalse.size()
                        && result.get(false).containsAll(expectedFalse)
                        && expectedFalse.containsAll(result.get(false))
        );

        Map<Boolean, List<Person>> result8 = CollectionUtils.partitionAdults8(collection);
        Assert.assertTrue(
                result8.get(true).size() == expectedTrue.size()
                        && result8.get(true).containsAll(expectedTrue)
                        && expectedTrue.containsAll(result8.get(true))
        );
        Assert.assertTrue(
                result8.get(false).size() == expectedFalse.size()
                        && result8.get(false).containsAll(expectedFalse)
                        && expectedFalse.containsAll(result8.get(false))
        );
    }

    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        Assert.assertEquals(CollectionUtils.namesToString(collection), "Names: Sara, Viktor, Eva.");
    }

    private long measure(Function function, Collection collection) {
        long start8 = System.nanoTime();
        function.apply(collection);
        return System.nanoTime() - start8;
    }
}