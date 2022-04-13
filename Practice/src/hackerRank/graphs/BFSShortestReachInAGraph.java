package hackerRank.graphs;

import java.util.*;

public class BFSShortestReachInAGraph {
    public static class Graph {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int nodesInGraph;
        public Graph(int size) {
            nodesInGraph = size;
            for (int i = 0; i < size; i++) {
                graph.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int first, int second) {
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[nodesInGraph];
            for (int i = 0; i < nodesInGraph ; i++) {
                distances[i] = -1;
            }
            distances[startId] = 0;

            boolean[] traversed = new boolean[nodesInGraph];
            traversed[startId] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(startId);

            while (!queue.isEmpty()){
                startId = queue.poll();
                Iterator<Integer> itr = graph.get(startId).listIterator();
                while(itr.hasNext())
                {
                    int n = itr.next();
                    if(!traversed[n])
                    {
                        traversed[n]= true;
                        queue.add(n);
                        distances[n] = distances[startId] + 6;
                    }
                }
            }
            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        for (int t = 0; t < queries; t++) {
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
