public class PowerFunction {
    public static int pow(int a, int n) {
        // Base case: Any number to the power of 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive case: Calculate power for half the exponent
        int p = pow(a, n / 2);

        // If n is even: Multiply p * p
        if (n % 2 == 0) {
            return p * p;
        } 
        // If n is odd: Multiply p * p * a
        else {
            return p * p * a;
        }
    }

    public static void main(String[] args) {
        System.out.println("2^10 = " + pow(2, 10)); // Output: 1024
        System.out.println("3^5 = " + pow(3, 5));   // Output: 243
        System.out.println("5^0 = " + pow(5, 0));   // Output: 1
    }
}
