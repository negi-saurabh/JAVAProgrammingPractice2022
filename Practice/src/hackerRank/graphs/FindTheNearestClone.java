package hackerRank.graphs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Graph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

public class FindTheNearestClone {
    private static final Scanner scanner = new Scanner(System.in);

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // creating a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer> >(graphNodes);
        for (int i = 0; i < graphNodes; i++)
            adj.add(new ArrayList<Integer>());
        Graph.addEdge(adj, 0, 1);

        return 0;
    }

    public static void main(String[] args) {
        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());
        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }
        long[] ids = new long[graphNodes];
        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }
        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);
        System.out.println(String.valueOf(ans));
        scanner.close();
    }
}
