Problem Description

An integer is given to you in the form of an array, with each element being a separate digit.

Find the smallest number (leading zeroes are allowed) that can be formed by rearranging the digits of the given number in an array. Return the smallest number in the form an array.

Note - Do not use any sorting algorithm or library's sort method.

Problem Constraints

1 ≤ N ≤ 105

0 ≤ A[i] ≤ 9

Input Format

First argument A is an array of length N, representing digits of the number.

Output Format

Return the array representing the smallest possible number in form of an array.

Example Input
Input 1:
A = [6, 3, 4, 2, 7, 2, 1]

Input 2:
A = [4, 2, 7, 3, 9, 0]

Example Output
Output 1:
[1, 2, 2, 3, 4, 6, 7]

Output 2:
[0, 2, 3, 4, 7, 9]


public class Solution {
    public int[] smallestNumber(int[] A) {

        int[] r = new int[10];

        for(int i = 0; i < A.length; i++){

            r[A[i]]++;
            
        }

        int k = 0;

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < r[i]; j++){

                A[k++] = i;
            }

        }

        return A;

    }
}


