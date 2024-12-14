import java.util.ArrayList;

public class Graph {

    // Method to perform DFS and check for cycles
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;        // Mark the node as visited
        pathVisited[node] = true;   // Mark the node as part of the current path

        // Traverse all adjacent nodes
        for (int neighbor : adj.get(node)) {
            // If the node is not visited, perform DFS on it
            if (!visited[neighbor]) {
                if (dfsCheck(neighbor, adj, visited, pathVisited)) {
                    return true; // Cycle detected
                }
            }
            // If the node is already visited and part of the current path, there's a cycle
            else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[node] = false;  // Remove the node from the current path
        return false;               // No cycle detected
    }

    // Method to detect a cycle in a directed graph
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];      // Visited array
        boolean[] pathVisited = new boolean[V];  // Path visited array

        // Perform DFS for all unvisited nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCheck(i, adj, visited, pathVisited)) {
                    return true; // Cycle detected
                }
            }
        }
        return false; // No cycle in the graph
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add directed edges
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // Back edge creating a cycle

        // Create a graph object and check for cycles
        Graph g = new Graph();
        System.out.println("Does the graph contain a cycle? " + g.isCyclic(V, adj));
    }
}
