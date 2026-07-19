package module.two.graph.notes;

import java.util.*;

/**
 * Below is a clean, production-quality Java version of a weighted adjacency list graph that includes:
 * <p>
 * ✅ Weighted graph ((neighbor, weight))
 * ✅ Directed / Undirected support
 * ✅ BFS & DFS
 * ✅ Cycle Detection
 * Undirected → DFS with parent
 * Directed → DFS with recursion stack
 * ✅ Dijkstra’s Algorithm (shortest path)
 * ✅ Topological Sort (Kahn’s Algorithm – BFS)
 */
public class _4AdjListGraphTraversal {

    // Edge class for weighted graph
    static class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    private int vertices;
    private ArrayList<ArrayList<Edge>> adjList;

    public _4AdjListGraphTraversal(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add Edge
    public void addEdge(int src, int dest, int weight, boolean isDirected) {
        if (!isValid(src, dest)) return;

        adjList.get(src).add(new Edge(dest, weight));

        if (!isDirected) {
            adjList.get(dest).add(new Edge(src, weight));
        }
    }

    private boolean isValid(int src, int dest) {
        if (src < 0 || dest < 0 || src >= vertices || dest >= vertices) {
            System.out.println("Invalid vertices!");
            return false;
        }
        return true;
    }

    // Display Graph
    public void display() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (Edge e : adjList.get(i)) {
                System.out.print("(" + e.dest + ", " + e.weight + ") ");
            }
            System.out.println();
        }
    }

    // BFS [TC: O(V+E), SC: O(V+E)]
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (Edge e : adjList.get(node)) {
                if (!visited[e.dest]) {
                    visited[e.dest] = true;
                    queue.offer(e.dest);
                }
            }
        }
        System.out.println();
    }

    // DFS [TC: O(V+E), SC: O(V+E)]
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (Edge e : adjList.get(node)) {
            if (!visited[e.dest]) {
                dfsUtil(e.dest, visited);
            }
        }
    }

    // ================= Cycle Detection (Undirected) =================
    public boolean hasCycleUndirected() {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfsCycleUndirected(i, visited, -1)) return true;
            }
        }
        return false;
    }

    private boolean dfsCycleUndirected(int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (Edge e : adjList.get(node)) {
            int neighbor = e.dest;

            if (!visited[neighbor]) {
                if (dfsCycleUndirected(neighbor, visited, node)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // ================= Cycle Detection (Directed) =================
    public boolean hasCycleDirected() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (dfsCycleDirected(i, visited, recStack)) return true;
        }
        return false;
    }

    private boolean dfsCycleDirected(int node, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for (Edge e : adjList.get(node)) {
            if (dfsCycleDirected(e.dest, visited, recStack)) return true;
        }

        recStack[node] = false;
        return false;
    }

    // ================= Dijkstra =================
    public void dijkstra(int start) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int currDist = curr[1];

            for (Edge e : adjList.get(node)) {
                int newDist = currDist + e.weight;

                if (newDist < dist[e.dest]) {
                    dist[e.dest] = newDist;
                    pq.offer(new int[]{e.dest, newDist});
                }
            }
        }

        System.out.println("Shortest distances from " + start + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println(start + " -> " + i + " = " + dist[i]);
        }
    }

    // ================= Topological Sort (Kahn's Algorithm) =================
    public void topologicalSort() {
        int[] indegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            for (Edge e : adjList.get(i)) {
                indegree[e.dest]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);

            for (Edge e : adjList.get(node)) {
                if (--indegree[e.dest] == 0) {
                    queue.offer(e.dest);
                }
            }
        }

        if (topoOrder.size() != vertices) {
            System.out.println("Cycle detected! Topological sort not possible.");
        } else {
            System.out.println("Topological Order: " + topoOrder);
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices: ");
        int v = sc.nextInt();

        _4AdjListGraphTraversal graph = new _4AdjListGraphTraversal(v);

        System.out.print("Enter edges: ");
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

        graph.bfs(0);
        graph.dfs(0);

        System.out.println("Cycle (Undirected): " + graph.hasCycleUndirected());
        System.out.println("Cycle (Directed): " + graph.hasCycleDirected());

        graph.dijkstra(0);

        if (isDirected) {
            graph.topologicalSort();
        }

        sc.close();
    }
}