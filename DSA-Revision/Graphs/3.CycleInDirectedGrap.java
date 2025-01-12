Problem Description

Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].


Output Format

Return 1 if cycle is present else return 0.



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

====================================================================================================================


public class Solution {

    private boolean[] visited;

    private boolean[] pathVisited; 

    private List<Integer>[] graph;


    public int solve(int A, int[][] B) {

        visited = new  boolean[A+1];

        pathVisited = new boolean[A+1];

        graph = new LinkedList[A+1];

        for(int i = 0; i <= A; i++) graph[i] = new LinkedList<>();

        for(int i = 0; i < B.length; i++){

            int u = B[i][0];

            int v = B[i][1];

            graph[u].add(v);

        }

        for(int i = 1; i <= A; i++){

            if(!visited[i]){

                if(dfs(i)){
                    return 1;
                }
            }


        }

        return 0;

    }


    private boolean dfs( int i ){
            
            visited[i] = true;

            pathVisited[i] = true;

            for(int ele: graph[i]){

                if(!visited[ele]){

                    if(dfs(ele)){
                        return true;
                    }

                }

                else if(pathVisited[ele]){
                    return true;
                }

            }

        pathVisited[i] = false;

        return false;

    }


}
