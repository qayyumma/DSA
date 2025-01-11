Problem Description

Given a binary tree, return the inorder traversal of its nodes' values.

NOTE: Using recursion and stack are not allowed.

Problem Constraints
1 <= number of nodes <= 105


Input Format

First and only argument is root node of the binary tree, A.


Output Format

Return an integer array denoting the inorder traversal of the given binary tree.


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
    public int[] solve(TreeNode A){

        ArrayList<Integer> ans = new ArrayList<>();

        TreeNode curr = A;

        while(curr != null){

            if(curr.left==null){

                ans.add(curr.val);

                curr = curr.right;

            }
            else{

                TreeNode temp = curr.left;

                while(temp.right != null && temp.right != curr){

                    temp = temp.right;

                }

                if(temp.right == null){

                    temp.right = curr;

                    curr = curr.left;

                }
                else if( temp.right == curr){

                    temp.right = null;

                    ans.add(curr.val);

                    curr = curr.right;

                }

            }

        }


        int[] arr = new int[ans.size()];

        for(int i = 0; i < ans.size(); i++){

            arr[i] = ans.get(i);

        }

        return arr;

    }
}

