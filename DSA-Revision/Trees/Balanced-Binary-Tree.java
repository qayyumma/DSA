
Problem Description

Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints

1 <= size of tree <= 100000

Input Format

First and only argument is the root of the tree A.

Output Format

Return 0 / 1 ( 0 for false, 1 for true ) for this problem.


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

    int ans = 1;

    public int isBalanced(TreeNode A) {

        depth(A);

        return ans;

    }

    public int depth(TreeNode curr) {

        if(curr==null){
            return 0;
        }

        int left = depth(curr.left);

        int right = depth(curr.right);

        if(Math.abs(left - right) > 1){

            ans = 0;

        }

        return 1 + Math.max(left, right);

    }

}
