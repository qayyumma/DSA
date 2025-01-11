Problem Description

Given a binary tree A, invert the binary tree and return it.

Inverting refers to making the left child the right child and vice versa.


Problem Constraints

1 <= size of tree <= 100000

Input Format

First and only argument is the head of the tree A.

Output Format

Return the head of the inverted tree.



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
    public TreeNode invertTree(TreeNode A) {

        mirror(A);

        return A;

    }

    public void mirror(TreeNode curr){

        if(curr==null){
            return;
        }

        TreeNode temp = curr.left;

        curr.left = curr.right;

        curr.right = temp;

        mirror(curr.left);

        mirror(curr.right);

    }
}

