Problem Description

Given an integer array A, sort the array using Quick Sort.

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

    int[] arr;

    public int[] solve(int[] A) {

        arr = new int[A.length];

        arr = A;

        quickSort(0, A.length-1);

        return arr;

    }


    public void quickSort( int start, int end ){

        if(start>=end){
            return;
        }

        int p = partition( start, end);

        quickSort( start, p);
        quickSort( p+1, end);


    }



    public int partition( int start, int end ) {

        int l = start+1;

        int r = end;

        int p = arr[start];

        while(l <= r){

            if(arr[l] < p){
                l++;
            }

            else if(arr[r] > p){
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

       arr[start] = arr[r];

       arr[r] = p;

        return r;

    }
    
}

