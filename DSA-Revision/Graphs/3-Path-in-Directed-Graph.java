Problem Description

Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

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

Return 1 if path exists between node 1 to node A else return 0.



public class Solution {

    private boolean[] visited;

    private List<Integer>[] graph;

    public int solve(int A, int[][] B) {

        visited = new boolean[A+1];

        graph = new LinkedList[A+1];

        for (int i = 0; i <= A; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i = 0; i < B.length; i++){

            int u = B[i][0];

            int v = B[i][1];

            graph[u].add(v);

        }

        bfs(1, A);

        return visited[A] ? 1: 0;

    }


    public void bfs(int i, int target){

        Queue<Integer> queue = new LinkedList<>();

        queue.add(i);

        visited[i] = true;

        while( !queue.isEmpty()){

            int j = queue.poll();

            for(int ele: graph[j]){

                if(!visited[ele]){

                    queue.add(ele);

                    visited[ele] = true;

                    if(ele==target){
                        return;
                    }
                    
                }

            }
        }

    }



}

