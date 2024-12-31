public class Solution {
    public int getMax(int[] A) {

        return maxVal(0, A);

    }

    public int maxVal(int i, int[] A){

        if(i > A.length-1){
            return Integer.MIN_VALUE;
        }

        int max = maxVal(i+1, A);

        return Math.max(A[i], max);

    }
}
