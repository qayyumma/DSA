
    // BFS Traversal
    public void bfs(int s) {
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true; // Mark source as visited
        queue.offer(s);    // Add source to the queue

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int u = queue.poll(); // Dequeue the front node
            System.out.print(u + " ");

            // Process all adjacent nodes
            for (int v : adjList[u]) {
                if (!visited[v]) {
                    visited[v] = true; // Mark as visited
                    queue.offer(v);   // Add to the queue
                }
            }
        }
    }

+++++++++++++++++++++++++++++++++++++BFS Traversal-for-directed-wightage-graph+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.util.*;

public class Graph {
    private LinkedList<Pair>[] adjList;

    // Pair class to store the neighbor node and weight
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Constructor
    public Graph(int nodes) {
        adjList = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an undirected weighted edge
    public void addEdge(int u, int v, int weight) {
        adjList[u].add(new Pair(v, weight)); // Add (v, weight) to the adjacency list of u
        adjList[v].add(new Pair(u, weight)); // Add (u, weight) to the adjacency list of v
    }

    // BFS Traversal
    public void bfs(int startNode) {
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> queue = new LinkedList<>();

        // Start from the given node
        visited[startNode] = true;
        queue.add(startNode);

        System.out.println("BFS Traversal:");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Visit all unvisited neighbors
            for (Pair neighbor : adjList[current]) {
                if (!visited[neighbor.node]) {
                    visited[neighbor.node] = true;
                    queue.add(neighbor.node);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        // Add weighted edges
        g.addEdge(0, 1, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 0, 7);

        // Perform BFS starting from node 0
        g.bfs(0);
    }
}
