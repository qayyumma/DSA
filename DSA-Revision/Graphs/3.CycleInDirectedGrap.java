public class Solution {


    public int solve(int A, int[][] B) {

        ArrayList<Integer>[] graph = new ArrayList[A+1];

        for(int i = 0; i < B.length; i++){

            int u = B[i][0];
            int v = B[i][1];

            if(graph[u]==null){
                graph[u] = new ArrayList<>();
            }

            graph[u].add(v);

        }

        boolean[] travel = new boolean[A+1];

        boolean[] check = new boolean[A+1];

        for(int i = 1; i <= A; i++){

            if(dft(graph, travel, check, i)){
                return 1;
            }
        }

        return 0;
        
    }

    public boolean dft( ArrayList<Integer>[] graph, boolean[] travel, boolean[] check, int p){

        if(check[p]){

            return true;
        }
        if( !travel[p] ){

            travel[p] = true;

            check[p] = true;

            ArrayList<Integer> arr = graph[p];

            if(arr == null){

                check[p] = false;
                return false;
            }

            for(int i = 0; i < arr.size(); i++){
                if(dft(graph, travel, check, arr.get(i))){
                    return true;
                }
            }
            check[p] = false;
        }
        return false;
    }
}
