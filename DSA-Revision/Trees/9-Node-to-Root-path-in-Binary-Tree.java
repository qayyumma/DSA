Problem Description

You are given a Binary Tree A with N nodes, with all nodes having distinct values from 1 to N, rooted at 1. You are also given an integer B.

Find a path from node with value B to the root of the tree.


NOTE: It is guaranteed that the node with value B exists in the tree.


Problem Constraints

1 ≤ N ≤ 105

1 ≤ B ≤ N


Input Format

First argument is a root node of the binary tree, A.

Second argument is an integer B.


Output Format

Return an array containing the values of all nodes which lie on the path from the node with value B to the root, i.e. 1.



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
    public int[] getPathToRoot(TreeNode A, int B) {

        ArrayList<Integer> arr = new ArrayList<>();

        code(A, arr, B);

        int[] ans = new int[arr.size()];

        for(int i = 0; i < ans.length; i++){

            ans[i] = arr.get(i);

        }

        return ans;

    }


    public boolean code(TreeNode A, ArrayList arr, int B){

        if(A==null){
            return false;
        }

        if(A.val==B){
            arr.add(A.val);
            return true;
        }

        boolean left = code(A.left, arr, B);

        boolean right = code(A.right, arr, B);

        if(left || right){
            arr.add(A.val);
        }

        return left || right;

    }
}

