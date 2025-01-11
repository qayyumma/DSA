Problem Description

Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.

Problem Constraints

1 <= size of tree <= 100000

0 <= value of node <= 109


Input Format

First and only argument is head of tree A.


Output Format

Return 1 if the tree can be partitioned into two trees of equal sum else return 0.


/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {

    long ts = 0;

    int ans = 0;

    long ps = 0;

    public int solve(TreeNode A) {

        ts = 0;

        ps = 0;

        tso(A);

        ans = 0;

        if(ts%2==1){

            return 0;
        }

        pso(A);

        return ans;

    }

    public void tso(TreeNode curr){

        if(curr == null){

            return;
        }

        ts += curr.val;

        tso(curr.left);

        tso(curr.right);
    }


    public long pso(TreeNode curr){

        if(curr == null){

            return 0;
        }

        long left = pso(curr.left);

        long right = pso(curr.right);

        long ps = curr.val + left + right;

        if(ps == ts/2){
            ans = 1;
            return ps;
        }

        return ps;      

    }
}

