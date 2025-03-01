Problem Description

You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).


Problem Constraints

1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000



Input Format

First argument is an integer array A representing the set.
Second argument is an integer B.



Output Format

Return an integer denoting the number of ways.

------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static int coinPermutation(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int amount = 1; amount <= target; amount++) {
            for (int coin : coins) {
                if (coin <= amount) {
                    dp[amount] += dp[amount - coin];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 4;

        System.out.println("Number of Combinations: " + coinCombination(coins, target)); // Output: 4
        System.out.println("Number of Permutations: " + coinPermutation(coins, target)); // Output: 7
    }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------------


Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Problem Constraints

1 <= N <= 103

1 <= C <= 103

1 <= A[i], B[i] <= 103



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.




-----------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int coinchange2(int[] A, int B) {

        long[] ans = new long[B+1];

        ans[0] = 1L;

        for(int i = 0; i < A.length; i++){

            for(int j = A[i]; j <= B; j++){

                if(A[i] <= j){

                    ans[j] = (ans[j] + ans[j-A[i]]) % 1000007;

                }

            }

        }

        return (int) ans[B];
    }
}


