Problem Description

Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.


Problem Constraints

1 <= Number of nodes in binary tree <= 105

0 <= B <= 106



Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B.



Output Format

Return 1 if such a node exist and 0 otherwise


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
    public int solve(TreeNode A, int B) {

        return code(A, B);

    }

    public int code(TreeNode A, int B){

        if(A==null){
            return 0;
        }

        if(A.val==B){
            return 1;
        }

        if(A.val < B ){

            return code(A.right, B);

        }

        return code(A.left, B);

    }


}
