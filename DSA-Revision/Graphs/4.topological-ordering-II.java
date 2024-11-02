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
