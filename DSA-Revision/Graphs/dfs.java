==========Iterative==========

public void dfsIterative(int startNode) {
    boolean[] visited = new boolean[adjList.length]; // Track visited nodes
    Stack<Integer> stack = new Stack<>();

    stack.push(startNode); // Start with the initial node
    System.out.println("DFS Traversal (Iterative):");

    while (!stack.isEmpty()) {
        int node = stack.pop();

        if (!visited[node]) {
            visited[node] = true; // Mark node as visited
            System.out.print(node + " "); // Print the node

            // Push all unvisited neighbors onto the stack
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}



=============Weightage=Recursive=Graph===============

import java.util.*;

public class Graph {
    private LinkedList<Integer>[] adjList;

    // Constructor to initialize the adjacency list
    public Graph(int vertices) {
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge
    public void addEdge(int u, int v) {
        adjList[u].add(v);
        adjList[v].add(u); // Undirected graph
    }

    // DFS Helper Method
    private void dfsUtil(int node, boolean[] visited) {
        visited[node] = true; // Mark the current node as visited
        System.out.print(node + " "); // Print the node

        // Visit all the neighbors of the current node
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // DFS Traversal
    public void dfs(int startNode) {
        boolean[] visited = new boolean[adjList.length]; // Track visited nodes
        System.out.println("DFS Traversal:");
        dfsUtil(startNode, visited); // Start the DFS from the given node
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        // Adding edges
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);

        // Perform DFS starting from node 0
        g.dfs(0);
    }
}
