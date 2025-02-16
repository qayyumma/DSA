Problem Description

You are given an array A of integers of length N and two indices, B and C.

Your task is to sort the subarray [B, C] within the given array. The rest of the array should remain unchanged.

Problem Constraints

1 ≤ N ≤ 105

0 ≤ A[i] ≤ 109

0 ≤ B ≤ C ≤ N - 1

Input Format

First argument is the array A of length N. The next two arguments are the integers B and C.

Output Format

Return the array after sorting the [B, C] subarray.

Example Input

Input:
A = [59, 11, 8, 91, 49, 44, 8]
B = 4
C = 6

Input 2:
A = [50, 40, 30, 20, 10]
B = 0
C = 3


Example Output

Output:
[59, 11, 8, 91, 8, 44, 49]

Output:
[20, 30, 40, 50, 10]


public class Solution {

    int[] r;

    public int[] sortSubarray(int[] A, int B, int C) {

        r = new int[A.length];

        r = A;

        merger(B, C);

        return r;

    }

    private void merger(int start, int end ){

        if(start == end){
            return;
        }

        int mid = ((end - start) / 2) + start;

        merger( start, mid);

        merger( mid+1, end);

        sort( start, mid, end);


    }

    private void sort(int start, int mid, int end){

        int size = end - start + 1;

        int[] l = new int[size];

        int i = start;

        int j = mid+1;

        int k = 0;

        while(i <= mid && j <= end){

            if(r[i] <= r[j]){

                l[k++] = r[i++];

            }

            else{

                l[k++] = r[j++];

            }

        }

        while(i <= mid){

            l[k++] = r[i++];
        }

        while(j <= end){

            l[k++] = r[j++];
        }


        for(int x = 0; x < l.length; x++){

            r[start+x] = l[x];

        }


    }


    
}
