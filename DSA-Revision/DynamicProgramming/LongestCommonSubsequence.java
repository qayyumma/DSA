public class LongestCommonSubsequence {
    public static int lcs(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            // Move curr to prev for the next row
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }

    public static void main(String[] args) {
        String A = "ABCBDAB";
        String B = "BDCABC";
        System.out.println("Length of LCS: " + lcs(A, B));
    }
}



// Optimized Complexity
// Time Complexity: 𝑂(𝑚⋅𝑛), same as the 2D array version.
// Space Complexity: 𝑂(𝑛), since we only need two 1D arrays.
