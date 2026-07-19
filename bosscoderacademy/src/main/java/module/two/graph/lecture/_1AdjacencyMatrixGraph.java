package module.two.graph.lecture;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Adjacency Matrix Graph:
 * - This is a simple Graph representation using Adjacency Matrix.
 * - The logic consist of directed and undirected graph creation.
 */
public class _1AdjacencyMatrixGraph {

    ArrayList<ArrayList<Integer>> adjMatrix;

    public _1AdjacencyMatrixGraph(int size) {
        this.adjMatrix = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(0);
            }
            this.adjMatrix.add(row);
        }
    }

    public void add(int row, int col, boolean isDirectedGraph) {
        if (row < 0 || col < 0 || row >= this.adjMatrix.size() || col >= this.adjMatrix.size()) {
            System.out.println("Invalid row or col");
            return;
        }
        this.adjMatrix.get(row).set(col, 1);
        if (!isDirectedGraph) {
            this.adjMatrix.get(col).set(row, 1);
        }
    }

    public void display() {
        for (ArrayList<Integer> row : adjMatrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int nodes = sc.nextInt();
        _1AdjacencyMatrixGraph graph = new _1AdjacencyMatrixGraph(nodes);
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();
        System.out.print("Is directed graph: ");
        boolean isDirectedGraph = sc.nextBoolean();
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter source and destination: ");
            int row = sc.nextInt(), col = sc.nextInt();
            graph.add(row, col, isDirectedGraph);
        }
        sc.close();
        graph.display();
    }

}
