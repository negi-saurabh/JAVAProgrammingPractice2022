package google.kickstart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpeedTyping {

    private static int getChanges(String actual, String sheWrote) {
        Map<Character, Integer> charCount = new HashMap<>();
        int totalCount = 0;
        for (int i = 0; i < sheWrote.length(); i++) {
            char currentChar = sheWrote.charAt(i);
            if (charCount.containsKey(currentChar)) {
                int numberOfTimes = charCount.get(currentChar);
                numberOfTimes = numberOfTimes + 1;
                charCount.put(currentChar, numberOfTimes);
            } else {
                charCount.put(currentChar, 1);
            }
        }

        for (int i = 0; i < actual.length(); i++) {
            char currentChar = actual.charAt(i);
            if (charCount.containsKey(currentChar)) {
                int numberOfTimes = charCount.get(currentChar);
                numberOfTimes = numberOfTimes - 1;
                if (numberOfTimes == 0) {
                    charCount.remove(currentChar);
                } else {
                    charCount.put(currentChar, numberOfTimes);
                }
            } else {
                return -1;
            }
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            totalCount = totalCount + entry.getValue();
        }
        return totalCount;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();

            for (int t = 1; t <= T; ++t) {
                String actual = in.next();
                String sheWrote = in.next();
                int mistakes = getChanges(actual, sheWrote);
                if (mistakes == -1) {
                    System.out.println("Case #" + t + ": " + "IMPOSSIBLE");
                } else
                    System.out.println("Case #" + t + ": " + mistakes);

            }
        }
    }
}
