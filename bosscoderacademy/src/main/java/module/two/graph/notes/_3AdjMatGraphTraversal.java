package module.two.graph.notes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Here’s a clean, interview-ready version of your graph using an adjacency matrix, upgraded to support:
 *
 * ✅ Weighted graph
 * ✅ Directed / Undirected
 * ✅ BFS (Breadth-First Search)
 * ✅ DFS (Depth-First Search)
 * ✅ Better input handling & structure
 * */
public class _3AdjMatGraphTraversal {

    private int[][] adjMatrix;
    private int vertices;

    public _3AdjMatGraphTraversal(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Add edge with weight
    public void addEdge(int src, int dest, int weight, boolean isDirected) {
        if (!isValid(src, dest)) return;

        adjMatrix[src][dest] = weight;
        if (!isDirected) {
            adjMatrix[dest][src] = weight;
        }
    }

    // Remove edge
    public void removeEdge(int src, int dest, boolean isDirected) {
        if (!isValid(src, dest)) return;

        adjMatrix[src][dest] = 0;
        if (!isDirected) {
            adjMatrix[dest][src] = 0;
        }
    }

    private boolean isValid(int src, int dest) {
        if (src < 0 || dest < 0 || src >= vertices || dest >= vertices) {
            System.out.println("Invalid vertices!");
            return false;
        }
        return true;
    }

    // Display matrix
    public void display() {
        System.out.println("\nAdjacency Matrix:");
        for (int[] row : adjMatrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // BFS Traversal [TC: O(V^2), SC: O(V^2)]
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }

    // DFS Traversal [TC: O(V^2), SC: O(V^2) + recursion stack]
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[node][i] != 0 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    // Main method (Driver)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        _3AdjMatGraphTraversal graph = new _3AdjMatGraphTraversal(v);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.print("Is directed graph? (1 = Yes, 0 = No): ");
        boolean isDirected = sc.nextInt() == 1;

        for (int i = 0; i < e; i++) {
            System.out.print("Enter (src dest weight): ");
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();

            graph.addEdge(src, dest, weight, isDirected);
        }

        graph.display();

        System.out.print("Enter start node for BFS: ");
        int bfsStart = sc.nextInt();
        graph.bfs(bfsStart);

        System.out.print("Enter start node for DFS: ");
        int dfsStart = sc.nextInt();
        graph.dfs(dfsStart);

        sc.close();
    }
}