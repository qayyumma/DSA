public class Solution {

    class cell{

        int i;

        int j;

        public cell(int i, int j){

            this.i = i;

            this.j = j;

        }

    }

    public boolean rotent(int i, int j, int N, int M, int[][] A){

        if(i < 0 || j < 0 || i >= N || j >= M || A[i][j] != 1 ){

            return false;
        }

        return true;

    }

    public int solve(int[][] A) {

        Queue<cell> q = new LinkedList<>();

        int N = A.length;

        int M = A[0].length;

        int totalone = 0;

        int time = 0;

        for(int i = 0; i < N; i++){

            for(int j = 0; j < M; j++){

                if(A[i][j]==2){

                    q.add(new cell (i, j));

                }
                else if(A[i][j]==1){
                    totalone++;

                }

            }

        }

        while(q.size() > 0){

            int size =  q.size();

            for(int i = 0; i < size; i++){

            cell c = q.remove();

            if( rotent(c.i, c.j-1, N, M, A)){

                A[c.i][c.j-1] = 2;

                q.add( new cell(c.i, c.j-1) );

                totalone--;

            }
            if( rotent(c.i, c.j+1, N, M, A)){

                A[c.i][c.j+1] = 2;

                q.add( new cell(c.i, c.j+1) );

                totalone--;

            }
            if( rotent(c.i-1, c.j, N, M, A)){

                A[c.i-1][c.j] = 2;

                q.add( new cell(c.i-1, c.j) );

                totalone--;

            }
            if( rotent(c.i+1, c.j, N, M, A)){

                A[c.i+1][c.j] = 2;

                q.add( new cell(c.i+1, c.j) );

                totalone--;

            }

            }
            

            if(!q.isEmpty()){
                time++;
            }
            

        }


        if(totalone==0){

            return time;
        }


        return -1;

    }
}
