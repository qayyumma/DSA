Problem Description

Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

Problem Constraints

1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9


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
    public int[] solve(TreeNode A) {

        Queue<TreeNode> queue =  new LinkedList<>();

        TreeNode curr = A;

        queue.offer(curr);

       ArrayList<Integer> arr = new ArrayList<>();

        int size = queue.size();

        while(!queue.isEmpty()){


            for(int j = 1; j <= size; j++){

                curr = queue.poll();

                if(curr.left!=null){
                    queue.offer(curr.left);
                }

                if(curr.right!=null){
                    queue.offer(curr.right);
                }

                if(j == size){
                    arr.add(curr.val);
                }

            }

            size = queue.size();
        }


        int[] ans = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {

            ans[i] = arr.get(i); 
        }

        return ans;


    }
}
