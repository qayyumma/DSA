Problem Description

Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

D[i]: Shortest distance from the C node to node i.
If node i is not reachable from C then -1.
Note:

There are no self-loops in the graph.
There are no multiple edges between two pairs of vertices.
The graph may or may not be connected.
Nodes are numbered from 0 to A-1.
Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A



Input Format

The first argument is an integer A, representing the number of nodes in the graph.
The second argument is a matrix B of size M x 3, where each row represents an edge in the graph. The three columns of each row denote the source node B[i][0], the destination node B[i][1], and the weight of the edge B[i][2].
The third argument is an integer C, representing the source node for which the shortest distance to all other nodes needs to be found.


Output Format

Return the integer array D.
=====================================================================================================================================


public class Solution {
    
    class Pair{

        int v;
        int w;

        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }

    }


    boolean[] visited;

    List<Pair>[] graph;

    int[] ans;
    
    public int[] solve(int A, int[][] B, int C) {

        visited = new boolean[A];

        graph = new LinkedList[A];

        ans = new int[A];

        for(int i = 0; i < A; i++){
            graph[i] = new LinkedList<>();
            ans[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < B.length; i++){

            int u = B[i][0];

            int v = B[i][1];

            int w = B[i][2];

            graph[u].add(new Pair(v, w));

            graph[v].add(new Pair(u, w));

        }

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.w, p2.w); // Min-heap based on weight
            }
        });

        ans[C] = 0;

        //visited[C] = true;

        queue.add(new Pair(C, 0));

        while(!queue.isEmpty()){

            Pair temp = queue.poll();

            if( temp.w > ans[temp.v]) continue;

            for(Pair ele: graph[temp.v]){

                int newW = temp.w + ele.w;

                if(newW < ans[ele.v]){

                    queue.add(new Pair(ele.v, newW));

                    ans[ele.v] = newW;

                }

            }

        }


        for(int i = 0; i < A; i++){

            if(ans[i]==Integer.MAX_VALUE){
                ans[i] = -1;
            }
        }

        return ans;

    }
}



=======================================================================================================================================
import java.util.*;

public class Solution {
    public int[] solve(int A, int[][] B, int C) {

        class Pair {
            int w; // distance (weight)
            int u; // destination node
            public Pair(int w, int u) {
                this.w = w;
                this.u = u;
            }
        }

        // Initialize adjacency list for graph representation
        ArrayList<Pair>[] g = new ArrayList[A];
        for (int i = 0; i < A; i++) {
            g[i] = new ArrayList<>();
        }

        // Build the graph from input
        for (int i = 0; i < B.length; i++) {
            int v = B[i][0]; // source
            int u = B[i][1]; // destination
            int w = B[i][2]; // weight
            g[u].add(new Pair(w, v));
            g[v].add(new Pair(w, u));
        }

        // Distance array and PriorityQueue for Dijkstra's algorithm
        int[] r = new int[A];
        Arrays.fill(r, Integer.MAX_VALUE);
        r[C] = 0; // Start node distance is 0

        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.w, p2.w); // min-heap on distance
            }
        });

        queue.add(new Pair(0, C)); // Start from the source node C

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int currentW = current.w;
            int currentU = current.u;

            // If we've already found a shorter path, continue
            if (r[currentU] < currentW) continue;

            // Explore neighbors
            for (Pair neighbor : g[currentU]) {
                int newW = currentW + neighbor.w;
                if (newW < r[neighbor.u]) {
                    r[neighbor.u] = newW;
                    queue.add(new Pair(newW, neighbor.u));
                }
            }
        }

        // Replace unreachable distances with -1
        for (int i = 0; i < A; i++) {
            if (r[i] == Integer.MAX_VALUE) {
                r[i] = -1;
            }
        }

        return r;
    }
}
