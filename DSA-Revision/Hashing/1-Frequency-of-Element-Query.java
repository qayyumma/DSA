Problem Description

SCALER organizes a series of contests aimed at helping learners enhance their coding skills. Each learner can participate in multiple contests, and their participation is represented by integers in an array. The goal is to identify how frequently each learner has participated in these contests. This information will help SCALER determine which learners are participating the least, allowing them to provide targeted support and encouragement.

Given an array A that represents the participants of various contests, where each integer corresponds to a specific learner, and an array B containing the learners for whom you want to check participation frequency, your task is to find the frequency of each learner from array B in the array A and return a list containing all these frequencies

Problem Constraints
1 <= |A| <= 105
1 <= |B| <= 105
1 <= A[i] <= 105
1 <= B[i] <= 105


Input Format
First argument A is an array of integers.
Second argument B is an array of integers denoting the queries.

Output Format
Return an array of integers containing the frequency of each learner in B as found in array A.

Example Input
Input 1:
A = [1, 2, 1, 1]
B = [1, 2]
Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]

Example Output
Output 1:
[3, 1]
Output 2:
[0, 2]


public class Solution {
    public int[] solve(int[] A, int[] B) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < A.length; i++){

            if(map.containsKey(A[i]) ){

                map.put(A[i], map.get(A[i])+1 );
            }
            else{

                map.put(A[i], 1);
            }

        }

        int[] ans = new int[B.length];

        for(int i = 0; i < B.length; i++){

            if(map.containsKey(B[i])){

                ans[i] = map.get(B[i]);
            }
            

        }

        return ans;

    }
}

