package module.two.graph.notes;

import java.util.Scanner;

/**
 * Adjacency Matrix Representation:
 * <p>
 * For a simple unweighted graph with a vertex set V, the adjacency matrix is a square |V| × |V| matrix A such that its element:
 * <p>
 * Aij = 1, when there is an edge from the vertex i to vertex j, and
 * Aij = 0, when there is no edge.
 * <p>
 * Each row in the matrix represents source vertices, and each column represents destination vertices. The diagonal elements of
 * the matrix are all zero since edges from a vertex to itself, i.e., loops are not allowed in simple graphs. If the graph is
 * undirected, the adjacency matrix will be symmetric. Also, for a weighted graph, Aij can represent edge weights.
 */
public class _1AdjacencyMatrixGraph {

    int[][] adjMatrix;
    int vertices;

    public _1AdjacencyMatrixGraph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int row, int col, boolean isDigraph) {
        updateGraph(row, col, isDigraph, 1);
    }

    public void removeEdge(int row, int col, boolean isDigraph) {
        updateGraph(row, col, isDigraph, 0);
    }

    private void updateGraph(int row, int col, boolean isDigraph, int val) {
        if (row < 0 || col < 0 || row >= this.vertices || col >= this.vertices) {
            System.out.println("Invalid edge");
            return;
        }
        this.adjMatrix[row][col] = val;
        if (!isDigraph) {
            this.adjMatrix[col][row] = val;
        }
    }

    public void display() {
        for (int[] row : this.adjMatrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        _1AdjacencyMatrixGraph graph = new _1AdjacencyMatrixGraph(vertices);
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        System.out.print("Is direct graph: ");
        boolean isDigraph = sc.nextBoolean();
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter endpoints: ");
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph.addEdge(start, end, isDigraph);
        }
        graph.display();
        sc.close();
    }

}
