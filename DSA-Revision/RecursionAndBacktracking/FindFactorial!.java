public class Solution {
    public int solve(int A) {

        int r = 1;

        for(int i = 2; i <= A; i++){
            r *= i;
        }

        return r;
    }
}
