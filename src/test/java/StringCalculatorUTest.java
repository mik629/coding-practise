import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorUTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void addEmptyString() {
        Assert.assertEquals(StringCalculator.add(""), 0);
    }

    @Test
    public void addOneString() {
        Assert.assertEquals(StringCalculator.add("1"), 1);
    }

    @Test
    public void addTwoCommaSeparatedStrings() {
        Assert.assertEquals(StringCalculator.add("1,2"), 3);
    }

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }

    @Test
    public void addMultipleCommaSeparatedStrings() {
        Assert.assertEquals(StringCalculator.add("1,2,5,7,9"), 24);
    }

    @Test
    public void addMultipleMixedSeparatorStrings() {
        Assert.assertEquals(StringCalculator.add("1,3\n5,7\n9"), 25);
    }

    @Test
    public void addMultipleCustomDelimeterSeparatedStrings() {
        Assert.assertEquals(StringCalculator.add("//;\n1;2;4;7;8"), 22);
    }

    @Test
    public void addNegativeStringsThrowsException() {
        expectedEx.expect(UnsupportedOperationException.class);
        expectedEx.expectMessage("negatives -1,-4,-8 are not allowed");

        StringCalculator.add("//;\n-1;2;-4;7;-8");
    }

    @Test
    public void addHugeIgnoredStrings() {
        Assert.assertEquals(StringCalculator.add("//;\n1;1001;2;5000;4;7;8"), 22);
    }

    @Test
    public void addLongDelimiterSeparatedStrings() {
        Assert.assertEquals(StringCalculator.add("//---\n1---2---5---5---8"), 21);
    }
}
