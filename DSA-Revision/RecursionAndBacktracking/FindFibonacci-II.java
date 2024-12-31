public class Solution {
    public int findAthFibonacci(int A) {

        if(A==0 || A== 1){
            return A;
        }

        int b1 = 1;

        int b2 = 1;

        for(int i = 3; i <= A; i++){
            int curr = b1 + b2;
            b1 = b2;
            b2 = curr;
        }

        return b2;

    }
}
