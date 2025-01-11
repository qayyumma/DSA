Problem Description

Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.

Note - If there are multiple options, always replace a node by its in-order predecessor


Problem Constraints

2 <= No. of nodes in BST <= 105
1 <= value of nodes <= 109
Each node has a unique value


Input Format

The first argument is the root node of a Binary Search Tree A.
The second argument is the value B.


Output Format

Delete the given node if found and return the root of the BST.


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
    public TreeNode solve(TreeNode A, int B) {

        return code(A, B);


    }

    public TreeNode code(TreeNode A, int B){

        if(A==null){
            return null;
        }

        if(A.val== B){

            if(A.left==null && A.right==null){
                return null;
            }

            else if (A.left==null){
                return A.right;
            }

            else if(A.right==null){
                return A.left;
            }
            else{

                TreeNode temp = A.left;

                while(temp.right != null){

                    temp = temp.right;

                }

                A.val = temp.val;

                A.left = code(A.left, temp.val);

            }

        }

        else if(B > A.val){
            A.right = code(A.right, B);
        }

        else{
            A.left = code(A.left, B);
        }

        return A;

    }

}
