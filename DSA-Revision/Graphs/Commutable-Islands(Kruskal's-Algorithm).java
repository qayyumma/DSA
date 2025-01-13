Problem Description

There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.

We need to find bridges with minimal cost such that all islands are connected.

It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.



Problem Constraints

1 <= A, M <= 6*104

1 <= B[i][0], B[i][1] <= A

1 <= B[i][2] <= 103



Input Format

The first argument contains an integer, A, representing the number of islands.

The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].



Output Format

Return an integer representing the minimal cost required.


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
                else if(r[ele] == r[temp]){
                    return true;
                }

            }

        }

        return false;

    }



}
