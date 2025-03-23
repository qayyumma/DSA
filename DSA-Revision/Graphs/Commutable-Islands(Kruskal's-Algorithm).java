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

    class Pair{

        int d;
        int w;

        public Pair(int d, int w){
            this.d = d;
            this.w = w;
        }

    }

    public int solve(int A, int[][] B) {

        ArrayList<Pair>[] graph = new ArrayList[A+1];

        for(int i = 1; i <= A; i++){

            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < B.length; i++){

            int u = B[i][0];

            int v = B[i][1];

            int w = B[i][2];

            graph[u].add(new Pair(v, w));

            graph[v].add(new Pair(u, w));

        }

        PriorityQueue<Pair> queue = new PriorityQueue( new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p1.w, p2.w);
            }
        });

        int ans = 0;

        boolean[] test = new boolean[A+1];

        queue.add(new Pair(1, 0));

        while(!queue.isEmpty()){

            Pair temp = queue.poll();

            if(test[temp.d]){

                continue;

            }

            test[temp.d] = true;

            ans += temp.w;

            for( Pair temp2: graph[temp.d]){

                if(!test[temp2.d]){
                    queue.add(new Pair(temp2.d, temp2.w));
                }

            }

        }

        return ans;
        
    }
}
