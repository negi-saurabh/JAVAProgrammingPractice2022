package google.kickstart;

import java.util.*;

public class HIndex {
    public static int[] getHIndexScore(int[] citationsPerPaper) {
        int[] hIndex = new int[citationsPerPaper.length];

        // TODO: Add logic to calculate h-index score for each paper
        int totalPapers = citationsPerPaper.length;
        List tempList = new ArrayList();
        Map indexMap = new HashMap();
        for (int i = 0; i < totalPapers; i++) {
            int citation = citationsPerPaper[i];
            if (indexMap.containsKey(citation)) {
                int numberOfTimes = (int) indexMap.get(citation);
                numberOfTimes++;
                indexMap.put(citation, numberOfTimes);
            } else {
                indexMap.put(citation, 1);
            }
        }

        int lastHIndex = 1;
        for (int i = 0; i < totalPapers; i++) {
            Iterator iter = indexMap.keySet().iterator();
            int counter = 0;
            while (iter.hasNext()) {
                int key = (int) iter.next();
                if (key >= citationsPerPaper[i]) {
                    counter = counter + (int)indexMap.get(key);
                }
            }
            if (counter >= citationsPerPaper[i] && citationsPerPaper[i] > lastHIndex) {
                hIndex[i] = counter;
                lastHIndex = counter;
            } else {
                hIndex[i] = lastHIndex;
            }
        }
        return hIndex;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get number of test cases in input
        int testCaseCount = scanner.nextInt();
        // Iterate through test cases
        for (int tc = 1; tc <= testCaseCount; ++tc) {
            // Get number of papers for this test case
            int paperCount = scanner.nextInt();
            // Get number of citations for each paper
            int[] citations = new int[paperCount];
            for (int p = 0; p < paperCount; ++p) {
                citations[p] = scanner.nextInt();
            }
            // Print h-index score after each paper in this test case
            System.out.print("Case #" + tc + ":");
            for (int score : getHIndexScore(citations)) {
                System.out.append(" ").print(score);
            }
            System.out.println();
        }
    }
}

