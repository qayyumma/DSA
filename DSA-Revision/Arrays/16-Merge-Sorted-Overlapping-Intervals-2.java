Problem Description

You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`. The intervals are sorted based on their start values.

Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.

Problem Constraints
1 <= len(A) <= 100000.
1 <= A[i][0] <= A[i][1] <= 100000

A is sorted based on the start value (A[i][0])

Input Format
First argument is a list of intervals in 2-Dimentional Array.

Output Format
Return the sorted list of intervals after merging all the overlapping intervals.


Example Input

Input 1:
[ [1, 3], [2, 6], [8, 10], [15, 18] ]
Input 2:
[ [2, 10], [4, 9], [6, 7] ]

Example Output
Output 1:
[ [1, 6], [8, 10], [15, 18] ]
Output 2:
[ [2, 10] ]


public class Solution {
    public int[][] solve(int[][] A) {

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        int ind = 0;

        int N = A.length;

        int start = A[0][0];

        int end = A[0][1];

        for(int i = 1; i < N; i++){

            int newStart = A[i][0];

            if( newStart <= end ){

                if( end < A[i][1]){

                    end = A[i][1];

                }

            } 
            else {

                ArrayList<Integer> temp = new ArrayList<>();

                temp.add(start);

                temp.add(end);

                //ArrayList<Integer> temp = new ArrayList<>(List.of(start, end));

                arr.add(temp);

                start = A[i][0];

                end = A[i][1]; 

            }           


        }


        ArrayList<Integer> temp = new ArrayList<>();

        temp.add(start);

        temp.add(end);

        arr.add(temp);

        int[][] ans = new int[arr.size()][2];


        for(int i = 0; i < arr.size(); i++){


            ans[i][0] = arr.get(i).get(0);

            ans[i][1] = arr.get(i).get(1);


        }

        return ans;


    }
}


========================================================================================================================




public class Solution {
    public int[][] solve(int[][] A) {

        List<List<Integer>> B = new ArrayList<>();

        int startValue = A[0][0];

        int endValue = A[0][1];

        int N = A.length;

        for(int i = 1; i < N; i++){

            int currentStartValue = A[i][0];

            int currentEndValue = A[i][1];

            List<Integer> C = new ArrayList<>();

            if(currentStartValue <= endValue){

                startValue = Math.min(startValue, currentStartValue);

                endValue = Math.max(endValue, currentEndValue);
            }

            else{

                C.add(startValue);

                C.add(endValue);

                B.add(C);

                startValue = A[i][0];

                endValue = A[i][1];

            }

        }


            List<Integer> C = new ArrayList<>();

            C.add(startValue);

            C.add(endValue);

            B.add(C);


        // Convert List<List<Integer>> to int[][]
        int[][] result = new int[B.size()][2];
        
        for (int i = 0; i < B.size(); i++) {
            result[i][0] = B.get(i).get(0);
            result[i][1] = B.get(i).get(1);
        }

        return result;


        }
}






