Problem Description

Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Problem Constraints

1 <= length of array <= 100000


Input Format

First argument is an integer array A.


Output Format

Return a root node of the Binary Search Tree.



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
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] A) {

        return code(A, 0, A.length-1);

    }

    public TreeNode code(int[] A, int start, int end){

        if(start > end || end < start){
            return null;
        }

        int mid = start + (end - start) / 2 ;

        TreeNode root = new TreeNode(A[mid]);

        root.left = code(A, start, mid-1);

        root.right = code(A, mid+1, end);

        return root;

    }

}
