package hackerRank.stringmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class AlternatingCharacters {

    public static int alternatingCharacters(String s) {
        // Write your code here
        int count =0;
        for (int i=0; i < s.length()-1 ; i++) {
                if(s.charAt(i) == s.charAt(i+1))
                    count++;
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();
                int result = alternatingCharacters(s);
                System.out.println(String.valueOf(result));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }
    }
