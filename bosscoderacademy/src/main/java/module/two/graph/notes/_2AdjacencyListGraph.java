package module.two.graph.notes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Adjacency List Representation:
 * <p>
 * An adjacency list representation for the graph associates each vertex in the graph with the collection of its neighboring
 * vertices or edges, i.e., every vertex stores a list of adjacent vertices. There are many variations of adjacency list
 * representation depending upon the implementation. This data structure allows the storage of additional data on the vertices
 * but is practically very efficient when the graph contains only a few edges. i.e. the graph is sparse.
 */
public class _2AdjacencyListGraph {

    ArrayList<ArrayList<Integer>> adjList;
    int vertices;

    public _2AdjacencyListGraph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int des, boolean isDigraph) {
        if (!isValidEdge(src, des)) return;
        this.adjList.get(src).add(des);
        if (!isDigraph) {
            this.adjList.get(des).add(src);
        }
    }

    public void removeEdge(int src, int des, boolean isDigraph) {
        if (!isValidEdge(src, des)) return;
        this.adjList.get(src).remove(Integer.valueOf(des));
        if (!isDigraph) {
            this.adjList.get(des).remove(Integer.valueOf(src));
        }
    }

    private boolean isValidEdge(int src, int des) {
        if (src < 0 || des < 0 || src >= this.vertices || des >= this.vertices) {
            System.out.println("Invalid edge");
            return false;
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < this.vertices; i++) {
            System.out.println(i + " -> " + this.adjList.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vertices: ");
        int vertices = sc.nextInt();
        _2AdjacencyListGraph graph = new _2AdjacencyListGraph(vertices);
        System.out.print("Enter edges: ");
        int edges = sc.nextInt();
        System.out.print("Is directed graph: ");
        boolean isDigraph = sc.nextInt() == 1;
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter source and destination: ");
            int src = sc.nextInt(), des = sc.nextInt();
            graph.addEdge(src, des, isDigraph);
        }
        graph.display();
        sc.close();
    }

}
