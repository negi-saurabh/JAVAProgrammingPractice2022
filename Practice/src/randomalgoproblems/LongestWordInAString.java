package randomalgoproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LongestWordInAString {

    private String getLongestWordWayOne(String input) {

        // return longest word
        // need an maxword variable which stores
        // need a datatype to store build up strings
        // space would mean break and need to flush the generated string

        // algo
        // convert to char array
        // iterate over it
        // create words unless space is reached
        // think about boundary conditon like the last
        StringBuffer buffer = new StringBuffer();
        int maxlength = 0;
        String maxWord = input.split(" ")[0];
        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                if (buffer.length() > maxlength) {
                    maxlength = buffer.length();
                    maxWord = buffer.toString();
                }
                buffer.setLength(0);
            } else
                buffer.append(c);
        }

        return maxWord;
    }

    private String getLongestWordWayTwo(String input) {

        String[] arr = input.split(" ");
        System.out.println(arr);
        return Arrays.stream(arr).max(Comparator.comparingInt(String::length)).orElse(null);
    }

    public static void main(String[] args) {
        LongestWordInAString checking = new LongestWordInAString();
        String longestOne = checking.getLongestWordWayOne("The quick brown fox jumped extraordinarily high");
        String longestTwo = checking.getLongestWordWayTwo("42 The quick brown fox jumped extraordinarily high");
        System.out.println("longestOne. " + longestOne);
        System.out.println("longestTwo. " + longestTwo);

    }

}
