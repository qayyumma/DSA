Problem Description

Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Note: The time complexity of your algorithm must be O(log n)..

Problem Constraints

1 <= N <= 106
1 <= A[i], B <= 109

Input Format

The first argument given is the integer array A.
The second argument given is the integer B.

Output Format

Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].

Example Input

Input 1:
 A = [5, 7, 7, 8, 8, 10]
 B = 8

Input 2:
 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:
 [3, 4]

Output 2:
 [-1, -1]

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {

        int l = 0;

        int r = A.length-1;

        while(l <= r){

            int mid = l + (r-l) / 2;

            if(A[mid]==B){

                int templ = mid;

                int tempr = mid;

                while( (templ != 0) && (A[templ-1] == B)){

                    templ--;

                }

                while( (tempr != A.length-1) && (A[tempr+1] == B)){
                    
                    tempr++;

                }

                return new int[]{templ, tempr};

            }


            else if( A[mid] < B ){

                l = mid + 1;

            }
            else{
                r = mid -1;
            }

        }


        return new int[]{-1, -1};
    }
}

