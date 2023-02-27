package jni;

import java.util.ArrayList;
import java.util.List;

public class NativeApiTest {

    private static final NativeApi TEST_INSTANCE = new NativeApi();

    public static void main(String[] args) {
        testSumIntegers();
        testSayHelloToMeOnFemale();
        testSayHelloToMeOnMale();
        testSayHelloToMeOnEmptyName();
    }

    private static void testSumIntegers() {
        List<List<Integer>> testCases = new ArrayList<>();
        testCases.add(List.of(1, 2, 3));
        testCases.add(List.of(3, 2, 5));
        testCases.add(List.of(2, 1, 3));
        testCases.add(List.of(0, 0, 0));

        testCases.forEach(testCase -> {
            int first = testCase.get(0);
            int second = testCase.get(1);
            int expected = testCase.get(2);

            int actual = TEST_INSTANCE.sumIntegers(first, second);

            assertEquals(actual, expected);
        });

        System.out.println("'testSumIntegers' is pass");
    }

    private static void testSayHelloToMeOnFemale() {
        String name = "name";
        boolean isFemale = true;

        String actual = TEST_INSTANCE.sayHelloToMe(name, isFemale);

        String expected = "Hello Ms. name!!!";
        assertEquals(actual, expected);

        System.out.println("'testSayHelloToMeOnFemale' is pass");
    }

    private static void testSayHelloToMeOnMale() {
        String name = "name";
        boolean isFemale = false;

        String actual = TEST_INSTANCE.sayHelloToMe(name, isFemale);

        String expected = "Hello Mr. name!!!";
        assertEquals(actual, expected);

        System.out.println("'testSayHelloToMeOnMale' is pass");
    }

    private static void testSayHelloToMeOnEmptyName() {
        String name = "";
        boolean isFemale = false;

        String actual = TEST_INSTANCE.sayHelloToMe(name, isFemale);

        String expected = "Hello Mr. !!!";
        assertEquals(actual, expected);

        System.out.println("'testSayHelloToMeOnEmptyName' is pass");
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) {
            String messagePattern = "Actual: '%d'\nExpected: '%d'";
            String message = String.format(messagePattern, actual, expected);
            throw new AssertionError(message);
        }
    }

    private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            String messagePattern = "\nActual: '%s'\nExpected: '%s'";
            String message = String.format(messagePattern, actual, expected);
            throw new AssertionError(message);
        }
    }
}
