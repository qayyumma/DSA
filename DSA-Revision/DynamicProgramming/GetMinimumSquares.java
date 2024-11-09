import java.util.Arrays;

// bottom to up

public class MinimumSquaresBottomUp {
    public static int minSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // Initialize dp array with a large number
        dp[0] = 0; // Base case: zero squares needed to get sum 0

        // Fill the dp array from 1 to n
        for (int i = 1; i <= n; i++) {
            for (int x = 1; x * x <= i; x++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
            }
        }

        return dp[n]; // The answer for dp[n] is the minimum number of squares for n
    }

    public static void main(String[] args) {
        int N = 5; // Example input
        System.out.println("Minimum squares required for " + N + " is: " + minSquares(N));
    }
}

// top down approach same time and space complexity

// N * N ^ 1/2 -- time complexity
// N -- space complexity  


import java.util.Arrays;

public class MinimumSquaresMemoization {
    static int[] dp;

    public static int psquares(int n) {
        if (n == 0) return 0; // Base case: 0 squares are needed to get sum 0
        if (dp[n] != -1) return dp[n]; // If already computed, return stored result

        int ans = Integer.MAX_VALUE;
        for (int x = 1; x * x <= n; x++) {
            ans = Math.min(ans, psquares(n - x * x)); // Recursively find the minimum
        }
        dp[n] = 1 + ans; // Store result in dp array
        return dp[n];
    }

    public static void main(String[] args) {
        int N = 12; // Example input
        dp = new int[N + 1];
        Arrays.fill(dp, -1); // Initialize dp array with -1

        System.out.println("Minimum squares required for " + N + " is: " + psquares(N));
    }
}
