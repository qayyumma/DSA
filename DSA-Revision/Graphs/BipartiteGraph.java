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
