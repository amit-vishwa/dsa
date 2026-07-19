package module.two.graph.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Adjacency List Graph:
 * - This is a simple Graph representation using Adjacency List.
 * - The logic consist of directed and undirected graph creation.
 */
public class _2AdjacencyListGraph {

    HashMap<Integer, ArrayList<Integer>> adjList;

    public _2AdjacencyListGraph() {
        this.adjList = new HashMap<>();
    }

    public void add(int src, int des, boolean isDirectedGraph) {
        this.adjList.computeIfAbsent(src, val -> new ArrayList<Integer>()).add(des);
        if (!isDirectedGraph) {
            this.adjList.computeIfAbsent(des, val -> new ArrayList<Integer>()).add(src);
        }
    }

    public void display() {
        for (Integer key : this.adjList.keySet()) {
            System.out.print(key + " -> ");
            System.out.println(this.adjList.get(key));
        }
    }

    public static void main(String[] args) {
        _2AdjacencyListGraph graph = new _2AdjacencyListGraph();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter nodes: ");
        int nodes = sc.nextInt();
        System.out.print("Enter edges: ");
        int edges = sc.nextInt();
        System.out.print("Is Graph Directed: ");
        boolean isDirectedGraph = sc.nextBoolean();
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter source and destination: ");
            int src = sc.nextInt(), des = sc.nextInt();
            if (src < 0 || des < 0 || src >= nodes || des >= nodes) {
                System.out.println("Invalid edge");
                continue;
            }
            graph.add(src, des, isDirectedGraph);
        }
        sc.close();
        graph.display();
    }

}
