import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the current string reaches the maximum length (2 * n)
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add an open parenthesis if possible
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add a close parenthesis if valid
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> parentheses = generateParentheses(n);
        System.out.println("All combinations of " + n + " pairs of parentheses:");
        for (String combination : parentheses) {
            System.out.println(combination);
        }
    }
}
