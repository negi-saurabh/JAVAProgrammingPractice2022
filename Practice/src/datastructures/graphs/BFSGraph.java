package datastructures.graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class BFSGraph {
    private int V;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public BFSGraph(int nodes){
        V = nodes;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        adj.get(u).add(v);
    }

    void BFS(int start){
        boolean[] visited = new boolean[V];
        ArrayList<Integer> queue  = new ArrayList<>();
        visited[start] = true;
        queue.add(start);
        for (int i = 0; i < queue.size(); i++) {
            start = queue.get(i);
            System.out.println(start);
            Iterator<Integer> itr = adj.get(start).listIterator();
            while(itr.hasNext())
            {
                    int n = itr.next();
                    if(!visited[n])
                    {
                        visited[n]= true;
                        queue.add(n);
                    }
            }
        }
    }

    public static void main(String[] args) {
        int nodes = 4;
        BFSGraph graph = new BFSGraph(nodes);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        graph.BFS(2);
    }

}
