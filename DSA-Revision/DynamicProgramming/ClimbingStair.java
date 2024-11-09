public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 1) return 1; // If there are 0 or 1 steps, only 1 way to reach the top

        int prev2 = 1; // Number of ways to reach the (N-2)th stair
        int prev1 = 1; // Number of ways to reach the (N-1)th stair

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2; // Number of ways to reach the current stair
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int N = 5; // Example value for N
        System.out.println("Ways to climb " + N + " stairs: " + climbStairs(N));
    }
}
