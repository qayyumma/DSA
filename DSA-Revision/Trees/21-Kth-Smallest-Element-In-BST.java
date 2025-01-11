Problem Description

Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9

Input Format

First and only argument is head of the binary tree A.

Output Format

Return an integer, representing the Bth element.


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

    int count = 0;

    TreeNode k = null;

    public int kthsmallest(TreeNode A, int B) {

        inOderTraversal(A, B);

        return k.val;

    }

    public void inOderTraversal(TreeNode A, int B){

        if(A==null){
            return;
        }

        inOderTraversal(A.left, B);

        count++;

        if(count==B){

            k = A;
            return;
        }

        inOderTraversal(A.right, B);

    }
}




