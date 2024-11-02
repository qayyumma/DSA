public class Solution {
    public int solve(int A, int[][] B) {

        class Pair{
            int u;
            int w;
            public Pair(int w, int u){
                this.u = u;
                this.w = w;
            }
        }

        ArrayList<Pair>[] graph = new ArrayList[A+1];

        for(int i = 1; i < A+1; i++){

            graph[i] = new ArrayList<>();

        }

        for(int i =0; i < B.length; i++){

            int u = B[i][0];

            int v = B[i][1];

            int w = B[i][2];

            graph[u].add(new Pair(w, v));

            graph[v].add(new Pair(w, u));

        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.w, p2.w); // min-heap on distance
            }
        });

        int sum = 0;

        boolean[] visited = new boolean[A+1];

        queue.add(new Pair(0, 1));

       // visited[1] = true;

        while( !queue.isEmpty() ){

            Pair temp = queue.poll();

            if(visited[ temp.u ]){
                continue;
            }

            visited[ temp.u ] = true;

            sum += temp.w;

            ArrayList<Pair> arr = graph[temp.u];

            for(int i = 0; i < arr.size(); i++){

                if( !visited[ arr.get(i).u ] ){

                    queue.add(new Pair( arr.get(i).w, arr.get(i).u ));

                }


            }


        }

        return sum;

    }
}
