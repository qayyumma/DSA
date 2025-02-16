Problem Description

Given an integer array A of length N, considering the last element as pivot p, rearrange the elements such that for all i:

if A[i] < p then it should be present on left side of the partition
if A[i] > p then it should be present on right side of the partition
Rearrange the given array as well as return the partition index.

Note: All elements are distinct

Problem Constraints

1 ≤ N ≤ 105

1 ≤ A[i] ≤ 109

Input Format
The only input argument is the given vector A.

Output Format
Return the partition index as well as rearrange the input array to satisfy the given conditions.

Example Input
Input:
A = [6, 2, 0, 4, 5]

Example Output

Output:
 Valid
A possible solution can be:
A = [2, 0, 4, 5, 6] and partitionIndex = 3


class Solution {
    public int partition(int[] arr) {

        int l = 0;

        int r = arr.length-2;

        int N = arr.length-1;

        while(l <= r){

            if(arr[l] < arr[N]){
                l++;
            }

            else if(arr[r] > arr[N]){
                r--;
            }
            else{

                int temp = arr[l];

                arr[l] = arr[r];

                arr[r] = temp;

                l++;

                r--;
            }

        }

        int temp = arr[l];

       arr[l] = arr[N];

       arr[N] = temp;

        return l;

    }
}

