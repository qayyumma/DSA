public class Solution {
    public int solve(int[][] A) {

        int count = 0;

        for(int i = 0; i < A.length; i++){

            for(int j = 0; j < A[0].length; j++){

                if(A[i][j]==1){

                    count++;

                    dft(A, i, j);

                }
            }
        }

        return count;

    }

    public void dft(int[][] arr, int i, int j){

        if(i < 0 || j < 0 || i > arr.length-1 || j > arr[0].length-1){

            return;
        }

        if(arr[i][j] == 0 || arr[i][j]==2){

            return;
        }

        arr[i][j] = 2;

        dft(arr, i, j+1);
        dft(arr, i, j-1);
        dft(arr, i+1, j);
        dft(arr, i-1, j);
        dft(arr, i-1, j-1);
        dft(arr, i-1, j+1);
        dft(arr, i+1, j-1);
        dft(arr, i+1, j+1);

    }
}
