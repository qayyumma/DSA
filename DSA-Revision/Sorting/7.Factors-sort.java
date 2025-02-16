Problem Description

You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.

Note: You cannot use any extra space

Problem Constraints

1 <= N <= 104
1 <= A[i] <= 104

Input Format

First argument A is an array of integers.

Output Format

Return an array of integers.

Example Input

Input 1:
A = [6, 8, 9]

Input 2:
A = [2, 4, 7]

Example Output

Output 1:
[9, 6, 8]

Output 2:
[2, 7, 4]


public class Solution {
    public int[] solve(int[] A) {

        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];  // Copy elements
        }

        Arrays.sort(arr, new customCompator());

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];  // Copy elements back
        }
        
        return result;

    }

    private int factorial( int n ){

        int ans = 0;

        for(int i = 1; i * i <= n; i++){

            if(n % i == 0){
                ans++;
                
                if(i != n/i ){
                    ans++;

                 }

            }

        }

        return ans;

    }

    class customCompator implements Comparator<Integer>{

        @Override
        public int compare( Integer i, Integer j){

            int a = factorial(i);

            int b = factorial(j);

            if(a < b){
                return -1;
            }

            else if( b < a){
                return 1;
            }
            else{

                if(i < j){
                    return -1;
                }
                else if( j < i ){
                    return 1;
                }

                return 0;
            }

        }

    }


}
