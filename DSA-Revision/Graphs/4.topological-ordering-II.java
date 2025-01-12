Problem Description

Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

There are no self-loops in the graph.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 104

1 <= M <= min(100000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.

//topological ordering - lexographically smallest one

public class Solution {
    public int[] solve(int A, int[][] B) {

        ArrayList<Integer>[] graph = new ArrayList[A+1];

        for(int i = 1; i <= A; i++){
            graph[i] = new ArrayList<>();
        }

        int[] dep = new int[A+1];

        for(int i = 0; i < B.length; i++){

            int u = B[i][0];

            int v = B[i][1];

            graph[u].add(v);

            dep[v]++;

        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int j = 0;

        int[] r = new int[A];

      // boolean 

        for(int i = 1; i <= A; i++){

            if(dep[i]==0){

                queue.add(i);
            }

        }

        while(!queue.isEmpty()){

            int t = queue.poll();

            r[j++] = t;

            for(int ele: graph[t]){

                dep[ele]--;

                if(dep[ele]==0){

                    queue.add(ele);
                }
            }
        }


        if(r[0]==0){
            return new int[]{};
        }

        return r;


    }
}
