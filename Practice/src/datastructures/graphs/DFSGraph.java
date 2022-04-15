package datastructures.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {

    private int V;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private boolean[] visited ;
    public DFSGraph(int nodes){
        V = nodes;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[V];
    }

    void addEdge(int u, int v){
        adj.get(u).add(v);
    }

    public void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        Iterator<Integer> i = adj.get(start).listIterator();
        while (i.hasNext()){
            int currentNode = i.next();
            boolean b = visited[currentNode];
            if(!b)
            {
                DFS(currentNode);
            }
        }
    }

    public static void main(String[] args) {
        int nodes = 4;
        DFSGraph graph = new DFSGraph(nodes);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        graph.DFS(2);
    }
}
