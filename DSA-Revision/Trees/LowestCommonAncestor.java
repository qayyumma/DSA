Problem Description

Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.


Problem Constraints

1 <= size of tree <= 100000

1 <= B, C <= 109


Input Format

First argument is head of tree A.

Second argument is integer B.

Third argument is integer C.


Output Format

Return the LCA.


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

    int ans = 0;

    public int lca(TreeNode A, int B, int C) {


        if( search(A, B)  == false || search(A, C) == false){
            return -1;
        }


        if(C==B){
            return B;
        }

        code(A, B, C);

        return ans;

    }

    public boolean code( TreeNode A, int B, int C ){


        if(A==null){
            return false;
        }

        if(A.val == B || A.val == C){

            ans = A.val;

            return true;

        }

        boolean left = code(A.left, B, C);

        boolean right = code(A.right, B, C);

        if(left == true && right ==true){

            ans = A.val;

        }

        return left || right;

    }

    public boolean search(TreeNode A, int V){

        if(A==null){
            return false;
        }

        if(A.val == V){
            return true;
        }

        boolean left = search(A.left, V);

        boolean right = search(A.right, V);

        return right || left;


    }


}

