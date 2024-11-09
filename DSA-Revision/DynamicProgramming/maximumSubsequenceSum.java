public class MaxNonAdjacentSubsequenceSum {
    public static int maxSubsetSum(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);
        
        for (int i = 2; i < n; i++) {
            int current = Math.max(prev1, arr[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 10, 7}; // Example array
        System.out.println("Maximum sum of non-adjacent subsequence: " + maxSubsetSum(arr));
    }
}

// time complexity -- N
// space complexity -- 1
