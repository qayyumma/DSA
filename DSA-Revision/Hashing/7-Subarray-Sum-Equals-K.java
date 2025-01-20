Problem Description

Given an array of integers A and an integer B.
Find the total number of subarrays having sum equals to B.

Problem Constraints

 1 <= length of the array <= 50000
-1000 <= A[i] <= 1000

Input Format

The first argument given is the integer array A.
The second argument given is integer B.

Output Format

Return the total number of subarrays having sum equals to B.

Example Input
Input 1:
A = [1, 0, 1]
B = 1
Input 2:
A = [0, 0, 0]
B = 0


Example Output
Output 1:
4
Output 2:
6


public class Solution {
    public int solve(int[] A, int B) {

        int count = 0;

        int prefixSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for(int i = 0; i < A.length; i++){

            prefixSum += A[i];

            int target = prefixSum - B;

            if(map.containsKey(target)){

                count += map.get(target);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) +1);


        }

        return count;

    }
}
