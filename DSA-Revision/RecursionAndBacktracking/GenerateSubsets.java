Problem Description

Given a set of distinct integers A, return all possible subsets that can be formed from the elements of array A.



Problem Constraints

1 ≤ |A| ≤ 16

INT_MIN ≤ A[i] ≤ INT_MAX

Array A is given in increasing order.

All elements of array A are distinct.



Input Format

First and only argument of input contains a single integer array A.



Output Format

Return a vector of vectors denoting the answer in any order.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // code here
        ArrayList<Integer> B = new ArrayList<>();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        ans(A, B, 0, ans);

        return ans;

    }

    public void ans(ArrayList<Integer> A, ArrayList<Integer> B, int i, ArrayList<ArrayList<Integer>> ans){

        if(i==A.size()){
            ans.add(new ArrayList<>(B));
            return;
        }

        B.add(A.get(i));

        ans(A, B, i+1, ans);

        B.remove(B.size()-1);

        ans(A, B, i+1, ans);


    }
}
