public class CoinChange {
    public static int coinCombination(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int amount = coin; amount <= target; amount++) {
                dp[amount] += dp[amount - coin];
            }
        }

        return dp[target];
    }

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
