Problem Description

You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Problem Constraints

1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109

Input Format

First argument A is an array of integers and second argument B is an integer.

Output Format

Return an integer.

Example Input
Input 1:
A = [3, 5, 1, 2]
B = 4

Input 2:
A = [1, 2, 1, 2]
B = 1


Example Output
Output 1:
1
Output 2:
4


public class Solution {
    public int solve(int[] A, int B) {

        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < A.length; i++){


            int f = A[i] - B;

            int s = A[i] + B;

            if(map.containsKey(f)){

                ans = ans + map.get(f);

            }

            if(map.containsKey(s)){

                ans = ans +  map.get(s);

            }


            if(map.containsKey(A[i])){

                map.put(A[i], map.get(A[i]) +1 );

            }

            else{
                map.put(A[i], 1);
            }


        }


        //return (int) (ans / 100000007 );

        return ans;

    }
}

