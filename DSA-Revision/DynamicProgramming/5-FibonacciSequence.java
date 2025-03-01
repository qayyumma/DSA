public class FibonacciOptimized {
    public static int fibonacci(int n) {
        if (n <= 1) return n;

        int prev2 = 0; // fib[0]
        int prev1 = 1; // fib[1]
        
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2; // fib[i] = fib[i - 1] + fib[i - 2]
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }

    public static void main(String[] args) {
        int N = 10; // Example value for N
        System.out.println("Fibonacci of " + N + " is: " + fibonacci(N));
    }
}
