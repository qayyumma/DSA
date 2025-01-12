Problem Description

Given a weighted undirected graph having A nodes, a source node C and destination node D.

Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.

You are expected to do it in Time Complexity of O(A + M).

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are Numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints

1 <= A <= 105

0 <= B[i][0], B[i][1] < A

1 <= B[i][2] <= 2

0 <= C < A

0 <= D < A



Input Format

The first argument given is an integer A, representing the number of nodes.

The second argument given is the matrix B, where B[i][0] and B[i][1] are connected through an edge of weight B[i][2].

The third argument given is an integer C, representing the source node.

The fourth argument is an integer D, representing the destination node.

Note: B[i][2] will be either 1 or 2.



Output Format

Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.



public class Solution {

    class Pair{
        int v;
        int w;
        public Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }


    public int solve(int A, int[][] B, int C, int D) {

        int ans = 0;

        List<Pair>[] graph = new LinkedList[A];

        for(int i = 0; i < A; i++){

            graph[i] = new LinkedList<>();

        }

        for(int i = 0; i < B.length; i++){

            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));

        }

        int[] r = new int[A];

        for(int i = 0; i < A; i++){

            r[i] = Integer.MAX_VALUE;
        }

        r[C] = 0;

        // Priority queue with explicit type arguments
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.w, p2.w); // Min-heap based on weight
            }
        });
        queue.add(new Pair(C, 0));

        while(!queue.isEmpty()){

            Pair temp = queue.poll();

            if( temp.w > r[temp.v] ) continue;

            if(temp.v == D) return temp.w;

            for(Pair n: graph[temp.v]){

                int newW = n.w + temp.w;

                if(newW < r[n.v]){

                    r[n.v] = newW;

                    queue.add(new Pair(n.v, newW));

                }


            }

        }


        return -1;

    }
}


