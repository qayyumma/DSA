Problem Description

You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.


Problem Constraints

1 <= Number of nodes in binary tree <= 105

0 <= node values <= 232-1

Input Format

First and only argument is head of the binary tree A.

Output Format

Return 0 if false and 1 if true.



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
    public int isValidBST(TreeNode A) {

        if(code(A, Long.MIN_VALUE, Long.MAX_VALUE)){
            return 1;
        }

        return 0;

    }

    public boolean code(TreeNode A, long min, long max){

        if(A==null){
            return true;
        }

        else if( A.val > min && A.val < max){

            boolean left = code(A.left, min, A.val);

            boolean right = code(A.right, A.val, max);

            return left && right;

        }

        return false;

    }
}
