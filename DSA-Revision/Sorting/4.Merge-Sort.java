Problem Description

Given an integer array A, sort the array using Merge Sort.

Problem Constraints

1 <= |A| <= 105
1 <= A[i] <= 109

Input Format
First argument is an integer array A.

Output Format

Return the sorted array.

Example Input

Input 1:-
A = [1, 4, 10, 2, 1, 5]

Input 2:-
A = [3, 7, 1]

Example Output
Output 1:-
[1, 1, 2, 4, 5, 10]

Output 2:-
[1, 3, 7]


public class Solution {

    int[] r;

    public int[] solve(int[] A) {

        r = new int[A.length];

        r = A;

        merger(0, A.length-1);
        
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

