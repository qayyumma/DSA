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
