package hackerRank.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DFSConnectedCellinAGrid {

    public static int maxRegion(List<List<Integer>> grid) {
        // Write your code here
        return 2;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int m = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] gridRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> gridRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowTempItems[j]);
                gridRowItems.add(gridItem);
            }

            grid.add(gridRowItems);
        }
        int res = maxRegion(grid);
        System.out.println(String.valueOf(res));
        bufferedReader.close();
    }
}
