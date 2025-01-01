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


-----------------------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int solve(int[] A, int[] B, int C) {

        int N = A.length+1;

        int[][] ans = new int[N][C+1];

        for(int i = 1; i < N; i++){

            for(int j = 1; j <= C; j++){

                int ex = ans[i-1][j];

                int in = 0;

                if(j >= B[i-1] ){

                    in = A[i-1] + ans[i-1][j-B[i-1]];
                }

                ans[i][j] = Math.max(ex, in);

            }

        }

        return ans[N-1][C];



    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.util.*;

class Item {
    int weight;
    int value;
    int quantity;

    Item(int weight, int value, int quantity) {
        this.weight = weight;
        this.value = value;
        this.quantity = quantity;
    }
}

public class BoundedKnapsack {
    public static int boundedKnapsack(int capacity, Item[] items) {
        // Create a list to hold the expanded items
        List<Item> expandedItems = new ArrayList<>();

        // Break each item into multiple items based on its quantity limit
        for (Item item : items) {
            for (int i = 1; i <= item.quantity; i++) {
                expandedItems.add(new Item(item.weight, item.value, 1));
            }
        }

        // Apply 0/1 Knapsack on the expanded list
        int[] dp = new int[capacity + 1];

        for (Item item : expandedItems) {
            for (int w = capacity; w >= item.weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - item.weight] + item.value);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(1, 10, 2),  // weight=1, value=10, quantity=2
            new Item(3, 40, 3),  // weight=3, value=40, quantity=3
            new Item(4, 50, 1)   // weight=4, value=50, quantity=1
        };

        int capacity = 6;
        System.out.println("Maximum Value: " + boundedKnapsack(capacity, items)); // Output: 90
    }
}


-------------------------------------------------------------------------------------------------------------------------------------------------------------------


0-1 Knapsack II


Problem Description

Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).



Problem Constraints

1 <= N <= 500

1 <= C, B[i] <= 106

1 <= A[i] <= 50



Input Format

First argument is an integer array A of size N denoting the values on N items.

Second argument is an integer array B of size N denoting the weights on N items.

Third argument is an integer C denoting the knapsack capacity.



Output Format

Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------

public class Solution {
    public int solve(int[] A, int[] B, int C) {
        int N = A.length; // Number of items
        int maxValue = N * 50; // Maximum possible value (each item's max value is 50)

        // DP array to store minimum weight required to achieve a value
        int[][] dp = new int[N + 1][maxValue + 1];

        // Initialize DP array
        for (int i = 0; i <= maxValue; i++) {
            dp[0][i] = Integer.MAX_VALUE; // Impossible to achieve value > 0 without items
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0; // Weight required to achieve 0 value is 0
        }

        // Fill the DP table
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= maxValue; j++) {
                if (j >= A[i - 1]) {
                    // Avoid overflow when dp[i-1][j-A[i-1]] is Integer.MAX_VALUE
                    int include = (dp[i - 1][j - A[i - 1]] == Integer.MAX_VALUE) ? 
                                    Integer.MAX_VALUE : 
                                    B[i - 1] + dp[i - 1][j - A[i - 1]];
                    
                    dp[i][j] = Math.min(dp[i - 1][j], include);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }



        // Find the maximum value achievable within weight capacity C
        for (int i = maxValue; i >= 0; i--) {
            if (dp[N][i] <= C) {
                return i; // Return the maximum value
            }
        }

        return 0; // If no value can be achieved
    }
}


