package hackerRank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NewYearChaos {

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribeSum = 0;
        boolean chaotic = false;
        for (int i = 0 ; i < q.size() ; i++){
            if(q.get(i) - (i+1)  > 2) {
                chaotic = true;
                break;
            }
            int initialPoint = Math.max(0, q.get(i)-2);
            for(int j = initialPoint ; j < i ; j++)
            {
                if(q.get(j) > q.get(i))
                    bribeSum++;
            }

        }
        if(chaotic)
            System.out.println("Too chaotic");
        else
            System.out.println(bribeSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> q = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qTemp[i]);
                q.add(qItem);
            }

            NewYearChaos.minimumBribes(q);
        }

        bufferedReader.close();
    }
}
