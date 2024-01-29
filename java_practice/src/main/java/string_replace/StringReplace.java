package java.string_replace;

public class StringReplace {
    public static void main(String[] args) {

//        Case 1.
//        Expected result: helloEternityAloha1234
//        String input = "helloWorldAloha1234";
//        String replace = "World";
//        String newSequence = "Eternity";

//        Case 2.
//        Expected result: helloEternityAlohaEternity1234
        String input = "helloWorldAlohaWorld1234";
        String replace = "World";
        String newSequence = "Eternity";

//        Case 3.
//        Expected result: helloAloha1234
//        String input = "helloAloha1234";
//        String replace = "World";
//        String newSequence = "Eternity";

//        Case 4.
//        Expected result: hello1234
//        String input = "helloAloha1234";
//        String replace = "Aloha";
//        String newSequence = "";

//        Case 5.
//        Expected result:
//        String input = "helloAloha1234";
//        String replace = "helloAloha1234";
//        String newSequence = "";

//        Case 6.
//        Expected result: ""
//        String input = "";
//        String replace = "hello";
//        String newSequence = "aloha";

        char[] inputChars = input.toCharArray();
        char[] replaceChars = replace.toCharArray();
        char[] newSequenceChars = newSequence.toCharArray();

        char[] changedChars = replace(inputChars, replaceChars, newSequenceChars);
        String result = new String(changedChars);

        String resultMessage = String.format("Result: %s", result);
        System.out.println(resultMessage);
    }

    private static char[] replace(char[] input, char[] replace, char[] newSequence) {
        char[] result = input;
        while (getSubstringPosition(result, replace) != -1) {
            result = replaceFirstOccurrence(result, replace, newSequence);
        }

        return result;
    }

    private static char[] replaceFirstOccurrence(char[] input, char[] replace, char[] newSequence) {
        if (replace.length == 0) {
            throw new IllegalArgumentException("Replace string is empty");
        }

        int startIndex = getSubstringPosition(input, replace);

        if (startIndex != -1) {
            char[] leftPart = getSubstring(input, 0, startIndex);

            int endIndex = startIndex + replace.length;
            char[] rightPart = getSubstring(input, endIndex, input.length);

            int resultLength = input.length - replace.length + newSequence.length;
            char[] result = new char[resultLength];

            System.arraycopy(leftPart, 0, result, 0, leftPart.length);
            System.arraycopy(newSequence, 0, result, leftPart.length, newSequence.length);
            System.arraycopy(rightPart, 0, result, leftPart.length + newSequence.length, rightPart.length);

            return result;
        }

        return input;
    }

    private static int getSubstringPosition(char[] input, char[] substring) {
        if (substring.length == 0) {
            throw new IllegalArgumentException("Substring is empty");
        }

        int startIndex = -1;

        for (int i = 0; i < input.length; i++) {
            char currentChar = input[i];

            int substringIndex = 0;
            if (currentChar == substring[substringIndex]) {
                startIndex = i;
            }

            while (currentChar == substring[substringIndex]) {
                substringIndex++;

                int nextInputIndex = i + substringIndex;
                if (nextInputIndex >= input.length || substringIndex >= substring.length) {
                    return startIndex;
                }

                currentChar = input[nextInputIndex];
            }
        }

        return startIndex;
    }

    private static char[] getSubstring(char[] input, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            throw new IllegalArgumentException("Start index is grater then end index");
        }

        if (endIndex > input.length || endIndex < 0) {
            throw new IllegalArgumentException("End index is too big or too small");
        }

        if (startIndex < 0) {
            throw new IllegalArgumentException("Start index is too small");
        }

        int resultLength = endIndex - startIndex;
        char[] result = new char[resultLength];

        for (int i = 0; i < result.length; i++) {

            int inputIndex = startIndex + i;
            result[i] = input[inputIndex];
        }

        return result;
    }
}
