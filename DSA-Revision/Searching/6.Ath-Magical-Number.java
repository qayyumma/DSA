Problem Description

You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.

Problem Constraints

1 <= A <= 109

2 <= B, C <= 40000

Input Format

The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.

Output Format

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Example Input
Input 1:

 A = 1
 B = 2
 C = 3

Input 2:
 A = 4
 B = 2
 C = 3


Example Output
Output 1:
 2

Output 2:
 6


public class Solution {
    public int solve(int A, int B, int C) {

        long l = (long)Math.min(B, C);

        long r = (long)Math.min(B, C) * (long)A;

        long lc =  lcm((long)B, (long)C);

        int ans = 0;

        while( l <= r ){

            long mid = l+ (r - l) /2;

            long val = (long)(mid / B) + (mid / C) - (mid / (long)lc); 

            if(val == (long)A){
                ans = (int) (mid % 1000000007);
                r = mid - 1;
            }

            else if(val > A){
                r = mid -1;
            }
            else{
                l = mid + 1;
            }


        }

        return ans;

    }

    private long gcd(long a, long b){

        while(b != 0){

            long temp = b;

            b = a % b;

            a = temp;

        }

        return a;

    }

    private long lcm(long a, long b){

        return  (a * b) / gcd(a, b);

    }
}
