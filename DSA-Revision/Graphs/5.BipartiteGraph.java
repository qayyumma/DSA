Problem Description

Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].

Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A <= 100000

1 <= M <= min(A*(A-1)/2,200000)

0 <= B[i][0],B[i][1] < A



Input Format

The first argument given is an integer A.

The second argument given is the matrix B.



Output Format

Return 1 if the given graph is bipartide else return 0.


==================================================================================================================================================

public class Solution {

    int[] r;

    List<Integer>[] graph; 

    public int solve(int A, int[][] B) {

        r = new int[A];

        graph = new LinkedList[A];

        for(int i = 0; i < A; i++){

            graph[i] = new LinkedList<>();

        }

        for(int i = 0; i < B.length; i++){

            int u = B[i][0];
            int v = B[i][1];

            graph[v].add(u);
            graph[u].add(v);

        }

        for(int i = 0; i < A; i++){

            for(int ele: graph[i]){

                if(r[ele]==0){

                    if(bfs(ele)){
                        return 0;
                    }

                }
            }

        }



        return 1;

    }


    private boolean bfs(int i ){

        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);

        r[i] = -1;

        while(!queue.isEmpty()){

            int temp = queue.poll();

            for(int ele: graph[temp]){

                if(r[ele]==0){
                    r[ele] = -r[temp];
                    queue.add(ele);
                }
                else if(r[ele]== r[temp]){
                    return true;
                }

            }

        }

        return false;

    }



}


=====================================================================================================================================================


import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    // Function to check if the graph is bipartite using BFS
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: uncolored, 1: color 1, -1: color 2

        // Traverse each component
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) { // if node is uncolored
                if (!bfsCheck(graph, i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper function to check if the component containing startNode is bipartite
    private boolean bfsCheck(int[][] graph, int startNode, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        colors[startNode] = 1; // Start with color 1

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (colors[neighbor] == 0) { // If uncolored, color it with the opposite color
                    colors[neighbor] = -colors[node];
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[node]) { // If same color as current node, it's not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph bg = new BipartiteGraph();

        // Sample graph represented as an adjacency list
        int[][] graph = {
            {1, 3},    // Node 0 is connected to 1 and 3
            {0, 2},    // Node 1 is connected to 0 and 2
            {1, 3},    // Node 2 is connected to 1 and 3
            {0, 2}     // Node 3 is connected to 0 and 2
        };

        boolean result = bg.isBipartite(graph);
        System.out.println("Is the graph bipartite? " + result);
    }
}
