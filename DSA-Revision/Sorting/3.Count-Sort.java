Problem Description

Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.

Problem Constraints

1 <= |A| <= 105
1 <= A[i] <= 105

Input Format

The first argument is an integer array A.

Output Format

Return an integer array that is the sorted array A.

Example Input

Input 1:
A = [1, 3, 1]

Input 2:
A = [4, 2, 1, 3]

Example Output

Output 1:
[1, 1, 3]

Output 2:
[1, 2, 3, 4]


public class Solution {
    public int[] solve(int[] A) {

        int max = A[0];
        int min = A[0];

        for(int i = 1; i < A.length; i++){

            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        int size = max - min + 1;

        int[] r = new int[size];

        for(int i = 0; i < A.length; i++){

            r[A[i] - min]++;

        }

        int k = 0;

        for(int i = 0; i < size; i++){

            for(int j = 0; j < r[i]; j++){

                A[k++] = min + i;
            }

        }

        return A;

    }
}


==========================================================================================


public class Solution {
    public int[] solve(int[] A) {

        int f[] = new int[1000000];

        for(int i = 0; i < A.length; i++){

          //  System.out.print(A[i] + " ");

            f[A[i]]++;

        }

        int k = 0;

        for(int i = 0; i < 1000000; i++){
            for(int j = 0; j < f[i]; j++){
                A[k++] = i;
            }
        }

        return A;

    }
