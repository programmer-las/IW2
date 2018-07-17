import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.*;

public class MultipleProcedTest {

    /**
     * test 15/5
     */
    @Test
    public void multiple() {

        Multiple multiple = new Multiple();
        multiple.setDivided(15);
        multiple.setDivider(5);
//        int actual = multiple.multiple(15,5);
        int actual = multiple.multiple();
        int expected = 0;
        assertEquals(actual, expected);
    }

    /**
     * test divided/0
     */
    @Test
    public void Multiple2() {
        Multiple multiple = new Multiple();
        int actual = 0;
        multiple.setDivided(5);
        multiple.setDivider(0);
        try {
//            actual = multiple.multiple(5,0);
            actual = multiple.multiple();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            int expected = -1;
            assertEquals(expected, actual);
        }
    }

    /**
     * test 0/divider
     */
    @Test
    public void Multiple4() {
        Multiple multiple = new Multiple();
        multiple.setDivided(0);
        multiple.setDivider(5);
//            int actual = multiple.multiple(0,5);
        int actual = multiple.multiple();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void isMultipleTrue() {
        Multiple multiple = new Multiple();
        multiple.setDivided(15);
        multiple.setDivider(5);
        boolean actual = multiple.isMultiple();
        assertTrue(actual);
    }

    @Test
    public void isMultipleFalse() {
        Multiple multiple = new Multiple();
        multiple.setDivided(9);
        multiple.setDivider(5);
        boolean actual = multiple.isMultiple();
        assertFalse(actual);
    }

    @Test
    public void multipleFrom1ToN() {
        Multiple multiple = new Multiple();
        Map<Integer, String> dividerMap = new HashMap<>();
        /*Use for testing divide at 0
        dividerMap.put(0, "zerro");*/
        dividerMap.put(3, "three");
        dividerMap.put(5, "five");
        multiple.setDividerMap(dividerMap);
        multiple.setDividedMax(15);
        multiple.multipleFrom1ToN();
        List<Integer> actual = multiple.getListOfMultipleIntegers();
        List<Integer> expected = Arrays.asList(3, 5, 6, 9, 10, 12, 15, 15);
        assertEquals(expected, actual);
    }
}